package dsd.timers.core;

import java.util.Random;

public class Timer{

    private static final int MOD = 23 * 3600 + 59 * 60 + 60;

    int time;

    public Timer(){
        long sysTime = System.currentTimeMillis();
        Random r = new Random(sysTime);
        this.time = ((r.nextInt() % MOD) + MOD) % MOD;
    }

    public Timer(int h, int m, int s){
        this.time = h * 3600 + m * 60 + s;
    }

    public Timer(int time){
        this.time = time;
    }

    public int getSeconds(){
        return time - getHours() * 3600 - getMinutes() * 60;
    }

    @Override
    public String toString(){
        return String.format("%02d", getHours())
            + ":" + String.format("%02d", getMinutes())
            + ":" + String.format("%02d", getSeconds());
    }

    public int getMinutes(){
        return (time % 3600) / 60;
    }

    public void increase(){
        time = (time + 1) % MOD;
    }

    public int getHours(){
        return time / 3600;
    }

}