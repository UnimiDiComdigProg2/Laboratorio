public abstract class Contenitore implements Comparable<Contenitore>, Cloneable {
//OVERVIEW: Contenitore astratto, caratterizzato da liquido che contiene (tipo e quantità)
	private String liq;
	private double qty;

	public Contenitore(String liq, double qty) throws IllegalArgumentException, CapacityException {
	//MODIFIES: this
	//EFFECTS: inizializza this
	//         se qty < 0 lancia IllegalArgumentException
	//         se liq == null e qty > 0 lancia IllegalArgumentException
	//         se liq != null e qty == 0 lancia IllegalArgumentException
		if(qty < 0)
			throw new IllegalArgumentException("qty < 0");

		if(liq == null && qty > 0)
			throw new IllegalArgumentException("liq == null && qty > 0");

		if(liq != null && qty == 0)
			throw new IllegalArgumentException("liq != null && qty == 0");

		this.qty = qty;
		this.liq = liq;

		assert repOk();
	}

	abstract public double volume();
	//EFFECTS: restituisce il volume di this

	public void versa(Contenitore c) throws LiquidsException, IllegalArgumentException {
	//MODIFIES: this, c
	//EFFECTS: se c.liq == this.liq, oppure c.liq == null travasare this.qty in c.qty, fino alla capienza di c (c.volume())
	//         altrimenti lancia LiquidsException
	//         se c == null lancia IllegalArgumentException
		if(c == null)
			throw new IllegalArgumentException("c null");

		if(c.liq != null && !(c.liq.equals(this.liq)))
			throw new LiquidsException("liquidi incompatibili " + this.liq + " e " + c.liq);

		c.liq = this.liq;

		if(c.volume() >= this.qty + c.qty) {
			c.qty += this.qty;
			this.qty = 0;
			this.liq = null;
		} else {
			this.qty -= c.volume() - c.qty;
			c.qty = c.volume();
		}

		assert repOk();
		assert c.repOk();
	}

	@Override
	public int compareTo(Contenitore o) {
		return Double.compare(o.volume(), this.volume());
	}

	public String getLiq() {
		return liq;
	}

	@Override
	public String toString() {
		String ret = "capienza: " + volume();

		if(liq != null)
			ret += " liquido: " + liq + " qty: " + qty;

		return ret;
	}

	public boolean repOk() {
		if(qty < 0)
			return false;

		if(volume() <= 0)
			return false;

		if(qty > volume())
			return false;

		if(liq == null && qty > 0)
			return false;

		if(liq != null && qty == 0)
			return false;

		return true;
	}

	@Override
	public Contenitore clone() {
		try {
			return (Contenitore) super.clone();
		} catch(CloneNotSupportedException e) {
			return null;
		}
	}

	public static void main(String[] args) {
		Sfera sf = new Sfera("acqua", 25, 2);
		Cuboide cu = new Cuboide(null,0,2,3,4);
		Cilindro ci = new Cilindro("alcool",20,2,3);

		try {
			sf.versa(ci);
		} catch (LiquidsException e) {
			System.out.println(e.getMessage());
		}

		try {
			sf.versa(cu);
		} catch (LiquidsException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(sf);
		System.out.println(cu);
		System.out.println(ci);
	}

}