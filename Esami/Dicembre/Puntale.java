public class Puntale extends Decorazione {
//OVERVIEW: Decorazione Puntale

	public Puntale(String nome, double peso) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza un nuovo Puntale
		super(nome, peso);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", puntale";
	}
}
