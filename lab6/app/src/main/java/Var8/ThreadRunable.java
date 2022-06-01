package Var8;

import java.io.*;
import java.net.*;
import java.util.LinkedList;

public class ThreadRunable implements Runnable {

    private double start;
    private double end;
    private double step;
    private String resultIntegral;
   
    public ThreadRunable(String l, String h, String s) {
        start = Double.valueOf(l);
        end = Double.valueOf(h);
        step = Double.valueOf(s);
    }

    @Override
    public void run() {
            double n = (end - start) / step;
            double result = 0;

            for (int i = 1; i < n - 1; i++) {

                double index = start + i * step;
                result += (Math.sin(Math.pow(index, 2)));
            }

            result += (Math.sin(Math.pow(start, 2)) + Math.sin(Math.pow(end, 2))) / 2;
            result = step * result;
            resultIntegral = Double.toString(result);
    }

    public String getResult() {
        return this.resultIntegral;
    }
}
