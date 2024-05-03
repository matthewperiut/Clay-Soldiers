package com.matthewperiut.clay.registry;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.teams.ITeam;
import com.matthewperiut.clay.entity.soldier.teams.StandardTeam;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import static com.matthewperiut.clay.ClayRegistries.getIdentifier;
import static com.matthewperiut.clay.registry.ItemRegistry.*;

public class TeamRegistry {
    public static final Identifier REGISTRY_ID = new Identifier(ClayMod.MOD_ID, "teams");
    public static final RegistryKey<Registry<ITeam>> REGISTRY_TEAMS_KEY =
            RegistryKey.ofRegistry(REGISTRY_ID);
    public static final Registrar<ITeam> SOLDIER_TEAMS = RegistrarManager
            .get(ClayMod.MOD_ID)
            .<ITeam>builder(REGISTRY_ID)
            .build();

    public static final RegistrySupplier<ITeam> CLAY_TEAM = SOLDIER_TEAMS.register(getIdentifier("clay"), () -> new StandardTeam((short) 0, "Standard Team", CLAY_SOLDIER_ITEM));
    public static final RegistrySupplier<ITeam> RED_TEAM = SOLDIER_TEAMS.register(getIdentifier("red"), () -> new StandardTeam((short) 1, "Red Team", RED_SOLDIER_ITEM));
    public static final RegistrySupplier<ITeam> YELLOW_TEAM = SOLDIER_TEAMS.register(getIdentifier("yellow"), () -> new StandardTeam((short) 2, "Yellow Team", YELLOW_SOLDIER_ITEM));
    public static final RegistrySupplier<ITeam> GREEN_TEAM = SOLDIER_TEAMS.register(getIdentifier("green"), () -> new StandardTeam((short) 3, "Green Team", GREEN_SOLDIER_ITEM));
    public static final RegistrySupplier<ITeam> BLUE_TEAM = SOLDIER_TEAMS.register(getIdentifier("blue"), () -> new StandardTeam((short) 4, "Blue Team", BLUE_SOLDIER_ITEM));
    public static final RegistrySupplier<ITeam> ORANGE_TEAM = SOLDIER_TEAMS.register(getIdentifier("orange"), () -> new StandardTeam((short) 5, "Orange Team", ORANGE_SOLDIER_ITEM));
    public static final RegistrySupplier<ITeam> MAGENTA_TEAM = SOLDIER_TEAMS.register(getIdentifier("magenta"), () -> new StandardTeam((short) 6, "Magenta Team", MAGENTA_SOLDIER_ITEM));
    public static final RegistrySupplier<ITeam> LIGHT_BLUE_TEAM = SOLDIER_TEAMS.register(getIdentifier("lightblue"), () -> new StandardTeam((short) 7, "Lightblue Team", LIGHTBLUE_SOLDIER_ITEM));
    public static final RegistrySupplier<ITeam> LIME_TEAM = SOLDIER_TEAMS.register(getIdentifier("lime"), () -> new StandardTeam((short) 8, "Lime Team", LIME_SOLDIER_ITEM));
    public static final RegistrySupplier<ITeam> PINK_TEAM = SOLDIER_TEAMS.register(getIdentifier("pink"), () -> new StandardTeam((short) 9, "Pink Team", PINK_SOLDIER_ITEM));
    public static final RegistrySupplier<ITeam> CYAN_TEAM = SOLDIER_TEAMS.register(getIdentifier("cyan"), () -> new StandardTeam((short) 10, "Cyan Team", CYAN_SOLDIER_ITEM));
    public static final RegistrySupplier<ITeam> PURPLE_TEAM = SOLDIER_TEAMS.register(getIdentifier("purple"), () -> new StandardTeam((short) 11, "Purple Team", PURPLE_SOLDIER_ITEM));
    public static final RegistrySupplier<ITeam> BROWN_TEAM = SOLDIER_TEAMS.register(getIdentifier("brown"), () -> new StandardTeam((short) 12, "Brown Team", BROWN_SOLDIER_ITEM));
    public static final RegistrySupplier<ITeam> BLACK_TEAM = SOLDIER_TEAMS.register(getIdentifier("black"), () -> new StandardTeam((short) 13, "Black Team", BLACK_SOLDIER_ITEM));
    public static final RegistrySupplier<ITeam> GRAY_TEAM = SOLDIER_TEAMS.register(getIdentifier("gray"), () -> new StandardTeam((short) 14, "Gray Team", GRAY_SOLDIER_ITEM));
    public static final RegistrySupplier<ITeam> WHITE_TEAM = SOLDIER_TEAMS.register(getIdentifier("white"), () -> new StandardTeam((short) 15, "White Team", WHITE_SOLDIER_ITEM));

    public static void init() {
    }
}
