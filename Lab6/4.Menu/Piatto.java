public class Piatto {
//OVERVIEW: modella un piatto (immutabile)

	final String nome, tipo;
	final int costo;

	public Piatto(String nome, String tipo, int costo) throws IllegalArgumentException {
	//MODIFIES: this;
	//EFFECTS: inizializza un nuovo piatto
	//         se nome null o vuoto lancia IllegalArgumentException
	//         se tipo null o vuoto lancia IllegalArgumentException
	//         se costo <= 0 lancia IllegalArgumentException
		if(nome == null || nome.equals(""))
			throw new IllegalArgumentException("nome null o vuoto");

		if(tipo == null || tipo.equals(""))
			throw new IllegalArgumentException("tipo nullo o vuoto");

		if(costo <= 0)
			throw new IllegalArgumentException("costo <= 0");

		this.nome = nome;
		this.tipo = tipo;
		this.costo = costo;
	}

	@Override
	public boolean equals(Object o) {
		if(o == this)
			return true;

		if(o == null)
			return false;

		if(!(o.getClass().equals(this.getClass())))
			return false;

		Piatto p = (Piatto) o;

		if(this.nome.equals(p.nome))
			return true;

		return false;
	}

	@Override
	public String toString() {
		return "Piatto (" + tipo + ") - " + nome + " [" + costo + "]" ;
	}

	public static void main(String[] args) {
		Piatto p1 = new Piatto("Tiramisù", "dessert", 8);
		Piatto p2 = new Piatto("Tiramisì", "dessert", 8);

		System.out.println(p1.equals(p2));
	}
}