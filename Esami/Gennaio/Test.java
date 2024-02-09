import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Lavanderia l = new Lavanderia();
		Scanner s = new Scanner(System.in);

		System.out.println("\tInserisci comandi (Ctrl+D termina)");
		System.out.println("\t\tinstalla <lavatrice/asciugatrice> <costo>");
		System.out.println("\t\tlava/asciuga/rimuovi/apri <id>");
		System.out.println("\t\taggiungi <credito>");
		System.out.println("\t\tstatus");

		while(s.hasNextLine()) {
			String[] p = s.nextLine().split(" ");

			switch(p[0]) {
			case "installa":
				try {
					if(p[1].equals("lavatrice"))
						System.out.println("\tinstallata lavatrice: " + l.install(new Lavatrice(Double.parseDouble(p[2]))));
					else if(p[1].equals("asciugatrice"))
						System.out.println("\tinstallata asciugatrice: " + l.install(new Asciugatrice(Double.parseDouble(p[2]))));
				} catch(IllegalArgumentException | NullPointerException e) {
					System.out.println("\t"+e.getMessage());
				}
				break;
			case "rimuovi":
				try {
					l.uninstall(Integer.parseInt(p[1]));
				} catch(IllegalArgumentException | IndexOutOfBoundsException e) {
					System.out.println("\t"+e.getMessage());
				}
				break;
			case "aggiungi":
				try {
					System.out.println("\tcredito: " + l.addCredit(Double.parseDouble(p[1])));
				} catch(IllegalArgumentException e) {
					System.out.println("\t"+e.getMessage());
				}
				break;
			case "lava":
				try {
					System.out.println("\tcredito: " + l.wash(Integer.parseInt(p[1])));
				} catch(IllegalArgumentException | IndexOutOfBoundsException | UnsupportedOperationException | LockException | CreditException e) {
					System.out.println("\t"+e.getMessage());
				}
				break;
			case "asciuga":
				try {
					System.out.println("\tcredito: " + l.dry(Integer.parseInt(p[1])));
				} catch(IllegalArgumentException | IndexOutOfBoundsException | UnsupportedOperationException | LockException | CreditException e) {
					System.out.println("\t"+e.getMessage());
				}
				break;
			case "apri":
				try {
					l.unlock(Integer.parseInt(p[1]));
				} catch(IllegalArgumentException | IndexOutOfBoundsException | LockException e) {
					System.out.println("\t"+e.getMessage());
				}
				break;
			case "status":
				System.out.println(l);
				break;
			}
		}
	s.close();
	}
}