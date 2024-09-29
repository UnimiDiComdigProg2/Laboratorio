import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MazzoRidotto extends Mazzo {
//OVERVIEW: MazzoRidotto con 40 carte (10 valori, 4 semi)

//costruttori
	public MazzoRidotto() {
	//MODIFIES: this
	//EFFECTS: inizializza nuovo MazzoRidotto di 40 carte
		this.cards = new ArrayList<>();

		for(char c : Arrays.asList('C','Q','F','P'))
			for(int i = 1; i < 11; i++)
				this.cards.add(new Carta(i, c));
	}

//metodi
	@Override
	public boolean cartaValida(Carta c) throws IllegalArgumentException {
	//EFFECTS: restituisce true se la carta è valida per questo MazzoRidotto, false altrimenti
	//         se la carta è null throws IllegalArgumentException

		if(c == null)
		  throw new IllegalArgumentException("MazzoRidotto - cartaValida: carta null");
		
		return c.valore > 0 && c.valore < 11;
	}

	@Override
	public void riordina() {
	//MODIFIES: this
	//EFFECTS: riordina il mazzo con A come valore più altro (e gli altri valori nell'ordine naturale precedente)
		this.cards.sort(new Comparator<Carta>() {

			@Override
			public int compare(Carta o1, Carta o2) {
				if(o1.valSeme() > o2.valSeme())
					return 1;
	
				if(o1.valSeme() < o2.valSeme())
					return -1;

				if(o1.valore > o2.valore)
					return 1;

				if(o1.valore < o2.valore)
					return -1;

				return 0;
			}
		});
	}
}
