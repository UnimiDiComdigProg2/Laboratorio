import java.util.Iterator;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;

class Matrice implements Iterable<Iterator<Integer>> {
	private int[][] matrice;
	
	public Matrice(int righe, int colonne) {
		this.matrice = new int[righe][colonne];
	}
	
	private boolean colonnaValida(int x) {
		if((x < 0) || (x >= this.matrice[0].length))
			return false;
		
		return true;
	}

	private boolean rigaValida(int y) {
		if((y < 0) || (y >= this.matrice.length))
			return false;
		
		return true;
	}

	public int getVal(int x, int y) throws IllegalArgumentException {
		if(!rigaValida(y))
			throw new IllegalArgumentException("y deve essere tra 0 e " + this.matrice.length);
		
		if(!colonnaValida(x))
			throw new IllegalArgumentException("x deve essere tra 0 e " + this.matrice[0].length);
			
		return(this.matrice[y][x]);
	}
	
	public void setVal(int x, int y, int v) throws IllegalArgumentException {
		if(!rigaValida(y))
			throw new IllegalArgumentException("y deve essere tra 0 e " + (this.matrice.length-1));
		
		if(!colonnaValida(x))
			throw new IllegalArgumentException("x deve essere tra 0 e " + (this.matrice[0].length-1));
		
		this.matrice[y][x] = v;
	}
	
	public Iterator<Iterator<Integer>> iterator() {
	
		return new Iterator<Iterator<Integer>>() {
			private int curR = 0;
			
			public boolean hasNext() {
				return Matrice.this.rigaValida(curR);
			}
			
			public Iterator<Integer> next() throws NoSuchElementException {
				if(!this.hasNext())
					throw new NoSuchElementException("non ci sono più righe");
				
				this.curR++;
				return new Iterator<Integer>() {
					private int curC = 0;
					
					public boolean hasNext() {
						return Matrice.this.colonnaValida(curC);
					}
					
					public Integer next() throws NoSuchElementException {
						if(!this.hasNext())
							throw new NoSuchElementException("non ci sono più colonne");
						
						curC++;
						return Matrice.this.matrice[curR-1][curC-1];
					}
				};
			}
		};
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
		for(Iterator<Integer> r : m) {
			while(r.hasNext())
				System.out.print(r.next() + " ");
			
			System.out.println();
		}
	}
}