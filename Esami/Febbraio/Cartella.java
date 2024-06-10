import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Cartella extends Contenuto implements Iterable<Contenuto> {
//OVERVIEW: Contenuto di tipo Cartella

//attributi
	private ArrayList<Contenuto> l = new ArrayList<>();
	private Cartella superiore = null;

//metodi
	public Cartella(String nome) {
		super(nome);
	}

	private Contenuto get(String nn) throws NullPointerException, IllegalArgumentException, NoSuchElementException {
	//EFFECTS: restituisce Contenuto n col nome nn, null se nessuno
	//         se nn null lancia NullPointerException
	//         se nn vuoto lancia IllegalArgumentException
	//         se n non esiste lancia NoSuchElementException
		if(nn == null)
			throw new NullPointerException("ECCEZIONE:nome contenuto null");

		if(nn.equals(""))
			throw new IllegalArgumentException("ECCEZIONE:nome contenuto vuoto");

		for(Contenuto n: l)
			if(n.getNome().equals(nn))
				return n;

		throw new NoSuchElementException("ECCEZIONE:contenuto non esiste");
	}

	public Cartella superiore() throws NoSuchElementException {
	//EFFECTS: restituisce la cartella superiore
	//         se null lancia NoSuchElementException
		if(superiore == null)
			throw new NoSuchElementException("ECCEZIONE:non ha una cartella superiore");

		return superiore;
	}

	public Cartella entra(String nn) throws NoSuchDirException {
	//EFFECTS: restituisce Cartella c col nome nn
	//         se nn null lancia NullPointerException
	//         se nn vuoto lancia IllegalArgumentException
	//         se n non esiste lancia NoSuchElementException
	//         se c non è cartella lancia NoSuchDirException
		Contenuto c = get(nn);
		if(c instanceof Cartella)
			return (Cartella) c.clone();

		throw new NoSuchDirException("ECCEZIONE:contenuto non è una cartella");
	}

	public void crea(Contenuto n) throws NullPointerException, ElementExistsException {
	//MODIFIES: this
	//EFFECTS: aggiunge n a this
	//         se n null lancia NullPointerException
	//         se n esiste lancia ElementExistsException
		if(n == null)
			throw new NullPointerException("ECCEZIONE:contenuto null");

		if(l.contains(n))
			throw new ElementExistsException("ECCEZIONE:contenuto esiste");

		Contenuto t = n.clone();

		l.add(t);

		if(t instanceof Cartella)
			((Cartella) t).superiore = this;

		assert repOK();
	}

	public void rimuovi(String nn) {
	//MODIFIES: this
	//EFFECTS: rimuove Contenuto n col nome nn da this
	//         se nn null lancia NullPointerException
	//         se nn vuoto lancia IllegalArgumentException
	//         se n non esiste lancia NoSuchElementException
		l.remove(get(nn));

		assert repOK();
	}

	@Override
	public int dimensione() {
		int t = 0;
		for(Contenuto n : l)
			t+=n.dimensione();

		return t;
	}

	@Override
	public Iterator<Contenuto> iterator() {
		l.sort(null);

		return new Iterator<Contenuto>() {
			Iterator<Contenuto> i = l.iterator();

			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public Contenuto next() {
				return i.next();
			}
		};
	}

	@Override
	public String toString() {
		String ret = "Cartella " + super.toString();

		for(Contenuto n : this)
			ret+="\n\t"+n.toString().replace("\n", "\n\t");

		return ret;
	}

	private boolean repOK() {
		for(Contenuto n: l)
			if(n == null)
				return false;

		return true;
	}
}