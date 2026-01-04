public class Cioccolatino extends Sorpresa {
//OVERVIEW: Un Cioccolatino come Sorpresa del Calendario
	private final int cacao;

	public Cioccolatino(String nome, int cacao) {
	//MODIFIES: this;
	//EFFECTS: inizializza una Sorpresa di tipo Cioccolatino con nome e percentuale cacao
	//         se cacao < 0 o > 100 lancia IllegalArgumentException
		super(nome);

		if(cacao <= 0 || cacao > 100)
			throw new IllegalArgumentException("\tEccezione: percentuale cacao errata");

		this.cacao = cacao;
	}

	@Override
	public double costo() {
	//EFFECTS: il costo è (cacao/10)
		return (double)cacao/10; //cast a double previa divisione per permettere un risultato decimale
	}

	@Override
	public String toString() {
		return "Cioccolatino: " + super.toString() + " cacao: " + cacao + "%";
	}
}