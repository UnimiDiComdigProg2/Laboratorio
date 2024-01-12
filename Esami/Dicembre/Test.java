import java.util.NoSuchElementException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Erogatore erogatore = new Erogatore();

		Scanner s = new Scanner(System.in);

		System.out.println("Inserisci comandi (Ctrl+D termina)");
		System.out.println("\tvalida <età>");
		System.out.println("\tAggiungi <credito>");
		System.out.println("\tEroga <nome>");
		System.out.println("\tCarica <nome> <prezzo> [etàMin] <qty>");
		while(s.hasNextLine()) {
			String[] parts = s.nextLine().split(" ");

			switch (parts[0]) {
				case "Carica":
					if(parts.length == 5)
						erogatore.carica(new ProdottoControllato(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3])), Integer.parseInt(parts[4]));
					else if(parts.length == 4)
						erogatore.carica(new Prodotto(parts[1], Double.parseDouble(parts[2])), Integer.parseInt(parts[3]));
					break;
				case "Valida":
					erogatore.validaEta(Integer.parseInt(parts[1]));
					break;
				case "Aggiungi":
					System.out.println("\tCredito: " + erogatore.addCredito(Integer.parseInt(parts[1])));
					break;
				case "Eroga":
					try {
						System.out.println("\tCredito: " + erogatore.eroga(parts[1]));
					} catch(Exception e) {
						System.out.println("\t" + e.getMessage());
					}
					break;
			}
		}

		System.out.println("\n" + erogatore);
	}
}