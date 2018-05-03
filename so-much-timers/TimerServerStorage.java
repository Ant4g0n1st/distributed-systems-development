package dsd;

import java.util.Collection;

public class TimerServerStorage
    extends TimerStorage{

    private static long timerCount = 0;

    public TimerServerStorage(){
        super();
    }

    public synchronized Collection<Timer> getTimers(){
        return values(); 
    }

    @Override
    public synchronized void putTimer(Timer timer){
        if(!timer.hasID()){
            timer.setID(timerCount);
            timerCount++;
        }
        super.putTimer(timer);
    }

}