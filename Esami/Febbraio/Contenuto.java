import java.util.Objects;

public abstract class Contenuto implements Comparable<Contenuto>, Cloneable {
//OVERVIEW: classe astratta che modella un Contenuto di un gestionale documenti

//attributes
	private final String nome;

//methods
	public Contenuto(String nome) {
	//MODIFIES: this
	//EFFECTS: inizializza Contenuto con nome
	//         se nome null lancia NullPointerException
	//         se nome vuoto lancia IllegalArgumentException

		if(nome == null)
			throw new NullPointerException("ECCEZIONE:nome null");

		if(nome.equals(""))
			throw new IllegalArgumentException("ECCEZIONE:nome vuoto");

		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public abstract int dimensione();
	//EFFECTS: restituisce la dimensione del Contenuto

	@Override
	public int compareTo(Contenuto o) throws NullPointerException {
		if(o == null)
			throw new NullPointerException("ECCEZIONE:comparando null");

		return Integer.compare(dimensione(), o.dimensione());
	}

	@Override
	public String toString() {
		return nome + " dimensione: " + dimensione();
	}

	@Override
	public Contenuto clone() {
		try {
			return (Contenuto) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;

		if(!(o instanceof Contenuto))
			return false;

		return ((Contenuto) o).getNome().equals(nome);
	}
}