package org.okunev.foodnerf;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class ModConfig {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    public static class Common {
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> blockedFoods;

        public Common(ForgeConfigSpec.Builder builder) {
            builder.comment("List of prohibited items (by ID)").push("foodnerf");

            blockedFoods = builder
                    .comment("Examples: 'minecraft:apple', 'minecraft:raw_beef'")
                    .defineListAllowEmpty(
                            "blocked_foods",
                            List.of("minecraft:apple", "minecraft:raw_beef"),
                            o -> o instanceof String
                    );

            builder.pop();
        }
    }

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        COMMON = new Common(builder);
        COMMON_SPEC = builder.build();
    }
}
