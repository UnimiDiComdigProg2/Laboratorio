import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Calendario c = new Calendario();
		Scanner s = new Scanner(System.in);

		System.out.println("Inserisci sorpresa o apri giorno (Ctrl+D termina)");
		System.out.println("\tinserisci <giorno> Cioccolatino <nome> <% cacao>");
		System.out.println("\tinserisci <giorno> Giocattolo <nome> <descrizione>");
		System.out.println("\tapri <giorno>\n");

		while(s.hasNextLine()) {
			String[] cmd = s.nextLine().split(" ", 5); //limitare a 5 split permette di avere tutta la descrizione unita nell'ultimo

			if(cmd[0].equals("inserisci")) {
				try {
					if(cmd[2].equals("Cioccolatino"))
						c.inserisci(Integer.parseInt(cmd[1]), new Cioccolatino(cmd[3], Integer.parseInt(cmd[4])));
					else if(cmd[2].equals("Giocattolo"))
						c.inserisci(Integer.parseInt(cmd[1]), new Giocattolo(cmd[3], cmd[4]));
				} catch(GiornoException | SorpresaException e) { //catturare sempre eccezioni esplicite (non Exception) se no diventa difficile capire quali sono e dove avvengono
					System.out.println(e.getMessage());
				}
			} else if(cmd[0].equals("apri")) {
				try {
					System.out.println("trovato: " + c.apri(Integer.parseInt(cmd[1])));
				} catch(GiornoException e) {
					System.out.println(e.getMessage());
				}
			}
		}

		System.out.println("\n" + c);
		s.close();
	}
}