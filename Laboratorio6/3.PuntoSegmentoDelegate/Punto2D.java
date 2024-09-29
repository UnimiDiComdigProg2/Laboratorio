public class Punto2D {
//OVERVIEW: classe che modella un punto immutabile sul piano cartesiano
	final double x,y; //essendo tipi primitivi e final, posso non renderli private perchè comunque non sono modificabili. Se fossero stati tipi per riferimento renderli final avrebbe reso immodificabile il loro riferimento alla heap, ma non il contenuto della heap. In tal caso avrei dovuto renderli privati e accessibili solo attraverso getter. Infine, avrei dovuto assicurarmi di usare il cloning ogni volta che li ricevo in input o fornisco in output.

	public Punto2D(double x, double y) {
	//MODIFIES: this
	//EFFECTS: inizializza un nuovo Punto2D
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	@Override
	public String toString() {
		return "Punto2D - x: " + this.getX() + ", y: " + this.getY();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Punto2D) {
			Punto2D p = (Punto2D)o;
			if(this.x == p.x && this.y == p.y)
				return true;
		}

		return false;
	}
	
	//Non serve un repOk perchè lo stato del Punto2D è valido per tutti i valori di x e y
}
 
