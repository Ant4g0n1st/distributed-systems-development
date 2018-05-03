package dsd.timers.server.app;

import dsd.timers.server.graphics.ServerWindow;

public class ServerApp{

    private ServerWindow sw = null;

    public ServerApp(){
        sw = new ServerWindow();
    }

    public static void main(String... args){
        new ServerApp();
    }

}