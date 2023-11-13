import java.lang.*;
import java.util.*;

public class Menu implements Iterable<Piatto> {
//OVERVIEW: this class models a set of Piatto
//class mutable, concrete

//ATTRIBUTES
	private ArrayList<Piatto> piatti;

	// CONSTRUCTORS:
	public Menu() {
	//MODIFIES: this
	//EFFECTS: initializes this
		this.piatti = new ArrayList<Piatto>();

		assert repOk();
	}

	// CONCRETE METHODS:
	public boolean repOk() { //REPRESENTATION INVARIANT
		if(this.piatti == null)
			return false;

		for(Piatto p : piatti)
			if(p == null)
				return false;
			else if(piatti.indexOf(p) != piatti.lastIndexOf(p)) //se ci sono ripetizioni
				return false;

		return true;
	}

	@Override
	public String toString() {
		String ret = "primi:\n";

		Iterator<Piatto> primi = this.iterator("primo");
		while(primi.hasNext())
			ret+= "\t" + primi.next() + "\n";

		ret+="\nsecondi:\n";

		Iterator<Piatto> secondi = this.iterator("secondo");
		while(secondi.hasNext())
			ret+= "\t" + secondi.next() + "\n";

		return ret;
	}

	public void aggiungiPiatto(Piatto piatto) throws NullPointerException, IllegalArgumentException { //MANIPULATOR
	//MODIFIES: this
	//EFFECTS: this method adds a plate in the menu
	//         if piatto is null throws a nullpointerexception
	//         if piatto exists throw IllegalArgumentException

		if(piatto == null)
			throw new NullPointerException("Piatto null");

		if(piatti.contains(piatto))
			throw new IllegalArgumentException("Piatto esiste");

		this.piatti.add(piatto);

		assert repOk();
	}

	public void togliPiatto(String piatto) throws NullPointerException, IllegalArgumentException { // MANIPULATOR
	//MODIFIES: this
	//EFFECTS: this method removes a piatto from the menu
	//         if piatto is null or empty throws nullpointerexception

		if(piatto == null || piatto.equals(""))
			throw new NullPointerException("Piatto null o vuoto");

		if(!piatti.contains(piatto))
			throw new IllegalArgumentException("Piatto non esiste");

		this.piatti.remove(piatto);

		assert repOk();
	}

	public void modificaPiatto(Piatto piattoNew, Piatto piattoOld) throws NullPointerException, IllegalArgumentException { // MANIPULATOR
		// MODIFIES: this
		// EFFECTS: this method modifies a plate in the menu
		//          if plate is null throws a nullpointerexception

		if(piattoOld == null || piattoOld.equals(""))
			throw new NullPointerException("piattoOld null o vuoto");

		if(piattoNew == null)
			throw new NullPointerException("piattoNew null o vuoto");

		if(!piatti.contains(piattoOld))
			throw new IllegalArgumentException("piattoOld non esiste");

		this.piatti.set(piatti.indexOf(piattoOld), piattoNew);

		assert repOk();
	}

	public Iterator<Piatto> iterator() { //notare l'uso di null per evitare di scrivere due volte il codice o dover fare IteraPiatti Inner non Local
		return this.iterator(null);
	}

	public Iterator<Piatto> iterator(String type) { // ITERATOR

		class IteraPiatti implements Iterator<Piatto> { // INNER CLASS. si poteva fare astratta?
		String type;
		Piatto next;
		Iterator<Piatto> iters;

		private IteraPiatti(String type) {
			this.type = type;
			this.next = null;
			this.iters = Menu.this.piatti.iterator();

			while(iters.hasNext()) {
				Piatto tmp = iters.next();
				if(type == null || tmp.getTipo().equals(type)) {
					this.next = tmp; // imposto il primo elemento next. se non lo trova rimane null
					break;
				}
			}
		}

		public boolean hasNext() { 
			if(this.next == null)
				return false;

			return true;
		}

		public Piatto next(){
			if(this.next == null)
				throw new NoSuchElementException("Non ci sono più piatti");

			Piatto ret = this.next;

			while(iters.hasNext()) {
				Piatto tmp = iters.next();
				if(type == null || tmp.getTipo().equals(type)) {
					this.next = tmp; // imposto il prossimo elemento next
					return ret;
				}
			}

			this.next = null; //se non lo trova next diventa null
			return ret;
		}
	}

		return new IteraPiatti(type);
	}

	public static void main(String[] args) {
		Menu menu = new Menu();

		Scanner s = new Scanner(System.in);

		System.out.println("aggiungi i piatti nel formato: nome tipo costo (terminare la lettura con CTRL+D):");
		while (s.hasNext()) {
			String nome = s.next();
			String tipo = s.next();
			String costos = s.next();
			int costo = Integer.parseInt(costos.substring(0, costos.length() - 1));
			
			try {
				menu.aggiungiPiatto(new Piatto(nome, tipo, costo));
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println();
		System.out.println(menu);
	}
}