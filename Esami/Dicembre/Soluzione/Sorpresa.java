public abstract class Sorpresa implements Comparable<Sorpresa> {
//OVERVIEW: modella una Sorpresa di un Calendario delle sorprese (immutabile)
	public final String nome;

	public Sorpresa(String nome) {
	//MODIFIES: this
	//EFFECTS: inizializza una nuova Sorpresa con nome
	//         se nome null o vuoto lancia IllegalArgumentException
		if(nome == null || nome.equals(""))
			throw new IllegalArgumentException("\tEccezione: nome null o vuoto");

		this.nome = nome;
	}

	public abstract double costo(); //se non so che sorpresa è non posso dire il costo -> metodo astratto
	//EFFECTS: restituisce il costo della sorpresa

	@Override
	public final int compareTo(Sorpresa s) { //ordinamento naturale richiesto dal tema e indispensabile per fare sort degli elementi
		return Double.compare(costo(), s.costo());
	}

	@Override
	public final boolean equals(Object o) { //richiesto dal tema e indispensabile per controllare la presenza dell'oggetto mediante contains()
		if(this == o)
			return true;

		if(o == null)
			return false;

		if(!(o instanceof Sorpresa)) //serve instanceof per controllare se o è istanza di Sorpresa. con getClass() si controllerebbe solo la classe concreta
			return false;

		if(nome.equals(((Sorpresa)o).nome))
			return true;

		return false;
	}

	@Override
	public final int hashCode() { //si dovrebbe fare sempre in coppia con equals(), indispensabile per poter usare una HashMap
		return java.util.Objects.hash(getClass(),nome);
	}

	@Override
	public String toString() {
		return nome + " (" + costo() + ")";
	}

	public static void main(String[] args) {
		Cioccolatino c = new Cioccolatino("Lindt", 25);
		System.out.println(c);
		Giocattolo g = new Giocattolo("Yorick", "di infinita allegria");
		System.out.println(g);
		Cioccolatino y = new Cioccolatino("Yorick", 1);
		System.out.println(y);
		System.out.println("I primi due sono uguali? " + c.equals(g));
		System.out.println("Gli ultimi due sono uguali? " + g.equals(y));
		System.out.println("Il primo è più grande del secondo? " + (c.compareTo(g) > 0));
	}
}