import java.util.Objects;

abstract class Prodotto implements Comparable<Prodotto>, Cloneable {
//OVERVIEW: modella un Prodotto di un Negozio
	private final String nome;
	private double prezzo;

	public Prodotto(String nome, double prezzo) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza this con nome e prezzo
	//         lancia IllegalArgumentException se nome null / vuoto o prezzo <= 0
		if(nome == null || nome.equals(""))
			throw new IllegalArgumentException("E:nome null or empty");

		if(prezzo <= 0)
			throw new IllegalArgumentException("E:prezzo <= 0");

		this.nome = nome;
		this.prezzo = prezzo;

		assert repOk();
	}

	public abstract String getCodice();
	//EFFECTS: restituisce il codice (stringa di 10 cifre) del prodotto

	public String getNome() {
		return nome;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public final void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
		assert repOk();
	}

	@Override
	public final int compareTo(Prodotto p) {
		return getCodice().compareTo(p.getCodice());
	}

	@Override
	public final boolean equals(Object o) {
		if(!(getClass().equals(o.getClass())))
			return false;

		Prodotto t = (Prodotto) o;

		if(!nome.equals(t.getNome()))
			return false;

		if(!getCodice().equals(t.getCodice()))
			return false;

		return true;
	}

	@Override
	public final int hashCode() {
		return Objects.hash(nome, getCodice());
	}

	@Override
	public final Prodotto clone() {
		try {
			return (Prodotto) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	@Override
	public String toString() {
		return getCodice() + " (" + nome + "): " + getPrezzo();
	}

	private boolean repOk() {
		if(prezzo <= 0)
			return false;

		return true;
	}
}