import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Erogatore implements Iterable<Prodotto> {
//OVERVIEW: modella Erogatore di prodotti con controllo età

//attributes
	private HashMap<Prodotto, Integer> prodotti = new HashMap<>();
	private double credito = 0;
	private int etaVal = 0;

//methods
	public void validaEta(int eta) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: imposta etaVal
	//         se eta <= 0 lancia IllegalArgumentException
		if(eta <= 0)
			throw new IllegalArgumentException("eta <= 0");

			etaVal = eta;

		assert repOK();
	}

	public void carica(Prodotto p, int qty) throws NullPointerException, IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: aggiunge o ricarica p con qty
	//         se p null lancia NullPointerException
	//         se qty <= 0 lancia IllegalArgumentException
		if(p == null)
			throw new NullPointerException("p null");

		if(qty <= 0)
			throw new IllegalArgumentException("qty <= 0");

		prodotti.put((Prodotto) p.clone(), qty+prodotti.getOrDefault(p, 0));

		assert repOK();
	}

	public double addCredito(double credito) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: aggiunge credito a this
	//         se credito <= 0 lancia IllegalArgumentException
		if(credito <= 0)
			throw new IllegalArgumentException("credito <= 0");

		this.credito+= credito;

		assert repOK();

		return this.credito;
	}

	public Prodotto get(String s) throws NullPointerException {
		if(s == null)
			throw new NullPointerException("s null");

		for(Prodotto p : prodotti.keySet())
			if(p.nome.equals(s))
				return (Prodotto) p.clone();

		return null;
	}

	public double eroga(String s) throws AgeException, CreditException, NoSuchElementException, NullPointerException {
	//MODIFIES: this
	//EFFECTS: eroga prodotto, scala il credito e il numero di prodotti e setta etaVal = 0
	//         se ProdottoControllato e etaVal < p.etaMin lancia EtaInsufficienteException
	//         se s null lancia NullPointerException
	//         se non contiene prodotto lancia NoSuchElementException
	//         se credito insufficiente lancia CreditoInsufficienteException
		Prodotto p = get(s);

		if(p == null)
			throw new NoSuchElementException(s + " non presente");

		if(p.getPrezzo() > this.credito)
			throw new CreditException("credito < " + p.getPrezzo());

		if(p.getClass().equals(ProdottoControllato.class))
			if(this.etaVal < ((ProdottoControllato)p).etaMin)
				throw new AgeException("età < min");

		this.credito-=p.getPrezzo();

		if(prodotti.get(p) == 1)
			prodotti.remove(p);
		else
			prodotti.replace(p, prodotti.get(p)-1);

		etaVal = 0;

		assert repOK();

		return this.credito;
	}

	@Override
	public Iterator<Prodotto> iterator() {

		ArrayList<Prodotto> list = new ArrayList<>(prodotti.keySet());
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

	@Override
	public String toString() {
		String ret = "Erogatore (età validata: " + etaVal + "):";
		for(Prodotto p : this)
			ret += "\n\t" + p + " qty: " + prodotti.get(p);
		return ret;
	}

	public boolean repOK() {
		if(credito < 0 )
			return false;

		if(etaVal < 0)
			return false;

		for(Prodotto p : prodotti.keySet())
			if(p == null)
				return false;
			else if(prodotti.get(p) <= 0)
				return false;

		return true;
	}
}