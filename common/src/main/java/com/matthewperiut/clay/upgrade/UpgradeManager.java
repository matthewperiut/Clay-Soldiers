package com.matthewperiut.clay.upgrade;

import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.nbt.NBTValues;
import com.matthewperiut.clay.network.UpgradeAdded;
import com.matthewperiut.clay.network.UpgradeRemoved;
import com.matthewperiut.clay.registry.UpgradeRegistry;
import com.matthewperiut.clay.util.NetworkUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;

import java.util.*;
import java.util.stream.Collectors;

// TODO evaluate if we might should use Annotations on upgrades to identify which has dependencies,
//  which needs to react on kills..., so that we don't mostly call empty methods
public class UpgradeManager {

    public static final UpgradeManager INSTANCE = new UpgradeManager();
    public final HashMap<ItemStack, ISoldierUpgrade> possibleUpgrades = getItemUpgrades();

    public void applyUpdate(SoldierDollEntity soldier, ItemStack stack) {
        ISoldierUpgrade upgrade = getUpgrade(stack);
        if (upgrade != null && upgrade.canUpgrade(stack, soldier)) {
            soldier.upgrades.add(upgrade);
            soldier.upgradeInstances.put(upgrade, new UpgradeInstance(new NbtCompound()));
            upgrade.onAdd(soldier);
            if (upgrade.shouldSyncToClient()) {
                UpgradeAdded.sendPacket(NetworkUtils.getTrackingPlayers(soldier), soldier.getId(), UpgradeRegistry.SOLDIER_UPGRADE_REGISTER.getId(upgrade));
            }
        }
    }

    public boolean canApplyUpdate(SoldierDollEntity soldier, ItemStack stack) {
        ISoldierUpgrade upgrade = getUpgrade(stack);
        if (upgrade != null) {
            return upgrade.canUpgrade(stack, soldier);
        }
        return false;
    }

    public void removeUpgrade(SoldierDollEntity soldier, ISoldierUpgrade upgrade) {
        upgrade.onRemove(soldier);
        soldier.upgrades.remove(upgrade);
        soldier.upgradeInstances.remove(upgrade);
        handleDependencies(soldier, upgrade);
        if (upgrade.shouldSyncToClient()) {
            UpgradeRemoved.sendPacket(NetworkUtils.getTrackingPlayers(soldier), soldier.getId(), UpgradeRegistry.SOLDIER_UPGRADE_REGISTER.getId(upgrade));
        }
    }

    private void handleDependencies(SoldierDollEntity soldier, ISoldierUpgrade upgrade) {
        if (soldier.upgrades.isEmpty()) return;
        Set<ISoldierUpgrade> dependencies = soldier.upgrades.stream().filter(u -> u.dependentsOn() != null && upgrade.hashCode() == u.dependentsOn().hashCode()).collect(Collectors.toSet());
        if (dependencies.isEmpty()) return;
        for (ISoldierUpgrade dependency : dependencies) {
            removeUpgrade(soldier, dependency);
        }

    }

    public void handleNBTRead(SoldierDollEntity soldier, Identifier upgradeId, NbtCompound compound) {
        ISoldierUpgrade upgrade = getUpgrade(upgradeId);

        if (upgrade == null) return;

        soldier.upgrades.add(upgrade);
        soldier.upgradeInstances.put(upgrade, new UpgradeInstance(compound));
        upgrade.readCustomNBTData(soldier, compound);
        upgrade.onLoad(soldier);
    }

    public void handleNBTWrite(SoldierDollEntity soldier, ISoldierUpgrade upgrade, NbtCompound compound) {
        compound.putString(NBTValues.SOLDIER_UPGRADES_ID.getKey(), upgrade.getUpgradeIdentifier().toString());
        upgrade.writeCustomNBTData(soldier, compound);
    }

    public ISoldierUpgrade getUpgrade(ItemStack stack) {
        Optional<Map.Entry<ItemStack, ISoldierUpgrade>> optionalEntry = possibleUpgrades.entrySet().stream().filter(e -> e.getKey().isOf(stack.getItem())).findFirst();
        return optionalEntry.map(Map.Entry::getValue).orElse(null);
    }

    public ISoldierUpgrade getUpgrade(Identifier identifier) {
        return UpgradeRegistry.SOLDIER_UPGRADE_REGISTER.get(identifier);
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
