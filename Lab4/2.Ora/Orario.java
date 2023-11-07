import java.util.InputMismatchException;
import java.util.Scanner;

public class Orario {
	private int ora;
	private int min; 

//costruttori
	public Orario() {
	//MODIFIES: this
	//EFFECTS: costruttore di default che inizializza un nuovo Orario con l'ora e i minuti a 0
		this.ora = 0;
		this.min = 0;

		assert repOk();
	}

	public Orario(int ora, int min) throws InputMismatchException {
	//MODIFIES: this
	//EFFECTS: inizializza un nuovo Orario con ora (tra 0 e 23) e minuti dati in input 
	//         throws InputMismatchException se l'ora o i minuti non sono nel formato corretto
		if(ora < 0 || ora > 23)
			throw new InputMismatchException("L'ora deve essere nel range 0-23");

		if(min < 0 || min > 59)
			throw new InputMismatchException("I minuti devono essere nel range 0-59");

		this.ora = ora;
		this.min = min;

		assert repOk();
	}

	public Orario(int ora, int min, boolean PM) throws InputMismatchException {
	//MODIEFIES: this
	//EFFECTS: inizializza un nuovo Orario con l'ora (nel range 1-12), i minuti, e un valore booleano che specifica se l'orario è di mattina (false) o pomeriggio (true)
	//         throws InputMismatchException se l'ora o i minuti non sono nel formato corretto
		if(ora < 1 || ora > 12)
			throw new InputMismatchException("L'ora deve essere nel range 1-12");

		if(min < 0 || min > 59)
			throw new InputMismatchException("I minuti devono essere nel range 0-59");

		this.ora = ora; //lo stato della classe può anche essere inconsistente prima della fine del metodo

		if(PM)
			if(ora < 12)
				this.ora += 12;
		else
			if(ora == 12)
				this.ora = 0;

		this.min = min;

		assert repOk();
	}

	//methods
	private void setOra(int o) {
		this.ora = o;

		assert repOk();
	}

	private void setMin(int m) {
		this.min = m;

		assert repOk();
	}

	public int getOra() {
	//EFFECTS: restituisce l'ora nel formato 0-23
		return this.ora;
	}

	public int getMinuti() {
		return this.min;
	}

	public String getOra24() {
	//EFFECTS: restituisce una stringa che rappresenta l’orario nel formato a 24 ore (hh:mm)
		return this.ora + ":" + this.min;
	}

	public String getOra12() {
	//EFFECTS: restituisce le ore in una notazione a 12 ore (h:mm xx) dove xx è AM o PM
		if(this.ora == 0)
			return "12:" + this.min + " AM";
		else if(this.ora == 12)
			return "12:" + this.min + " PM";
		else if(this.ora > 12)
			return this.ora - 12 + ":" + this.min + " PM";

		return this.ora + ":" + this.min + " AM";
	}

	public void avanza(int ora, int min) throws InputMismatchException {
	//EFFECTS: fa avanzare l'orario di ore e minuti specificati, gestendo opportunamente il cambio d'ora
		if(ora < 0 || min < 0)
			throw new InputMismatchException("Input inserito non corretto! ore o minuti negativi");

		int mintot = (this.ora+ora) * 60 + (this.min+min);

		this.min = mintot%60;
		this.ora = (mintot/60)%24;

		assert repOk();
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;

		if(obj == null)
			return false;

		if(!(obj.getClass().equals(this.getClass())))
			return false;

		Orario tmp = (Orario)obj;

		if(tmp.ora != this.ora)
			return false;

		if(tmp.min != tmp.min)
			return false;

		return true;
	}
	
	public boolean repOk() {
		if(this.ora < 0 || this.ora > 23)
			return false;

		if(this.min < 0 || this.min > 59)
			return false;

		return true;
	}

	public static void main(String[] args) {
		Orario orario = new Orario();

		if(args.length > 0) {
			String[] elements = args[0].split(":");

			try {
				if(args.length == 1)
					orario = new Orario(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
				else if(args.length == 2)
					if(args[1].equals("AM"))
						orario = new Orario(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), false);
					else if(args[1].equals("PM"))
						orario = new Orario(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), true);
					else
						throw new InputMismatchException("Formato ora errato (flag AM/PM errato)");
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}

		System.out.println("Orario: " + orario.getOra24());
		System.out.println("Orario: " + orario.getOra12());

		Scanner scan = new Scanner(System.in);
		String[] avanza = scan.nextLine().split(" ");
		scan.close();

		orario.avanza(Integer.parseInt(avanza[1]), Integer.parseInt(avanza[2]));
		
		System.out.println(orario.getOra24());
		System.out.println(orario.getOra12());
	}
}