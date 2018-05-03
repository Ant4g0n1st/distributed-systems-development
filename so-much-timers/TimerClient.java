package dsd;

import java.io.IOException;

public class TimerClient{

    private TimerClientReader tcr = null;
    private TimerClientSocket tcs = null;
    private TimerStorage ts = null;
    private TimerWriter tw = null;
    private TimerPanel tp = null;

    public TimerClient(TimerPanel tp){
        this.tp = tp;
        initClient();
    }

    public synchronized void sendTimer(Timer timer){
        if(timer == null) return;
        try{
            tw.writeTimer(timer);
        }catch(Exception e){
            System.out.println(
                "Exception at " +
                "TimerClient." +
                "sendTimer() : " +
                e.getMessage()
            );
            System.exit(0);
        }
    }

    public synchronized void addTimer(Timer timer){
        if(timer == null) return;
        ts.putTimer(timer);
        tp.addTimer(timer);
    }

    private void initClient(){
        try{
            tcs = new TimerClientSocket();
            System.out.println("Connected");
            tcr = new TimerClientReader(tcs);
            tw = new TimerWriter(tcs);
            ts = new TimerStorage();
            tcr.setClient(this);
            tcr.start();
            System.out.println("Started");
        }catch(Exception e){
            System.out.println(
                "Exception at " +
                "TimerClient." +
                "initClient() : " +
                e.getMessage()
            );
            System.exit(0);
        }
    }

}