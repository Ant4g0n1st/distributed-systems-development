package dsd.timers.graphics;

import dsd.timers.core.Timer; 

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Insets;
import java.awt.Font;

public class TimerDisplay extends JPanel 
    implements Runnable{

    protected static final Font DISPLAY_FONT = new Font("Arial", Font.PLAIN, 20);
    protected static final Insets MARGIN = new Insets(5, 5, 5, 5);

    protected volatile Timer timer = null;
    private boolean running = true;
    protected JLabel label = null;
    private boolean hold = false;

    public TimerDisplay(){}

    public TimerDisplay(Timer timer){
        this.timer = timer;
    }

    public synchronized void replaceTimer(Timer timer){
        this.timer = timer;
    }

    @Override
    public void run(){
        while(running){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){}
            if(!hold){
                timer.increase();
                label.setText(timer.toString());
                revalidate();
            }
        }
    }

    protected void start(){
        new Thread(this).start();   
    }

    public void stop(){
        this.running = false;
    }

    public void resume(){
        this.hold = false;
    }

    public void pause(){
        this.hold = true;
    }

}