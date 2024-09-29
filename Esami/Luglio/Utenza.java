import java.util.Arrays;

abstract class Utenza implements Comparable<Utenza> {
//OVERVIEW: Utenza con nome, numero e durata chiamate

//attributes
	final public String numero, nome;
	private int durata = 0;

//constructors
	public Utenza(String numero, String nome) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza Utenza. Se nome o numero null o vuoti, o numero contiene non-cifre lancia IllegalArgumentException
		if(nome == null || nome.equals(""))
			throw new IllegalArgumentException("nome null o vuoto");

		if(numero == null || numero.equals(""))
			throw new IllegalArgumentException("numero null o vuoto");

		if(numero.length() != 10)
			throw new IllegalArgumentException("lunghezza numero != 10");

		for(char c : numero.toCharArray())
			if(!(Arrays.asList('0','1','2','3','4','5','6','7','8','9').contains(c)))
				throw new IllegalArgumentException("numero contiene caratteri diversi da cifre");

		this.numero = numero;
		this.nome = nome;
	}

//methods
	public void chiama(int durata) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: incrementa durata; se <= 0 lancia IllegalArgumentException
		if(durata <= 0 )
			throw new IllegalArgumentException("durata <= 0");

		this.durata+=durata;

		assert repOk();
	}

	@Override
	public String toString() {
		return "Utenza di " + nome + ", numero: " + numero + "; durata: " + durata;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Utenza))
			return false;

		if(this.numero.equals(((Utenza)o).numero))
			return true;
		
		return false;
	}

	@Override
	public int compareTo(Utenza o) {
		return this.durata - o.durata;
	}

	public boolean repOk() {
		return durata >= 0;
	}
}