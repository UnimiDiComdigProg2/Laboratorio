public class Documento extends Contenuto {
//OVERVIEW: Contenuto di tipo Documento con dimensione

//attributi
	private final int dimensione;

//metodi
	public Documento(String nome, int dimensione) {
	//MODIFIES: this
	//EFFECTS: inizializza this con nome e dimensione
		super(nome);

		if(dimensione < 0)
			throw new IllegalArgumentException("ECCEZIONE:dimensione documento < 0");

		this.dimensione = dimensione;
	}

	@Override
	public int dimensione() {
		return dimensione;
	}

	@Override
	public String toString() {
		return "Documento " + super.toString();
	}
}