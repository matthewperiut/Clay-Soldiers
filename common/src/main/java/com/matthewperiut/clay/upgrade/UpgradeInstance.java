package com.matthewperiut.clay.upgrade;

import net.minecraft.nbt.NbtCompound;

/**
 * Allows Upgrades to save custom data
 */
public record UpgradeInstance(NbtCompound nbtCompound) {
}
