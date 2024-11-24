import java.util.NoSuchElementException;
import java.util.Comparator;
import java.util.Scanner;

public class Massimo<T> {
//OVERVIEW: classe che mantiene il valore massimo tra quelli inseriti
	T max = null; //non serve repOk perchè max può essere qualunque T, anche null
	final Comparator<T> comp; //comp può essere qualunque Comparator<T>, anche null

	public Massimo() {
		this(null);
	}

	public Massimo(Comparator<T> comp) throws IllegalArgumentException{
	//MODIFIES: this
	//EFFECTS: inizializza this con Comparator
		this.comp = comp;
	}

	public T getMax() {
	//EFFECTS: restituisce max
	//         se non ancora inseriti elementi lancia NoSuchElementException
		if(max == null)
			throw new NoSuchElementException("no element yet inserted");

		return this.max; //vorrei manon posso clonare Max perchè non so cos'è - potrebbe essere non-clonabile
		//il risultato è che max potrà essere modificato da fuori. Magari diventa meno max di altri inseriti
		//non ho garanzie che è il valore più alto inserito, solo che lo era al momento dell'inseriomento
	}

	@SuppressWarnings("unchecked")
	public void insert(T t) throws UnsupportedOperationException {
	//MODIFIES: this
	//EFFECTS: inserisce t in max se maggiore di valori precedenti
	//         se t non è comparable e non viene fornito un comparator lancia una UnsupportedOperationException
		if((this.comp == null) && !(t instanceof Comparable))
			throw new UnsupportedOperationException("oggetti non comparabili");

		if(this.max == null) {
			this.max = t; //vorrei manon posso clonare Max perchè non so cos'è - potrebbe essere non-clonabile
		} else if(this.comp != null) {
			if(comp.compare(t, max) > 0)
				this.max = t; //idem
		} else if(t instanceof Comparable) {
			if(((Comparable) t).compareTo(this.max) > 0)
				this.max = t; //idem
		}
	}

	@Override
	public String toString() {
		return "Massimo<"+ max.getClass().getSimpleName() + ">: " + max;
	}

	public static void main(String[] args) {

	Massimo<String> mLex = new Massimo<>();
		Massimo<String> mLen = new Massimo<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(),o2.length());
			}
		});

		Scanner s = new Scanner(System.in);

		System.out.println("Inserisci Stringhe (CTRL+D per terminare)");
		while(s.hasNext()) {
			String str = s.next();

			mLex.insert(str);
			mLen.insert(str);
		}

		System.out.println(mLex + " (lessicografico)");
		System.out.println(mLen + " (lunghezza)");
	}
}