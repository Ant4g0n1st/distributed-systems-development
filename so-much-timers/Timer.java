package dsd;

import java.io.Serializable;

import java.util.Random;

public class Timer
    implements Serializable{

    private static final int MOD = 23 * 3600 + 59 * 60 + 60;
    public static final long SID = -1L;

    private long id = SID;
    private int time;

    public Timer(){
        Random r = new Random(System.currentTimeMillis());
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
    public synchronized String toString(){
        return String.format("%02d", getHours())
            + ":" + String.format("%02d", getMinutes())
            + ":" + String.format("%02d", getSeconds());
    }

    public synchronized void increase(){
        time = (time + 1) % MOD;
    }

    public int getMinutes(){
        return (time % 3600) / 60;
    }

    public void setID(long id){
        this.id = id;
    }

    public int getHours(){
        return time / 3600;
    }

    public boolean hasID(){
        return id != SID;
    }

    public long getID(){
        return id;
    }

}