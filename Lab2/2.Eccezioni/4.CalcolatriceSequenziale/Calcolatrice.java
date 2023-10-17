import java.util.Scanner;

/**
 * Semplice calcolatrice testuale. La classe può anche
 * Essere utilizzata per creare altri programmi simili.
 */
public class Calcolatrice {
	private double risultato;
	private double precisione = 0.0001;
	// Numeri cosi' prossimi a zero sono considerati pari a zero.

	public Calcolatrice() {
		risultato = 0;
	}

	public void gestisciDivisionePerZeroException(DivisionePerZeroException e) {
		System.out.println(e.getMessage());
		System.out.println("Che errore");
		System.out.println("Programma terminato.");
		System.exit(0);
	}

	public void gestisciOpSconosciutaException(OpSconosciutaException e) {
		System.out.println(e.getMessage());
		System.out.println("Riprova dall'inizio:");

		try {
			System.out.print("Formato di ogni linea: ");
			System.out.println("operatore spazio numero");
			System.out.println("Per esempio: + 3");
			System.out.println("Per terminare inserire la lettera 'f'.");
			eseguiCalcoli();
		} catch (OpSconosciutaException e2) {
			System.out.println(e2.getMessage());
			System.out.println("Riprova in un secondo momento.");
			System.out.println("Fine del programma.");
			System.exit(0);
		} catch (DivisionePerZeroException e3) {
			gestisciDivisionePerZeroException(e3);
		}
	}

	public void reset() {
		risultato = 0;
	}

	public void setRisultato(double nuovoRisultato) {
		risultato = nuovoRisultato;
	}

	public double getRisultato() {
		return risultato;
	}

	/**
	 * Restituisce n1 op n2, ammesso che op sia uno tra +, -, * e /.
	 * Ogni altro valore di op lancia una OpSconosciutaException.
	 */
	public double valuta(char op, double n1, double n2) throws DivisionePerZeroException, OpSconosciutaException {
		double risposta;

		switch (op) {

			case '+':
				risposta = n1 + n2;
				break;
			case '-':
				risposta = n1 - n2;
				break;
			case '*':
				risposta = n1 * n2;
				break;
			case '/':
				if ((-precisione < n2) && (n2 < precisione))
					throw new DivisionePerZeroException();
				risposta = n1 / n2;
				break;
			default:
				throw new OpSconosciutaException(op);
		}
		return risposta;
	}

	public void eseguiCalcoli() throws DivisionePerZeroException, OpSconosciutaException {
		Scanner tastiera = new Scanner(System.in);
		boolean fatto = false;
		risultato = 0;
		System.out.println("risultato = " + risultato);

		while (!fatto) {
			char prossimaOp = (tastiera.next()).charAt(0);
			if ((prossimaOp == 'f') || (prossimaOp == 'F'))
				fatto = true;
			else {
				double prossimoNumero = tastiera.nextDouble();
				risultato = valuta(prossimaOp, risultato, prossimoNumero);
				System.out.println("risultato " + prossimaOp + " " +
						prossimoNumero + " = " + risultato);
				System.out.println("risultato aggiornato = " + risultato);
			}
		}
	}

	public static void main(String[] args) {
		Calcolatrice calc = new Calcolatrice();

		try {
			System.out.println("Calcolatrice attivata.");
			System.out.print("Formato di ogni linea: ");
			System.out.println("operatore spazio numero");
			System.out.println("Per esempio: + 3");
			System.out.println("Per terminare inserire la lettera 'f'.");
			calc.eseguiCalcoli();
		} catch (OpSconosciutaException e) {
			calc.gestisciOpSconosciutaException(e);
		} catch (DivisionePerZeroException e) {
			calc.gestisciDivisionePerZeroException(e);
		}
		System.out.println("Il risultato finale e' " + calc.getRisultato());
		System.out.println("Fine del programma.");
	}
}