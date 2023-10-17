import java.time.DateTimeException;

public class FormatoOra {

	public static String converti(String s) throws DateTimeException {
	//EFFECTS: converti l'ora nel formato "HH:MM" in formato "h:MM AM/PM"
	//         se stringa vuota o nulla lancia InvalidArgumentException
	//         se stringa non valida lancia DateTimeException
		if(s == null || s.equals(""))
			throw new IllegalArgumentException("s vuota o nulla");

		String[] parts = s.split(":");

		if(parts.length != 2)
			throw new DateTimeException(": non trovati");
		
		if(parts[0].length() != 2)
			throw new DateTimeException("ora deve avere 2 cifre");
		
		if(parts[1].length() != 2)
			throw new DateTimeException("minuti devono avere 2 cifre");

		if("012".indexOf(parts[0].charAt(0)) == -1 || "0123456789".indexOf(parts[0].charAt(1)) == -1)
			throw new DateTimeException("ora formata da caratteri errati");

		if("012345".indexOf(parts[1].charAt(0)) == -1 || "0123456789".indexOf(parts[1].charAt(1)) == -1)
			throw new DateTimeException("minuti formati da caratteri errati");

		int ore = Integer.valueOf(parts[0]);
		int minuti = Integer.valueOf(parts[1]);

		if(ore < 0 || ore > 23)
			throw new DateTimeException("ore non valide");

		if(minuti < 0 || minuti > 59)
			throw new DateTimeException("minuti non validi");

		String ampm = "";

		if(ore < 12)
			ampm =" AM";
		else
			ampm =" PM";

		if(ore > 12)
			ore-=12;

		return ore + ":" + minuti + ampm;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(converti(args[0]));
		} catch(DateTimeException e) {
			System.out.println(e.getMessage());
		}
	}
}