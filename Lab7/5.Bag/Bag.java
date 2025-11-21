import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Bag<E> implements Iterable<E> {//anche qua non posso usare clone su E perchè potrebbe non averlo
//OVERVIEW: modella un Multiset (o Bag) che memorizza gli elementi inseriti e il numero di volte di inserimento per ciascuno

	HashMap<E,Integer> map = new HashMap<>();

//metodi
	public void add(E elem) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inserisci elem in this
	//         se elem == null lancia IllegalArgumentException
		if(elem == null)
			throw new IllegalArgumentException("elemento è null");

		map.put(elem, map.getOrDefault(elem, 0)+1);
		//elem potrebbe cambiare da fuori e diventare uguale a un altro. É un problema irrisolvibile

		assert repOk();
	}

	public void remove(E elem) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: rimuove elem da this
	//         se elem == null lancia IllegalArgumentException

		if(elem == null)
			throw new IllegalArgumentException("elemento è null");

		if(map.containsKey(elem))
			if(map.replace(elem, map.get(elem)-1) == 1)
				map.remove(elem);

		assert repOk();
	}

	@Override
	public Iterator<E> iterator() {
	//EFFECTS: restituisce un Iterator di E
		return new Iterator<E>() {
			Iterator<E> keys = map.keySet().iterator();
			E curr = keys.next();
			int counter = 0;

			@Override
			public boolean hasNext() {
			//EFFECTS: se ci sono ancora elementi ed il loro contatore
			//         è inferiore al numero degli elementi restituisce true;
			//         false altrimenti
				if(map.get(curr) > counter)
					return true;

				if(keys.hasNext())
					return true;

				return false;
			}

			@Override
			public E next() throws NoSuchElementException {
			//MODIFIES: contatore degli elementi, elemento corrente
			//EFFECTS: restituisce il prossimo elemento, aggiornando il contatore
			//         se il contatore dell'elemento supera la disponibilità passa al successivo
			//         se non ci sono più elementi throw NoSuchElementException
				if(!(this.hasNext()))
					throw new NoSuchElementException("no more elements");

				if(map.get(curr) > counter)
					counter++;
				else {
					curr = keys.next();
					counter = 1;
				}
				return curr;
			}
		};
	}

	public boolean repOk() {
		for(E elem: map.keySet())
			if(elem == null || map.get(elem) == null || map.get(elem) <= 0)
				return false;

		return true;
	}

	@Override
	public String toString() {
		String ret = "Bag - elements: [ ";

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
				b.add(s.nextInt());

			System.out.println(b);

		} else if(type.equals("Double")) {

			Bag<Double> b = new Bag<Double>();
			System.out.println("Inserisci numeri Razionali (CTRL+D per terminare)");
			while(s.hasNextDouble())
				b.add(s.nextDouble());

			System.out.println(b);

		} else if(type.equals("String")) {

			Bag<String> b = new Bag<String>();
			System.out.println("Inserisci Stringhe (CTRL+D per terminare)");
			while(s.hasNext())
				b.add(s.next());

			System.out.println(b);

		}
	}
}