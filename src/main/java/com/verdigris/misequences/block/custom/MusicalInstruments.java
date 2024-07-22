package com.verdigris.misequences.block.custom;

import com.verdigris.misequences.particle.ModParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class MusicalInstruments extends Block {
    public static final IntegerProperty NOTE = IntegerProperty.create("note", 0, 24); // 音高范围：0-24
    private final SoundEvent sound;

    int DEFAULT_PITCH = 12;//默认音高

    private int note;


    public MusicalInstruments(Properties pProperties, SoundEvent pSoundEvent) {
        super(pProperties);
        this.sound = pSoundEvent;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(BlockStateProperties.POWERED, false)
                .setValue(NOTE, DEFAULT_PITCH));
    }

    // createBlockStateDefinition 方法用于定义方块的状态属性，这里添加了 POWERED 和 NOTE 属性。
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.POWERED, NOTE);
    }

    // neighborChanged 方法用于检测红石信号状态变化。
    @Override
    public void neighborChanged(@NotNull BlockState pBlockState, @NotNull Level pLevel, @NotNull BlockPos pBlockPos, @NotNull Block pBlock, @NotNull BlockPos pFromBlockPos, boolean isMoving) {
        super.neighborChanged(pBlockState, pLevel, pBlockPos, pBlock, pFromBlockPos, isMoving);

        boolean isPowered = pLevel.hasNeighborSignal(pBlockPos);
        boolean wasPowered = pBlockState.getValue(BlockStateProperties.POWERED);

        if (isPowered && !wasPowered) {
            pLevel.setBlock(pBlockPos, pBlockState.setValue(BlockStateProperties.POWERED, true), 3);
            playSound(pBlockState, pLevel, pBlockPos);
        } else if (!isPowered && wasPowered) {
            pLevel.setBlock(pBlockPos, pBlockState.setValue(BlockStateProperties.POWERED, false), 3);
        }
    }

    // 用于播放声音的方法，根据音高调整音调。
    private void playSound(BlockState pBlockState, Level pLevel, BlockPos pBlockPos) {
        int note = pBlockState.getValue(NOTE);
        float pitch = (float) Math.pow(2.0D, (double) (note - 12) / 12.0D);
        pLevel.playSound(null, pBlockPos, this.sound, SoundSource.BLOCKS, 3.0F, pitch);
    }

    // 右键使用，用于调整音高并播放声音，同时显示粒子效果。
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState pBlockState, Level pLevel, @NotNull BlockPos pBlockPos, @NotNull Player pPlayer, @NotNull InteractionHand pInteractionHand, @NotNull BlockHitResult pBlockHitResult) {
        if (!pLevel.isClientSide) {
            // 增加音高
            note = pBlockState.getValue(NOTE);
            note = (note + 1) % 25; // 音高范围：0-24
            pLevel.setBlock(pBlockPos, pBlockState.setValue(NOTE, note), 3);

            // 播放点击声音
            playSound(pBlockState.setValue(NOTE, note), pLevel, pBlockPos);

            // 显示粒子效果
            showNoteParticle(pBlockPos);
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide);
    }

    // 客户端显示粒子效果
    private void showNoteParticle(BlockPos pBlockPos) {
        double d0 = (double) pBlockPos.getX() + 0.5D;
        double d1 = (double) pBlockPos.getY() + 1.2D;
        double d2 = (double) pBlockPos.getZ() + 0.5D;

        SimpleParticleType particleType = getParticleTypeForNote(note);

        if (Minecraft.getInstance().level != null & particleType != null) {
            Minecraft.getInstance().level.addParticle(particleType, d0, d1, d2, 0.0D, 0.1D, 0.0D);
        }
    }

    private SimpleParticleType getParticleTypeForNote(int note) {
        return switch (note) {
            case 0 -> ModParticles.NOTE_PARTICLES_C4.get();
            case 1 -> ModParticles.NOTE_PARTICLES_C4S.get();
            case 2 -> ModParticles.NOTE_PARTICLES_D4.get();
            case 3 -> ModParticles.NOTE_PARTICLES_D4S.get();
            case 4 -> ModParticles.NOTE_PARTICLES_E4.get();
            case 5 -> ModParticles.NOTE_PARTICLES_F4.get();
            case 6 -> ModParticles.NOTE_PARTICLES_F4S.get();
            case 7 -> ModParticles.NOTE_PARTICLES_G4.get();
            case 8 -> ModParticles.NOTE_PARTICLES_G4S.get();
            case 9 -> ModParticles.NOTE_PARTICLES_A4.get();
            case 10 -> ModParticles.NOTE_PARTICLES_A4S.get();
            case 11 -> ModParticles.NOTE_PARTICLES_B4.get();

            case 12 -> ModParticles.NOTE_PARTICLES_C5.get();
            case 13 -> ModParticles.NOTE_PARTICLES_C5S.get();
            case 14 -> ModParticles.NOTE_PARTICLES_D5.get();
            case 15 -> ModParticles.NOTE_PARTICLES_D5S.get();
            case 16 -> ModParticles.NOTE_PARTICLES_E5.get();
            case 17 -> ModParticles.NOTE_PARTICLES_F5.get();
            case 18 -> ModParticles.NOTE_PARTICLES_F5S.get();
            case 19 -> ModParticles.NOTE_PARTICLES_G5.get();
            case 20 -> ModParticles.NOTE_PARTICLES_G5S.get();
            case 21 -> ModParticles.NOTE_PARTICLES_A5.get();
            case 22 -> ModParticles.NOTE_PARTICLES_A5S.get();
            case 23 -> ModParticles.NOTE_PARTICLES_B5.get();

            case 24 -> ModParticles.NOTE_PARTICLES_C6.get();

            default -> null;
        };
    }
}