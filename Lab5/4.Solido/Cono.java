public class Cono extends Solido {
//OVERVIEW: modella un Cono, sottotipo di Solido
	public final double r, h; //se final non ho pericoli ad esporre (ma attenzione che si perde la modificabilità)

	public Cono(double r, double h) {
	//REQUIRES: r, h > 0 //oppure mettere i controlli
	//MODIFIES: this
	//EFFECTS: inizializza this con raggio e altezza
		this.r = r;
		this.h = h;
	}

	@Override
	public String tipo() { //questo metodo, seppur valido
		return "Cono";
	}

	@Override
	public double volume() {
		return (Math.PI * this.r * this.r * this.h) / 3;
	}

	@Override
	public String toString() {
		return super.toString() + " raggio: " + r + " altezza: " + h;
	}

	//clone non serve perchè rep primitiva e immutabile
	//equals è facile perchè non c'è rep nel supertipo (che non è istanziabile) quindi si compara solo al livello del sottotipo
}