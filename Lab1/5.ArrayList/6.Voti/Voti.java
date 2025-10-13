import java.util.ArrayList;
import java.util.Scanner;

public class Voti {

	// Method to read numbers from standard input and return an ArrayList
	public static ArrayList<Integer> leggiNumeri() {
		ArrayList<Integer> numeri = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Inserisci i voti:");
		while (scanner.hasNextInt()) {
			int voto = scanner.nextInt();
			// Ensure the vote is between 0 and 100
			if (voto >= 0 && voto <= 100)
				numeri.add(voto);
			else
				System.out.println("Voto non valido: inserisci un valore tra 0 e 100.");
		}
		return numeri;
	}

	public static ArrayList<Integer> filtraVotiSufficienti(ArrayList<Integer> l) {
		ArrayList<Integer> res = new ArrayList<>();

		for (int voto : l)
			if (voto >= 18)
				res.add(voto);

		return res;
	}

	public static ArrayList<Integer> filtraVotiInsufficienti(ArrayList<Integer> l) {
		ArrayList<Integer> res = new ArrayList<>();

		for (int voto : l)
			if (voto < 18)
				res.add(voto);

		return res;
	}

	// Method to filter and print sufficient and insufficient votes
	public static ArrayList<Integer> filtraVoti(ArrayList<Integer> l, boolean quali) {
		ArrayList<Integer> res = new ArrayList<>();

		for (int voto : l)
			if (quali == true && voto >= 18 || quali == false && voto < 18)
				res.add(voto);

		return res;
	}

	public static void main(String[] args) {
		// Step 1: Read the list of numbers
		ArrayList<Integer> voti = leggiNumeri();

		// Step 2: Filter and print sufficient and insufficient votes
		System.out.print("Voti sufficienti: ");
		System.out.println(filtraVoti(voti, true));
		System.out.print("Voti insufficienti: ");
		System.out.println(filtraVoti(voti, false));
	}
}
