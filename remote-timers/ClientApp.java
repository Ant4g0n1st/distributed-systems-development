package dsd.timers.client.app;

import dsd.timers.client.graphics.ClientWindow;

public class ClientApp{

    private ClientWindow cw = null;

    public ClientApp(){
        cw = new ClientWindow();
    }

    public static void main(String... args){
        new ClientApp();
    }

}