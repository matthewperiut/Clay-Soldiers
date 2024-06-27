package com.matthewperiut.clay.mixins;

import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(LootTables.class)
public interface LootTablesAccess {
    @Invoker("registerLootTable")
    static RegistryKey<LootTable> invokeRegisterLootTable(RegistryKey<LootTable> key) {
        return null;
    }
}
