public class Decorazione {
//OVERVIEW: una decorazione di un albero natalizio

//attributi
	private final String nome;
	private final double peso;

//costruttori
	public Decorazione(String nome, double peso) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza una nuova decorazione con nome e peso. Se nome è null o vuoto, oppure peso è <= 0 lancia IllegalArgumentException
		if(nome == null || nome.equals(""))
			throw new IllegalArgumentException("nome nullo o vuoto");

		if(peso <= 0)
			throw new IllegalArgumentException("peso <= 0");

		this.nome = nome;
		this.peso = peso;
	}

//metodi
	public String getNome() {
		return this.nome;
	}

	public double getPeso() {
		return this.peso;
	}
	
	@Override
	public String toString() {
		return "\tDecorazione: " + this.nome + "; peso: " + this.peso;
	}
}