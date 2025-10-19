import java.util.Scanner;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		String[] agenda = new String[6];

		Scanner s = new Scanner(System.in);

		while(Ricevimento.orariDisponibili(agenda).length > 0) {
			int[] o = Ricevimento.orariDisponibili(agenda);

			System.out.println("Puoi prenotare un appuntamento alle " + Arrays.toString(o));

			System.out.println("Qual è il tuo nome?");
			String nome = s.next();
			System.out.println("A che ora vorresti l'appuntamento?");
			int orario = s.nextInt();

			try{
				Ricevimento.prenota(agenda, orario, nome);
			} catch(NullPointerException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			} catch(TimeBusyException | AlreadyBookedException | ParameterException e) { //ParameterException è una IllegalArgumentException per gestire il caso sotto
				System.out.println(e.getMessage());
			} catch(IllegalArgumentException e){ //Questa eccezione può avvenire se l'orario o nome non è valido (in tal caso non porta a termine del programma) o se l'agenda non ha gli slot corretti (in tal caso bisogna terminare)
				System.out.println(e.getMessage());

				//if(e.getMessage() == "L'agenda non ha 6 slot") //questa però è una pessima pratica, meglio distinguere per tipo eccezione
					System.exit(0);
			}

		}

		s.close();

		for (int i=0; i<agenda.length; i++)
			System.out.println("Alle " + (i+13) + " è fissato l'appuntamento di " + agenda[i]);
	}
}