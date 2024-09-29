import java.lang.*;
import java.util.*;

public class Menu implements Iterable<Piatto> {
// OVERVIEW: this class models a set of Piatto
// class mutable, concrete

	// CLASS ATTRIBUTES
	private ArrayList<Piatto> piatti;

	// CONSTRUCTORS:
	public Menu() throws NullPointerException { //DRAGAN: non ha senso inserire la lista nel costruttore. Meglio aggiungerli uno ad uno come arrivano
		// MODIFIES: this
		// EFFECTS: initializes this
		this.piatti = new ArrayList<Piatto>();
		
		assert repOk();
	}

	// CONCRETE METHODS:
	public boolean repOk() { //REPRESENTATION INVARIANT
	//DRAGAN: mi immagino che non ci siano ripetizioni nel menu, quindi non dovrebbero esserci piatti uguali nel menu
	//DRAGAN: e i piatti singoli non dovrebbero essere null
		if (this.piatti == null)
			return false;

		return true;
	}

	private ArrayList<Piatto> getMenu() { // OBSERVER
		// EFFECTS: it returns this piatti
		return this.piatti;
	}

	public void aggiungiPiatto(Piatto piatto) throws NullPointerException { // MANIPULATOR
		// MODIFIES: this
		// EFFECTS: this method adds a plate in the menu
		// it plate is null it thwrows a nullpointerexception
		if (piatto == null)
			throw new NullPointerException("Piatto null");

		this.getMenu().add(piatto);
	}

	public void togliPiatto(Piatto piatto) throws NullPointerException { // MANIPULATOR
		// MODIFIES: this
		// EFFECTS: this method removes a plate in the menu
		// it plate is null it thwrows a nullpointerexception

		if (piatto == null)
			throw new NullPointerException("Piatto null");

		this.getMenu().remove(piatto);
	}

	public void modificaPiatto(Piatto piatto, int indice) throws NullPointerException { // MANIPULATOR
		// MODIFIES: this
		// EFFECTS: this method modifies a plate in the menu
		// it plate is null it thwrows a nullpointerexception

		if (piatto == null)
			this.getMenu().set(indice, piatto);
	}

	public Iterator<Piatto> iterator() { //Dragan: notare l'uso di null per evitare di scrivere il doppio costruttore di IteraPiatti e per evitare di farla Inner non Local
		return this.iterator(null);
	}

	public Iterator<Piatto> iterator(String type) { // ITERATOR
	
		class IteraPiatti implements Iterator<Piatto> { // INNER CLASS
		String type;
		Piatto next;
		Iterator<Piatto> iters;
		
		private IteraPiatti(String type) {
			this.type = type;
			this.iters = Menu.this.piatti.iterator();
		}
		
		public boolean hasNext() { //hasnext cicla i piatti e se trova uno del tipo corretto 
			while(this.iters.hasNext()) {
				Piatto tmp = this.iters.next();
				
				if((tmp.getTipo().equals(this.type)) || (this.type == null)) {
					this.next = tmp;
					return true;
				}
			}
			this.next = null;
			return false;
		}
		
		public Piatto next(){
			if(this.next == null)
				throw new NoSuchElementException("Non ci sono più piatti");
				
			return this.next;
		}
	}
	
		return new IteraPiatti(type);
	}

	public static void main(String[] args) { // MAIN TESTING
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
		System.out.println("Primi:");
		Iterator<Piatto> primi = menu.iterator("primo");
		while(primi.hasNext())
			System.out.println(primi.next());

		System.out.println();
		System.out.println("Secondi:");
		Iterator<Piatto> secondi = menu.iterator("secondo");
		while(secondi.hasNext())
			System.out.println(secondi.next());

		System.out.println();
		System.out.println("Tutti:");
		for(Piatto p : menu)
			System.out.println(p);
	}
}
