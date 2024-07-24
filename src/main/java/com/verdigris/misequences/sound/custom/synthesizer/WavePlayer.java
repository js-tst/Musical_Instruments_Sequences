package com.verdigris.misequences.sound.custom.synthesizer;

import org.lwjgl.openal.AL10;
import org.lwjgl.system.MemoryStack;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class WavePlayer implements AutoCloseable {
    private final int sampleRate = 44100;
    private final int format = AL10.AL_FORMAT_MONO8; // 修改为8位单声道
    private int source;
    private int buffer;

    public WavePlayer() {
        // Initialize OpenAL
        try (MemoryStack stack = MemoryStack.stackPush()) {
            IntBuffer bufferPointer = stack.mallocInt(1);
            AL10.alGenBuffers(bufferPointer);
            buffer = bufferPointer.get(0);

            IntBuffer sourcePointer = stack.mallocInt(1);
            AL10.alGenSources(sourcePointer);
            source = sourcePointer.get(0);

            checkALError(); // 检查初始化错误
        }
    }

    public void playWave(float frequency, int duration, float volume) {
        ByteBuffer data = generateWave(frequency, duration);
        AL10.alBufferData(buffer, format, data, sampleRate);
        checkALError();

        AL10.alSourcei(source, AL10.AL_BUFFER, buffer);
        checkALError();

        AL10.alSourcef(source, AL10.AL_GAIN, volume); // 设置音量
        checkALError();

        AL10.alSourcePlay(source);
        checkALError();

        // 等待声音播放完毕
        try {
            Thread.sleep(duration * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 停止播放
        AL10.alSourceStop(source);
        checkALError();
    }

    private ByteBuffer generateWave(float frequency, int duration) {
        int numSamples = sampleRate * duration; // 计算样本数量
        ByteBuffer buffer = ByteBuffer.allocateDirect(numSamples); // 1字节每个样本

        double sampleInterval = 1.0 / sampleRate; // 每个样本的时间间隔
        for (int i = 0; i < numSamples; i++) {
            double time = i * sampleInterval; // 当前样本的时间
            double period = 1.0 / frequency; // 一个周期的时间
            byte sample = (byte) ((time % period < period / 2) ? 255 : 0); // 方波值
            buffer.put(sample);
        }
        buffer.flip();
        return buffer;
    }

    private void checkALError() {
        int error = AL10.alGetError();
        if (error != AL10.AL_NO_ERROR) {
            throw new IllegalStateException("OpenAL error: " + error);
        }
    }

    @Override
    public void close() {
        AL10.alSourceStop(source);
        AL10.alSourcei(source, AL10.AL_BUFFER, AL10.AL_NONE);
        AL10.alDeleteSources(source);
        AL10.alDeleteBuffers(buffer);
        checkALError();
    }
}
