public class Sfera extends Contenitore {
//OVERVIEW: modella un Contenitore Sfera;

//attributes
	private final double r;

//methods
	public Sfera(String liq, double qty, double r) throws CapacityException {
	//MODIFIES: this
	//EFFECTS:  se r <= 0 lancia IllegalArgumentException
		super(liq, qty, Math.PI * r*r*r * 4/3);

		if(r <= 0)
			throw new IllegalArgumentException("r <= 0");

		this.r = r;
	}

	@Override
	public String toString() {
		return "Sfera - r: " + r + "\n\t\t(" + super.toString() + ")";
	}
}