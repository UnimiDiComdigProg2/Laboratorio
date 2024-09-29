import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Bag<E> implements Iterable<E> {
//OVERVIEW: modella un Multiset (o Bag) che memorizza gli elementi inseriti
//          e il numero di volte di inserimento per ciascuno

	HashMap<E,Integer> map;

//costruttori
	public Bag() {
	//MODIFIES: this
	//EFFECTS: inizializza this
		map = new HashMap<>();
	}

//metodi
	public void insert(E elem) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: if elem != null inserisci in this, altrimenti lancia IllegalArgumentException
		if(elem == null) throw new IllegalArgumentException("elemento è null");

		Integer count = map.putIfAbsent(elem, 1);

		if(count != null)
			map.replace(elem, count+1);
	}

	public void remove(E elem) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: if elem != null lo rimuove da this, altrimenti lancia IllegalArgumentException
	if(elem == null) throw new IllegalArgumentException("elemento è null");

		Integer count = map.get(elem);

		if(count != null) {
			if(count == 1)
				map.remove(elem);
			else
				map.replace(elem, count-1);
		}
	}

	@Override
	public Iterator<E> iterator() {
	//EFFECTS: restituisce un Iterator di E
		return new Iterator<E>() {
			E curr = null;
			int counter = 1;
			Iterator<E> keys = map.keySet().iterator();

			@Override
			public boolean hasNext() {
			//EFFECTS: se ci sono ancora elementi ed il loro contatore
			//         è inferiore al numero degli elementi restituisce true;
			//         false altrimenti
				if(curr != null && map.get(curr) > counter)
					return true;
				else if(keys.hasNext())
					return true;

				return false;
			}

			@Override
			public E next() throws NoSuchElementException {
			//MODIFIES: contatore degli elementi, elemento corrente
			//EFFECTS: restituisce il prossimo elemento, aggiornando il contatore
			//         se il contatore dell'elemento supera la disponibilità passa al successivo
			//         se non ci sono più elementi throw NoSuchElementException
				if(!(this.hasNext())) throw new NoSuchElementException("no more elements");

				if(curr != null && map.get(curr) > counter)
					counter++;
				else {
					curr = keys.next();
					counter = 1;
				}
				return curr;
			}
		};
	}

	@Override
	public String toString() {
		String ret = "Bag - elements: [ ";
		//Iterator<E> iter = this.iterator();
		//while(iter.hasNext())
		//   ret += iter.next() + " ";

		for(E i : this)
			ret += i + " ";

		return ret + "]";
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String type = args[0];
		
		if(type.equals("Integer")) {
			Bag<Integer> b = new Bag<Integer>();
			
			System.out.println("Inserisci numeri Interi (CTRL+D per terminare)");
			while(s.hasNextInt())
				b.insert(s.nextInt());
			
			System.out.println(b);
		} else if(type.equals("Double")) {
			Bag<Double> b = new Bag<Double>();
			
			System.out.println("Inserisci numeri Razionali (CTRL+D per terminare)");
			while(s.hasNextDouble())
				b.insert(s.nextDouble());
			
			System.out.println(b);
		} else if(type.equals("String")) {
			Bag<String> b = new Bag<String>();
			
			System.out.println("Inserisci Stringhe (CTRL+D per terminare)");
			while(s.hasNext())
				b.insert(s.next());
			
			System.out.println(b);
		} else
			System.exit(1);
	}
}