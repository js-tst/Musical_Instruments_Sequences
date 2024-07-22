package com.verdigris.misequences.particle;

import com.verdigris.misequences.MISequences;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    public static  final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MISequences.MODID);

    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_C4 = PARTICLE_TYPES.register("note_particles_c4", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_C4S = PARTICLE_TYPES.register("note_particles_c4s", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_D4 = PARTICLE_TYPES.register("note_particles_d4", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_D4S = PARTICLE_TYPES.register("note_particles_d4s", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_E4 = PARTICLE_TYPES.register("note_particles_e4", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_F4 = PARTICLE_TYPES.register("note_particles_f4", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_F4S = PARTICLE_TYPES.register("note_particles_f4s", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_G4 = PARTICLE_TYPES.register("note_particles_g4", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_G4S = PARTICLE_TYPES.register("note_particles_g4s", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_A4 = PARTICLE_TYPES.register("note_particles_a4", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_A4S = PARTICLE_TYPES.register("note_particles_a4s", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_B4 = PARTICLE_TYPES.register("note_particles_b4", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_C5 = PARTICLE_TYPES.register("note_particles_c5", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_C5S = PARTICLE_TYPES.register("note_particles_c5s", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_D5 = PARTICLE_TYPES.register("note_particles_d5", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_D5S = PARTICLE_TYPES.register("note_particles_d5s", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_E5 = PARTICLE_TYPES.register("note_particles_e5", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_F5 = PARTICLE_TYPES.register("note_particles_f5", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_F5S = PARTICLE_TYPES.register("note_particles_f5s", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_G5 = PARTICLE_TYPES.register("note_particles_g5", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_G5S = PARTICLE_TYPES.register("note_particles_g5s", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_A5 = PARTICLE_TYPES.register("note_particles_a5", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_A5S = PARTICLE_TYPES.register("note_particles_a5s", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_B5 = PARTICLE_TYPES.register("note_particles_b5", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> NOTE_PARTICLES_C6 = PARTICLE_TYPES.register("note_particles_c6", () -> new SimpleParticleType(true));


    public static void register(IEventBus eventBus){
        PARTICLE_TYPES.register(eventBus);
    }
}
