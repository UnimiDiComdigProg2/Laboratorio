import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Menu implements Iterable<Piatto> {
//OVERVIEW: modella un Menu di Piatti

	private ArrayList<Piatto> lista = new ArrayList<>(); //lista inizializzata qua e non servono parametri alla creazione -> no costruttore

	public void aggiungi(Piatto p) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: aggiungi p a this
	//         se p null lancia IllegalArgumentException
	//         se p già in this lancia IllegalArgumentException
		if(p == null)
			throw new IllegalArgumentException("p nullo");

		if(lista.contains(p))
			throw new IllegalArgumentException("p esiste in lista");

		lista.add(p);

		assert repOk();
	}

	public void rimuovi(Piatto p) {
	//MODIFIES: this
	//EFFECTS: rimuove p da this
	//         se p null lancia IllegalArgumentException
	//         se p non è già in this lancia IllegalArgumentException
		if(p == null)
			throw new IllegalArgumentException("p nullo");

		if(!(lista.contains(p)))
			throw new IllegalArgumentException("p non esiste in lista");

		lista.remove(p);
			
		assert repOk();
	}

	public void sostituisci(Piatto p1, Piatto p2) {
	//MODIFIES: this
	//EFFECTS: rimuove p1 da this e aggiunge p2 al suo posto
	//         se p1 o p2 null lancia IllegalArgumentException
	//         se p1 non è già in this lancia IllegalArgumentException
	//         se p2 già in this lancia IllegalArgumentException
		if(p1 == null)
			throw new IllegalArgumentException("p1 nullo");

		if(p2 == null)
			throw new IllegalArgumentException("p2 nullo");

		if(!(lista.contains(p1)))
			throw new IllegalArgumentException("p1 non esiste in lista");

		if(lista.contains(p2))
			throw new IllegalArgumentException("p2 esiste in lista");

		lista.set(lista.indexOf(p1), p2);

		assert repOk();
	}

	@Override
	public Iterator<Piatto> iterator() {
		return new Iterator<Piatto>() {

		Iterator<Piatto> i = lista.iterator();

			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public Piatto next() {
				return i.next();
			}
		};
	}

	public Iterator<Piatto> iterator(String tipo) {
	//EFFECTS: restituisce solo i piatti del tipo specificato

		ArrayList<Piatto> piattiFiltrati = new ArrayList<>();

		for(Piatto piatto : lista)
			if(piatto.tipo.equals(tipo))
				piattiFiltrati.add(piatto);

		

		return new Iterator<Piatto>() {

		Iterator<Piatto> i = piattiFiltrati.iterator();

			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public Piatto next() {
				
				return i.next();
			}
		};
	}

	@Override
	public String toString() {
		String ret = "Menu: \n";

		for (Piatto p : this)
			ret+= "\t" + p + "\n";

		return ret;
	}

	public boolean repOk() {
		return false;
	}

	public static void main(String[] args) {

		Menu m = new Menu();

		Scanner s = new Scanner(System.in);

		while (s.hasNextLine()) {
			
			String line = s.nextLine();

			String[] linePieces = line.split(" ");

			int prezzo = Integer.parseInt(linePieces[2].substring(0,linePieces[2].length()-1));

			Piatto p = new Piatto(linePieces[0], linePieces[1], prezzo);

			m.aggiungi(p);
		}

		System.out.println(m);

		Iterator<Piatto> iPrimi = m.iterator("primo");

		System.out.println("primi:");
		while(iPrimi.hasNext())
			System.out.println(iPrimi.next());

		Iterator<Piatto> iSecondi = m.iterator("secondo");

		System.out.println("secondi:");
		while(iSecondi.hasNext())
			System.out.println(iSecondi.next());
		


	}
}