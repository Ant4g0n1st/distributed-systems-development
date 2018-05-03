package dsd;

import java.util.TreeMap;

public class TimerStorage
    extends TreeMap<Long,Timer>{

    public TimerStorage(){
        super();
    }

    public void putTimer(Timer timer){
        put(timer.getID(), timer);
    }

}