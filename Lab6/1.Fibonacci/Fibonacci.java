import java.util.Iterator;
class Fibonacci implements Iterator<Integer> {
//OVERVIEW: Iterator che produce in sequenza i numeri di Fibonacci
//          Un numero di Fibonacci è la somma dei due numeri precedenti della sequenza.

	private int[] result = {0, 1}; //inizializziamo la sequenza con 0 e 1, restituiremo sempre result[1];

	@Override
	public boolean hasNext() {
	//EFFECTS: restituisce true (la sequenza è infinita)
		return true;
	}

	@Override
	public Integer next() { //non serve gestire NoSuchElementException perchè la sequenza è infinita
	//EFFECTS: restituisce il prossimo numero della sequenza di Fibonacci
		int tmp = this.result[1]; //valore temporaneo per tenere result[1]
		this.result[1] = this.result[0]+this.result[1]; //result[1] diventa la somma dei due precedenti
		this.result[0] = tmp; //result[0] sarà il vecchio result[1]
		return tmp; //restituiremo il vecchio result[1]
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		Fibonacci f = new Fibonacci();

		for(int i = 0; i < n; i++)
			System.out.println(f.next());
	}
}