package dsd;

import java.net.ServerSocket;
import java.net.Socket;

import java.util.Collection;
import java.util.ArrayList;

import java.io.IOException;

public class TimerClientHandler 
    implements Runnable{

    private ArrayList<TimerServerReader> readers = null;
    private TimerServerStorage tst = null; 
    private TimerWriterGroup twg = null;
    private ServerSocket ss = null;
    private boolean running = true;
    private TimerServer ts = null;

    public TimerClientHandler(TimerServer ts)
        throws IOException{
        this.twg = new TimerWriterGroup();
        this.ss = new TimerServerSocket();
        this.readers = new ArrayList<>();
        tst = new TimerServerStorage();
        this.ts = ts;
    }

    public synchronized void sendTimer(Timer timer){
        if(timer == null) return;
        tst.putTimer(timer);
        twg.writeTimer(timer);
    }

    @Override
    public void run(){
        while(running){
            TimerServerReader tsr = null;
            Collection<Timer> ct = null;
            TimerWriter tw = null;
            Socket s = null;
            try{
                s = ss.accept();
                tw = new TimerWriter(s);
                tsr = new TimerServerReader(s);
                ct = tst.getTimers();
                for(Timer t : ct)
                    tw.writeTimer(t);
                twg.addRecipient(tw);
                tsr.setHandler(this);
                readers.add(tsr);
                tsr.start();
                System.out.println("New Client");
            }catch(IOException e){
                System.out.println(
                    "Exception at " +
                    "TimerClientHandler." +
                    "run() : " +
                    e.getMessage()
                );
            }
        }
    }

    public void start(){
        new Thread(this).start();
    }

}