import java.util.ArrayList;
import java.util.Iterator;

public class Menu implements Iterable<Piatto> {
//OVERVIEW: modella un Menu di Piatti

	private ArrayList<Piatto> lista = new ArrayList<>(); //lista inizializzata qua e non servono parametri alla creazione -> no costruttore

	public void aggiungi(Piatto p) {
	//MODIFIES: this
	//EFFECTS: aggiungi p a this
	//         se p null lancia IllegalArgumentException
	//         se p già in this lancia IllegalArgumentException
	}

	public void rimuovi(Piatto p) {
	//MODIFIES: this
	//EFFECTS: rimuove p da this
	//         se p null lancia IllegalArgumentException
	//         se p non è già in this lancia IllegalArgumentException

	}

	public void sostituisci(Piatto p1, Piatto p2) {
	//MODIFIES: this
	//EFFECTS: rimuove p1 da this e aggiunge p2 al suo posto
	//         se p1 o p2 null lancia IllegalArgumentException
	//         se p1 non è già in this lancia IllegalArgumentException
	//         se p2 già in this lancia IllegalArgumentException
	}

	@Override
	public Iterator<Piatto> iterator() {
		return new Iterator<Piatto>() {

		//cosa sarà la rep dell'Iterator? Si può fare per delega?

			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public Piatto next() {
				return null;
			}
		};
	}

	public Iterator<Piatto> iterator(String tipo) {
	//EFFECTS: restituisce solo i piatti del tipo specificato

		//SUGGERIMENTO: qua si potrebbe filtrare i piatti per tipo

		return new Iterator<Piatto>() {

		//cosa sarà la rep dell'Iterator? Si può fare per delega?

			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public Piatto next() {
				return null;
			}
		};
	}

	@Override
	public String toString() {
		return "";
	}

	public boolean repOk() {
		return false;
	}

	public static void main(String[] args) {
	}
}