package com.matthewperiut.clay.entity.soldier.teams;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class StandardTeam implements ITeam {
    private final short teamId;
    private final String name;
    private final RegistrySupplier<Item> teamItem;

    public StandardTeam(short teamId, String name, RegistrySupplier<Item> teamItem) {
        this.teamId = teamId;
        this.name = name;
        this.teamItem = teamItem;
    }

    @Override
    public short getTeamId() {
        return this.teamId;
    }

    @Override
    public String getTeamName() {
        return this.name;
    }

    @Override
    public ItemStack getTeamItem() {
        return new ItemStack(teamItem.get());
    }
}
