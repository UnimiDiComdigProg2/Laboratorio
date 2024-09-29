import java.util.Arrays;
import java.util.HashMap;

public class Carta implements Comparable<Carta> {
//OVERVIEW: modella una carta IMMUTABILE

//attributi
	final int valore;
	final char seme;

//costruttori
	public Carta(int valore, char seme) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza nuova Carta con valore e seme.
	//         se valore < 1 o > 13 lancia IllegalArgumentException
	//         se seme diverso da C Q F o P lancia IllegalArgumentException
		if(valore < 1 || valore > 13)
			throw new IllegalArgumentException("Carta - Costruttore con valore errato");
		
		if(!(Arrays.asList('C','Q','F','P').contains(seme)))
			throw new IllegalArgumentException("Carta - Costruttore con seme errato");

		this.seme = seme;
		this.valore = valore;
	}

//metodi
	public int valSeme() {
	//EFFECTS: restituisce un valore numerico corrispondente al seme della carta (C=1,Q=2,F=3,P=4)
		HashMap<Character,Integer> vs = new HashMap<>();
		vs.put('C', 1);
		vs.put('Q', 2);
		vs.put('F', 3);
		vs.put('P', 4);

		return vs.get(this.seme);
	}

	@Override
	public int compareTo(Carta o) {
		if(this.valore > o.valore)
			return 1;
		if(this.valore < o.valore)
			return -1;
		
		if(this.valSeme() > o.valSeme())
			return 1;

		if(this.valSeme() < o.valSeme())
			return -1;

		return 0;
	}

	@Override
	public String toString() {
		return "Carta: " + this.valore + " " + this.seme;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Carta))
			return false;
		
		Carta tmp = (Carta)obj;

		return tmp.seme == this.seme && tmp.valore == this.valore;
	}
}