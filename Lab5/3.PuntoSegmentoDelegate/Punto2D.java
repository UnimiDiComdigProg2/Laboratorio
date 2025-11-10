public class Punto2D implements Punto {
//OVERVIEW modella un punto in 2D - immutabile
	public final double x,y;

	public Punto2D(double x, double y) {
	//MODIFIES: this
	//EFFECTS: inizializza this con x e y
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Punto - x: " + this.x + ", y: " + this.y;
	}

	//i getter sono utili per rendere l'accesso più consistente in un processo di delega. Se no dovrei chiamare le coordinate x e y nel Punto3D p3d fatto componendo un Punto2D p2d con p3d.p2d.x e p3d.p2d.y  
	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;

		if(o == null)
			return false;

		if(!(o instanceof Punto2D))
			return false;

		Punto2D tmp = (Punto2D) o;

		if(this.x != tmp.x)
			return false;

		if(this.y != tmp.y)
			return false;

		return true;
	}
}