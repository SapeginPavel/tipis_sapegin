package com.example.tipis_sapegin;

public class DFT {
    static class Complex {
        public double im = 0;
        public double real = 0;
    }

    public static double[][] getXYForSinus(int sinusFrequency, int sampleRate) throws Exception {
        int maxX = 1;
        if (sampleRate <= 1) {
            throw new Exception("Incorrect sampleRate");
        }
        double step = (maxX + 0.0) / sampleRate; //sampleRate == numOfPoints
        double x = 0.0;
        double[][] xyArr = new double[2][sampleRate];
        for (int i = 0; i < sampleRate; i++) {
            xyArr[0][i] = x;
            xyArr[1][i] = Math.sin(x * 2 * Math.PI * sinusFrequency);
            x += step;
        }
        return xyArr;
    }

    public static double[] dft(double[] yArrInput, int sampleRate) {

        Complex[] yArrOutput = new Complex[sampleRate / 2];
        for (int k = 0; k < yArrOutput.length; k++) {
            yArrOutput[k] = new Complex();
            for (int n = 0; n < yArrInput.length; n++) {
                double cof = 2 * Math.PI * k * n / sampleRate;
                yArrOutput[k].real += yArrInput[n] * Math.cos(cof);
                yArrOutput[k].im -= yArrInput[n] * Math.sin(cof);
            }
        }

        double[] resArr = new double[yArrOutput.length];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = Math.sqrt(yArrOutput[i].real * yArrOutput[i].real + yArrOutput[i].im * yArrOutput[i].im);
        }
        return resArr;
    }

}
