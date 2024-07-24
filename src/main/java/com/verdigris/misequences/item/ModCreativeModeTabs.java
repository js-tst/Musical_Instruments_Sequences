package com.verdigris.misequences.item;

import com.verdigris.misequences.MISequences;
import com.verdigris.misequences.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MISequences.MODID);

    public static final RegistryObject<CreativeModeTab> MIS_TAB = CREATIVE_MODE_TABS.register("mis_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModBlocks.KICK_808_BLOCK.get()))
            .title(Component.translatable("creativetab.mis_tab"))
            .displayItems((pItemDisplayParameters, pOutput) -> {
                pOutput.accept(ModBlocks.KICK_808_BLOCK.get());
                pOutput.accept(ModBlocks.HIHAT_808_BLOCK.get());
                pOutput.accept(ModBlocks.SNARE_808_BLOCK.get());
                pOutput.accept(ModBlocks.CLAP_808_BLOCK.get());
                pOutput.accept(ModBlocks.COWBELL_808_BLOCK.get());

                pOutput.accept(ModBlocks.SYNTHESIZER_BLOCK.get());
            })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
