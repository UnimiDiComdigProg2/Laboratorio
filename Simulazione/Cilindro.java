public class Cilindro extends Contenitore {
//OVERVIEW: modella un Contenitore Cilindro

//attributi
	private final double altezza;
	private final double raggio;

//costruttori
	public Cilindro(String liquido, double contenuto, double altezza, double raggio) throws IllegalArgumentException, ExceededCapacityException {
	//MODIFIES: this
	//EFFECTS: inizializza this con altezza, raggio, tipo di liquido e volume del liquido contenuto.
		super(contenuto, liquido, altezza * Math.PI * raggio * raggio);
		
		if(altezza <= 0)
			throw new IllegalArgumentException("altezza <= 0");
		
		if(raggio <= 0)
			throw new IllegalArgumentException("raggio <= 0");
		
		this.altezza = altezza;
		this.raggio = raggio;
	}

//metodi
	@Override
	public String toString() {
		return "Cilindro - altezza: " + altezza + ", raggio: " + raggio + "\n\t\t(" + super.toString() + ")";
	}
}