package exceptions;

public class WrongLengthPasswordExceptions extends RuntimeException{
    public WrongLengthPasswordExceptions(String message){
        super(message);
    }
}
