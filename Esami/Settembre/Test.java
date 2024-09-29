import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Spesa spesa = new Spesa();

		Scanner s = new Scanner(System.in);

		System.out.println("Inserisci o rimuovi prodotti (Ctrl+D termina)");
		System.out.println("\tinserisci <nome> <prezzo> <codice> <qty>");
		System.out.println("\tinserisci <nome> <prezzo> <codicebase> <peso> <qty>");
		System.out.println("\trimuovi <nome>");

		while(s.hasNextLine()) {
			String[] parts = s.nextLine().split(" ");

			if(parts[0].equals("inserisci")) {
				try {
					if(parts.length == 6)
						spesa.aggiungi(new ProdottoPeso(parts[1], Double.parseDouble(parts[2]), parts[3], Integer.parseInt(parts[4])), Integer.parseInt(parts[5]));
					else if(parts.length == 5)
						spesa.aggiungi(new ProdottoBase(parts[1], Double.parseDouble(parts[2]), parts[3]), Integer.parseInt(parts[4]));
				} catch(IllegalArgumentException | CodeException | ElementException e) {
					System.out.println(e.getMessage());
				}
			} else if(parts[0].equals("rimuovi")) {
				try {
					spesa.rimuovi(parts[1]);
				} catch(IllegalArgumentException | ElementException e) {
					System.out.println(e.getMessage());
				}
			}
		}

		System.out.println("\n" + spesa);
		s.close();
	}
}