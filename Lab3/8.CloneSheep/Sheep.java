//Grazie a Nicola Montagnese per il codice

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Sheep implements Cloneable {
// OVERVIEW: it models a a sheep with a its dna and a unique name
// note this class is immutable, it doesn't allow manipolators methods
// if an istance of the class is created it'll be a new one or a clone
// attributes are therefore final
	final private ArrayList<String> dna;
	final private String nome;

//constructors
	public Sheep(ArrayList<String> dna, String nome) throws NullPointerException, IllegalArgumentException {
	//MODIFIES: this statements
	//EFFECTS: it creates an unique istance of a sheep
	//         note if dna is null, or nome is null or is empty, it throws respectively
	//         nullpointer or illegal exception

		if (dna == null)
			throw new NullPointerException("Dna cannot be empty");

		if (nome.equals("") || nome == null)
			throw new InputMismatchException("Name must be declared");

		this.dna = (ArrayList<String>)(dna.clone());
		this.nome = nome;
		assert repOk();
	}

// METHODS:
	public ArrayList<String> getDna() { // OBSERVER //DRAGAN: bella questa cosa di segnalare che tipo di metodo è
	//EFFECTS: it returns the name of the sheep
		return (ArrayList<String>) this.dna.clone();
	}

	public String getNome() { // OBSERVER
		return this.nome;
	}

	public boolean equals(Object o) { // EQUALS. DRAGAN: la cosa migliore è fare i controlli uno per uno - più pulito e si evitano parentesi e indentazioni inutili.
		if(o == null)
			return false;

		if(!(o instanceof Sheep))
			return false;

		Sheep p = (Sheep) o;

		if(!(p.nome.equals(this.nome))) //usare sintassi diretta invece dei getter è possibile qua dentro (e meno dispendioso)
			return false;

		//ArrayList<String> dna = this.getDna(); DRAGAN: queste istruzioni clonano il dna il che qua non serve perchè tanto non li modifico. È solo dispendioso come risorse. meglio usare accesso diretto 
		//ArrayList<String> dnaToCompare = p.getDna();

		try {
			for (int i = 0; i < dna.size(); i++)
				if(!(this.leggiCromosoma(i).equals(p.leggiCromosoma(i)))) //DRAGAN: se si usa leggiCromosoma invece del get si ottiene gratuitamente il controllo del range dell'indice, potendo così usare un try/catch per gestire la cosa
					return false;

		} catch(InputMismatchException e) {
			return false;
		}

		return true;
	}

	public Object clone() throws CloneNotSupportedException { // CLONE
		ArrayList<String> lista = this.getDna();
		String nome = this.getNome();

		return new Sheep(lista, nome);
	}

	public String leggiCromosoma(int indice) throws InputMismatchException {
	//EFFECTS: it returns a String of cromosoma at the indice indicated
	//         if indice is < = 0 it throws an InputMismatchException
		if((indice < 0) || (indice >= this.dna.size())) //DRAGAN: attenzione agli indici <= 0 vuol dire che quando si controlla il primo indice da inevitabilmente l'eccezione e quindi in equals da false! serve <0
			throw new InputMismatchException("indice fuori dal range del dna"); //DRAGAN: bisogna controllare anche se l'indice va fuori dal range

		return this.dna.get(indice);
	}

	public void sostituisciCromosoma(String cromosoma, int indice) throws InputMismatchException {
	//MODIFIES: this
	//EFFECTS: replaces dna at indice with cromosoma
	//         throws InputMismatchException if indice is out of array boundaries
		if((indice <= 0) || (indice >= this.dna.size()))
			throw new InputMismatchException("indice fuori dal range del dna"); //DRAGAN: anche qua ci sta controllare sul range dell'indice

		if (cromosoma.equals("") || cromosoma == null)
			throw new InputMismatchException("Name must be declared"); //DRAGAN: ci sta anche controllare la stringa

		this.dna.set(indice, cromosoma);
	}

	public boolean repOk() { // REPRESENTATION INVARIANT
		if (this.dna == null)
			return false;

		if (this.nome.equals("") || this.nome == null)
			return false;

		return true;
	}
}