import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pets {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		List<Persona> l = new ArrayList<>(); //Si potrebbe gestire attraverso un set

		System.out.println("Inserisci righe nel formato `nomePersona nomeAnimale tipoAnimale` (CTRL+D per terminare)");
		while(s.hasNext()) {
			Persona p = new Persona(s.next());
			int i = l.indexOf(p);

			if(i >= 0)
				p = l.get(i);
			else
				l.add(p);

			String nomepet = s.next();

			switch (s.next()) {
				case "Cane":
					p.add(new Cane(nomepet));
					break;
				case "Gatto":
					p.add(new Gatto(nomepet));
					break;
				case "Cavia":
					p.add(new Cavia(nomepet));
					break;
				default:
					System.exit(1);
			}
		}

		for(Persona tp : l) {
			System.out.println();
			tp.coro();
		}
	}
}