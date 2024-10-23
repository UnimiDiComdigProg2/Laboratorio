import java.util.InputMismatchException;

public class CalcolatriceConMemoria {
//OVERVIEW: modella una calcolatrice con memoria alla quale è possibile applicare operazioni aritmetiche base.

	private double mem;

//constructors
	public CalcolatriceConMemoria() {
	//MODIFIES: this
	//EFFECTS: inizializza la calcolatrice impostando lo stato di memoria iniziale a 0

		this.mem = 0;
	}

	public CalcolatriceConMemoria(double mem) {
	// MODIFIES: this
	// EFFECTS: inizializza la calcolatrice impostando lo stato di memoria iniziale a `mem`

		this.mem = mem;
	}

//methods
	public double getMem() {
	//EFFECTS: restituisce il valore correntemente in memoria
		return this.mem;
	}

	public double add(double op2) {
	//MODIFIES: this
	//EFFECTS: svolge l'operazione somma tra il valore in memoria e `op2`, impostando il valore in memoria al risultato dell'operazione

		this.mem += op2;
		return this.mem;
	}

	public double sub(double op2) {
	//MODIFIES: this
	//EFFECTS: svolge l'operazione differenza tra il valore in memoria e `op2`, impostando il valore in memoria al risultato dell'operazione

		this.mem -= op2;
		return this.mem;
	}

	public double mul(double op2) {
	//MODIFIES: this
	//EFFECTS: svolge l'operazione prodotto tra il valore in memoria e `op2`, impostando il valore in memoria al risultato dell'operazione

		this.mem *= op2;
		return this.mem;
	}

	public double div(double op2) throws DivideByZeroException {
	//MODIFIES: this
	//EFFECTS: svolge l'operazione divisione tra il valore in memoria e `op2`, impostando il valore in memoria al risultato dell'operazione.
	//         Se `op2` è uguale a 0, il metodo lancia una `DivideByZeroException`

		if(op2 == 0)
			throw new DivideByZeroException("Non è possibile dividere per 0");

		this.mem /= op2;
		return this.mem;
	}

	public double operate(char operator, double op2) throws DivideByZeroException, InputMismatchException { //devo ancora includere la DivideByZeroException se non la gestisco qua
	// MODIFIES: this
	// EFFECTS: svolge l'operazione definita da `operator` tra il valore in memoria e `op2`, impostando il valore in memoria al risultato dell'operazione.
	//          Se `operator è diverso da `+, `-`, `*` o `/`, il metodo lancia una `InputMismatchException`
	//          Se `op2` è uguale a 0, il metodo lancia una `DivideByZeroException`

		switch(operator) {
			case '+':
				this.add(op2); //riuso i metodi creati
				return this.mem;
			case '-':
				this.sub(op2);
				return this.mem;
			case '*':
				this.mul(op2);
				return this.mem;
			case '/':
				this.div(op2); //questa operazione lancia una DivideByZeroException. Pertanto la devo o gestire, o rilanciare (modificando intestazione ed EFFECTS)
				return this.mem;
			default:
				throw new InputMismatchException("Operatore non riconosciuto");
		}
	}
}