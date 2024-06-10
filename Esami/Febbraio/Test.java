import java.util.NoSuchElementException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Cartella c = new Cartella("/");

		Scanner s = new Scanner(System.in);

		System.out.println("\tInserisci comandi (Ctrl+D termina)");
		System.out.println("\t\tcrea cartella <nome>");
		System.out.println("\t\tcrea documento <nome> <dimensione>");
		System.out.println("\t\trimuovi <nome>");
		System.out.println("\t\tentra <nome>");
		System.out.println("\t\tesci");
		System.out.println("\t\telenca");

		while(s.hasNextLine()) {
			String[] p = s.nextLine().split(" ");

			switch(p[0]) {
				case "crea":
					try {
						if(p[1].equals("cartella"))
							c.crea(new Cartella(p[2]));
						else if(p[1].equals("documento"))
							c.crea(new Documento(p[2],Integer.valueOf(p[3])));
					} catch (NullPointerException | IllegalArgumentException | ElementExistsException e) {
						System.out.println(e.getMessage());
					}
					break;
				case "rimuovi":
					try {
						c.rimuovi(p[1]);
					} catch (NullPointerException | IllegalArgumentException | NoSuchElementException e) {
						System.out.println(e.getMessage());
					}
					break;
				case "entra":
					try {
						c = c.entra(p[1]);
					} catch (NoSuchDirException | NullPointerException | IllegalArgumentException | NoSuchElementException e) {
						System.out.println(e.getMessage());
					}
					break;
				case "esci":
					try {
						c = c.superiore();
					} catch (NoSuchElementException e) {
						System.out.println(e.getMessage());
					}
					break;
				case "elenca":
					System.out.println(c);   
					break;
			}
		}
		s.close();
	}
}