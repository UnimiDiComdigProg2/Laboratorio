public class Piatto {
	// OVERVIEW: it models a Piatto with
	// unique name and type (primo,secondo,contorno...)
	// note that this class is immutable, and concrete
	// doesn't allow manipulators

//ATTRIBUTES:
	private final String nome;
	private final String tipo;
	private final int costo;

//CONSTRUCTORS:
	public Piatto(String nome, String tipo, int costo) throws IllegalArgumentException {
		//MODIFIES: this statements
		//EFFECTS: it create an unique istance of Piatto
		//          if costo is < 0 it throws illegalargumentexception
		//          if nome or tipo null or empty throws illegalargumentexception
		if(costo < 0)
			throw new IllegalArgumentException("Costo non può essere minore di 0");

		if(nome == null || nome.equals(""))
			throw new IllegalArgumentException("Nome nullo o vuoto");

		if(tipo == null || tipo.equals(""))
			throw new IllegalArgumentException("Tipo nullo o vuoto");

		this.nome = nome;
		this.tipo = tipo;
		this.costo = costo;

		//DRAGAN: repok non serve essendo immutabile
	}

//CONCRETE METHODS:
	public String getNome() {// OBSERVER
		return this.nome;
	}

	public int getCosto() {// OBSERVER
		return this.costo;
	}

	public String getTipo() { // OBSERVER
		return this.tipo;
	}

	@Override
	public boolean equals(Object o) { // EQUALS
		if(o == this)
			return true;

		if(o == null)
			return false;

		if(!(o.getClass().equals(this.getClass())))
			return false;

		Piatto p = (Piatto) o;

		if(this.costo != p.getCosto())
			return false;

		if(!this.nome.equals(p.getNome()))
			return false;

		if(!this.tipo.equals(p.getTipo()))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return this.getNome() + ", " + this.getTipo() + ": " + this.getCosto();
	}
}