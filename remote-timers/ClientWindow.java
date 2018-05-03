package dsd.timers.client.graphics;

import dsd.timers.graphics.Window;

public class ClientWindow extends Window{

    private static final int WINDOW_HEIGHT = 75;
    private static final int WINDOW_WIDTH = 250;

    public ClientWindow(){
        super(WINDOW_WIDTH, WINDOW_HEIGHT);
        configure();
    }

    private void configure(){
        try{
            setContentPane(new ClientTimerPanel());
            setVisible(true);
        }catch(Exception e){
            System.out.println("Exception at "
                + "ClientWindow."
                + "configure() : " 
                + e.getMessage());  
        }
    }

}