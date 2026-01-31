public class Gara extends Evento {
//OVERVIEW: Evento di tipo Gara (immutabile)

	final public int atleti;

	public Gara(String nome, int atleti) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza this
	//         se atleti <= 0 lancia IllegalArgumentException
		super(nome);

		if(atleti <= 0)
			throw new IllegalArgumentException("\tECCEZIONE: atleti <= 0");

		this.atleti = atleti;
	}

	@Override
	public int durata() {
	//EFFECTS: Gara dura 5 min per ciascun atleta;
		return 5 * atleti;
	}

	@Override
	public String toString() {
		return "Gara" + super.toString() + " con " + atleti + " atleti" ;
	}
}