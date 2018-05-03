package dsd;

public class TimerServer{

    private TimerClientHandler tcl = null;

    public TimerServer(){
        initServer();
    }

    private void initServer(){
        try{
            tcl = new TimerClientHandler(this);
            tcl.start();
            System.out.println("Started");
        }catch(Exception e){
            System.out.println(
                "Exception at " +
                "TimerServer." +
                "initServer() : " +
                e.getMessage()
            );
        }
    }

    public static void main(String... args){
        new TimerServer();
    }

}