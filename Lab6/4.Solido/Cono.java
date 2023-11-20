public class Cono extends Solido {
//OVERVIEW: modella un Cono, sottotipo di Solido
	double r, h;

	public Cono(double r, double h) {
	//MODIFIES: this
	//EFFECTS: inizializza this con raggio e altezza
		this.r = r;
		this.h = h;
	}

	@Override
	public String tipo() {
		return "Cono";
	}

	@Override
	public double volume() {
		return (Math.PI * this.r * this.r * this.h) / 3;
	}
}