import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Team[] ts = new Team[2];

		Scanner s = new Scanner(System.in);

		for(int i = 0; i < 2; i++) {
			ts[i] = new Team(args[i]);

			System.out.println("\tInserisci i giocatori della squadra: " + args[i]);
			System.out.println("\t\tportiere,<numero>,<frazione parate>,<nome>");
			System.out.println("\t\tgiocatore,<numero>,<attacco>,<difesa>,<nome>");

			ArrayList<Player> ps = new ArrayList<>();

			while(ts[i].countPlayers() < 5) {
				String[] l = s.nextLine().split(",");

				try {
					switch(l[0]) {
						case "portiere":
							ts[i].add(new Goalie(l[3], Integer.parseInt(l[1]), Double.parseDouble(l[2])));
							break;
						case "giocatore":
							ts[i].add(new FieldPlayer(l[4], Integer.parseInt(l[1]), Integer.parseInt(l[2]), Integer.parseInt(l[3])));
							break;
					}
				} catch(IllegalArgumentException | TeamException e) {
					System.out.println("\t"+e.getMessage());
				}
			}
		}

		System.out.println(ts[0] + "\n" + ts[1]);

		try {
		 System.out.println("Risultato " + ts[0].score(ts[1]) + ":" + ts[1].score(ts[0]));
		} catch(IllegalArgumentException | TeamException e) {
			System.out.println("\t"+e.getMessage());
		}
	}
}