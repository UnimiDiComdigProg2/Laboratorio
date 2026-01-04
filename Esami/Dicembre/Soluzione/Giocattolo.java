public class Giocattolo extends Sorpresa {
//OVERVIEW: Un Giocattolo come Sorpresa del Calendario

	private final String descrizione;

	public Giocattolo(String nome, String descrizione) {
	//MODIFIES: this
	//EFFECTS: inizializza una nuova Sorpresa di tipo Giocattolo con nome e descrizione
	//         se descrizione null o vuota lancia IllegalArgumentException
		super(nome);

		if(descrizione == null || descrizione.equals(""))
				throw new IllegalArgumentException("\tEccezione: descrizione null o vuota");

		this.descrizione = descrizione;
	}

	@Override
	public double costo() {
	//EFFECTS: il costo è il numero delle parole della descrizione
		return descrizione.split(" ").length;
	}

	@Override
	public String toString() {
		return "Giocattolo: " + super.toString() + " descrizione: " + descrizione;
	}
}