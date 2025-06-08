package org.okunev.foodnerf;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod(FoodBlockerMod.MODID)
public class FoodBlockerMod {
    public static final String MODID = "foodblocker";

    public FoodBlockerMod() {
        ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.COMMON, ModConfig.COMMON_SPEC);
        FoodBlockerEvents.register();
    }
}
