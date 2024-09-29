//Grazie a Nicola Montagnese per il codice
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Sheep implements Cloneable {
// OVERVIEW: models a a sheep with its dna and a unique name
	final private ArrayList<String> dna; //DRAGAN: dna può essere modificato perchè ArrayList è mutabile. final rende solo il puntatore in memoria a dna immutabile
	final private String nome;

//CONSTRUCTORS
	@SuppressWarnings("unchecked") //serve perchè uso un casting di ArrayList dopo il clone
	public Sheep(ArrayList<String> dna, String nome) throws NullPointerException, IllegalArgumentException {
	// MODIFIES: this
	// EFFECTS: creates a sheep
	//          if dna is null throw NullPointerException
	//          if nome is null or empty throw InputMismatchException

		if(dna == null)
			throw new NullPointerException("Dna cannot be empty");

		if(nome == null || nome.equals("")) //DRAGAN: il controllo di null va prima del controllo di equals perchè se è null non ci si può chiamare su equals
			throw new InputMismatchException("Name must be declared");

		for(String s : dna) //DRAGAN: servirebbe anche un controllo cromosoma per cromosoma per vedere che non sia null o vuoto
			if(s == null || s.equals(""))
				throw new InputMismatchException("Cromosome null or empty");

		this.dna = (ArrayList<String>)(dna.clone()); //DRAGAN: essendo ArrayList mutabile serve clone. il clone di ArrayList fa una "shallow copy", cioè è clonata la ArrayList, ma non i suoi elementi, quindi ora ci sono due arraylist che puntano agli stessi elementi. Questo va bene perchè tanto è una arraylist di String che sono immutabili.
		this.nome = nome; //DRAGAN: non serve clone perchè stringa è immutabile
		assert repOk();
	}

//METHODS
	@SuppressWarnings("unchecked") //serve perchè uso un casting di ArrayList dopo il clone
	public ArrayList<String> getDna() { // OBSERVER //DRAGAN: bella questa cosa di segnalare che tipo di metodo è, volendo è un getter
	// EFFECTS: returns sheep dna
		return (ArrayList<String>) this.dna.clone(); //DRAGAN: essendo ArrayList mutabile serve clone.
	}

	public String getNome() { // OBSERVER
	// EFFECTS: returns sheep name
		return this.nome; //DRAGAN: non essendo mutabile non serve clone
	}

	public boolean equals(Object o) { // EQUALS. DRAGAN: la cosa migliore è fare i controlli uno per uno - più pulito e si evitano parentesi e indentazioni inutili.
		if(o == null)
			return false;

		if(!(o instanceof Sheep))
			return false;

		Sheep p = (Sheep) o;

		if(!(p.nome.equals(this.nome))) //DRAGAN: usare sintassi diretta invece dei getter è possibile qua dentro (e meno dispendioso)
			return false;

		if(!this.dna.equals(p.dna)) //DRAGAN: ArrayList ha equals, usiamolo
			return false;

		return true;
	}

	//DRAGAN: come vedremo più avanti, il clone default restituisce Object, ma è possibile nella ridefinizione far restituire una sottoclasse. Per comodità restituiamo Sheep
	//inoltre il clone normalmente lancerebbe CloneNotSupportedException, ma è possibile nella ridefinizione lanciare eccezioni più specifiche o non lanciarle affatto.
	//se però usassimo super.clone() invece del costruttore, quel metodo lancerebbe CloneNotSupportedException e in tal caso o la dovremmo rilanciare o mascherare
	public Sheep clone() { // CLONE
			return new Sheep(dna, nome); //possiamo usare il costruttore invece del clone perchè tutta la rappresentazione è passata in fase di costruzione.
	}

	public String leggiCromosoma(int indice) throws InputMismatchException {
	// EFFECTS: returns a String of cromosoma at the indice indicated
	//          if indice is < = 0 it throws an InputMismatchException
		if((indice < 0) || (indice >= this.dna.size())) //DRAGAN: attenzione agli indici <= 0 vuol dire che quando si controlla il primo indice da inevitabilmente l'eccezione e quindi in equals da false! serve <0
			throw new InputMismatchException("indice fuori dal range del dna"); //DRAGAN: bisogna controllare anche se l'indice va fuori dal range

		return this.dna.get(indice);
	}

	public void sostituisciCromosoma(String cromosoma, int indice) throws InputMismatchException {
	// MODIFIES: this
	// EFFECTS: replaces dna at indice with cromosoma
	//          throws InputMismatchException if indice is out of array boundaries
		if((indice <= 0) || (indice >= this.dna.size()))
			throw new InputMismatchException("indice fuori dal range del dna"); //DRAGAN: anche qua ci sta controllare sul range dell'indice

		if(cromosoma == null || cromosoma.equals(""))
			throw new InputMismatchException("Name must be declared"); //DRAGAN: ci sta anche controllare la stringa

		this.dna.set(indice, cromosoma);
	}

	public boolean repOk() { // REPRESENTATION INVARIANT
		if(this.nome == null || this.nome.equals(""))
			return false;

		if(this.dna == null)
			return false;

		for(String s : dna) //DRAGAN: servirebbe anche un controllo cromosoma per cromosoma per vedere che non sia null o vuoto
			if(s == null || s.equals(""))
				return false;

		return true;
	}
}