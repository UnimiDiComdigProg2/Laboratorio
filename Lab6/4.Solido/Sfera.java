public class Sfera extends Solido {
//OVERVIEW: modella una Sfera, sottotipo di Solido
	double r;

	public Sfera(double r) {
	//MODIFIES: this
	//EFFECTS: inizializza this con raggio r
		this.r = r;
	}

	@Override
	public String tipo() {
		return "Sfera";
	}

	@Override
	public double volume() {
		return (4 * Math.PI * this.r * this.r * this.r) / 3;
	}
}