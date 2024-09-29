public class ProdottoPeso extends Prodotto {
//OVERVIEW: modella ProdottoPeso, un prodotto con un codicebase di 4 cifre e un peso tra 1 e 999999 grammi
	private final String codicebase;
	private final int peso;

	public ProdottoPeso(String nome, double prezzo, String codicebase, int peso) throws CodeException, IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza this con nome, codicebase
	//         lancia CodeException se codicebase nullo, vuoto, o ha != 4 caratteri
	//         lancia IllegalArgumentException se peso < 1 o > 999999
		super(nome, prezzo);

		if(codicebase == null || codicebase.equals(""))
			throw new CodeException("E:codicebase null or empty");

		if(codicebase.length() != 4)
			throw new CodeException("E:wrong length codice");

		for(char c : codicebase.toCharArray())
			if(!(Character.isDigit(c)))
				throw new CodeException("E:codicebase contains non-digits");

		if(peso < 1 || peso > 999999)
			throw new IllegalArgumentException("E:peso < 1 || > 999999");

		this.codicebase = codicebase;
		this.peso = peso;
	}

	@Override
	public String getCodice() {
		return codicebase + String.format("%06d", peso);
	}

	@Override
	public double getPrezzo() {
		return super.getPrezzo() * peso / 1000;
	}

	@Override
	public String toString() {
		return super.toString() + " (" + peso + "g)";
	}
}