public class Sfera extends Contenitore {
//OVERVIEW: modella un Contenitore Sfera

//attributi
	private final double raggio;

//costruttori
	public Sfera(String liquido, double contenuto, double raggio) throws IllegalArgumentException, ExceededCapacityException {
	//MODIFIES: this
	//EFFECTS: inizializza this con raggio, tipo di liquido e volume del liquido contenuto.
		super(contenuto, liquido, Math.PI * raggio * raggio * raggio * 4/3);
		
		if(raggio <= 0)
			throw new IllegalArgumentException("raggio <= 0");
		
		this.raggio = raggio;
	}

//metodi
	@Override
	public String toString() {
		return "Sfera - raggio: " + raggio + "\n\t\t(" + super.toString() + ")";
	}
}
