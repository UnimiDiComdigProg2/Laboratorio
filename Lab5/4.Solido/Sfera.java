public class Sfera extends Solido {
//OVERVIEW: modella una Sfera, sottotipo di Solido
	public final double r; //se final non ho pericoli ad esporre (ma attenzione che si perde la modificabilità)

	public Sfera(double r) {
	//REQUIRES: r > 0 //oppure mettere i controlli
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

	@Override
	public String toString() {
		return super.toString() + " raggio: " + r;
	}

	//clone non serve perchè rep primitiva e immutabile
	//equals è facile perchè non c'è rep nel supertipo (che non è istanziabile) quindi si compara solo al livello del sottotipo
}