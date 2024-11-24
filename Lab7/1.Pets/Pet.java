public abstract class Pet {
//OVERVIEW: modella una classe astratta Pet
	private final String nome;

	public Pet(String nome) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza pet col nome
	//         se nome nullo o vuoto lancia IllegalArgumentException
	if(nome == null || nome.equals(""))
		throw new IllegalArgumentException("nome nullo o vuoto");

		this.nome = nome;
	}

	abstract void verso();
	//MODIFIES: System.out
	//EFFECTS: stampa su sout il verso del Pet

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return this.getNome();
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;

		if(o == null)
			return false;

		if(!(this.getClass().equals(o.getClass())))
			return false;

		if(!(this.getNome().equals(((Pet) o).getNome())))
			return false;

		return true;
	}
}