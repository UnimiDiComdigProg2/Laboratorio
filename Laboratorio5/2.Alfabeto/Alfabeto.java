import java.util.Iterator;
import java.util.NoSuchElementException;

class Alfabeto implements Iterator<Character> {
//OVERVIEW: Iterator che produce in sequenza le lettere dell'alfabeto ASCII
	
	char start = 'a', end = 'z', current = 'a';
	
	public Alfabeto(char start, char end) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza this con la lettera iniziale e la lettera finale della sequenza
	//         se start o end non sono lettere ASCII lancia una IllegalArgumentException
	//         se start > end lancia una IllegalArgumentException
	
		if(!letteraValida(start))
			throw new IllegalArgumentException("primo carattere non valido");
		
		if(!letteraValida(end))
			throw new IllegalArgumentException("secondo carattere non valido");
		
		if(start > end)
			throw new IllegalArgumentException("la prima lettera è successiva alla seconda");
		
		this.start = start;
		this.current = start;
		this.end = end;
	}
	
	public Alfabeto() { //serve un costruttore base anche senza EFFECTS perchè esiste il costruttore coi parametri, altrimenti errore
	}
	
	private static boolean letteraValida(char c) {
	//EFFECTS: restituisce true se c è lettera ASCII valida, false altrimenti.
		if((c>='a' && c<='z') || (c>='A' && c<='Z'))
			return true;
		
		return false;
	}
	
	@Override
	public boolean hasNext() {
	//EFFECTS: restituisce true se ci sono altre lettere tra la iniziale e la finale, false altrimenti
		return (this.current >= this.start) && (this.current <= this.end);
	}

	@Override
	public Character next() {
	//EFFECTS: restituisce il prossimo carattere dell'alfabeto ASCII
	//         se non ci sono altri caratteri nella sequenza lancia una NoSuchElementException
		if(!(this.hasNext()))
			throw new NoSuchElementException("non ci sono più caratteri nella sequenza");
		
		return this.current++;
	}
	
	public static void main(String[] args) {
		Alfabeto a = new Alfabeto();

		if( (args.length != 0 ) || (args.length != 2 ) ) {
			System.out.println("");
		}

		if(args.length == 2) {
			char c1 = args[0].charAt(0);
			char c2 = args[1].charAt(0);
			
			try {
				a = new Alfabeto(c1, c2);
			} catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
		
		while(a.hasNext())
			System.out.println(a.next());
	}
}