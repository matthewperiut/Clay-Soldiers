package com.matthewperiut.clay.upgrade;

import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.network.UpgradeAdded;
import com.matthewperiut.clay.registry.UpgradeRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UpgradeManager {

    public static final UpgradeManager INSTANCE = new UpgradeManager();
    public final HashMap<ItemStack, ISoldierUpgrade> possibleUpgrades = getItemUpgrades();

    public void applyUpdate(SoldierDollEntity entity, ItemStack stack) {
        ISoldierUpgrade upgrade = getUpgrade(stack);
        if (upgrade != null && upgrade.canUpgrade(stack, entity)) {
            upgrade.onAdd(entity);
            entity.upgrades.add(upgrade);
            if (upgrade.shouldSyncToClient()) {
                UpgradeAdded.sendPacket(((ServerWorld) entity.getWorld()).getPlayers(), entity.getId(), UpgradeRegistry.SOLDIER_UPGRADE_REGISTER.getId(upgrade));
            }
        }
    }

    public ISoldierUpgrade getUpgrade(ItemStack stack) {
        Optional<Map.Entry<ItemStack, ISoldierUpgrade>> optionalEntry = possibleUpgrades.entrySet().stream().filter(e -> e.getKey().isOf(stack.getItem())).findFirst();
        return optionalEntry.map(Map.Entry::getValue).orElse(null);
    }

    private HashMap<ItemStack, ISoldierUpgrade> getItemUpgrades() {
        List<ISoldierUpgrade> soldierUpgrades = UpgradeRegistry.SOLDIER_UPGRADE_REGISTER.entrySet().stream().map(Map.Entry::getValue).toList();
        HashMap<ItemStack, ISoldierUpgrade> upgrades = new HashMap<>();
        for (ISoldierUpgrade soldierUpgrade : soldierUpgrades) {
            upgrades.put(soldierUpgrade.getUpgradeItem(), soldierUpgrade);
        }
        return upgrades;
    }
}