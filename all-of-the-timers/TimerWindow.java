package dsd.timers.graphics;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Point;

import javax.swing.JFrame;

public class TimerWindow extends JFrame{ 

    private static final int WINDOW_HEIGHT = 500;
    private static final int WINDOW_WIDTH = 500;

    public TimerWindow(){
        this.configure();
    }

    private void configure(){
        Point mid = null;
        int h,w;
        try{
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mid = TimerWindow.getScreenMidpoint();
            h = WINDOW_HEIGHT; w = WINDOW_WIDTH; 
            mid.translate(-(w >> 1), -(h >> 1));
            setContentPane(new TimerPanel());
            setResizable(false); 
            setLocation(mid);
            setVisible(true);
            setSize(w, h);
        }catch(Exception e){
            System.out.println("Exception at "
                + "TimerWindow."
                + "configure() : " 
                + e.getMessage());  
        }
    }

    private static Point getScreenMidpoint(){
        Dimension screen = null;
        Toolkit tool = null;
        int sw,sh;
        try{
            tool = Toolkit.getDefaultToolkit();
            screen = tool.getScreenSize();
            sh = (int) screen.getHeight();
            sw = (int) screen.getWidth();
            return new Point(sw >> 1, sh >> 1);
        }catch(Exception e){
            System.out.println("Exception at "
                + "TimerWindow."
                + "getScreenMidpoint() : "
                + e.getMessage());  
        }
        return null;
    }

}