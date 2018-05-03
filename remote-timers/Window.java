package dsd.timers.graphics;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Point;

import javax.swing.JFrame;

public class Window extends JFrame{

    public Window(int w, int h){
        configure(w, h);
    }

    private void configure(int w, int h){
        try{
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Point mid = Window.getScreenMidpoint();
            mid.translate(-(w >> 1), -(h >> 1));
            setResizable(false); 
            setLocation(mid);
            setSize(w, h);
        }catch(Exception e){
            System.out.println("Exception at "
                + "Window."
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
                + "Window."
                + "getScreenMidpoint() : "
                + e.getMessage());  
        }
        return null;
    }

}