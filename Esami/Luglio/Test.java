import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Operatore o = new Operatore(args[0]);

		Scanner s = new Scanner(System.in);
		System.out.println("Inserisci Utenza e comando (add/call/load/reset):");

		while(s.hasNextLine()) {
			String[] cmd = s.nextLine().split(" ", 4);
			Utenza t = null;

			if(cmd[1].equals("add")) {
				try {
					if(cmd[2].equals("Prepagata"))
						t = new UtenzaPrepagata(cmd[0], cmd[3]);
					else
						t = new UtenzaSoglia(cmd[0], cmd[3], Integer.valueOf(cmd[2].split("-")[1]));

					o.aggiungiUtenza(t);
				} catch(IllegalArgumentException | UtenzaNonValidaException e) {
					System.out.println(e);
					System.exit(1);
				}
			} else {
				try {
					t = o.getUtenza(cmd[0]);
				} catch(UtenzaNonValidaException e) {
					System.out.println(e);
					System.exit(1);
				}

				if(cmd[1].equals("call")) {
					try {
						t.chiama(Integer.valueOf(cmd[2]));
					} catch(TempoEsauritoException | IllegalArgumentException e) {
						System.out.println(e);
						System.exit(1);
					}
				} else if(cmd[1].equals("load")) {
					try {
						((UtenzaPrepagata) t).ricarica(Integer.valueOf(cmd[2]));
					} catch(UnsupportedOperationException | ClassCastException e) {
						System.out.println(e);
						System.exit(1);
					}
				} else if(cmd[1].equals("reset")) {
					try {
						((UtenzaSoglia) t).reset();
					} catch(ClassCastException e) {
						System.out.println(e);
						System.exit(1);
					}
				}
			}
		}

		System.out.println(o);
		s.close();
	}
}