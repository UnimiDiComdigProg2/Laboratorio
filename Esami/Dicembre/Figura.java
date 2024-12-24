import java.util.Objects;

public abstract class Figura implements Comparable<Figura> {
//OVERVIEW: modella una Figura di un Presepio (immutabile)
	private final String nome;

	public Figura(String nome) {
	//MODIFIES: this
	//EFFECTS: inizializza una nuova figura con nome
	//         se nome null o vuoto lancia IllegalArgumentException
		if(nome == null || nome.equals(""))
			throw new IllegalArgumentException("\tEmergenza: nome null o vuoto");

		this.nome = nome;
	}

	public abstract int valore();
	//EFFECTS: restituisce il valore della figura

	public String getNome() {
		return nome;
	}

	@Override
	public final int compareTo(Figura f) {
		return Integer.compare(valore(), f.valore());
	}

	@Override
	public final boolean equals(Object o) {
		if(this == o)
			return true;

		if(o == null)
			return false;

		if(!(getClass().equals(o.getClass()))) //stesso tipo
			return false;

		if(nome.equals(((Figura)o).nome)) //stesso nome
			return true;

		return false;
	}

	@Override
	public final int hashCode() { //rispecchia equals
		return Objects.hash(getClass(),nome);
	}

	@Override
	public String toString() {
		return nome + " (" + valore() + ")";
	}
}