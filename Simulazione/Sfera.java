public class Sfera extends Contenitore {
//OVERVIEW: modella un contenitore sferico;

//attributes
	private final double r;

//methods
	public Sfera(double volume, String tipo, double r) throws ExceededCapacityException, IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS:  se r <= 0 lancia IllegalArgumentException
		super(volume, tipo, Math.PI * r*r*r * 4/3);

		if(r <= 0)
			throw new IllegalArgumentException("r <= 0");

		this.r = r;
	}

	@Override
	public String toString() {
		return "Sfera - r: " + r + "\n\t\t(" + super.toString() + ")";
	}
}