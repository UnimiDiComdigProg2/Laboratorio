public class Cilindro extends Contenitore {
//OVERVIEW: modella un Contenitore Cilindro;

//attributes
	private final double r, h;

//methods
	public Cilindro(String liq, double qty, double r, double h) throws CapacityException {
	//MODIFIES: this
	//EFFECTS:  se r o h <= 0 lancia IllegalArgumentException
		super(liq, qty, h * Math.PI * r*r);

		if(r <= 0 || h <= 0 )
			throw new IllegalArgumentException("r o h <= 0");

		this.r = r;
		this.h = h;
	}

	@Override
	public String toString() {
		return "Cilindro - h: " +  h + " r: " + r + "\n\t\t(" + super.toString() + ")";
	}
}