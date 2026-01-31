abstract public class Evento implements Comparable<Evento> {
//OVERVIEW: modella un Evento delle olimpiadi invernali (immutabile)

	final public String nome;

	public Evento(String nome) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza this con nome evento
	//         se nome null o vuoto lancia IllegalArgumentException
		if(nome == null || nome.equals(""))
			throw new IllegalArgumentException("\tECCEZIONE: nome null o vuoto");

		this.nome = nome;
	}

	abstract public int durata();
	//EFFECTS: restituisce durata dell'evento in minuti

	@Override
	public int compareTo(Evento e) {
		return Integer.compare(this.durata(), e.durata());
	}

	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;

		if(o == this)
			return true;

		if(!(o instanceof Evento))
			return false;

		if(((Evento) o).nome.equals(this.nome))
			return true;

		return false;
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(getClass(),nome);
	}

	@Override
	public String toString() {
		return " nome: " + nome + " durata: " + durata();
	}

	public static void main(String[] args) {
		Cerimonia c = new Cerimonia("Apertura2026", true);
		System.out.println(c);
		Gara g = new Gara("Slittino1", 15);
		System.out.println(g);
		Cerimonia c2 = new Cerimonia("Slittino1", false);
		System.out.println(c2);
		System.out.println("I primi due sono uguali? " + c.equals(g));
		System.out.println("Gli ultimi due sono uguali? " + g.equals(c2));
		System.out.println("Il primo è più grande del secondo? " + (c.compareTo(g) > 0));
	}
}