import java.util.Iterator;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Pretendenti implements Iterable<Integer> {
	
	ArrayList<Integer> pretendenti;
	
	public Pretendenti(int n) throws IllegalArgumentException {
	// MODIFIES: this
	// EFFECTS: inizializza this con n pretendenti

		if(n <= 0)
			throw new IllegalArgumentException("Ci devono essere dei pretendenti");
		
		this.pretendenti = new ArrayList<Integer>();
		
		for(int i=1;i<=n;i++)
			this.pretendenti.add(i);
	}
	
	public int getPrimo() {
	// EFFECTS: restituisce primo pretendente;
		return this.pretendenti.get(0);
	}
	
	@Override
	public String toString() {
		String ret = "Pretendenti: ";
		for(int i : this.pretendenti)
			ret+= i + " ";
		
		return ret;
	}
	
	@Override
	public Iterator<Integer> iterator() {
	// EFFECTS: restituisce un iteratore che seleziona un nuovo pretendente a distanza di 3 dall'ultimo restituito.
	// MODIFIES: l'iteratore può modificare this, eliminando l'ultimo pretendente selezionato
	
		return new Iterator<Integer>() {
			boolean direction = true; //direzione dal primo all'ultimo
			boolean removed = true;
			int current = 0;
			
			@Override
			public String toString() {
				if(this.direction)
					return "Si conta da " + Pretendenti.this.pretendenti.get(this.current) + " direzione avanti";
				
				return "Si conta da " + Pretendenti.this.pretendenti.get(this.current) + " direzione indietro";
			}
			
			@Override
			public boolean hasNext() {
			// EFFECTS: restituisce true se ci sono altri pretendenti eliminabili. Se è rimasto uno solo restituisce false;
				return Pretendenti.this.pretendenti.size() > 1;
			}
			
			@Override
			public Integer next() {
			// MODIFIES: this
			// EFFECTS: restituisce il prossimo pretendente e aggiorna l'elemento corrente, la direzione di ricerca e imposta removed a false
			//          se non ci sono più pretendenti lancia NoSuchElementException
			
				if(!(this.hasNext()))
					throw new NoSuchElementException("Non ci sono più pretendenti");
				
				this.removed = false; //dopo la chiamata a next() il pretendente selezionato può essere eliminato;
				
				if(this.direction)
					this.current+=2; //se avanti il prossimo elemento è a distanza di +2
				else
					this.current-=2; //se indietro il prossimo elemento è a distanza di -2
				
				if(this.current >= Pretendenti.this.pretendenti.size()-1) { //se dopo lo spostamento l'indice è in fondo o dopo la lista
					this.current = 2*(Pretendenti.this.pretendenti.size()-1) - this.current; //tornare indietro di tanto di quanto si sfora
					this.direction = false; //indicare che si sta tornando indietro
				}
				
				if(this.current <= 0) { //se dopo lo spostamento l'indice è in capo o prima della lista
					this.current = -this.current; //tornare in avanti di tanto di quanto si sfora
					this.direction = true; //indicare che si sta andando avanti
				}
				
				return Pretendenti.this.pretendenti.get(this.current); //restituire il pretendente
			}
			
			@Override
			public void remove() throws IllegalStateException {
			// MODIFIES: Pretendenti.this, this
			// EFFECTS: rimuove il pretendente selezionato da next(), aggiorna l'elemento corrente e imposta removed a false
			//          se è stato già invocato removed senza fare un next dopo, lancia IllegalStateException
			
				if(this.removed) //se è già stato rimosso un elemento non se ne possono rimuovere altri finchè non si invoca nuovamente next
					throw new IllegalStateException("elemento già rimosso");
				
				Pretendenti.this.pretendenti.remove(this.current); //rimuovere l'ultimo pretendente (l'indice parte da 1 quindi sottrarre 1)
				
				this.removed = true; //segnalare che è stato rimosso
				
				if(!direction) //se la direzione è indietro
					current--; //bisogna passare all'elemento prima
				
				if(this.current > Pretendenti.this.pretendenti.size()-1) //se cancellando un elemento current esce dal range
					this.current--; //tornare nel range
				
				if(this.current == Pretendenti.this.pretendenti.size()-1) //se cancellando current punta all'ultimo posto
					this.direction = false; //si può solo tornare indietro

				if(this.current == 0) //se cancellando current punta al primo posto
					this.direction = true; //si può solo andare avanti
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