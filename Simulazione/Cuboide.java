public class Cuboide extends Contenitore {
//OVERVIEW: modella un Contenitore Cuboide;

//attributes
	private final double a, b, c;

//methods
	public Cuboide(String liq, double qty, double a, double b, double c) throws CapacityException {
	//MODIFIES: this
	//EFFECTS:  se r o h <= 0 lancia IllegalArgumentException
	//          se volume() <= 0 lancia IllegalArgumentException
	//          se qty > volume() lancia CapacityException
		super(liq, qty);

		if(a <= 0 || b <= 0 || c <= 0 )
			throw new IllegalArgumentException("a, b o c <= 0");

		this.a = a;
		this.b = b;
		this.c = c;

		if(volume() <= 0)
			throw new IllegalArgumentException("max <= 0");

		if(qty > volume())
			throw new CapacityException("qty > max");
	}

	@Override
	public double volume() {
		return a*b*c;
	}

	@Override
	public String toString() {
		return "Cuboide - a: " +  a + " b: " + b + " c: " + c + "\n\t\t(" + super.toString() + ")";
	}
}