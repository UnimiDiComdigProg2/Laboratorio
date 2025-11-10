public class UnoOgniNGratis extends PoliticaSconto {
//OVERVIEW: ogni e-simo prodotto gratis

	public final int e;

	public UnoOgniNGratis(int n, double p, int e) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: initializes this
	//         if e <= 0 throws IllegalArgumentException
		super(n, p);

		if(e <= 0)
			throw new IllegalArgumentException("e<=0");

		this.e = e;
	}

	@Override
	public double calcolaSconto() {
	//EFFECTS: o = p*floor(n/e)
		return p*Math.floor(n/e);
	}

	@Override
	public String toString() {
		return "UnoOgniNGratis (every:"+e+") " + super.toString() + "=" + calcolaSconto();
	}
}