abstract class Macchina implements Comparable<Macchina>, Cloneable {
//OVERVIEW: abstract machine

	public final double cost;
	private boolean locked = false;

	Macchina(double cost) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: initializes this
		if(cost <= 0)
			throw new IllegalArgumentException("costo <= 0");

		this.cost = cost;
	}

	public void lock() throws LockException {
	//MODIFIES: this
	//EFFECTS: locks this
	//         if locked throw LockException
		if(locked)
			throw new LockException("Già chiusa");

		locked = true;
	}

	public void unlock() throws LockException {
	//MODIFIES: this
	//EFFECTS: unlocks this
	//         if unlocked throw LockException
		if(!locked)
			throw new LockException("Già aperta");

		locked = false;
	}

	public boolean isLocked() {
		return locked;
	}

	@Override
	public int compareTo(Macchina o) {
		return Double.compare(cost, o.cost);
	}

	@Override
	public String toString() {
		return " costo: " + cost + (locked ? " chiusa" : " aperta");
	}

	@Override
	public Macchina clone() {
		try {
			return (Macchina) super.clone();
		} catch(Exception e) {
			return null;
		}
	}
}