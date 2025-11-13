import java.util.Iterator;

public class Fibonacci implements Iterator<Integer> {
//OVERVIEW: modella un generatore di numeri della successione di Fibonacci

//attributi
	private int ultimo = 0, penultimo = 0;

	@Override
	public Integer next() {
		if(penultimo == 0 && ultimo == 0)
			return penultimo++; // penultimo=1, ultimo=0, restituito=0;
													// penultimo=0, ultimo=1,  restituito=1


		int risultato = ultimo + penultimo;
		this.penultimo = this.ultimo;
		this.ultimo = risultato;
		return risultato;
	}

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public String toString() {
		return "Fibonacci (penultimo:" + penultimo + ", ultimo:" + ultimo + ")";		 
	}

	public boolean repOk() {
		if(penultimo < 0 || ultimo < 0)
			return false;

		if(ultimo != 0 && ultimo < penultimo)
			return false;

		return true;
	}
	
	public static void main(String[] args) {

		Fibonacci f = new Fibonacci();

		int n = Integer.parseInt(args[0]);

		for (int i = 0; i < n; i++){
			System.out.println(f.next());
			System.out.println(f);
		}
	}
}