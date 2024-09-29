public final class Punto3D extends Punto2D {
//OVERVIEW: classe che modella un punto immutabile nello spazio
	final double z; //anche qua posso solo rendere la coordinata z final

	public Punto3D(double x, double y, double z) {
	//MODIFIES: this
	//EFFECTS: inizializza un nuovo Punto3D
		super(x, y); //richiamo il costruttore di Punto2D
		this.z = z;
	}

	@Override
	public String toString() {
		return "Punto3D - x: " + this.x + ", y: " + this.y + ", z: " + this.z;
	}

	@Override
	public boolean equals(Object o) { //l'estensione di Punto2D crea un problema impossibile di controllo dell'uguaglianza
		// if(this.getClass().equals(o.getClass())) //l'uso di getclass per vincolare l'uguaglianza al solo tipo concreto viola il principio di sostituzione di Liskov perchè non potrei sostituire il sottotipo Punto2D al posto di un Punto3D come `o`. Precisamente va contro la regola dei metodi che dice che un metodo di un sottotipo, con lo stesso input dello stesso metodo del supertipo, dovrebbe dare lo stesso output.
		if(o instanceof Punto3D) {//Questo usato da solo viola il principio di sostituzione di Liskov. Infatti un Punto3D non può essere sostituito ad un Punto2D
			Punto3D p = (Punto3D)o;
			if((this.x == p.x) && (this.y == p.y) && (this.z == p.z)) //controllare solo su x e y violerebbe la proprietà simmetrica. Infatti potrebbe succedere che due Punto3D siano diversi tra loro per coordinata z ma diano comunque equals true.
				return true;
		} else if(o instanceof Punto2D) {//L'aggiunta di questo viola la proprietà transitiva. Infatti due diversi Punto3D potrebbero essere uguali a un Punto2D per coordinate x e y, ma differire tra di loro per coordinata z.
			Punto2D p = (Punto2D)o;
			if((this.x == p.x) && (this.y == p.y))
				return true;
		}
		
		return false;
	}
}
 
