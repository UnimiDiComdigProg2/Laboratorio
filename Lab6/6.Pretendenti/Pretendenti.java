import java.util.Iterator;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Pretendenti implements Iterable<Integer> {
//OVERVIEW: modella il meccanismo di selezione dei pretendenti
	ArrayList<Integer> p = new ArrayList<Integer>();

//costruttori
	public Pretendenti(int n) throws IllegalArgumentException {
	// MODIFIES: this
	// EFFECTS: inizializza this con n pretendenti

		if(n <= 0)
			throw new IllegalArgumentException("Ci devono essere dei pretendenti");

		for(int i = 1; i <= n; i++)
			p.add(i); //creo pretendenti numerati

		assert repOk();
	}

	public int getPrimo() {
		return p.get(0);
	}

	@Override
	public String toString() {
		String ret = "Pretendenti: ";

		for(int i : p)
			ret+= i + " ";

		return ret;
	}

	public boolean repOk() {
		for(Integer i : p)
			if(i == null || i <= 0 || p.indexOf(i) != p.lastIndexOf(i))
				return false;

		return true;
	}

	@Override
	public Iterator<Integer> iterator() {
	// EFFECTS: restituisce un iteratore che seleziona un nuovo pretendente a distanza di 3 dall'ultimo restituito.
	// MODIFIES: l'iteratore può modificare this, eliminando l'ultimo pretendente selezionato

		return new Iterator<Integer>() {
		//OVERVIEW: normalmente l'iterator non deve essere specificato direttamente ma basta la specifica del metodo iterator()
		//          data la complessità, si forniscono ulteriori specifiche
			boolean dir = true; //direzione dal primo all'ultimo
			int cur = 0;
			boolean removed = true; //é stato rimosso un elemento, non si può rimuovere il prossimo fino alla prossima chiamata next

			@Override
			public String toString() { //normalmente in un iterator non serve la AF, qua la facciamo per comodità dell'esercizio
				if(dir)
					return "Si conta da " + p.get(cur) + " direzione avanti";

				return "Si conta da " + p.get(cur) + " direzione indietro";
			}

			@Override
			public boolean hasNext() {
			//EFFECTS: restituisce true se ci sono altri pretendenti eliminabili. Se è rimasto uno solo restituisce false;
				return p.size() > 1;
			}

			@Override
			public Integer next() {
			//MODIFIES: this
			//EFFECTS: restituisce il prossimo pretendente e aggiorna l'elemento corrente, la direzione di ricerca e imposta removed a false
			//         se non ci sono più pretendenti lancia NoSuchElementException

				if(!(hasNext()))
					throw new NoSuchElementException("Non ci sono più pretendenti");

				if(dir)
					cur+=2; //se avanti il prossimo elemento è a distanza di +2
				else
					cur-=2; //se indietro il prossimo elemento è a distanza di -2

				if(cur >= p.size()-1) { //se dopo lo spostamento l'indice è in fondo o dopo la lista
					cur = 2*(p.size()-1) - cur; //tornare indietro di tanto di quanto si sfora
					dir = false; //indicare che si sta tornando indietro
				}

				if(cur <= 0) { //se dopo lo spostamento l'indice è in capo o prima della lista
					cur = -cur; //tornare in avanti di tanto di quanto si sfora
					dir = true; //indicare che si sta andando avanti
				}

				removed = false; //dopo la chiamata a next() il pretendente selezionato può essere eliminato;

				return p.get(cur); //restituire il pretendente
			}

			@Override
			public void remove() throws IllegalStateException {
			// MODIFIES: Pretendenti.this, this
			// EFFECTS: rimuove il pretendente selezionato da next(), aggiorna l'elemento corrente e imposta removed a false
			//          se è stato già invocato remove senza fare un next dopo, lancia IllegalStateException

				if(removed) //se è già stato rimosso un elemento non se ne possono rimuovere altri finchè non si invoca nuovamente next
					throw new IllegalStateException("elemento già rimosso");

				p.remove(cur); //rimuovere l'ultimo pretendente (l'indice parte da 1 quindi sottrarre 1)

				removed = true; //segnalare che è stato rimosso

				if(!dir) //se la direzione è indietro
					cur--; //bisogna passare all'elemento prima

				if(cur > p.size()-1) //se cancellando un elemento cur esce dal range
					cur--; //tornare nel range

				if(cur == p.size()-1) //se cancellando cur punta all'ultimo posto
					dir = false; //si può solo tornare indietro

				if(cur == 0) //se cancellando cur punta al primo posto
					dir = true; //si può solo andare avanti

				assert repOk();
			}
		};
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		Pretendenti p = new Pretendenti(n);
		Iterator<Integer> i = p.iterator();

		while(i.hasNext()) {
			System.out.println(p);
			System.out.println(i);
			System.out.println("Eliminato: " + i.next());
			i.remove();
		}

		System.out.println("il numero " + p.getPrimo() + " è il fortunato vincitore");
	}
}