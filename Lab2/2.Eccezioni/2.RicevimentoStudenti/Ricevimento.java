//Grazie a Jacopo per la base della soluzione che ho modificato qua

import java.util.Scanner;
import java.util.Arrays;

public class Ricevimento {

	public static void main(String[] args) {
		String[] agenda = new String[6];

		Scanner s = new Scanner(System.in);

		while(orariDisponibili(agenda).length > 0) {
			int[] o = orariDisponibili(agenda);

			System.out.println("Puoi prenotare un appuntamento alle " + Arrays.toString(o).substring(1,Arrays.toString(o).length()-1)); //approccio smart ma hacky, meglio fare un metodo pulito che faccia questa stringa.

			System.out.println("Qual è il tuo nome?");
			String nome = s.next();
			System.out.println("A che ora vorresti l'appuntamento?");
			int orario = s.nextInt();

			try{
				prenota(agenda, orario, nome);
			} catch(NullPointerException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			} catch(ArrayStoreException f) {
				System.out.println(f.getMessage());
			} catch(IllegalArgumentException g){ //Questa eccezione può avvenire se l'orario non è valido (in tal caso non porta a termine del programma) o se l'agenda non ha gli slot corretti (in tal caso bisogna terminare)
				System.out.println(g.getMessage());
				
				if(g.getMessage() == "L'agenda non ha 6 slot")
					System.exit(0);
			}

		}

		s.close();

		try{
			stampaAgenda(agenda);
		} catch(NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	public static void prenota(String[] agenda, int ora, String nome) throws NullPointerException, ArrayStoreException, IllegalArgumentException {
	// MODIFIES: agenda 
	// EFFECTS: data l'ora e il nome prenota assegnerà lo slot in agenda corrispondente
	//          throws NullPointerException se agenda è null; ArrayStoreException se lo slot è già prenotato o `nome` ha già prenotato un orario diverso; IllegalArgumentException se 'orario' non valido o 'nome' vuoto

		if (agenda == null) {
			throw new NullPointerException("Agenda non inizializzata");
		} else if (agenda.length !=6) {
			throw new IllegalArgumentException("L'agenda non ha 6 slot");
		} else if (nome == "") {
			throw new IllegalArgumentException("nome non valido");
		} else if (ora < 13 | ora >18 ) {
			throw new IllegalArgumentException("orario non valido");
		} else if (agenda[ora-13] != null) {
			throw new ArrayStoreException("Lo Slot è già stato prenotato");
		} else if(nomeEsiste(agenda, nome)) { // Alternative sono usare gli stream o Arrays.asList(agenda).contains(nome)
			throw new ArrayStoreException(nome + ", hai già prenotato!");
		}

		agenda[ora-13] = nome;
	}

	public static boolean nomeEsiste(String[] agenda, String nome) {
	// REQUIRES: agenda not null e con length 6
	// EFFECTS: restituisce true se nome presente in agenda, false altrimenti

		for(String entry : agenda)
			if(entry != null && entry.equals(nome))
				return true;

		return false;
	}

	public static void stampaAgenda(String[] agenda) throws NullPointerException, IllegalArgumentException {
	// EFFECTS: Data l'agenda stampa su Standard Output la disposizione degli orari
	// RAISES : NullPointerException se l'agenda è nulla o IllegalArgumentException se non ha esattamente 6 slot

		if (agenda == null) {
			throw new NullPointerException("Agenda non inizializzata");
		} else if(agenda.length !=6) {
			throw new IllegalArgumentException("L'agenda non ha 6 slot");
		}

		for (int i=0; i<agenda.length; i++) {
			System.out.println("Alle " + (i+13) + " è fissato l'appuntamento di " + agenda[i]);
		}
	}

	public static int[] orariDisponibili(String[] agenda)	throws NullPointerException, IllegalArgumentException {
	// EFFECTS : Data un'agenda ritorna gli orari disponibili tra i sei possibili (13,14,15,16,17,18).
	// RAISES  : NullPointerException se l'agenda è nulla o IllegalArgumentException se non ha esattamente 6 slot 

		if(agenda == null) {
			throw new NullPointerException("Agenda non inizializzata");
		} else if(agenda.length !=6) {
			throw new IllegalArgumentException("L'agenda non ha 6 slot");
		}

		int count = 0;

		for (int i = 0; i<agenda.length; i++)
			if (agenda[i] == null)
				count++;

		int[] orari = new int[count];

		int j = 0;
		for (int i = 0; i<agenda.length; i++) {
			if (agenda[i] == null) {
				orari[j] = i+13;
				j++;
			}
		}

		return orari;
	}
}
