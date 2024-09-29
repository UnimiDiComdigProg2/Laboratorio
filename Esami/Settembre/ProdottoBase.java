public class ProdottoBase extends Prodotto {
//OVERVIEW: modella ProdottoBase, un Prodotto con un codice fisso
	private final String codice;

	public ProdottoBase(String nome, double prezzo, String codice) throws CodeException {
	//MODIFIES: this
	//EFFECTS: inizializza this con nome e codice di 10 cifre
	//         lancia CodeException se codice nullo, vuoto, ha != 10 caratteri, contiene non-cifre 
		super(nome, prezzo);

		if(codice == null || codice.equals(""))
			throw new CodeException("E:codice null or empty");

		if(codice.length() != 10)
			throw new CodeException("E:wrong length codice");

		for(char c : codice.toCharArray())
			if(!(Character.isDigit(c)))
				throw new CodeException("E:codice contains non-digits");

		this.codice = codice;
	}

	@Override
	public String getCodice() {
		return codice;
	}
}