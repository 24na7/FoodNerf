package org.okunev.foodnerf;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

@Mod.EventBusSubscriber(modid = FoodBlockerMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FoodBlockerEvents {

    public static void register() {
        MinecraftForge.EVENT_BUS.register(FoodBlockerEvents.class);
    }

    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.RightClickItem event) {
        ItemStack stack = event.getItemStack();
        if (isFoodBlocked(stack)) {
            event.setCanceled(true);
            event.getEntity().displayClientMessage(
                    Component.translatable("message.foodnerf.id1").withStyle(ChatFormatting.RED),
                    true
            );
        }
    }

    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (isFoodBlocked(stack)) {
            event.getToolTip().add(
                    Component.literal("message.foodnerf.id1").withStyle(ChatFormatting.GRAY)
            );
        }
    }

    private static boolean isFoodBlocked(ItemStack stack) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(stack.getItem());
        List<? extends String> blockedList = ModConfig.COMMON.blockedFoods.get();
        return id != null && blockedList.contains(id.toString());
    }
}
