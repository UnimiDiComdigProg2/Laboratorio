public class Cilindro extends Contenitore {
//OVERVIEW: modella un contenitore cilindrico;

//attributes
	private final double r, h;

//methods
	public Cilindro(double volume, String tipo, double r, double h) throws ExceededCapacityException, IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS:  se r o h <= 0 lancia IllegalArgumentException
		super(volume, tipo, h * Math.PI * r*r);

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