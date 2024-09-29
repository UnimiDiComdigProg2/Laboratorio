public class Guerriero implements Comparable<Guerriero> {
//OVERVIEW: Guerriero di gioco di strategia

//attributes
	private int x, y;
	protected int pv;
	final String nome;
	final int att;

//constructors
	public Guerriero(String nome, int x, int y, int pv, int att) {
	//MODIFIES: this
	//EFFECTS: inizializza this, se x, y < 0 lancia IllegalArgumentException
		if(nome == null || nome.equals(""))
			throw new IllegalArgumentException("nome null o vuoto");

		if(x < 0 || y < 0)
			throw new IllegalArgumentException("x o y < 0");

		if(pv < 1 || att < 1)
			throw new IllegalArgumentException("pv o att < 1");

		this.nome = nome;
		this.x = x;
		this.y = y;
		this.pv = pv;
		this.att = att;

		assert repOk();
	}

//methods
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void muovi(int x, int y) {
		if(x < 0 || y < 0)
			throw new IllegalArgumentException("x o y < 0");

		this.x = x;
		this.y = y;
	} 

	protected boolean distOK(Guerriero g) {
	//EFFECTS: restituisce true se distanza di manhattan da g == 1
		return Math.abs(this.x-g.x)+Math.abs(this.y-g.y) == 1;
	}

	public void attacca(Guerriero g) throws MapException, CharException {
	//MODIFIES: g
	//EFFECTS: diminuisce g.pv di this.attacco. Se g null lancia IllegalArgumentException. Se distanza tra g e this > 1 lancia FarException. Se g.pv o this.pv < 1 lancia DeadException. 
		if(g == null)
			throw new IllegalArgumentException("p null");

		if(!distOK(g))
			throw new MapException("Troppo distante");

		if(this.pv < 1)
			throw new CharException(this.nome + " incapacitato");

		if(g.pv < 1)
			throw new CharException(g.nome + " incapacitato");

		g.pv = Math.max(g.pv-this.att, 0);

		assert repOk();
		assert g.repOk();
	}

	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Guerriero) || !(this.nome.equals(((Guerriero)o).nome)))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return this.x+" "+this.y+" "+this.pv+" "+this.att;
	}

	@Override
	public int compareTo(Guerriero g) {
		return g.pv-this.pv;
	}

	public boolean repOk() {
		if(x < 0 || y < 0 || pv < 0)
			return false;

		return true;
	}
}