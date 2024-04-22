package com.matthewperiut.clay.nbt;

public enum NBTValues {

    SOLDIER_UPGRADES("soldier_upgrades"), SOLDIER_UPGRADES_ID("soldier_upgrades_id");

    private final String key;

    NBTValues(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
