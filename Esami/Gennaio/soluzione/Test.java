import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Olimpiade o = new Olimpiade(Integer.valueOf(args[0]));
		Scanner s = new Scanner(System.in);

		System.out.println("Comandi possibili (Ctrl+D termina)");
		System.out.println("\taggiungi <giorno> Cerimonia <nome> <apertura / chiusura>");
		System.out.println("\taggiungi <giorno> Gara <nome> <numero atleti>");
		System.out.println("\trimuovi <giorno>\n");

		while(s.hasNextLine()) {
			String[] cmd = s.nextLine().split(" ");

			if(cmd[0].equals("aggiungi")) {
				try {
					if(cmd[2].equals("Gara"))
						o.aggiungi(Integer.parseInt(cmd[1]), new Gara(cmd[3], Integer.parseInt(cmd[4])));
					else if(cmd[2].equals("Cerimonia"))
						o.aggiungi(Integer.parseInt(cmd[1]), new Cerimonia(cmd[3], (cmd[4].equals("apertura") ? true : false)));
				} catch(GiornoException | EventoException e) {
					System.out.println(e.getMessage());
				}
			} else if(cmd[0].equals("rimuovi")) {
				try {
					o.rimuovi(Integer.parseInt(cmd[1]));
				} catch(GiornoException e) {
					System.out.println(e.getMessage());
				}
			}
		}

		System.out.println("\n" + o);

		System.out.println("Eventi in ordine di durata:");
		for(Evento e : o)
			System.out.println("\t" + e);

		s.close();
	}
}