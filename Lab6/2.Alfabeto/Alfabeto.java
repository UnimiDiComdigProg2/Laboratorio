import java.util.Iterator;
import java.util.NoSuchElementException;

public class Alfabeto implements Iterator<Character> {
//OVERVIEW: Generatore di lettere dell'alfabeto tra una lettera iniziale e una finale

	private char s, e;

	public Alfabeto(char s, char e) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza this con s ed e
	//         se e > s lancia una IllegalArgumentException
	//         se e o s non sono lettere lancia una IllegalArgumentException
		if(s > e)
			throw new IllegalArgumentException("s > e");

		if(s > 'z' || s < 'a')
			throw new IllegalArgumentException("s non è una lettera");

		if(e > 'z' || e < 'a')
			throw new IllegalArgumentException("e non è una lettera");

		this.e = e;
		this.s = s;

		assert repOk();
	}

	@Override
	public boolean hasNext() {
		return s <= e;
	}

	@Override
	public Character next() {
		if(hasNext())
			return s++;

		throw new NoSuchElementException("non ci sono più lettere");
	}

	@Override
	public String toString() {
		return "Alfabeto (corrente: " + s + ", finale: " + e + ")";  
	}

	public boolean repOk() {
		if(s > e)
			return false;

		if(s > 'z' || s < 'a')
			return false;

		if(e > 'z' || e < 'a')
			return false;

		return true;
	}

	public static void main(String[] args) {

		char start = args[0].charAt(0);
		char end = args[1].charAt(0);

		Alfabeto a = new Alfabeto(start, end);

		while (a.hasNext())
			System.out.println(a.next());
	}
}