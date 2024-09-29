public class DivideByZeroException extends Exception {
	
    public DivideByZeroException() {
        super("Divisione per zero!");
    } 
    
    public DivideByZeroException(String messaggio) {
        super(messaggio);
    }
}