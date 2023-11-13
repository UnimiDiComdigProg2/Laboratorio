import java.util.Iterator;
import java.util.ArrayList;

class Primi implements Iterator<Integer> {
//OVERVIEW: Iterator che genera numeri primi

	private ArrayList<Integer> primi = new ArrayList<Integer>();
	private int current = 2;

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Integer next() {
		if(this.primi.size() == 0) { //se ancora non ci sono numeri primi generati
			this.primi.add(2); //il primo sarà 2
			this.current = 3; //il successivo da controllare;
			return 2;
		}

		for(int i = this.current; true; i++) { //per ogni numero i successivo all'ultimo primo restituito
			for(int j : this.primi) { //per ogni primo j già generato
				if(i%j == 0) //verificare se i è divisibile per j
					break; //in tal caso i non sarà primo, prendo un nuovo i
				
				if(j*j > i) { //se il quadrato di j è superiore a i, non ci sono più divisori possibili per i
					this.primi.add(i); //quindi è primo
					this.current=i+2; //il prossimo da controllare sarà i+2 (i+1 è pari quindi inutile controllare)
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