package dsd;

public class InvalidInputException extends Exception{

    public InvalidInputException(String input){
        super("The input is invalid: " + input + ".");
    }

    public InvalidInputException(){
        super("The input is invalid.");
    }

}