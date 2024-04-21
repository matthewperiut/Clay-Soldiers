package com.matthewperiut.clay.entity.ai.goal;

import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.Goal;

import java.util.EnumSet;
import java.util.List;

public class PickUpUpgradesGoal extends Goal {

    SoldierDollEntity entity;


    public PickUpUpgradesGoal(SoldierDollEntity entity) {
        this.entity = entity;
        this.setControls(EnumSet.of(Control.MOVE));
    }

    @Override
    public boolean canStart() {
        return entity.getAttacker() == null;
    }

    @Override
    public void tick() {
        List<ItemEntity> itemsNearby = entity.getWorld().getEntitiesByClass(ItemEntity.class, entity.getBoundingBox().expand(8.0, 8.0, 8.0), Entity::isGlowing);
        if (!itemsNearby.isEmpty()) {
            entity.getNavigation().startMovingTo(itemsNearby.get(entity.getRandom().nextBetween(0, itemsNearby.size() - 1)), 2);
        }
    }
}
