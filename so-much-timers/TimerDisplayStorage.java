package dsd;

import java.util.TreeMap;

public class TimerDisplayStorage
    extends TreeMap<Long,TimerDisplay>{

    public TimerDisplayStorage(){
        super();
    }

    public void addDisplay(TimerDisplay display, Timer timer){
        if(timer.hasID())
            put(timer.getID(), display);
    }

    public boolean updateDisplay(Timer timer){
        if(containsKey(timer.getID())){
            get(timer.getID()).replaceTimer(timer);
            return true;
        }
        return false;
    }

}