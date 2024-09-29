import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Vetreria implements Iterable<Contenitore> {
//OVERVIEW: modella una vetreria con una lista di contenitori
	ArrayList<Contenitore> contenitori = new ArrayList<>();
	
	public void add(Contenitore c) throws NullPointerException {
	//MODIFIES: this;
	//EFFECTS: aggiungi Contenitore c alla vetreria;
	//         se c è nullo lancia NullPointerException
		if(c == null)
			throw new NullPointerException("Contenitore nullo");
		
		contenitori.add(c);
		
		assert repOk();
	}

	public void sort() {
	//MODIFIES: this
	//EFFECTS: riordina la vetreria nell'ordine naturale (capienza)
		this.contenitori.sort(null);
	}

	public void ottimizza() {
	//MODIFIES: this
	//EFFECTS: riordina la vetreria per capienza e travasa i liquidi corrispondenti nei contenitori più grandi, svuotando se possibile quelli più piccoli
		this.sort();
		for(int i = 0; i < this.contenitori.size(); i++)
			for(int j = this.contenitori.size()-1; j > i ; j--)
				this.contenitori.get(j).travasa(this.contenitori.get(i));
	}

	public Vetreria estrai(String liquido) throws NullPointerException {
	//MODIFIES: this
	//EFFECTS: se liquido nullo o vuoto lancia NullPointerException
	//		 altrimenti estrai tutti i Contenitori contenenti il tipo di liquido specificato e restituisci una nuova vetreria con quei contenitori
	//		 la vetreria corrente non avrà più quei Contenitori
		if(liquido == null || liquido.equals(""))
			throw new NullPointerException("nome del liquido nullo o vuoto");
		
		Vetreria v = new Vetreria();
		Iterator<Contenitore> i = this.contenitori.iterator();
		
		while(i.hasNext()) {
			Contenitore c = i.next();
			
			if(c.getLiquido().equals(liquido))
				v.add(c);
		}
		
		this.contenitori.removeAll(v.contenitori);
		
		return v;
	}

	@Override
	public String toString() {
		String res = "\nVetreria con:\n";
		for(Contenitore c : this)
			res+="\t"+c+"\n";
		return res;
	}

	@Override
	public Iterator<Contenitore> iterator() {
	//EFFECTS: restituisce un nuovo iteratore di Contenitori per questa vetreria
		return new Iterator<Contenitore>() {
			Iterator<Contenitore> i = contenitori.iterator();
			
			@Override
			public boolean hasNext() {
				return i.hasNext();
			}
			
			@Override
			public Contenitore next() {
				return i.next();
			}
		};
	}

	public boolean repOk() {
		for(Contenitore c : this.contenitori)
			if(c == null)
				return c.repOk();
		
		return true;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Vetreria v = new Vetreria();
		HashSet<String> h = new HashSet<>();
		
		while(s.hasNext()) {
			String liquido = s.next();
			h.add(liquido);
			
			double qta = s.nextDouble();
			Contenitore c = null;
			
			try {
				switch (s.next()) {
					case "Sfera":
						c = new Sfera(liquido, qta, s.nextDouble());
						break;
					case "Cilindro":
						c = new Cilindro(liquido, qta, s.nextDouble(), s.nextDouble());
						break;
					case "Cuboide":
						c = new Cuboide(liquido, qta, s.nextDouble(), s.nextDouble(), s.nextDouble());
						break;
				}
			} catch (ExceededCapacityException e) {
				System.out.println(e.getMessage());
				continue;
			}
			
			v.add(c);
		}
		
		System.out.println(v);
		
		ArrayList<Vetreria> av = new ArrayList<>();
		
		for(String hs : h)
			av.add(v.estrai(hs));
		
		for(Vetreria ava : av) {
			ava.ottimizza();
			System.out.println(ava);
		}
		
		s.close();
	}
}