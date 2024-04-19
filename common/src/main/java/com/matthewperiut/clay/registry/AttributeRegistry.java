package com.matthewperiut.clay.registry;

import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;

public class AttributeRegistry {

    public static void init() {
        EntityTypeRegistry.ENTITY_TYPES_HORSES.forEach(e -> {
            EntityAttributeRegistry.register(() -> (EntityType<? extends LivingEntity>) e.get(), HorseDollEntity::setAttributesBuilder);
        });
        EntityTypeRegistry.ENTITY_TYPES_SOLDIERS.forEach(e -> {
            EntityAttributeRegistry.register(() -> (EntityType<? extends LivingEntity>) e.get(), SoldierDollEntity::createAttributes);
        });
    }
}
