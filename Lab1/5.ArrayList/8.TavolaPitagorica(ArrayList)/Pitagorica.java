import java.util.ArrayList;

public class Pitagorica {

	public static ArrayList<Integer> creaRigaPitagorica(int m, int n) {
		ArrayList<Integer> riga = new ArrayList<>();

		for(int i = 0; i < n; i++)
				riga.add((m+1)*(i+1));

		return riga;
	}
	
	public static ArrayList<ArrayList<Integer>> creaTavolaPitagorica(int n) {
		ArrayList<ArrayList<Integer>> tabella = new ArrayList<>();

		for(int i = 0; i < n; i++)
			tabella.add(creaRigaPitagorica(i,n));

		return tabella;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		ArrayList<ArrayList<Integer>> tavola = creaTavolaPitagorica(n);

		for(ArrayList<Integer> riga : tavola) {
			for(Integer elemento : riga)
				System.out.print(elemento + "\t");

			System.out.println();
		}
	}
}