import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Olimpiade implements Iterable<Evento> {
//OVERVIEW: modella la programmazione di un'edizione delle olimpiadi invernali (mutable)

	private HashMap<Integer,Evento> calendario = new HashMap<>();
	final public int anno;

	public Olimpiade(int anno) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza Olimpiade per l'anno
	//         se anno <= 0 lancia IllegalArgumentException
		if(anno <= 0)
			throw new IllegalArgumentException("\tECCEZIONE: anno <= 0");

		this.anno = anno;

		assert repOk();
	}

	public void aggiungi(int giorno, Evento e) throws IllegalArgumentException, NullPointerException, EventoException, GiornoException {
	//MODIFIES: this
	//EFFECTS: aggiungi e a giorno
	//         se giorno <= 0 o > 19 lancia IllegalArgumentException
	//         se e null lancia NullPointerException
	//         se e è Cerimonia apertura e giorno != 1 || chiusura e giorno != 19 lancia GiornoException (checked)
	//         se già presente un evento per il giorno lancia una GiornoException
	//         se e esiste in calendario lancia EventoException (unchecked)
		if(giorno <= 0 || giorno > 19)
			throw new IllegalArgumentException("\tECCEZIONE: giorno non valido");

		if(e == null)
			throw new NullPointerException("\tECCEZIONE: evento null");

		if(e.getClass().equals(Cerimonia.class))
			if(((Cerimonia) e).apertura && giorno != 1 || !(((Cerimonia) e).apertura) && giorno != 19)
				throw new GiornoException("\tECCEZIONE: cerimonia nel giorno sbagliato");

		if(calendario.containsKey(giorno))
			throw new GiornoException("\tECCEZIONE: un evento già presente per il giorno");

		if(calendario.values().contains(e))
			throw new EventoException("\tECCEZIONE: evento esiste");

		calendario.put(giorno,e);

		assert repOk();
	}

	public void rimuovi(int giorno) throws IllegalArgumentException, GiornoException {
	//MODIFIES: this
	//EFFECTS: rimuovi evento da giorno
	//         se giorno <= 0 o > 19 lancia IllegalArgumentException
	//         se giorno non esiste lancia GiornoException
		if(giorno <= 0 || giorno > 19)
			throw new IllegalArgumentException("\tECCEZIONE: giorno non valido");

		if(!(calendario.containsKey(giorno)))
			throw new GiornoException("\tECCEZIONE: giorno non esiste");

		calendario.remove(giorno);

		assert repOk();
	}

	@Override
	public Iterator<Evento> iterator() {

		ArrayList<Evento> a = new ArrayList<>(calendario.values());
		a.sort(null);

		return new Iterator<Evento>() {

			Iterator<Evento> i = a.iterator();

			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public Evento next() {
				return i.next();
			}
		};
	}

	@Override
	public String toString() {
		String ret = "Olimpiade Invernale " + anno + ":\n";

		for(int g = 1; g < 20; g++)
			if(calendario.get(g) != null)
				ret += "\t" + g + ": " + calendario.get(g) + "\n";

		return ret;
	}

	public boolean repOk() {
		ArrayList<Evento> el = new ArrayList<Evento>(calendario.values());

		for(int g : calendario.keySet()) {
			if(g <= 0 || g > 19)
				return false;

			Evento e = calendario.get(g);

			if(e == null || el.indexOf(e) != el.lastIndexOf(e))
				return false;

			if(e instanceof Cerimonia)
				if(((Cerimonia) e).apertura && g != 1)
					return false;
				else if(!(((Cerimonia) e).apertura) && g != 19)
					return false;
		}

		return true;
	}
}