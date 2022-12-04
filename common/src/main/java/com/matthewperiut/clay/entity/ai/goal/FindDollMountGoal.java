package com.matthewperiut.clay.entity.ai.goal;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class FindDollMountGoal extends Goal
{
    protected final SoldierDollEntity mob;
    private final double speed;
    private Path path;

    public FindDollMountGoal(SoldierDollEntity mob, double speed)
    {
        this.mob = mob;
        this.speed = speed;
    }

    public HorseDollEntity getGoal()
    {
        World world = this.mob.getWorld();
        Entity result;

        Box box = new Box(this.mob.getPos().subtract( 8, 4, 8), this.mob.getPos().add(8, 4, 8));
        List<Entity> entities = world.getOtherEntities(this.mob, box);
        List<HorseDollEntity> horses = new ArrayList<>();
        for (Entity entity : entities)
        {
            if (entity instanceof HorseDollEntity)
            {
                if (!entity.hasPassengers())
                {
                    horses.add((HorseDollEntity) entity);
                }
            }
        }

        // closest
        double distance = 1000;
        HorseDollEntity chosen = null;
        for (HorseDollEntity horse : horses)
        {
            if (ClayMod.random.nextFloat() < 0.33F)
            {
                return horse;
            }
            double d = this.mob.squaredDistanceTo(horse.getX(), horse.getY(), horse.getZ());
            if (d < distance)
            {
                chosen = horse;
            }
        }

        return chosen;
    }

    private long lastUpdateTime;
    @Override
    public boolean canStart()
    {
        if (this.mob.hasVehicle())
        {
            return false;
        }

        long l = this.mob.world.getTime();
        if (l - this.lastUpdateTime < 20L)
        {
            return false;
        }
        else
        {
            this.lastUpdateTime = l;
            this.mob.horseTarget = getGoal();
            HorseDollEntity goalMob = this.mob.horseTarget;
            if (goalMob == null)
            {
                return false;
            }
            else if (!goalMob.isAlive())
            {
                return false;
            }
            else
            {
                this.path = this.mob.getNavigation().findPathTo(goalMob, 0);
                if (this.path != null)
                {
                    return true;
                }
                else
                {
                    return this.getSquaredMaxRideDistance(goalMob) >= this.mob.squaredDistanceTo(goalMob.getX(), goalMob.getY(), goalMob.getZ());
                }
            }
        }
    }

    private int updateCountdownTicks;
    private int cooldown;

    @Override
    public void start()
    {
        this.mob.getNavigation().startMovingAlong(this.path, this.speed);
        this.cooldown = 0;
    }

    @Override
    public boolean shouldContinue()
    {
        HorseDollEntity goalMob = this.mob.horseTarget;
        if (goalMob == null)
        {
            return false;
        }
        else if (!goalMob.isAlive())
        {
            return false;
        }
        else if (goalMob.hasPassengers())
        {
            return false;
        }
        else if (!this.mob.isInWalkTargetRange(goalMob.getBlockPos()))
        {
            return false;
        }

        return true;
    }

    @Override
    public void stop()
    {
        HorseDollEntity goalMob = this.mob.horseTarget;
        if (!EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(goalMob))
        {
            this.mob.setTarget((LivingEntity)null);
        }
        this.mob.getNavigation().stop();
    }

    @Override
    public boolean shouldRunEveryTick()
    {
        return true;
    }

    public void tick() {
        HorseDollEntity goalMob = this.mob.horseTarget;
        if (goalMob != null)
        {
            this.mob.getLookControl().lookAt(goalMob, 30.0F, 30.0F);
            double d = this.mob.squaredDistanceTo(goalMob.getX(), goalMob.getY(), goalMob.getZ());

            if (ClayMod.random.nextFloat() < 0.25F)
            {
                this.mob.getNavigation().startMovingTo(goalMob, this.speed);
            }

            if (ClayMod.random.nextFloat() < 0.05f)
            {
                this.mob.horseTarget = getGoal();
                return;
            }

            this.cooldown = Math.max(this.cooldown - 1, 0);
            this.ride(goalMob, d);
        }
    }

    protected void ride(HorseDollEntity target, double squaredDistance)
    {
        double d = this.getSquaredMaxRideDistance(target);
        if (squaredDistance <= d && this.cooldown <= 0)
        {
            if (shouldContinue())
            {
                if (target.age > 40)
                    this.mob.startRiding(target);
            }
        }
    }

    protected double getSquaredMaxRideDistance(LivingEntity entity)
    {
        return 2.0;
    }

    protected void resetCooldown()
    {
        this.cooldown = this.getTickCount(20);
    }

    protected boolean isCooledDown()
    {
        return this.cooldown <= 0;
    }

    protected int getCooldown()
    {
        return this.cooldown;
    }

    protected int getMaxCooldown()
    {
        return this.getTickCount(20);
    }
}