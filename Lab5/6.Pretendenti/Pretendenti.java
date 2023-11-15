<<<<<<< HEAD
import java.util.Iterator;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Pretendenti implements Iterable<Integer> {
//OVERVIEW: modella il meccanismo di selezione dei pretendenti
	ArrayList<Integer> pretendenti;

//costruttori
	public Pretendenti(int n) throws IllegalArgumentException {
	// MODIFIES: this
	// EFFECTS: inizializza this con n pretendenti

		if(n <= 0)
			throw new IllegalArgumentException("Ci devono essere dei pretendenti");

		this.pretendenti = new ArrayList<Integer>();

		for(int i=1;i<=n;i++)
			this.pretendenti.add(i); //creo pretendenti numerati

		assert repOk();
	}

	public int getPrimo() {
		return this.pretendenti.get(0);
	}

	@Override
	public String toString() {
		String ret = "Pretendenti: ";
		for(int i : this.pretendenti)
			ret+= i + " ";

		return ret;
	}

	public boolean repOk() {
		for(Integer i : pretendenti)
			if(i == null || i < 0)
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
			boolean direction = true; //direzione dal primo all'ultimo
			boolean removed = true; //é stato rimosso un elemento, non si può rimuovere il prossimo fino alla prossima chiamata next
			int current = 0;

			@Override
			public String toString() { //normalmente in un iterator non serve la AF, qua la facciamo per comodità dell'esercizio
				if(this.direction)
					return "Si conta da " + Pretendenti.this.pretendenti.get(this.current) + " direzione avanti";

				return "Si conta da " + Pretendenti.this.pretendenti.get(this.current) + " direzione indietro";
			}

			@Override
			public boolean hasNext() {
			//EFFECTS: restituisce true se ci sono altri pretendenti eliminabili. Se è rimasto uno solo restituisce false;
				return Pretendenti.this.pretendenti.size() > 1;
			}

			@Override
			public Integer next() {
			//MODIFIES: this
			//EFFECTS: restituisce il prossimo pretendente e aggiorna l'elemento corrente, la direzione di ricerca e imposta removed a false
			//         se non ci sono più pretendenti lancia NoSuchElementException

				if(!(this.hasNext()))
					throw new NoSuchElementException("Non ci sono più pretendenti");

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

				this.removed = false; //dopo la chiamata a next() il pretendente selezionato può essere eliminato;

				return Pretendenti.this.pretendenti.get(this.current); //restituire il pretendente
			}

			@Override
			public void remove() throws IllegalStateException {
			// MODIFIES: Pretendenti.this, this
			// EFFECTS: rimuove il pretendente selezionato da next(), aggiorna l'elemento corrente e imposta removed a false
			//          se è stato già invocato remove senza fare un next dopo, lancia IllegalStateException

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
=======
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Pretendenti implements Iterable<Integer> {
    //OVERVIEW modellare una lista di pretendenti da selezionare 

ArrayList<Integer> pretendenti;

    //costruttori
    public Pretendenti(int n) throws IllegalArgumentException { 
    //MODIFIES: this
    //EFFECTS: inizializza this con n pretendenti
    //se n è minore uguale a zero lancio una IllegalArgumentException
    if(n<=0)
    throw new IllegalArgumentException("La lista deve avere almeno un pretendente");

    this.pretendenti = new ArrayList<Integer>();
    for (int i = 1; i <=n; i++) {
        this.pretendenti.add(i);
                
    }
    assert repOK();

    }
    //metodi

    public int getPrimo() throws IllegalStateException{
        //EFFECTS: restituire l'ultimo pretendente
       // se la lista contiene più di un pretendente allora lancio una IllegalStateException
       if (this.pretendenti.size()!=1)
        throw new IllegalStateException("Deve esserci un solo vincitore");
        
        return this.pretendenti.get(0);

    }


    @Override
    public String toString(){
        String ret = "Pretendenti: ";
        for (int i : this.pretendenti) {
            ret+=i + " ";
        }
        return ret;
    }
    
    public boolean repOK() {
        for (Integer i : pretendenti) 
          if (i==null || i<=0)
                 return false;
            return true;
           
       
    }


    @Override
      public Iterator<Integer> iterator(){
        //EFFECTS: restituisce un iteratore che seleziona il pretendente  eliminare a poi salta di tre
        //MODIFIES: modifica la lista dei pretendenti elimando quello selezionato
         return new Iterator<Integer>() {
            //OVERVIEW:  iterator che conta  ogni volta tre pretendenti eliminandone uno ogni tre.
            boolean direction = true;
            boolean removed = true;
            int current = 0;

            @Override
            public boolean hasNext() {
            //EFFECTS: restituisce true in caso di pretendenti eliminabile e false altrimenti
            return Pretendenti.this.pretendenti.size() > 1;
                   }

            @Override
            public Integer next() throws NoSuchElementException {
                //MODIFIES: this
                //EFFECTS: restiutisce il prossimo pretendente da eliminare e aggiorna l'indice aggiorna la direzione imposta il flag removed a false
                // se non ci sono più elementi lancia una NoSuchelementException
                 if (!(this.hasNext()))
                    throw new NoSuchElementException("non si sono piuù pretendneti");
                if (this.direction)
                    this.current+=2;
                else    
                    this.current-=2;
                
                if (this.current>=Pretendenti.this.pretendenti.size()-1){
                    this.current= 2*(Pretendenti.this.pretendenti.size()-1)-(this.current);
                    this.direction=false;

                }

                if (this.current<=0){
                    this.current= -this.current;
                    this.direction=true;
                }
                
                this.removed=false;
                return Pretendenti.this.pretendenti.get(this.current);

              }

            @Override
            public void remove() throws IllegalStateException {
                //this.pretendenti this
                //EFFECTS rimuovere il pretendente selezionato dal next()  e agggiornare l'indice 
                //se sto eliminado senza aver fatto prima una next() allora lancio una IllegalStateException
            if (this.removed)
                throw new IllegalStateException("non puoi eliminare se prima non selezioni un nuvo pretendente da eliminare");
                Pretendenti.this.pretendenti.remove(this.current);
                this.removed=true;
                if (!this.direction)
                    this.current--;
                if (this.current>Pretendenti.this.pretendenti.size()-1)
                    this.current--;
                if (this.current==Pretendenti.this.pretendenti.size()-1)
                    this.direction=false;
                if (this.current==0)
                    this.direction=true;
            
                 assert repOK();   


            }
        @Override
        public String toString() {
            String dirstring = direction ? "avanti" : "indietro";
            return "si conta da " + Pretendenti.this.pretendenti.get(this.current) + " direzione "+ dirstring;
            
        }
             
         };

        
    }

    public static void main(String[] args) {
        int  n =Integer.parseInt(args[0]);
        Pretendenti p = new Pretendenti(n);
        Iterator<Integer> i = p.iterator();

        while (i.hasNext()){
            System.out.println(p);
            System.out.println(i);
            System.out.println("Elimino " + i.next());
            i.remove();
        }
    System.out.println("Il pretendente vincitore è " + p.getPrimo());
    }
}
>>>>>>> 7c5106a (ste)
