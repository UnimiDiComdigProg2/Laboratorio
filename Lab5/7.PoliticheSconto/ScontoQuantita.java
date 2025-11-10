public class ScontoQuantita extends PoliticaSconto {
//OVERVIEW: sconto di percentuale s in base alla quantità minima m

//attributes
	public final int m;
	public final double s;

//constructors
	public ScontoQuantita(int n, double p, int m, double s) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: initializes this
	//         if m < 0 or s <= 0 throws IllegalArgumentException
		super(n, p);

		if(m < 0)
			throw new IllegalArgumentException("m < 0");

		if(s <= 0)
			throw new IllegalArgumentException("s <= 0");

		this.s = s;
		this.m = m;
	}

//methods
	@Override
	public double calcolaSconto() {
	//EFFECTS: o = n*p*s if m>n, 0 otherwise
		if(n>m)
			return n*p*s;

		return 0;
	}

	@Override
	public String toString() {
		return "ScontoQuantita (min:"+m+",percent:"+s+") " + super.toString() + "=" + calcolaSconto();
	}
}