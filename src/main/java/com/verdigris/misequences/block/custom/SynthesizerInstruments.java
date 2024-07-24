package com.verdigris.misequences.block.custom;

import com.verdigris.misequences.sound.custom.synthesizer.WavePlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class SynthesizerInstruments extends Block {

    public SynthesizerInstruments(Properties pProperties) {
        super(pProperties);
    }

    // 右键使用，用于调整音高并播放声音，同时显示粒子效果。
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState pBlockState, Level pLevel, @NotNull BlockPos pBlockPos, @NotNull Player pPlayer, @NotNull InteractionHand pInteractionHand, @NotNull BlockHitResult pBlockHitResult) {
        if (!pLevel.isClientSide) {
            // 启动新的线程播放正弦波声音
            new Thread(() -> {
                try (WavePlayer player = new WavePlayer()) {
                    player.playWave(440f, 2, 15f); // 播放440Hz（A4音调）的正弦波，持续2秒
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide);
    }
}
