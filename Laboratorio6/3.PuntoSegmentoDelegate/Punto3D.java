public final class Punto3D {
//OVERVIEW: classe che modella un punto immutabile nello spazio
	final Punto2D p;
	final double z; //anche qua posso solo rendere la coordinata z final

	public Punto3D(double x, double y, double z) {
	//MODIFIES: this
	//EFFECTS: inizializza un nuovo Punto3D
		this.p = new Punto2D(x, y); //richiamo il costruttore di Punto2D
		this.z = z;
	}
	
	public double getX() {
		return this.p.getX();
	}

	public double getY() {
		return this.p.getY();
	}

	public double getZ() {
		return this.z;
	}

	@Override
	public String toString() {
		return "Punto3D - x: " + this.getX() + ", y: " + this.getY() + ", z: " + this.getZ();
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Punto3D) {
			Punto3D p = (Punto3D)o;
			if((this.p.equals(p.p)) && (this.z == p.z))
				return true;
		}
		
		return false;
	}
}
 
