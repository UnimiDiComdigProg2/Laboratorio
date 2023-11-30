import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Vetreria v = new Vetreria();
		HashSet<String> tipi = new HashSet<>();

		while(s.hasNext()) {
			String tipo = s.next();
			tipi.add(tipo);

			double volume = s.nextDouble();

			try {
				switch(s.next()) {
					case "Sfera":
						v.add(new Sfera(volume, tipo, s.nextDouble()));
						break;
					case "Cilindro":
						v.add(new Cilindro(volume, tipo, s.nextDouble(), s.nextDouble()));
						break;
					case "Cuboide":
						v.add(new Cuboide(volume, tipo, s.nextDouble(), s.nextDouble(), s.nextDouble()));
						break;
				}
			} catch(ExceededCapacityException e) {
				System.out.println(e.getMessage());
				return;
			}
		}

		System.out.println(v);

		ArrayList<Vetreria> vetrerie = new ArrayList<>();

		for(String tipo : tipi)
			vetrerie.add(v.estrai(tipo));

		for(Vetreria vetreria : vetrerie) {
			vetreria.ottimizza();
			System.out.println(vetreria);
		}

		s.close();
	}
}