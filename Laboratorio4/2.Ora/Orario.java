import java.util.InputMismatchException;
import java.util.Scanner;

public class Orario {
	private int ora;
	private int min; 
	private boolean pm = false;

	//costruttori
	public Orario() {
	//MODIFIES: this
	//EFFECTS: costruttore di default che inizializza un nuovo Orario con l'ora e i minuti a 0
		this.setOra(0);
		this.setMin(0);
	}

	public Orario(int ore, int minuti) throws InputMismatchException {
	//MODIFIES: this
	//EFFECTS: inizializza un nuovo Orario con ora (tra 0 e 23) e minuti dati in input 
	//		 throws InputMismatchException se l'ora o i minuti non sono nel formato corretto
		if (ore < 0 || ore > 23) {
			throw new InputMismatchException("L'ora deve essere nel range 0-23");
		}
		if (minuti < 0 || minuti > 59) {
			throw new InputMismatchException("I minuti devono essere nel range 0-59");
		}

		this.setOra(ore);
		this.setMin(minuti);
	}

	public Orario(int ore, int minuti, boolean PM) throws InputMismatchException {
	//MODIEFIES: this
	//EFFECTS: inizializza un nuovo Orario con l'ora (nel range 1-12), i minuti, e un valore booleano che specifica se l'orario è di mattina (false) o pomeriggio (true)
	//         throws InputMismatchException se l'ora o i minuti non sono nel formato corretto
		if (ore < 1 || ore > 12) {
			throw new InputMismatchException("L'ora deve essere nel range 1-12");
		}
		if (minuti < 0 || minuti > 59) {
			throw new InputMismatchException("I minuti devono essere nel range 0-59");
		}

		this.setMin(minuti);
		this.setOra(ore);
		if (PM == true) {
			this.pm = true;
		}
	}

	//methods
	private void setOra(int o) {
		this.ora = o;
	}

	private void setMin(int m) {
		this.min = m;
	}

	public int getOra() {
	//EFFECTS: restituisce l'ora nel formato 0-23
		if (this.pm == true) {
			return this.ora + 12;
		}
		return this.ora;
	}

	public int getMinuti() {
	//EFFECTS: restituisce i minutiù
		return this.min;
	}

	public String getOra24() {
	//EFFECTS: restituisce una stringa che rappresenta l’orario nel formato a 24 ore (hh:mm)
		if (this.pm == true) {
			return this.ora + 12 + ":" + this.min;
		}
		return this.ora + ":" + this.min;
	}

	public String getOra12() {
	//EFFECTS: restituisce le ore in una notazione a 12 ore (h:mm xx) dove xx è AM o PM
		if (this.pm == false) {
			if (this.ora > 12) {
				return this.ora - 12 + ":" + this.min + " PM";
			} else {
				return this.ora + ":" + this.min + " AM";
			}
		} else {
			return this.ora + ":" + this.min + " AM";
		}
	}

	public Orario avanza(int ore, int minuti) throws InputMismatchException {
	// EFFECTS: fa avanzare l'orario di ore e minuti specificati, gestendo opportunamente il cambio d'ora
	//		  throws InputMismatchException se minuti > 59 oppure minuti o ore < zero
		if (ore < 0 || minuti < 0 || minuti > 59) {  // forse meglio fare i tre casi divisi con tre messaggi diversi
			throw new InputMismatchException("Input inserito non corretto! 0 <= ore e 0 <= minuti <= 59");
		}
	
		// problema: ritorna sempre e sono orario in formato 24h, non mantiene il formato 12h se this è in 12h

		Orario tmp = new Orario();

		// gestiamo minuti
		tmp.setMin((this.min + minuti)%60);

		// gestiamo ora 
		if ((this.min + minuti) > 59) {
			tmp.ora++;
		} 

		tmp.ora += (this.ora + ore)%24;
	
		return tmp;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Orario)) {
			return false;
		} else {
			Orario tmp = (Orario)obj;
			if (tmp.ora == this.ora && tmp.min == tmp.min && tmp.pm == this.pm) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Orario orario = new Orario();
/*
		} if (args.length < 2){
			String[] elements = args[0].split(":");
			try {
				orario = new Orario(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}	
		} else if (args.length == 2) {
			String[] elements = args[0].split(":");
			try {
				orario = new Orario(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), Boolean.parseBoolean(args[1]));
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}	
		}
*/
		switch (args.length) {
			case 1:
				String[] elements = args[0].split(":");
				try {
					orario = new Orario(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
					System.exit(0);
				} 
				break;
			case 2:
				String[] elements2 = args[0].split(":");
				try {
					orario = new Orario(Integer.parseInt(elements2[0]), Integer.parseInt(elements2[1]), Boolean.parseBoolean(args[1]));
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
					System.exit(0);
				} 
				break;
		}

		//Orario orario = new Orario(23, 13); per testare le altre funzioni
		
		System.out.println("Orario: " + orario.getOra24());
		System.out.println("Orario: " + orario.getOra12());

		Scanner scan = new Scanner(System.in);
		System.out.print("+ ");
		int setOre = scan.nextInt();
		int setMin = scan.nextInt();
		scan.close();

		Orario tmp = orario.avanza(setOre, setMin);
		
		System.out.println(tmp.getOra24());
		System.out.println(tmp.getOra12());

	}
}
 
