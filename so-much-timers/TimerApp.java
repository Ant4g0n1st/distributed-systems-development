package dsd;

public class TimerApp{ 

    public TimerApp(){
        javax.swing.SwingUtilities.invokeLater(
            ()->{ new TimerWindow(); }
        );
    }

    public static void main(String... args){
        new TimerApp();
    }

}