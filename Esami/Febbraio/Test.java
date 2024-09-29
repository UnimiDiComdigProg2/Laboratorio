import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Mazzo m = null;

		switch (args[0]) {
			case "Mazzo":
				m = new Mazzo();
				break;
			case "MazzoRidotto":
				m = new MazzoRidotto();
				break;
			default:
				System.exit(0);
		}

		m.mischia();
		System.out.println(m);

		Scanner s = new Scanner(System.in);

		while(s.hasNextLine()) {
			String[] cmd = s.nextLine().split(" ");

			switch (cmd[0]) {
				case "estrai":
					if(m.hasNext())
						System.out.println("Estratto: " + m.next());
					else
						System.out.println("Non ci sono più carte");
					break;
			
				case "inserisci":
					try {
						Carta tc = new Carta(Integer.valueOf(cmd[1]), cmd[2].charAt(0));
						m.inserisci(tc);
						System.out.println("Inserito: " + tc);
					} catch (CardExistsException e) {
						System.out.println(e.getMessage());
					} catch (CardNotValidException f) {
						System.out.println(f.getMessage());
					}
					break;
			}
		}

		s.close();

		m.riordina();

		System.out.println(m);
	}
}
