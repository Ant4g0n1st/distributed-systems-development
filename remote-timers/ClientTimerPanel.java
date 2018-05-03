package dsd.timers.client.graphics;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ClientTimerPanel extends JPanel{

    public ClientTimerPanel(){
        configure();
    }

    private void configure(){
        ClientTimerDisplay ctd = null;
        try{
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            ctd = new ClientTimerDisplay();
            add(ctd);
        }catch(Exception e){
            System.out.println("Exception at "
                + "ClientTimerPanel."
                + "configure() : "
                + e.getMessage());
        }
    }

}