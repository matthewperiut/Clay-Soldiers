package com.matthewperiut.clay.entity.ai.goal;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;

import java.util.EnumSet;

import static java.lang.Math.sqrt;

public class MeleeAttackTinyGoal extends Goal
{
    protected final PathAwareEntity mob;
    private final double speed;
    private final boolean pauseWhenMobIdle;
    private Path path;
    private long lastUpdateTime;

    public MeleeAttackTinyGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle)
    {
        this.mob = mob;
        this.speed = speed;
        this.pauseWhenMobIdle = pauseWhenMobIdle;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    public boolean canStart()
    {
        long l = this.mob.getWorld().getTime();
        if (l - this.lastUpdateTime < 20L)
        {
            return false;
        }
        else
        {
            this.lastUpdateTime = l;
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null)
            {
                return false;
            }
            else if (!livingEntity.isAlive())
            {
                return false;
            }
            else
            {
                this.path = this.mob.getNavigation().findPathTo(livingEntity, 0);
                if (this.path != null)
                {
                    return true;
                }
                else
                {
                    return this.getSquaredMaxAttackDistance(livingEntity) >= this.mob.squaredDistanceTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
                }
            }
        }
    }

    public boolean shouldContinue()
    {
        LivingEntity livingEntity = this.mob.getTarget();
        if (livingEntity == null)
        {
            return false;
        }
        else if (!livingEntity.isAlive())
        {
            return false;
        }
        else if (!this.mob.isInWalkTargetRange(livingEntity.getBlockPos()))
        {
            return false;
        }
        else
        {
            return !(livingEntity instanceof PlayerEntity) || !livingEntity.isSpectator() && !((PlayerEntity) livingEntity).isCreative();
        }
    }

    public void start()
    {
        this.mob.getNavigation().startMovingAlong(this.path, this.speed);
        this.mob.setAttacking(true);
    }

    public void stop()
    {
        LivingEntity livingEntity = this.mob.getTarget();
        if (!EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(livingEntity))
        {
            this.mob.setTarget(null);
        }

        this.mob.setAttacking(false);
        this.mob.getNavigation().stop();
    }

    public boolean shouldRunEveryTick()
    {
        return true;
    }

    private void pushTowardOther(Vec3d direction, double mod)
    {
        Entity mob = this.mob;
        if (mob.hasVehicle()) mob = mob.getVehicle();
        double x = direction.getX();
        double y = direction.getY();
        double z = direction.getZ();
        double length = sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        mob.addVelocity((x / length) * mod, (y / length) * mod, (z / length) * mod);
    }

    public void tick()
    {
        LivingEntity livingEntity = this.mob.getTarget();
        if (livingEntity != null)
        {
            this.mob.getLookControl().lookAt(livingEntity, 30.0F, 30.0F);
            double d = this.mob.squaredDistanceTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
            if ((this.mob.getVisibilityCache().canSee(livingEntity)))
            {
                this.mob.getNavigation().startMovingTo(livingEntity, this.speed);
                pushTowardOther(livingEntity.getPos().subtract(this.mob.getPos()), 0.0125);
            }

            this.attack(livingEntity, d);
        }
    }

    protected void attack(LivingEntity target, double squaredDistance)
    {
        double d = this.getSquaredMaxAttackDistance(target);
        if (squaredDistance <= d)
        {
            this.mob.swingHand(Hand.MAIN_HAND);
            this.mob.tryAttack(target);
        }
    }

    protected double getSquaredMaxAttackDistance(LivingEntity entity)
    {
        return 1.0;
    }
}
