public class Razionale {
//OVERVIEW: Classe che rappresenta un numero razionale. Deve avere delle variabili intere
	private int numeratore;
	private int denominatore;

//constructors
	public Razionale(int numeratore, int denominatore) {
	//MODIFIES: this
	//EFFECTS: se denominatore != 0, inizializza il numero razionale con numeratore e denominatore;
	//         throws ArithmeticException se denominatore == 0
		setNumeratore(numeratore);
		setDenominatore(denominatore);
	}

//methods
	public void setNumeratore(int numeratore) {
		this.numeratore = numeratore;
	}

	public void setDenominatore(int denominatore) {
	// MODIFIES: this
	// EFFECTS: imposta this col denominatore specificato;
	//          se == 0 lancia ArithmeticException
		if(denominatore == 0)
			throw new ArithmeticException("Denominatore del razionale e' zero");

		this.denominatore = denominatore;

		assert repOk();
	}

	public double valore() {
	//EFFECTS: restituisce il decimale corrispondente
		return (double) this.numeratore / this.denominatore;
	}

	public int getNumeratore() {
		return this.numeratore;
	}

	public int getDenominatore() {
		return this.denominatore;
	}
	
	private boolean repOk() {
		if(this.denominatore == 0)
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "Razionale: " + numeratore + "/" + denominatore;
	}

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		int den = Integer.parseInt(args[1]);
		Razionale r = new Razionale(num, den);
		System.out.println(r + " o " + r.valore());
	}
}