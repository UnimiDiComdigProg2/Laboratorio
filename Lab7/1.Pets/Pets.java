import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pets {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		List<Persona> l = new ArrayList<>();

		System.out.println("Inserisci righe nel formato `nomePersona nomeAnimale tipoAnimale` (CTRL+D per terminare)");
		while(s.hasNext()) {
			Persona pers = new Persona(s.next());

			if(l.indexOf(pers) != -1)
				pers = l.get(l.indexOf(pers));
			else
				l.add(pers);

			String nomepet = s.next();

			try {
				switch (s.next()) {
					case "Cane":
						pers.add(new Cane(nomepet));
						break;
					case "Gatto":
						pers.add(new Gatto(nomepet));
						break;
					case "Cavia":
						pers.add(new Cavia(nomepet));
						break;
					default:
						System.exit(1);
				}
			} catch(PetException e) {
				System.out.println(e.getMessage());
			}
		}

		for(Persona tp : l) {
			System.out.println("\nIl coro degli animali di " + tp.getNome() + ":");
			for(Pet pet : tp)
				System.out.println("\t" + pet.getNome() + " dice " + pet.verso());
		}
	}
}