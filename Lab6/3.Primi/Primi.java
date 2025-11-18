import java.util.Iterator;
import java.util.ArrayList;

class Primi implements Iterator<Integer> {
//OVERVIEW: Iterator che genera numeri primi

	private ArrayList<Integer> l = new ArrayList<Integer>();

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Integer next() {
		if(this.l.isEmpty()) { //se ancora non ci sono numeri primi generati
			this.l.add(2); //il primo sarà 2
			return 2;
		}

		for(int i = l.get(l.size()-1)+1; true; i++) { //per ogni numero i successivo all'ultimo primo restituito
			for(int j: this.l) { //per ogni primo j già generato
				if(i%j == 0) //verificare se i è divisibile per j
					break; //in tal caso i non sarà primo, prendo un nuovo i

				if(j*j > i) { //se il quadrato di j è superiore a i, non ci sono più divisori possibili per i
					this.l.add(i); //quindi è primo
					return i;
				}
			}
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Primi p = new Primi();

		for(int i=0; i<n; i++)
			System.out.println(p.next());
	}
}