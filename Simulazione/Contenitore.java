public abstract class Contenitore implements Comparable<Contenitore>, Cloneable {
//OVERVIEW: Contenitore astratto, caratterizzato da liquido che contiene (tipo e quantità) e volume massimo (dipende dal tipo di contenitore)
	private String liq;
	private double qty;
	final private double max;

	public Contenitore(String liq, double qty, double max) throws IllegalArgumentException, CapacityException {
	//MODIFIES: this
	//EFFECTS: inizializza this
	//         se qty < 0 lancia IllegalArgumentException
	//         se max <= 0 lancia IllegalArgumentException
	//         se qty > max lancia CapacityException
	//         se liq == null e qty > 0 lancia IllegalArgumentException
	//         se liq != null e qty == 0 lancia IllegalArgumentException
		if(qty < 0)
			throw new IllegalArgumentException("qty < 0");

		if(max <= 0)
			throw new IllegalArgumentException("max <= 0");

		if(qty > max)
			throw new CapacityException("qty > max");

		if(liq == null && qty > 0)
			throw new IllegalArgumentException("liq == null && qty > 0");

		if(liq != null && qty == 0)
			throw new IllegalArgumentException("liq != null && qty == 0");

		this.qty = qty;
		this.liq = liq;
		this.max = max;

		assert repOk();
	}

	public void versa(Contenitore c) throws LiquidsException, IllegalArgumentException {
	//MODIFIES: this, c
	//EFFECTS: se c.liq == this.liq, oppure c.liq == null travasare this.qty in c.qty, fino alla capienza di c (c.max)
	//         altrimenti lancia LiquidsException
	//         se c == null lancia IllegalArgumentException
		if(c == null)
			throw new IllegalArgumentException("c null");

		if(c.liq != null && !(c.liq.equals(this.liq)))
			throw new LiquidsException("liquidi incompatibili");

		if(c.max >= this.qty + c.qty) {
			c.qty += this.qty;
			this.qty = 0;
			this.liq = null;
		} else {
			this.qty -= c.max - c.qty;
			c.qty = c.max;
		}

		assert repOk();
		assert c.repOk();
	}

	@Override
	public int compareTo(Contenitore o) {
		return Double.compare(o.max, this.max);
	}

	public String getLiq() {
		return liq;
	}

	@Override
	public String toString() {
		String ret = "capienza: " + max;

		if(liq != null)
			ret += " liquido: " + liq + " qty: " + qty;

		return ret;
	}

	public boolean repOk() {
		if(qty < 0)
			return false;

		if(max <= 0)
			return false;

		if(qty > max)
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
}