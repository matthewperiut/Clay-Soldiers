package com.matthewperiut.clay.entity.ai.goal;

import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.TypeFilter;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.EnumSet;
import java.util.List;

public abstract class SoldierAIFindTarget<T extends Entity> extends Goal {
    protected final SoldierDollEntity soldier;
    protected final TypeFilter<Entity, T> typeFilter;
    protected T target;

    public SoldierAIFindTarget(SoldierDollEntity soldier, TypeFilter<Entity, T> filter) {
        this.target = null;
        this.soldier = soldier;
        this.typeFilter = filter;
        this.setControls(EnumSet.of(Control.TARGET));
    }

    @Override
    public boolean canStart() {
        return this.soldier.getFollowingEntity() == null;
    }

    @Override
    public void tick() {
        findTarget();
    }

    @Override
    public void stop() {
        this.target = null;
    }

    protected void findTarget() {
        World world = this.soldier.getWorld();

        Box box = new Box(this.soldier.getPos().subtract(8, 4, 8), this.soldier.getPos().add(8, 4, 8));

        List<T> targets = world.getEntitiesByType(this.typeFilter, box, this::isTargetable);

        if (targets.isEmpty()) return;

        this.target = targets.get(this.soldier.getRandom().nextBetweenExclusive(0, targets.size()));
        this.soldier.setFollowingEntity(this.target);
    }

    protected abstract boolean isTargetable(T searchTarget);

    public static class Mount extends SoldierAIFindTarget<HorseDollEntity> {

        public Mount(SoldierDollEntity soldier, TypeFilter<Entity, HorseDollEntity> filter) {
            super(soldier, filter);
        }

        @Override
        protected boolean isTargetable(HorseDollEntity searchTarget) {
            return searchTarget.isAlive() && !searchTarget.hasPassengers() && searchTarget.canSee(soldier);
        }

        @Override
        public boolean canStart() {
            return !this.soldier.hasVehicle() && super.canStart();
        }
    }

    public static class Upgrade extends SoldierAIFindTarget<ItemEntity> {

        public Upgrade(SoldierDollEntity soldier, TypeFilter<Entity, ItemEntity> filter) {
            super(soldier, filter);
        }

        @Override
        protected boolean isTargetable(ItemEntity searchTarget) {
            // TODO check upgrades on the soldier
            return false;
        }
    }
}
