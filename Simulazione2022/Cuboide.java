public class Cuboide extends Contenitore {
//OVERVIEW: modella un Contenitore Cuboide

//attributi
	private final double a;
	private final double b;
	private final double c;

//costruttori
	public Cuboide(String liquido, double contenuto, double a, double b, double c) throws IllegalArgumentException, ExceededCapacityException {
	//MODIFIES: this
	//EFFECTS: inizializza this con a, b, c, tipo di liquido e volume del liquido contenuto.
		super(contenuto, liquido, a*b*c);
		
		if(a <= 0)
			throw new IllegalArgumentException("a <= 0");
			
		if(b <= 0)
			throw new IllegalArgumentException("b <= 0");
		
		if(c <= 0)
			throw new IllegalArgumentException("c <= 0");
		
		this.a = a;
		this.b = b;
		this.c = c;
	}

//metodi
	@Override
	public String toString() {
		return "Cuboide - lati: " + a + ", " + b + ", " + c + "\n\t\t(" + super.toString() + ")";
	}
}
