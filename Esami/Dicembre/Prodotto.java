public class Prodotto implements Comparable<Prodotto>, Cloneable {
//OVERVIEW: modella Prodotto di un Erogatore

//attributes
	public final String nome;
	private double prezzo;

//methods
	public Prodotto(String nome, double prezzo) throws NullPointerException, IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza this con nome e prezzo
	//         se nome null lancia NullPointerException
	//         se nome vuoto o prezzo <=0 lancia IllegalArgumentException
		if(nome == null)
			throw new NullPointerException("nome null");

		if(nome.equals(""))
			throw new IllegalArgumentException("nome vuoto");

		if(prezzo <= 0)
			throw new IllegalArgumentException("prezzo <= 0");

		this.nome = nome;
		this.prezzo = prezzo;

		assert repOK();
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) throws IllegalArgumentException {
		if(prezzo <= 0)
			throw new IllegalArgumentException("prezzo <= 0");

		this.prezzo = prezzo;
	}

	@Override
	public int compareTo(Prodotto o) {
		return this.nome.compareTo(o.nome);
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;

		if(!(o instanceof Prodotto))
			return false;

		return ((Prodotto) o).nome.equals(this.nome);
	}

	@Override
	public int hashCode() {
		return this.nome.hashCode();
	}

	@Override
	public String toString() {
		return "Prodotto: " + this.nome + " prezzo: " + this.prezzo;
	}

	@Override
	protected Object clone() {
		try {
			return super.clone();
		} catch(CloneNotSupportedException e) {
			return null;
		}
	}

	public boolean repOK() {
		if(nome == null)
			return false;

		if(nome.equals(""))
			return false;

		if(prezzo <= 0)
			return false;

		return true;
	}
}