import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Calendario implements Iterable<Sorpresa> {
//OVERVIEW: modella un Calendario delle sorprese
	private HashMap<Integer,Sorpresa> sorprese = new HashMap<>();

	public void inserisci(int giorno, Sorpresa s) throws GiornoException {
	//MODIFIES: this
	//EFFECTS: aggiungi s a this per il giorno specificato
	//         se s null lancia IllegalArgumentException
	//         se giorno < 1 o > 31 lancia IllegalArgumentException
	//         se presente una sorpresa per il giorno specificato lancia una GiornoException
	//         se già presente questa sorpresa in this lancia una SorpresaException
		if(s == null)
			throw new IllegalArgumentException("\tEccezione: Sorpresa null");

		if(giorno < 1 || giorno > 31)
			throw new IllegalArgumentException("\tEccezione: Giorno non valido");

		if(sorprese.containsKey(giorno))
			throw new GiornoException("\tEccezione: Una sorpresa già presente per il giorno");

		if(sorprese.values().contains(s))
			throw new SorpresaException("\tEccezione: Questa sorpresa già presente nel calendario");

		sorprese.put(giorno, s);
		assert repOk();
	}

	public Sorpresa apri(int giorno) throws GiornoException {
	//MODIFIES: this
	//EFFECTS: rimuovi da this e restituisci Sorpresa per il giorno specificato
	//         se giorno < 1 o > 31 lancia IllegalArgumentException
	//         se non è presente una sorpresa per il giorno specificato lancia una GiornoException
		if(giorno < 1 || giorno > 31)
			throw new IllegalArgumentException("\tEccezione: Giorno non valido");

		Sorpresa s = sorprese.remove(giorno);

		if(s == null)
			throw new GiornoException("\tEccezione: Nessuna sorpresa per il giorno");

		assert repOk();
		return s;
	}

	public double costo() {
	//EFFECTS: restituisce il costo totale del Calendario
		return sorprese.values().stream().mapToDouble(i -> i.costo()).sum(); //si può fare con un semplice ciclo for
	}

	@Override
	public Iterator<Sorpresa> iterator() {
	//EFFECTS: restituisce un iteratore alle sorprese del calendario, ordinate per costo

		ArrayList<Sorpresa> a = new ArrayList<>(sorprese.values());
		a.sort(null);

		return new Iterator<Sorpresa>() {
			Iterator<Sorpresa> i = a.iterator(); 

			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public Sorpresa next() {
				return i.next();
			}
		};
	}

	@Override
	public String toString() {
		String ret = "Calendario delle sorprese (" + costo() + ")";
		for(Sorpresa s : this)
				ret+="\n\t" + s;

		return ret;
	}

	public boolean repOk() {
		if(sorprese == null)
			return false;

		for(int g: sorprese.keySet())
			if(g < 1 || g > 31)
				return false;

		ArrayList<Sorpresa> sl = new ArrayList<Sorpresa>(sorprese.values());

		for(Sorpresa s: sl)
			if(s == null || sl.indexOf(s) != sl.lastIndexOf(s))
				return false;

		return true;
	}
}