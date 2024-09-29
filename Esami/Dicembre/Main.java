import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		AlberoNatalizio a = new AlberoNatalizio(Double.valueOf(args[0]), Double.valueOf(args[1]));
		
		Scanner s = new Scanner(System.in);
		
		while(s.hasNext()) {
			try {
				switch (s.next()) {
					case "DecorazioneElettrica":
						a.add(new DecorazioneElettrica(s.next(), s.nextDouble(), s.nextDouble()));
						break;
					case "Puntale":
						a.add(new Puntale(s.next(), s.nextDouble()));
						break;
					case "Decorazione":
						a.add(new Decorazione(s.next(), s.nextDouble()));
						break;
				}
			} catch (WeightReachedException e) {
				System.out.println(e.getMessage());
			} catch (TopperExistsException f) {
				System.out.println(f.getMessage());
			}
		}
		
		a.accendi();
		
		System.out.println();
		
		System.out.println(a);
		for (Decorazione decorazione : a)
			System.out.println(decorazione);
	}
}