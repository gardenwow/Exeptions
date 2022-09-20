package exceptions;

public class WrongLoginExceptions extends RuntimeException{
    public WrongLoginExceptions(String message){
        super(message);
    }

}
