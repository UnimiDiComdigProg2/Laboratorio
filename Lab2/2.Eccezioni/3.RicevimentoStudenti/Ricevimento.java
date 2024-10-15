//Grazie a Jacopo per la base della soluzione che ho modificato qua
public class Ricevimento {
//OVERVIEW: classe statica per gestire un'agenda di appuntamenti modellata come un array di 6 elementi

	public static void prenota(String[] agenda, int ora, String nome) throws NullPointerException, TimeBusyException, AlreadyBookedException, IllegalArgumentException {
	// MODIFIES: agenda 
	// EFFECTS: data l'ora e il nome prenota assegnerà lo slot corrispondente in agenda
	//          throws NullPointerException se agenda è null; TimeBusyException se lo slot è già prenotato o AlreadyBookedException se `nome` ha già prenotato un orario diverso; IllegalArgumentException se 'orario' non valido (<13 o >18) o 'nome' vuoto

		if(agenda == null)
			throw new NullPointerException("Agenda non inizializzata");

		if(agenda.length !=6)
			throw new IllegalArgumentException("L'agenda non ha 6 slot");

		if(nome == null || nome.equals(""))
			throw new ParameterException("nome non valido");

		if(ora < 13 | ora >18 )
			throw new ParameterException("orario non valido");

		if(agenda[ora-13] != null)
			throw new TimeBusyException("Lo Slot è già stato prenotato");

		if(nomeEsiste(agenda, nome)) // Alternativ: Arrays.asList(agenda).contains(nome)
			throw new AlreadyBookedException(nome + ", hai già prenotato!");

		agenda[ora-13] = nome;
	}

	private static boolean nomeEsiste(String[] agenda, String nome) { //metodo usato solo internamente quindi privato
	// REQUIRES: agenda not null e con length 6
	// EFFECTS: restituisce true se nome presente in agenda, false altrimenti

		for(String entry : agenda)
			if(entry != null && entry.equals(nome))
				return true;

		return false;
	}

	public static int[] orariDisponibili(String[] agenda)	throws NullPointerException, IllegalArgumentException {
	//EFFECTS: Data un'agenda ritorna gli orari disponibili tra i sei possibili (13,14,15,16,17,18).
	//         throws NullPointerException se l'agenda è nulla, IllegalArgumentException se non ha esattamente 6 slot 

		if(agenda == null)
			throw new NullPointerException("Agenda non inizializzata");

		if(agenda.length !=6)
			throw new IllegalArgumentException("L'agenda non ha 6 slot");

		int count = 0;

		for (int i = 0; i<agenda.length; i++)
			if (agenda[i] == null)
				count++;

		int[] orari = new int[count];

		for(int i = 0, j = 0; i<agenda.length; i++)
			if(agenda[i] == null)
				orari[j++] = i+13;

		return orari;
	}
}