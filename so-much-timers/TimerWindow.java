package dsd;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Point;

import javax.swing.JFrame;

import java.util.Random;

public class TimerWindow extends JFrame{ 

    private static final int WINDOW_HEIGHT = 500;
    private static final int WINDOW_WIDTH = 500;

    public TimerWindow(){
        this.configure();
    }

    private void configure(){
        Point point = null;
        int h,w;
        try{
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            point = TimerWindow.getRandomPoint();
            h = WINDOW_HEIGHT; w = WINDOW_WIDTH; 
            setContentPane(new TimerPanel());
            setResizable(false); 
            setLocation(point);
            setVisible(true);
            setSize(w, h);
        }catch(Exception e){
            System.out.println("Exception at "
                + "TimerWindow."
                + "configure() : " 
                + e.getMessage());  
        }
    }

    private static Point getRandomPoint(){
        Dimension screen = null;
        Random random = null;
        Toolkit tool = null;
        int sw,sh,x,y;
        try{
            random = new Random(System.currentTimeMillis());
            tool = Toolkit.getDefaultToolkit();
            screen = tool.getScreenSize();
            sh = (int) screen.getHeight();
            sw = (int) screen.getWidth();
            y = random.nextInt(sh - WINDOW_HEIGHT);
            x = random.nextInt(sw - WINDOW_WIDTH);
            return new Point(x, y);
        }catch(Exception e){
            System.out.println("Exception at "
                + "TimerWindow."
                + "getScreenMidpoint() : "
                + e.getMessage());  
        }
        return null;
    }

}