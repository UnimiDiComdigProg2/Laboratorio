public class ProdottoControllato extends Prodotto {
//OVERVIEW: modella ProdottoControllato con età minima

//attributes
	public final int etaMin;

//methods
	public ProdottoControllato(String nome, double prezzo, int etaMin) throws NullPointerException, IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza this con anche etaMin
	//         se etaMin <= 0 lancia IllegalArgumentException
		super(nome, prezzo);

		if(etaMin <= 0)
			throw new IllegalArgumentException("etaMin <= 0");

		this.etaMin = etaMin;
	}

	@Override
	public String toString() {
		return super.toString() + " (min " + etaMin + " anni)";
	}
}