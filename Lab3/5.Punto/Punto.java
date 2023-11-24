//Grazie a Edoardo Carmelo Longo 
//mannaggia a te metti le specifiche!
import java.util.ArrayList;
import java.util.Scanner;

public class Punto {
//OVERVIEW: modella un punto mutabile in 2d
	private double x,y;

	public Punto(double x, double y) {
	//MODIFIES: this
	//EFFECTS: inizializza this
		this.x=x;
		this.y=y;
		
		//non serve repOk() perchè tutti i valori di x e y sono validi
	}

	public Punto(double x) {
		this(x,x);
	}

	public Punto() {
		this(0);
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public void setX(double x) {
		this.x=x;
	}

	public void setY(double y) {
		this.y=y;
	}

	public void setXY(double x, double y) {
		this.x=x;
		this.y=y;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;

		if(o == null)
			return false;

		if(!(o instanceof Punto))
			return false;

		Punto po = (Punto) o;

		if(this.x != po.x || this.y != po.y)
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "{Punto: "+x+", "+y+"}";
	}

	public double distanza(Punto p) throws NullPointerException {
	//EFFECTS: restituisci distanza tra this e p
	//         se p è null lancia NullPointerException
		if(p == null)
			throw new NullPointerException("p null");

		return Math.sqrt(
			Math.pow((this.x-p.x), 2) +
			Math.pow((this.y-p.y), 2)
		);
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Inserire i punti (<x> <y>)");

		ArrayList<Punto> l = new ArrayList<>();

		while(s.hasNext())
			l.add(new Punto(s.nextDouble(),s.nextDouble()));

		Punto max1 = null, max2 = null;
		double max = 0;

		for(int i = 0; i < l.size() -1; i++) {
			for(int j = i+1; j < l.size(); j++) {
				double d = l.get(i).distanza(l.get(j));

				if(d > max) {
					max = d;
					max1 = l.get(i);
					max2 = l.get(j);
				}
			}
		}

		System.out.println("\nI punti più distanti sono:");
		System.out.println(max1); //tostring chiamato in automatico!
		System.out.println(max2);
	}
}