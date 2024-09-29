public class Arciere extends Guerriero {
//OVERVIEW: Arciere

//constructors
	public Arciere(String nome, int x, int y, int pv, int att) {
		super(nome, x, y, pv, att);
	}

//methods
	protected boolean distOK(Guerriero g) {
		return Math.abs(this.getX()-g.getX())+Math.abs(this.getY()-g.getY()) <= 2;
	}

	@Override
	public String toString() {
		return this.nome+" Arciere "+super.toString();
	}
}