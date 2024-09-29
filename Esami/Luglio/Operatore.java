import java.util.Iterator;
import java.util.ArrayList;

public class Operatore implements Iterable<Utenza> {
//OVERVIEW: Operatore con utenze

//attributes
	public final String nome;
	ArrayList<Utenza> utenze = new ArrayList<>();

//constructors
	public Operatore(String nome) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza this. Se nome null o vuoto lancia IllegalArgumentException
		if(nome == null || nome.equals(""))
			throw new IllegalArgumentException("nome null o vuoto");

		this.nome = nome;
	}

//methods
	public void aggiungiUtenza(Utenza u) throws IllegalArgumentException, UtenzaNonValidaException {
	//MODIFIES: this
	//EFFECTS: aggiungi u a utenze. se u null lancia IllegalArgumentException, se esiste lancia UtenzaNonValidaException
		if(u == null)
			throw new IllegalArgumentException("utenza null");

		if(utenze.contains(u))
			throw new UtenzaNonValidaException("utenza esiste");

		utenze.add(u);

		assert repOk();
	}

	 public Utenza getUtenza(String n) throws UtenzaNonValidaException {
	//EFFECTS: restituisce Utenza con numero n. Se non esiste lancia UtenzaNonValidaException
		for(Utenza u : utenze)
			if(u.numero.equals(n))
				return u;

		throw new UtenzaNonValidaException("utenza " + n + " inesistente");
	}

	@Override
	public Iterator<Utenza> iterator() {
		this.utenze.sort(null);

		return new Iterator<Utenza>(){
			Iterator<Utenza> i = utenze.iterator();

			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public Utenza next() {
				return i.next();
			}
		};
	}

	@Override
	public String toString() {
		String res = "\nUtenze di " + nome + ":\n";

		for(Utenza u : this)
			res+="\t" + u.toString() + "\n";

		return res;
	}

	private boolean repOk() {
		for(int i = 0; i < utenze.size(); i++)
			for(int j = i+1; j < utenze.size(); j++)
				if(utenze.get(i).equals(utenze.get(j)))
					return false;

		return true;
	}
}