import java.util.ArrayList;
import java.util.Iterator;

public class Vetreria implements Iterable<Contenitore> {
//OVERVIEW: modella una vetreria di contenitori

//attributes
	ArrayList<Contenitore> contenitori = new ArrayList<>();

//methods
	@Override
	public Iterator<Contenitore> iterator() {
		return new Iterator<Contenitore>(){

			Iterator<Contenitore> i = contenitori.iterator();

			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public Contenitore next() {
				return i.next();
			}
		};
	}

	public void ordina() {
	//MODIFIES: this;
	//EFFECTS: ordina this in ordine Decrescente
		contenitori.sort(null);
	}

	public void add(Contenitore c) throws NullPointerException {
	//MODIFIES: this
	//EFFECTS: aggiungi c a this
	//         se c == null lancia NullPointerException
		if(c == null)
			throw new NullPointerException("c null");

		this.contenitori.add((Contenitore) c.clone()); //clonare per evitare esposizione della rep

		assert repOk();
	}

	public Vetreria estrai(String tipo) throws NullPointerException {
	//MODIFIES: this
	//EFFECTS: estrai tutti i Contenitore contenenti tipo di liquido in una nuova Vetreria
	//         se tipo null lancia NullPointerException
		Vetreria nuova = new Vetreria();

		for(Contenitore contenitore : contenitori)
			if(tipo.equals(contenitore.getTipo()))
				nuova.add(contenitore);

		this.contenitori.removeAll(nuova.contenitori);

		return nuova;
	}

	public void ottimizza() {
	//MODIFIES: this
	//EFFECTS: riordina per capienza la vetreria, travasa il contenuto nei contenitori più grandi svuotando i più piccoli

		this.ordina();

		for(int i = 0; i < contenitori.size() - 1; i++)
			for(int j = i+1; j < contenitori.size(); j++)
				if(contenitori.get(i).getTipo() == null || contenitori.get(i).getTipo().equals(contenitori.get(j).getTipo()))
					contenitori.get(j).versa(this.contenitori.get(i));
	}

	@Override
	public String toString() {
		String res = "\n Vetreria con:\n";

		for(Contenitore contenitore : contenitori)
			res+= "\t"+contenitore+"\n";

		return res;
	}

	public boolean repOk() {
		for(Contenitore contenitore : contenitori)
			if(contenitore == null)
				return false;
			else if(contenitore.repOk() == false)
				return false;

		return true;
	}
}