public class Punto3D implements Punto {

	final Punto2D p; // si acquisice lo stato di Punto2D per composizione 
	final double z;

	public Punto3D(double x, double y, double z) {
		//MODIFIES: this
		//EFFECTS: inizializza this con x y z
		this.p = new Punto2D(x, y);
		this.z = z;
	}

	@Override
	public double getX() {
		return p.getX(); //si acquisisce il comportamento di Punto2D per delega, implementando i metodi in Punto3D che delegano ai metodi con lo stesso nome in Punto2D
	}

	@Override
	public double getY() {
		return p.getY();
	}

	public double getZ() { //questo non è override
		return z;
	}

	@Override
	public String toString() {
		return p.toString() + ", z: " + z;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;

		if(o == null)
			return false;
	
		if(!(o instanceof Punto3D)) //non serve chiedersi se uguale a Punto2D perchè non è suo supertipo!
			return false;

		Punto3D tmp = (Punto3D) o;

		if(!(this.p.equals(tmp.p)))
			return false;

		if(this.z != tmp.z)
			return false;

		return true;
	}
}