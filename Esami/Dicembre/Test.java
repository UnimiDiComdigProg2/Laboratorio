import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Presepio p = new Presepio();

		Scanner s = new Scanner(System.in);

		System.out.println("Aggiungi o togli Figura (Ctrl+D termina)");
		System.out.println("\taggiungi <nome> Persona");
		System.out.println("\taggiungi <nome> Animale <aggettivo>");
		System.out.println("\taggiungi <nome> Base [aggettivo1 aggettivo2 ...]");
		System.out.println("\ttogli <nome>\n");

		while(s.hasNextLine()) {
			String[] cmd = s.nextLine().split(" ", 4);
			
			if(cmd[0].equals("aggiungi")) {
				try {
					if(cmd[2].equals("Base"))
						p.aggiungi(new Base(cmd[1], cmd[3].split(" "))); // a un metodo con parametri variabili si può anche passare un array di quel tipo
					else if(cmd[2].equals("Animale"))
						p.aggiungi(new Animale(cmd[1], cmd[3]));
					else if(cmd[2].equals("Persona"))
						p.aggiungi(new Persona(cmd[1]));
				} catch(FiguraException | NomeException e) {
					System.out.println(e.getMessage());
				}
			} else if(cmd[0].equals("togli")) {
				try {
					p.togli(cmd[1]);
				} catch(FiguraException e) {
					System.out.println(e.getMessage());
				}
			}
		}

		System.out.println("\n" + p);
		s.close();
	}
}