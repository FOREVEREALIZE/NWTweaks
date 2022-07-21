package com.newwind.nwtweaks;

import com.electronwill.nightconfig.toml.TomlParser;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ConfigManager {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Values
    public static final ForgeConfigSpec.ConfigValue<String> modpackName;

    static {
        BUILDER.push("Test!");

        modpackName = BUILDER.comment("This is the name of the modpack. It is used to only load certain things for certain modpacks so that a tweaker does not have to be created for each of them.")
                .define("Modpack Name", "");

        BUILDER.pop();
        SPEC = BUILDER.build();

    }
}
