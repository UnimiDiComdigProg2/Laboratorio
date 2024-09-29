import java.util.ArrayList;
import java.util.Scanner;

public class Segmento2D implements Segmento {
//OVERVIEW: classe che modella un Segmento sul piano cartesiano (immutabile)
	final Punto2D a,b; //anche qua basta final perchè i punti stessi sono immutabili, quindi il loro contenuto non può essere modificato

	public Segmento2D(Punto2D a, Punto2D b) throws IllegalArgumentException {
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
	
	public Punto2D getA() {
		return this.a;
	}

	public Punto2D getB() {
		return this.b;
	}

	public double length() {
	//EFFECTS: returns the length of the segment;
		double c1 = (this.getA().getX() - this.getB().getX());
		double c2 = (this.getA().getY() - this.getB().getY());
		return Math.sqrt(c1*c1+c2*c2);
	}

	private boolean repOk() { //le invarianti sono che a e b non devono essere null e a e b non devono essere uguali
		if(this.a.equals(this.b))
			return false;
		
		if(this.a == null)
			return false;
		
		if(this.b == null)
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "Segmento - a: (" + this.getA() + "), b: (" + this.getB() + ") lunghezza: " + this.length();
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Segmento2D> l = new ArrayList<Segmento2D>();
		Double minLength = Double.parseDouble(args[0]);
		
		System.out.println("Inserisci i segmenti nel formato ax ay bx by (temina con CTRL+D)");
		while(s.hasNext()) {
			double ax = Double.parseDouble(s.next());
			double ay = Double.parseDouble(s.next());
			double bx = Double.parseDouble(s.next());
			double by = Double.parseDouble(s.next());
			l.add(new Segmento2D(new Punto2D(ax,ay), new Punto2D(bx,by)));
		}
		
		System.out.println("Segmenti di lunghezza superiore a " + minLength);
		for(Segmento2D segmento : l)
			if(segmento.length() > minLength)
				System.out.println(segmento);
		
		s.close();
	}
}