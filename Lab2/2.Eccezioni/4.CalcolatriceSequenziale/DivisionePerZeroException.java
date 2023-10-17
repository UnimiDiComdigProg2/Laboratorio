public class DivisionePerZeroException extends Exception {
	
    public DivisionePerZeroException() {
        super("Divisione per zero!");
    } 
    
    public DivisionePerZeroException(String messaggio) {
        super(messaggio);
    }
}