import java.util.ArrayList;
import java.util.Iterator;

public class Persona implements Iterable<Pet> {
//OVERVIEW: modella una persona con dei Pet
	private final String nome;
	private ArrayList<Pet> pets = new ArrayList<>();

	public Persona(String nome) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza Persona col nome
	//         se nome nullo o vuoto lancia IllegalArgumentException
	if(nome == null || nome.equals(""))
		throw new IllegalArgumentException("nome nullo o vuoto");

		this.nome = nome;

		assert repOk();
	}

	public String getNome() {
		return this.nome;
	}

	public void add(Pet pet) throws PetException {
	//MODIFIES: this
	//EFFECTS: aggiungi pet
	//         se pet nullo lancia IllegalArgumentException
	//         se pet esiste lancia PetException

	if(pet == null)
		throw new IllegalArgumentException("nome nullo o vuoto");

	if(this.pets.contains(pet)) //si può fare anche un'eccezione pù specifica
		throw new PetException("pet già inserito");

		pets.add(pet);

		assert repOk();
	}

	public void remove(String nome) throws PetException {
	//MODIFIES: this
	//EFFECTS: rimuovi pet con nome
	//         se nome nullo o vuoto lancia IllegalArgumentException
	//         se pet non esiste lancia PetException
		if(nome == null || nome.equals(""))
			throw new IllegalArgumentException("nome nullo o vuoto");

		for(Pet p: pets)
			if(nome.equals(p.getNome()) && pets.remove(p))
				return;

		throw new PetException("pet non esiste");
	}

	@Override
	public String toString() {
		return "Persona: " + nome;
	}

	public boolean repOk() {
		if(nome == null || nome.equals(""))
			return false;

		if(pets == null)
			return false;

		for(Pet p : pets)
			if(p == null)
				return false;
			else if(pets.indexOf(p) != pets.lastIndexOf(p))
				return false;

		return true;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;

		if(o == null)
			return false;

		if(!(this.getClass().equals(o.getClass())))
			return false;

		if(!(this.getNome().equals(((Persona) o).getNome())))
			return false;

		return true;
	}

	@Override
	public Iterator<Pet> iterator() {
		return new Iterator<Pet>() {

			Iterator<Pet> ip = pets.iterator(); //composizione

			@Override
			public boolean hasNext() {
				return ip.hasNext(); //delega
			}

			@Override
			public Pet next() {
				return ip.next(); //delega
			}
		};
	}
}