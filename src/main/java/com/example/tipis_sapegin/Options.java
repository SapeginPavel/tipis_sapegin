package com.example.tipis_sapegin;

public class Options {
    private static int maxX = 3;

    private static int sampleRate = 30;

    private static int[] frequencies = {1, 2, 4, 8};

    public static int getMaxX() {
        return maxX;
    }

    public static int getSampleRate() {
        return sampleRate;
    }

    public static int[] getFrequencies() {
        return frequencies;
    }


    public static void setSampleRate(int sampleRate) {
        Options.sampleRate = sampleRate;
    }
}
