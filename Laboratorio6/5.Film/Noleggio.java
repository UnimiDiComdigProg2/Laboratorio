//Grazie a Nicola Montagnese per il codice

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Noleggio {
	public static void main(String[] args) { // TESTING
		Scanner s = new Scanner(System.in);
		int codice = 1;
		double totalePenale = 0;
		
		System.out.println("Inserisci i film noleggiati nel formato `nome tipo data` (CTRL+D per terminare)");
		while (s.hasNext()) {
			String nome = s.next();
			String tipo = s.next();
			LocalDate dataNoleggio = LocalDate.parse(s.next(), DateTimeFormatter.ofPattern("d-M-yyyy"));
			Film film = null; //polimorfismo!
			
			try {
				switch(tipo) {
					case "Azione":
						film = new Azione(nome, codice, dataNoleggio);
						break;
					case "Dramma":
						film = new Dramma(nome, codice, dataNoleggio);
						break;
					case "Commedia":
						film = new Commedia(nome, codice, dataNoleggio);
						break;
				}
			} catch (NotValidFilmException n) {
				System.out.println(n.getMessage());
			}
			
			if(film != null)
				totalePenale += film.calcolaPenaleRitardo();
			
			codice++;
		}
		
		System.out.println("Penale totale: " + totalePenale + "€");
	}
}
