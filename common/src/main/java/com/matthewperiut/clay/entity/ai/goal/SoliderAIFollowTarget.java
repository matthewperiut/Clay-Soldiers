package com.matthewperiut.clay.entity.ai.goal;

import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.upgrade.UpgradeManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

import java.util.EnumSet;

public abstract class SoliderAIFollowTarget extends Goal {

    protected final SoldierDollEntity soldier;
    protected double speed;

    public SoliderAIFollowTarget(SoldierDollEntity soldier, double speed) {
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        this.soldier = soldier;
        this.speed = speed;
    }

    @Override
    public boolean canStart() {
        Entity target = getTarget();
        return target != null && target.isAlive() && hasValidTarget();
    }

    @Override
    public void tick() {
        Entity target = getTarget();
        this.soldier.getLookControl().lookAt(target, 30.0F, 30.0F);
        double distanceToTarget = this.soldier.squaredDistanceTo(target.getX(), target.getY(), target.getZ());
        if (this.soldier.getRandom().nextFloat() < 0.25F) {
            this.soldier.getNavigation().startMovingTo(target, this.speed);
        }
        action(distanceToTarget);
    }

    @Override
    public void stop() {
        this.cleanUp();
    }


    abstract void action(double distanceToTarget);

    abstract Entity getTarget();

    abstract boolean hasValidTarget();

    // TODO maybe this doesn't need to be abstract
    abstract void cleanUp();

    public static class Mount extends SoliderAIFollowTarget {

        public Mount(SoldierDollEntity soldier, double speed) {
            super(soldier, speed);
        }

        @Override
        public Entity getTarget() {
            return soldier.getFollowingEntity();
        }

        @Override
        boolean hasValidTarget() {
            Entity target = getTarget();
            return target instanceof HorseDollEntity && !target.hasPassengers();
        }

        @Override
        void cleanUp() {
            soldier.setFollowingEntity(null);
        }

        @Override
        void action(double distanceToTarget) {
            Entity target = getTarget();
            if (distanceToTarget <= 2 && target.age > 20) {
                soldier.startRiding(target);
                cleanUp();
            }
        }
    }

    public static class Upgrade extends SoliderAIFollowTarget {
        public Upgrade(SoldierDollEntity soldier, double speed) {
            super(soldier, speed);
        }

        @Override
        void action(double distanceToTarget) {
            if (distanceToTarget <= 2) {
                ItemEntity target = getTarget();
                UpgradeManager.INSTANCE.applyUpdate(soldier, target.getStack());
                target.getStack().decrement(1);
                soldier.getWorld().playSound(null, soldier.getX(), soldier.getY(), soldier.getZ(), SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2F, ((soldier.getRandom().nextFloat() - soldier.getRandom().nextFloat()) * 0.7F + 1.0F) * 2.0F);
                if (target.getStack().getCount() == 0) {
                    target.setDespawnImmediately();
                }
                cleanUp();
            }
        }

        @Override
        ItemEntity getTarget() {
            if (this.soldier.getFollowingEntity() instanceof ItemEntity)
                return (ItemEntity) this.soldier.getFollowingEntity();
            return null;
        }

        @Override
        boolean hasValidTarget() {
            return getTarget() != null && getTarget().getStack().getCount() >= 1;
        }

        @Override
        void cleanUp() {
            soldier.setFollowingEntity(null);
        }
    }
}
