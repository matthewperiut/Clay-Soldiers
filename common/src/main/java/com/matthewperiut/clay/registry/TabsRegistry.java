package com.matthewperiut.clay.registry;

import com.matthewperiut.clay.ClayMod;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import static net.minecraft.registry.RegistryKeys.ITEM_GROUP;

public class TabsRegistry {
    public static final DeferredRegister<ItemGroup> TABS = DeferredRegister.create(ClayMod.MOD_ID, ITEM_GROUP);
    public static final RegistrySupplier<ItemGroup> CLAY_GROUP = TABS.register("clay_group", () -> CreativeTabRegistry.create(Text.translatable("itemGroup." + ClayMod.MOD_ID + ".clay_group"), () -> new ItemStack(ItemRegistry.CLAY_SOLDIER_ITEM.get())));
    public static final RegistrySupplier<ItemGroup> CLAY_MISC_GROUP = TABS.register("clay_misc_group", () -> CreativeTabRegistry.create(Text.translatable("itemGroup." + ClayMod.MOD_ID + ".clay_misc_group"), () -> new ItemStack(ItemRegistry.CLAY_SOLDIER_ITEM.get())));

    public static void init() {
        TABS.register();
    }

}
