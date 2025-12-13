public class Sfera extends Contenitore {
//OVERVIEW: modella un Contenitore Sfera;

//attributes
	private final double r;

//methods
	public Sfera(String liq, double qty, double r) throws CapacityException {
	//MODIFIES: this
	//EFFECTS:  se r <= 0 lancia IllegalArgumentException
	//          se volume() <= 0 lancia IllegalArgumentException
	//          se qty > volume() lancia CapacityException
		super(liq, qty);

		if(r <= 0)
			throw new IllegalArgumentException("r <= 0");

		this.r = r;

		if(volume() <= 0)
			throw new IllegalArgumentException("max <= 0");

		if(qty > volume())
			throw new CapacityException("qty > max");
	}

	@Override
	public double volume() {
		return Math.PI * r*r*r * 4/3;
	}

	@Override
	public String toString() {
		return "Sfera - r: " + r + "\n\t\t(" + super.toString() + ")";
	}
}