import java.util.ArrayList;
import java.util.Scanner;

public class Segmento3D { //è inutile ereditare Segmento2D perchè la sua rappresentazione non sarebbe riusabile. Quando non si riusa la rep ma solo le intestazioni dei metodi è meglio utilizzare interfacce comuni.
//OVERVIEW: classe che modella un Segmento nello spazio (immutabile)
	final Punto3D a,b;

	public Segmento3D(Punto3D a, Punto3D b) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza this con due punti diversi e non nulli
	//         se i punti sono nulli o uguali lancia IllegalArgumentException
		if(a == null)
			throw new IllegalArgumentException("a cannot be null");

		if(b == null)
			throw new IllegalArgumentException("b cannot be null");

		if(a.equals(b))
			throw new IllegalArgumentException("Segment points need to be different");

		this.a = a; //se non fossero stati oggetti immutabili servirebbe (Punto2D)(a.clone());
		this.b = b;
	}

	public double length() {
	//EFFECTS: returns the length of the segment;
		double c1 = (this.a.x - this.b.x);
		double c2 = (this.a.y - this.b.y);
		double c3 = (this.a.z - this.b.z);
		return Math.sqrt(c1*c1+c2*c2);
	}

	private boolean repOk() { //le invarianti sono che a e b non devono essere null e a e b non devono essere uguali
		if(a.equals(b))
			return false;
		
		if(a == null)
			return false;
		
		if(b == null)
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "Segmento3D - a: (" + this.a + "), b: (" + this.b + ") lunghezza: " + this.length();
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Segmento3D> l = new ArrayList<Segmento3D>();
		Double minLength = Double.parseDouble(args[0]);
		
		System.out.println("Inserisci i segmenti nel formato ax ay az bx by bz (temina con CTRL+D)");
		while(s.hasNext()) {
			double ax = Double.parseDouble(s.next());
			double ay = Double.parseDouble(s.next());
			double az = Double.parseDouble(s.next());
			double bx = Double.parseDouble(s.next());
			double by = Double.parseDouble(s.next());
			double bz = Double.parseDouble(s.next());
			l.add(new Segmento3D(new Punto3D(ax,ay,az), new Punto3D(bx,by,bz)));
		}
		
		System.out.println("Segmenti di lunghezza superiore a " + minLength);
		for(Segmento3D segmento : l)
			if(segmento.length() > minLength)
				System.out.println(segmento);
		
		s.close();
	}
}