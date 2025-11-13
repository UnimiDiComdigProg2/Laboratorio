import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Pretendenti implements Iterable<Integer> {
//OVERVIEW: modella il meccanismo di selezione dei pretendenti di Eva

//attributi
	private ArrayList<Integer> pretendenti = new ArrayList<>();

	public Pretendenti(int n) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza la lista dei pretendenti con n pretendenti
	//         se n <= 0 lancia una IllegalArgumentException
		if(n <= 0)
			throw new IllegalArgumentException("n <= 0");

		for (int i = 1; i <= n ; i++)
			pretendenti.add(i);

		assert repOk();
	}

	@Override
	public String toString() {
		return "Pretendenti: " + pretendenti;
	}

	public boolean repOk() {
		if(pretendenti == null)
			return false;

		if(pretendenti.size() == 0)
			return false;

		for (int i = 0; i < pretendenti.size(); i++) {
			if(pretendenti.get(i) == null || pretendenti.get(i) <= 0 || pretendenti.indexOf(pretendenti.get(i)) != pretendenti.lastIndexOf(pretendenti.get(i)))
				return false;

			if(i > 0 &&  pretendenti.get(i) < pretendenti.get(i-1))
				return false;
		}

		return true;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			boolean dir = true; // true = dal primo all'ultimo
			boolean canRemove = false;
			int currentIdx = 0;

			@Override
			public boolean hasNext() {
				return Pretendenti.this.pretendenti.size() > 1;
			}

			@Override
			public Integer next() {
				if(!(hasNext()))
					throw new NoSuchElementException("finiti i pretendenti");

				if(dir)
					currentIdx+=2;
				else
					currentIdx-=2;

				if(currentIdx >= pretendenti.size()-1) {
					currentIdx = 2*(pretendenti.size() - 1) - currentIdx;
					//assumiamo su una size di 4 elementi
					//se sono all'indice 4 (ovvero uno di fuori) dovrei andare all'indice 2, ovvero uno di dentro
					//dovrei calcolare di quanto ho sforato cioè indice corrente (4) - (dimensione array (4)-1) = 1
					//dovrei fare (dimensione array (4)-1)-quanto sopra

					dir = false;
				}

				if(currentIdx <= 0) {
					currentIdx = -currentIdx;
					dir = true;
				}

				canRemove = true;

				return Pretendenti.this.pretendenti.get(currentIdx);
			}


			@Override
			public void remove() throws IllegalStateException {
				if(canRemove == false)
					throw new IllegalStateException("cannot remove");

				pretendenti.remove(currentIdx);

				if(dir == false)
					currentIdx--;

				if(currentIdx > pretendenti.size()-1)
					currentIdx--;

				if(currentIdx == pretendenti.size()-1)
					dir = false;

				if(currentIdx == 0)
					dir = true;

				canRemove = false;
			}

			@Override
			public String toString() {
				//return "Si conta da " + currentIdx + "direzione: " + (dir ? "avanti" : "indietro");

				if(dir)
					return  "Si conta dal elemento all'indice " + currentIdx + " valore: " + Pretendenti.this.pretendenti.get(currentIdx) + " direzione: avanti";
				else
					return  "Si conta dal elemento all'indice " + currentIdx + " valore: " + Pretendenti.this.pretendenti.get(currentIdx) + " direzione: indietro";
				
			}
			
		};
	}

	public static void main(String[] args) {

		Pretendenti p = new Pretendenti(Integer.parseInt(args[0]));

		Iterator<Integer> i = p.iterator();

		System.out.println(p);
		System.out.println(i);

		while (i.hasNext()) {
			System.out.println(i.next());
			i.remove();
			System.out.println(p);
			System.out.println(i);
		}
	}
}