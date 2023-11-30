public class Cuboide extends Contenitore {
//OVERVIEW: modella un contenitore di forma cuboide;

//attributes
	private final double a, b, c;

//methods
	public Cuboide(double volume, String tipo, double a, double b, double c) throws ExceededCapacityException, IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS:  se r o h <= 0 lancia IllegalArgumentException
		super(volume, tipo, a*b*c);

		if(a <= 0 || b <= 0 || c <= 0 )
			throw new IllegalArgumentException("a, b o c <= 0");

		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public String toString() {
		return "Cuboide - a: " +  a + " b: " + b + " c: " + c + "\n\t\t(" + super.toString() + ")";
	}
}