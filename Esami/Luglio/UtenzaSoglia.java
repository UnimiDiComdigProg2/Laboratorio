public class UtenzaSoglia extends UtenzaPrepagata {
//OVERVIEW: Utenza con soglia settimanale

//attributes
	public final int soglia;

//constructors
	public UtenzaSoglia(String numero, String nome, int soglia) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza this
		super(numero, nome);

		if(soglia <= 0)
			throw new IllegalArgumentException("soglia <= 0");

		this.soglia = soglia;
		super.ricarica(soglia);
	}

//methods
	public void reset() {
	//MODIFIES: this
	//EFFECTS: resetta la soglia
		this.setCredito(soglia);
	}

	@Override
	public void ricarica(int credito) {
		throw new UnsupportedOperationException("ricarica non supportata");
	}

	@Override
	public String toString() {
		return super.toString() + ", soglia: " + soglia;
	}
}