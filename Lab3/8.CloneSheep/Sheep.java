//Grazie a Nicola Montagnese per il codice
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Sheep implements Cloneable {
//OVERVIEW: models a a sheep with its dna and a unique name
	final private ArrayList<String> dna; //dna può essere modificato perchè ArrayList è mutabile. final rende solo il puntatore in memoria a dna immutabile
	final private String nome;

//CONSTRUCTORS
	// @SuppressWarnings("unchecked") //serve se si usa clone percé serve casting di ArrayList
	public Sheep(ArrayList<String> dna, String nome) throws NullPointerException, IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: creates a sheep
	//         if dna is null throw NullPointerException
	//         if nome is null or empty throw InputMismatchException

		if(dna == null)
			throw new NullPointerException("Dna cannot be empty");

		if(nome == null || nome.equals(""))
			throw new InputMismatchException("Name must be declared");

		for(String s : dna)
			if(s == null || s.equals(""))
				throw new InputMismatchException("Cromosome null or empty");

		//essendo ArrayList mutabile serve clone. il clone di ArrayList fa una "shallow copy", cioè è clonata la ArrayList, ma non i suoi elementi, quindi ora ci sono due arraylist che puntano agli stessi elementi. Questo va bene perchè tanto è una arraylist di String che sono immutabili.
		//this.dna = (ArrayList<String>)(dna.clone());

		//alternativamente si può usare il copy constructor di ArrayList che non è un'operazione unchecked
		this.dna = new ArrayList<String>(dna);

		this.nome = nome; //non serve clone perchè stringa è immutabile
//		assert repOk(); //NON ANCORA FATTO
	}

//METHODS
	//@SuppressWarnings("unchecked") //serve se uso clone
	public ArrayList<String> getDna() {
	//EFFECTS: returns sheep dna
		//return (ArrayList<String>) this.dna.clone(); //essendo ArrayList mutabile serve clone.
		return new ArrayList<String>(this.dna); //copy constructor
	}

	public String getNome() {
	//EFFECTS: returns sheep name
		return this.nome; //non essendo mutabile non serve clone
	}

	public String leggiCromosoma(int indice) throws InputMismatchException {
	//EFFECTS: returns a String of cromosoma at the indice indicated
	//         if indice is < = 0 it throws an InputMismatchException
		if((indice < 0) || (indice >= this.dna.size())) //attenzione agli indici
			throw new InputMismatchException("indice fuori dal range del dna");

		return this.dna.get(indice);
	}

	public void sostituisciCromosoma(String cromosoma, int indice) throws InputMismatchException {
	//MODIFIES: this
	//EFFECTS: replaces dna at indice with cromosoma
	//         throws InputMismatchException if indice is out of array boundaries
		if((indice <= 0) || (indice >= this.dna.size()))
			throw new InputMismatchException("indice fuori dal range del dna");

		if(cromosoma == null || cromosoma.equals(""))
			throw new InputMismatchException("Name must be declared");

		this.dna.set(indice, cromosoma); //non serve clone perché String immutabile
//		assert repOk(); //NON ANCORA FATTO
	}

	//come dicevamo a teoria, il clone default restituisce Object, ma è possibile nella ridefinizione far restituire una sottoclasse. Per comodità restituiamo Sheep
	//inoltre il clone normalmente lancerebbe CloneNotSupportedException, ma è possibile nella ridefinizione lanciare eccezioni più specifiche o non lanciarle affatto.
	//se però usassimo super.clone() invece del costruttore, quel metodo lancerebbe CloneNotSupportedException e in tal caso o la dovremmo rilanciare o mascherare
	public Sheep clone() { // CLONE
			return new Sheep(dna, nome); //possiamo usare il costruttore invece del clone perchè tutta la rappresentazione può essere passata in fase di costruzione.
	}

	public boolean equals(Object o) {
		if(o == null)
			return false;

		if(!(o instanceof Sheep))
			return false;

		Sheep p = (Sheep) o;

		if(!(p.nome.equals(this.nome)))
			return false;

		if(!this.dna.equals(p.dna)) //DRAGAN: ArrayList ha equals, usiamolo
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "Sheep " + this.nome + "\n" + dna;
	}

/* ANCORA NON FATTO
	public boolean repOk() {
		if(this.nome == null || this.nome.equals(""))
			return false;

		if(this.dna == null)
			return false;

		for(String s : dna)
			if(s == null || s.equals(""))
				return false;

		return true;
	}
*/
}