import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Arrays;

public class Presepio implements Iterable<Figura> {
//OVERVIEW: modella un Presepio
	private HashSet<Figura> figure = new HashSet<>();

	public void aggiungi(Figura f) throws FiguraException {
	//MODIFIES: this
	//EFFECTS: aggiungi f a this
	//         se f null lancia IllegalArgumentException
	//         se f in this lancia FiguraException
		if(f == null)
			throw new IllegalArgumentException("\tEmergenza: Figura null");

		if(figure.contains(f))
			throw new FiguraException("\tEmergenza: Figura " + f + " già presente");

		figure.add(f); //non serve clone se Figura immutabile
		assert repOk();
	}

	public void togli(String nome) throws FiguraException {
	//MODIFIES: this
	//EFFECTS: rimuovi figura con nome da this
	//         se nome null o vuoto lancia IllegalArgumentException
	//         se non esiste lancia FiguraException
		if(nome == null || nome.equals(""))
			throw new IllegalArgumentException("\tEmergenza: nome null");

		if(!(figure.removeIf(f -> (f.getNome().equals(nome))))) //rimuovi da figure se figura f ha il nome uguale al parametro
			throw new FiguraException("\tEmergenza: Figura " + nome + " assente"); //se non rimuove nulla

		/* variante con for
		for(Figura f: figure) {
			if(f.getNome().equals(nome)) {
				figure.remove(f);
				assert repOk();
				return;
			}
		}

		throw new FiguraException("\tEmergenza: Figura " + nome + " assente");
		*/
	}

	public int valore() {
	//EFFECTS: restituisce il valore totale del presepio
		return figure.stream().mapToInt(i -> i.valore()).sum(); //genera stream di interi coi valori delle figure e poi lo somma

		/* variante con una variabile accumulatore e un ciclo for
		int r = 0
		for(f: figure)
			r+=f.valore();
		return r;
		*/
	}

	@Override
	public Iterator<Figura> iterator() {
	//EFFECTS: restituisce un iteratore alle figure, ordinate per valore

		ArrayList<Figura> a = new ArrayList<>(figure);
		a.sort(null);

		return new Iterator<Figura>() {

			Iterator<Figura> i = a.iterator(); 

			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public Figura next() {
				return i.next();
			}
		};
	}

	@Override
	public String toString() {
		String ret = "Presepio Imminente (" + valore() + ")";
		for(Figura f: this)
			ret+="\n\t" + f;

		return ret;
	}

	public boolean repOk() {
		if(figure == null)
			return false;

		for(Figura f: figure)
			if(f == null)
				return false;

		return true;
	}
}