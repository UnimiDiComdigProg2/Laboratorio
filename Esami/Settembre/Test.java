import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Mappa m = new Mappa(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

		Scanner s = new Scanner(System.in);
		System.out.println("Inserisci comando e parametri:");

		while(s.hasNext()) {
			String[] cmd = s.nextLine().split(" ");

			try {
				switch(cmd[0]) {
					case "crea":
						if(cmd[1].equals("Arciere"))
							m.crea(new Arciere(cmd[2], Integer.valueOf(cmd[3]), Integer.valueOf(cmd[4]), Integer.valueOf(cmd[5]), Integer.valueOf(cmd[6])));
						else
							m.crea(new Barbaro(cmd[2], Integer.valueOf(cmd[3]), Integer.valueOf(cmd[4]), Integer.valueOf(cmd[5]), Integer.valueOf(cmd[6])));
						break;

					case "muovi":
						m.muovi(cmd[1], Integer.valueOf(cmd[2]), Integer.valueOf(cmd[3]));
						break;

					case "attacca":
						m.attacca(cmd[1], cmd[2]);
						break;
				}
			} catch (MapException | CharException e) {
				System.out.println("\t"+e.getMessage());
			}
		}

		System.out.println(m);
	}
}