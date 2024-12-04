import java.util.ArrayList;
import java.util.Iterator;

public class Vetreria implements Iterable<Contenitore> {
//OVERVIEW: modella una Vetreria di Contenitori

//attributes
	ArrayList<Contenitore> lc = new ArrayList<>();

//methods
	public void add(Contenitore c) {
	//MODIFIES: this
	//EFFECTS: aggiungi c a this
	//         se c == null lancia IllegalArgumentException
		if(c == null)
			throw new IllegalArgumentException("c null");

		lc.add(c.clone());

		assert repOk();
	}

	public Vetreria estrai(String tipo) {
	//MODIFIES: this
	//EFFECTS: estrai tutti i Contenitore con tipo di liquido in una nuova Vetreria
		Vetreria nuova = new Vetreria();

		for(Contenitore c: lc)
			if(tipo.equals(c.getLiq()))
				nuova.add(c);

		lc.removeAll(nuova.lc);

		assert repOk();

		return nuova;
	}

	public void ottimizza() {
	//MODIFIES: this
	//EFFECTS: riordina per capienza la vetreria, travasa il contenuto nei contenitori più grandi svuotando i più piccoli

		ArrayList<Contenitore> tmp = new ArrayList<>(lc);
		tmp.sort(null);

		for(int i = 0; i < tmp.size() - 1; i++)
			for(int j = i+1; j < tmp.size(); j++)
				if(tmp.get(i).getLiq() == null || tmp.get(i).getLiq().equals(tmp.get(j).getLiq()))
					tmp.get(j).versa(tmp.get(i));
	}

	@Override
	public Iterator<Contenitore> iterator() {

		lc.sort(null);

		return new Iterator<Contenitore>(){

			Iterator<Contenitore> i = lc.iterator();

			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public Contenitore next() {
				return i.next().clone();
			}
		};
	}

	@Override
	public String toString() {
		String res = "Vetreria con:\n";

		for(Contenitore c: this)
			res+= "\t"+c+"\n";

		return res;
	}

	public boolean repOk() {
		for(Contenitore c: lc)
			if(c == null)
				return false;

		return true;
	}
}