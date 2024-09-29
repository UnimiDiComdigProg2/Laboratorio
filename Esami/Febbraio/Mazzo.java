import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Mazzo implements Iterator<Carta> {
//OVERVIEW: Mazzo con 52 carte (13 valori, 4 semi)

//attributi
	ArrayList<Carta> cards; //package protected

//costruttori
	public Mazzo() {
	//MODIFIES: this
	//EFFECTS: inizializza nuovo Mazzo di 52 carte

		this.cards = new ArrayList<>();

		for(char c : Arrays.asList('C','Q','F','P'))
			for(int i = 1; i < 14; i++)
				this.cards.add(new Carta(i, c));
	}

//metodi
	public boolean cartaValida(Carta c) throws IllegalArgumentException {
	//EFFECTS: restituisce true se carta valida per questo tipo di Mazzo, false altrimenti
	//         se la carta è nulla throws IllegalArgumentException 
		if(c == null)
			throw new IllegalArgumentException("Mazzo - cartaValida: carta null");

		return true;
	}
	
	public void mischia() {
	//MODIFIES: this
	//EFFECTS: mischia il mazzo in ordine pseudocasuale
		Collections.shuffle(this.cards);
	}

	public void riordina() {
	//MODIFIES: this
	//EFFECTS: riordina il mazzo nel suo ordine naturale
		this.cards.sort(null);
	}

	public void inserisci(Carta c) throws IllegalArgumentException, CardExistsException, CardNotValidException {
	//MODIFIES: this
	//EFFECTS: inserisci la Carta c nel mazzo
	//         se la carta è nulla throws IllegalArgumentException
	//         se la carta è già presente throws CardExistsException (unchecked)
	//         se la carta non è valida throws CardNotValidException (checked)
		if(c == null)
			throw new IllegalArgumentException("Mazzo - inserisci: carta null");

		if(!cartaValida(c))
			throw new CardNotValidException("Mazzo - inserisci: carta non valida");

		if(this.cards.contains(c))
			throw new CardExistsException("Mazzo - inserisci: carta già nel mazzo");

		this.cards.add(c);
	}

	@Override
	public boolean hasNext() {
	//EFFECTS: restituisce true se ci sono ancora carte nel mazzo, false altrimenti

		return this.cards.size() > 0;
	}

	@Override
	public Carta next() throws NoSuchElementException {
	//MODIFIES: this
	//EFFECTS: restituisce una delle carte del mazzo (togliendola dal mazzo)
	//         se non ci sono più carte throws NoSuchElementException
		if(!hasNext())
			throw new NoSuchElementException("Mazzo - next: finite le carte");
		return this.cards.remove(0);
	}

	@Override
	public String toString() {
		String ret = "Mazzo:\n";
		for(Carta c : this.cards)
			ret+="\t"+c+"\n";

		return ret;
	}

	public boolean repOk() {
		if(this.cards == null)
			return false;

		for(Carta c : this.cards)
			if(c == null)
				return false;
			else if(!cartaValida(c))
				return false;
			else if(Collections.frequency(this.cards, c) > 1)
				return false;

		return true;
	}
}
