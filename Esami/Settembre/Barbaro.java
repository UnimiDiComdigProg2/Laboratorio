public class Barbaro extends Guerriero {
//OVERVIEW: Barbaro

//constructors
	public Barbaro(String nome, int x, int y, int pv, int att) {
		super(nome, x, y, pv, att);
	}

//methods
	@Override
	public void attacca(Guerriero g) throws MapException, CharException {
	//MODIFIES: this
	//EFFECTS: attacca e fa 1 danno aggiuntivo a this e 2 a g
		super.attacca(g);
		this.pv-=1;
		g.pv = Math.max(g.pv-2, 0);

		assert repOk();
		assert g.repOk();
	}

	@Override
	public String toString() {
		return this.nome+" Barbaro "+super.toString();
	}
}