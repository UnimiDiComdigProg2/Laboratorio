import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Famiglia {
//OVERVIEW: modella una Famiglia con numero di persone e reddito complessivo
	double reddito;
	int dimensione;

//constructors
	public Famiglia(double reddito, int dimensione) throws InputMismatchException {
	// MODIFIES: this
	// EFFECTS: inizializza this con reddito e dimensione
	// 					Lancia una `InputMismatchException` se dimensione non è positiva;

		if(dimensione <= 0)
			throw new InputMismatchException("La dimensione della Famiglia non può essere minore di 1");

		this.dimensione = dimensione;
		this.reddito = reddito;
	}

	public boolean sottoSogliaPoverta(double costoCasa, double costoCibo) throws InputMismatchException {
	// EFFECTS: restituisce `true` se la somma tra `costoCasa` e `costoCibo` (moltiplicato per la `dimensione` della famiglia) è maggiore della metà del `reddito` della famiglia (costoCibo è il costo medio mensile del cibo per ogni individuo, mentre costoCasa è unico mensile per la famiglia);
	//					Lancia una `InputMismatchException` se costoCasa o costoCibo non sono positivi;

		if(costoCasa <= 0 || costoCibo <= 0)
			throw new InputMismatchException("La dimensione della Famiglia non può essere minore di 1");

		if(costoCasa + this.dimensione * costoCibo > reddito/2)
			return true;
			
		return false;
	}

	public String toString() {
		return this.dimensione + " persone con reddito complessivo di: " + this.reddito;
	}

	public static void main(String[] args) {
		double costoCasa = Integer.parseInt(args[0]);
		double costoCibo = Integer.parseInt(args[1]);

		List<Famiglia> famiglieSottoSoglia = new ArrayList<Famiglia>();

		Scanner s = new Scanner(System.in);

		System.out.println("Inserisci il reddito e la dimensione di una famiglia (Ctrl+D per terminare la lettura)");
		while(s.hasNext()) {
			double tmpRed = s.nextDouble();
			int tmpDim = s.nextInt();

			Famiglia tmpFam = new Famiglia(tmpRed,tmpDim);

			if(tmpFam.sottoSogliaPoverta(costoCasa,costoCibo)) {
				famiglieSottoSoglia.add(tmpFam);
			}

			System.out.println("Inserisci il reddito e la dimensione di una famiglia (Ctrl+D per terminare la lettura)");
		}

		System.out.println();
		System.out.println(famiglieSottoSoglia.size() + " famiglie sotto la soglia di povertà:");

		for(int i = 0; i < famiglieSottoSoglia.size(); i++) {
			System.out.println("Famiglia " + (i+1) + ": " + famiglieSottoSoglia.get(i));
		}
	}
}