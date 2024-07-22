package com.verdigris.misequences.sound;

import com.verdigris.misequences.MISequences;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MISequences.MODID);


    // 声音
    public static final RegistryObject<SoundEvent> KICK_808 = registerSoundEvents("808_kick");
    public static final RegistryObject<SoundEvent> HIHAT_808 = registerSoundEvents("808_hihat");
    public static final RegistryObject<SoundEvent> SNARE_808 = registerSoundEvents("808_snare");
    public static final RegistryObject<SoundEvent> CLAP_808 = registerSoundEvents("808_clap");




    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MISequences.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
