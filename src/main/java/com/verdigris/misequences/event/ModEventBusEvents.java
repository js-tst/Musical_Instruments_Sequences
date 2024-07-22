package com.verdigris.misequences.event;

import com.verdigris.misequences.MISequences;
import com.verdigris.misequences.particle.ModParticles;
import com.verdigris.misequences.particle.custom.NoteParticles;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MISequences.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event){
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_C4.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_C4S.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_D4.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_D4S.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_E4.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_F4.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_F4S.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_G4.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_G4S.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_A4.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_A4S.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_B4.get(), NoteParticles.Provider::new);

        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_C5.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_C5S.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_D5.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_D5S.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_E5.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_F5.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_F5S.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_G5.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_G5S.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_A5.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_A5S.get(), NoteParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_B5.get(), NoteParticles.Provider::new);

        Minecraft.getInstance().particleEngine.register(ModParticles.NOTE_PARTICLES_C6.get(), NoteParticles.Provider::new);
    }
}
