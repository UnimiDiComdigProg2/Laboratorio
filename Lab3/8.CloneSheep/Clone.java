//Grazie a Nicola Montagnese per il codice
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Clone {
	public static void main(String[] args) {
	
		String nome = args[0];
		ArrayList<String> dna = new ArrayList<String>();

		Scanner s = new Scanner(System.in);
		System.out.println("Inserisci i cromosomi, uno per riga (terminare con CTRL+D):");
		while(s.hasNext())
			dna.add(s.next());

		try {
			Sheep pecora = new Sheep(dna, nome);

			try {
				Sheep clone = (Sheep) pecora.clone();
				System.out.println("Ho creato un clone di " + nome);

				if(pecora.equals(clone))
					System.out.println("I due pokemon sono uguali");
				else 
					System.out.println("I due pokemon sono diversi... controlla nei box...");

				Scanner t = new Scanner(System.in);
				System.out.println("Inserisci il cromosoma da modificare ed il nuovo codice:");
				int indice = Integer.parseInt(t.next());
				String cromosoma = t.next();

				try {
					clone.sostituisciCromosoma(cromosoma, indice);

					if (pecora.equals(clone))
						System.out.println("I due pokemon sono ancora uguali");
					else
						System.out.println("I due pokemon sono diversi... controlla nei box...");

				} catch (InputMismatchException i) {
					System.out.println(i.getMessage());
				}
			} catch (CloneNotSupportedException c) {
				System.out.println(c.getMessage());
			}
		} catch (NullPointerException n) {
			System.out.println(n.getMessage());
		} catch (IllegalAccessError i) {
			System.out.println(i.getMessage());
		}
	}
}