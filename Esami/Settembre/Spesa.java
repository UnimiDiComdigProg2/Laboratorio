import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Spesa implements Iterable<Prodotto> {
//OVERVIEW: modella una Spesa costituita da prodotti
	private HashMap<Prodotto, Integer> m = new HashMap<>();

	public void aggiungi(Prodotto p, int qty) throws ElementException, IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: aggiunge p con qty a this
	//         lancia IllegalArgumentException se p null o se qty <= 0
	//         lancia ElementException se un altro prodotto con lo stesso codice esiste
		if(p == null)
			throw new IllegalArgumentException("E:p null");

		if(qty <= 0)
			throw new IllegalArgumentException("E:qty <= 0");

		for(Prodotto p2 : m.keySet())
			if(p.getCodice().equals(p2.getCodice()))
				throw new ElementException("E:product with same code exists");

		m.put((Prodotto) p.clone(), qty+m.getOrDefault(p, 0));

		assert repOK();
	}

	public void rimuovi(String c) throws ElementException, IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: rimuove il prodotto con il codice c da this
	//         lancia IllegalArgumentException se c null o vuota 
	//         lancia NoSuchElementException se prodotto non esiste
		if(c == null)
			throw new IllegalArgumentException("E:c null");

		for(Prodotto p : m.keySet()) {
			if(p.getCodice().equals(c)) {
				m.remove(p);
				assert repOK();
				return;
			}
		}

		throw new ElementException("E:c does not exist");
	}

	@Override
	public Iterator<Prodotto> iterator() {
		ArrayList<Prodotto> list = new ArrayList<>(m.keySet());
		list.sort(null);

		return new Iterator<Prodotto>() {

			Iterator<Prodotto> i = list.iterator();

			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public Prodotto next() {
				return i.next();
			}
		};
	}

	public double tot() {
	//EFFECTS: restituisce costo totale della spesa
		double ret = 0;

		for(Prodotto p : this)
			ret += m.get(p) * p.getPrezzo();

		return ret;
	}

	@Override
	public String toString() {
		String ret = "Spesa:";
		for(Prodotto p : this)
			ret += "\n\t" + p + " qty: " + m.get(p);

		ret += "\nTot: " + tot();
		return ret;
	}

	public boolean repOK() {
		for(Prodotto p : m.keySet())
			if(p == null)
				return false;
			else if(m.get(p) <= 0)
				return false;

		return true;
	}
}