import java.util.Iterator;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;

class Matrice implements Iterable<Iterator<Integer>> {
	private int[][] matrice;

	public Matrice(int righe, int colonne) {
	//MODIFIES: this
	//EFFECTS: crea una nuova matrice righe*colonne
	//         se righe o colonne <= 0 lancia IllegalArgumentException
		if(righe <= 0 || colonne <= 0)
			throw new IllegalArgumentException("righe e colonne devono essere > 0");

		matrice = new int[righe][colonne];

		assert repOk();
	}
	
	private boolean colonnaValida(int x) {
	//EFFECTS: true se colonna x esiste, false altrimenti
		if((x < 0) || (x >= matrice[0].length))
			return false;

		return true;
	}

	private boolean rigaValida(int y) {
	//EFFECTS: true se riga y esiste, false altrimenti
		if((y < 0) || (y >= matrice.length))
			return false;

		return true;
	}

	public int getVal(int x, int y) throws IllegalArgumentException {
		if(!rigaValida(y))
			throw new IllegalArgumentException("y deve essere tra 0 e " + matrice.length);

		if(!colonnaValida(x))
			throw new IllegalArgumentException("x deve essere tra 0 e " + matrice[0].length);

		return(matrice[y][x]);
	}

	public void setVal(int x, int y, int v) throws IllegalArgumentException {
		if(!rigaValida(y))
			throw new IllegalArgumentException("y deve essere tra 0 e " + (matrice.length-1));

		if(!colonnaValida(x))
			throw new IllegalArgumentException("x deve essere tra 0 e " + (matrice[0].length-1));

		matrice[y][x] = v;
	}

	public Iterator<Iterator<Integer>> iterator() {
	//EFFECTS: restituisce degli Iterator<Integer> per ciascuna riga
	//         questi restituiranno i valori degli elementi della riga
		return new Iterator<Iterator<Integer>>() {
			private int curR = 0; //riga corrente

			public boolean hasNext() {
				return rigaValida(curR);
			}

			public Iterator<Integer> next() throws NoSuchElementException {
				if(!hasNext())
					throw new NoSuchElementException("non ci sono più righe");

				curR++;
				return new Iterator<Integer>() {
					private int curC = 0; //colonna corrente

					public boolean hasNext() {
						return colonnaValida(curC);
					}

					public Integer next() throws NoSuchElementException {
						if(!hasNext())
							throw new NoSuchElementException("non ci sono più colonne");

						curC++;
						return matrice[curR-1][curC-1];
					}
				};
			}
		};
	}

	public boolean repOk() {
		if(matrice == null)
			return false;

		if(matrice.length <= 0)
			return false;

		if(matrice[0].length <= 0)
			return false;

		return true;
	}

	public static void main(String[] args) {
		int righe = Integer.parseInt(args[0]);
		int colonne = Integer.parseInt(args[1]);

		Matrice m = new Matrice(righe,colonne);

		Scanner s = new Scanner(System.in);

		for(int i=0;i<righe;i++) {
			System.out.println("Inserisci i " + colonne + " numeri (separati da spazio) della riga " + (i+1));
			for(int j=0;j<colonne;j++) {
				m.setVal(j,i,s.nextInt());
			}
		}

		System.out.println("Matrice inserita:");
		for(Iterator<Integer> r : m) { //L'iteratore di matrice mi restituisce gli iteratori di ciascuna riga
			while(r.hasNext()) //Che poi uso per iterare sugli elementi singoli
				System.out.print(r.next() + " ");

			System.out.println();
		}
	}
}