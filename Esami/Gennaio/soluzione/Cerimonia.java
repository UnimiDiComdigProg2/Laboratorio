public class Cerimonia extends Evento {
//OVERVIEW: Evento di tipo Cerimonia (immutabile)

	final public boolean apertura;

	public Cerimonia(String nome, boolean apertura) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza this
		super(nome);

		this.apertura = apertura;
	}

	@Override
	public int durata() {
	//EFFECTS: Cerimonia dura 60 min;
		return 60;
	}

	@Override
	public String toString() {
		return "Cerimonia " + (apertura ? "apertura" : "chiusura") + super.toString();
	}
}