public class Animale extends Figura {
//OVERVIEW: Figura di un Animale del Presepio
	private final String aggettivo;

	public Animale(String nome, String aggettivo) {
	//MODIFIES: this;
	//EFFECTS: inizializza una nuova Figura Animale con un aggettivo
	//         se aggettivo null o vuoto lancia IllegalArgumentException
		super(nome);

		if(aggettivo == null || aggettivo.equals(""))
			throw new IllegalArgumentException("\tEmergenza: aggettivo null o vuoto");

		this.aggettivo = aggettivo;
	}

	@Override
	public int valore() {
	//EFFECTS: il valore è la lunghezza dell'aggettivo
		return aggettivo.length();
	}

	@Override
	public String toString() {
		return "Animale: " + super.toString() + " <" + aggettivo + ">";
	}
}