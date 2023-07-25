package com.matthewperiut.clay.entity.soldier;

import com.matthewperiut.clay.entity.soldier.variant.*;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.mob.MobEntity;

public class Targets
{
    public boolean checker(Object obj, Class someClass)
    {
        return someClass.isInstance(obj);
    }

    private static void add(Class soldierType, Object entity, GoalSelector targetSelector)
    {
        if (!soldierType.isInstance(entity))
        {
            MobEntity mob = (MobEntity) entity;
            targetSelector.add(3, new ActiveTargetGoal<>(mob, soldierType, true));
        }
    }

    public static void AddTargets(MobEntity you, GoalSelector targetSelector)
    {
        add(RegularSoldierDoll.class, you, targetSelector);
        add(RedSoldierDoll.class, you, targetSelector);
        add(YellowSoldierDoll.class, you, targetSelector);
        add(GreenSoldierDoll.class, you, targetSelector);
        add(BlueSoldierDoll.class, you, targetSelector);
        add(OrangeSoldierDoll.class, you, targetSelector);
        add(MagentaSoldierDoll.class, you, targetSelector);
        add(LightblueSoldierDoll.class, you, targetSelector);
        add(LimeSoldierDoll.class, you, targetSelector);
        add(PinkSoldierDoll.class, you, targetSelector);
        add(CyanSoldierDoll.class, you, targetSelector);
        add(PurpleSoldierDoll.class, you, targetSelector);
        add(BrownSoldierDoll.class, you, targetSelector);
        add(BlackSoldierDoll.class, you, targetSelector);
        add(GraySoldierDoll.class, you, targetSelector);
        add(WhiteSoldierDoll.class, you, targetSelector);
    }
}
