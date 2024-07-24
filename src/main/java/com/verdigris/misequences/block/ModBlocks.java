package com.verdigris.misequences.block;

import com.verdigris.misequences.MISequences;
import com.verdigris.misequences.block.custom.MusicalInstruments;
import com.verdigris.misequences.block.custom.SynthesizerInstruments;
import com.verdigris.misequences.item.ModItems;
import com.verdigris.misequences.sound.ModSounds;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MISequences.MODID);

    //public static final RegistryObject<Block> T2 = registerBlock("t2", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> KICK_808_BLOCK = registerBlock("kick_808_block", () -> new MusicalInstruments(BlockBehaviour.Properties.copy(Blocks.NOTE_BLOCK), ModSounds.KICK_808.get()));
    public static final RegistryObject<Block> HIHAT_808_BLOCK = registerBlock("hihat_808_block", () -> new MusicalInstruments(BlockBehaviour.Properties.copy(Blocks.NOTE_BLOCK), ModSounds.HIHAT_808.get()));
    public static final RegistryObject<Block> SNARE_808_BLOCK = registerBlock("snare_808_block", () -> new MusicalInstruments(BlockBehaviour.Properties.copy(Blocks.NOTE_BLOCK), ModSounds.SNARE_808.get()));
    public static final RegistryObject<Block> CLAP_808_BLOCK = registerBlock("clap_808_block", () -> new MusicalInstruments(BlockBehaviour.Properties.copy(Blocks.NOTE_BLOCK), ModSounds.CLAP_808.get()));
    public static final RegistryObject<Block> COWBELL_808_BLOCK = registerBlock("cowbell_808_block", () -> new MusicalInstruments(BlockBehaviour.Properties.copy(Blocks.NOTE_BLOCK), ModSounds.COWBELL_808.get()));

    public static final RegistryObject<Block> SYNTHESIZER_BLOCK = registerBlock("synthesizer_block", () -> new SynthesizerInstruments(BlockBehaviour.Properties.copy(Blocks.NOTE_BLOCK)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
