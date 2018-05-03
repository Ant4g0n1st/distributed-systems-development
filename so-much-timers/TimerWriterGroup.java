package dsd;

import java.io.IOException;

import java.util.ArrayList; 

public class TimerWriterGroup{

    private ArrayList<TimerWriter> recipients;

    public TimerWriterGroup(){
        recipients = new ArrayList<>();
    }

    public synchronized void addRecipient(TimerWriter recipient){
        recipients.add(recipient);
    }

    public synchronized void writeTimer(Timer timer){
        for(TimerWriter recipient : recipients)
            try{
                recipient.writeTimer(timer);
            }catch(IOException e){}
    }

}