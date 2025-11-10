public abstract class PoliticaSconto {
//OVERVIEW: PoliticaSconto su numeroArticoli e prezzoArticolo (IMMUTABILE)

//attributes
	public final int n;
	public final double p;

//constructors
	public PoliticaSconto(int n, double p) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: initializes this
	//         if n <= 0 or p <= 0 throw new IllegalArgumentException
		if(n <= 0)
			throw new IllegalArgumentException("n <= 0");

		if(p <= 0)
			throw new IllegalArgumentException("p <= 0");

		this.p = p;
		this.n = n;
	}

//methods
	public abstract double calcolaSconto();
	//EFFECT: calculates discount based on specific policy
	@Override
	public String toString() {
		return n + " " + p;
	}
}