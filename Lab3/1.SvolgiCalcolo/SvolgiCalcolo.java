import java.util.Scanner;

public class SvolgiCalcolo {

	public static void printHead() { //metodo per non dover ripetere la scrittura in più punti.
	//MODIFIES: System.out
	//EFFECTS: stampa l'intestazione delle operazioni
		System.out.println("Inserisci <operatore> <operando>. es: + 3");
		System.out.println("Per terminare inserire il carattere '='");
	}

	public static void main(String[] args) {
		CalcolatriceConMemoria calc;

		/* potrei utilizzare ArrayIndexOutOfBoundsException per controllare args[0]. Tuttavia non è un comportamento inatteso, e le eccezioni pesano. Meglio un semplice if
		try {
			calc = new CalcolatriceConMemoria(Integer.parseInt(args[0]));
		} catch (ArrayIndexOutOfBoundsException e) {
			calc = new CalcolatriceConMemoria();
		}
		*/

		if(args.length > 0)
			calc = new CalcolatriceConMemoria(Integer.parseInt(args[0]));
		else
			calc = new CalcolatriceConMemoria();

		System.out.println("Calcolatrice inizializzata, valore: " + calc.getMem());
		printHead();

		Scanner scan = new Scanner(System.in); //nuovo oggetto di tipo scanner

		while(scan.hasNext()) {
			char op = scan.next().charAt(0);

			if(op == '=') //controllo subito se c'è = e termino. Devo farlo prima di leggere o2
				break;

			double o2 = scan.nextDouble();

			try {
				calc.operate(op, o2);
			} catch (DivideByZeroException e) {
				System.out.println(e.getMessage());
				printHead();
			}

			System.out.println("valore in memoria: " + calc.getMem());
		}

		System.out.println("Il risultato finale e' " + calc.getMem());
	}
}