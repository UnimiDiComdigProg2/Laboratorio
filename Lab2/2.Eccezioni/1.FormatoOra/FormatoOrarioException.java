public class FormatoOrarioException extends Exception {
	public FormatoOrarioException() {
		super("Formato ora non valido");
	}

	public FormatoOrarioException(String messaggio) {
		super(messaggio);
	}
}