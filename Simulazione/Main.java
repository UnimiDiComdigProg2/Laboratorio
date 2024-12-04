import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Vetreria mv = new Vetreria();
		HashSet<String> ls = new HashSet<>();

		while(s.hasNext()) {
			String liq = s.next();
			ls.add(liq);

			double qty = s.nextDouble();

			try {
				switch(s.next()) {
					case "Sfera":
						mv.add(new Sfera(liq, qty, s.nextDouble()));
						break;
					case "Cilindro":
						mv.add(new Cilindro(liq, qty, s.nextDouble(), s.nextDouble()));
						break;
					case "Cuboide":
						mv.add(new Cuboide(liq, qty, s.nextDouble(), s.nextDouble(), s.nextDouble()));
						break;
				}
			} catch(CapacityException e) {
				System.out.println(e.getMessage());
				return;
			}
		}

		System.out.println(mv);

		ArrayList<Vetreria> vs = new ArrayList<>();

		for(String l: ls)
			vs.add(mv.estrai(l));

		for(Vetreria v: vs) {
			v.ottimizza();
			System.out.println("\n"+v);
		}
	}
}