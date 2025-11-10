import java.util.ArrayList;
import java.util.Scanner;

public class Segmento3D implements Segmento {
//OVERVIEW: modella un segmento in 3D - Immutabile

	private final Punto3D a, b;

	public Segmento3D(Punto3D a, Punto3D b) {
	//MODIFIES: this
	//EFFECTS: inizializza this
	//         se a o b null lancia NullPointerException
	//         se a == b lancia IllegalArgumentException

		if(a == null)
			throw new NullPointerException("a null");

		if(b == null)
			throw new NullPointerException("b null");

		if(a.equals(b))
			throw new IllegalArgumentException("a equals b");

		this.a = a;
		this.b = b;
	}
  
	@Override
	public Punto3D getA() { //override con return covariante - restituisce Punto3D che è sottotipo di Punto
		return a;
	}

	@Override
	public Punto3D getB() {
		return b;
	}

	@Override
	public double length() {
		return Math.sqrt(
			Math.pow(this.a.p.x - this.b.p.x, 2) +
			Math.pow(this.a.p.y - this.b.p.y, 2) +
			Math.pow(this.a.z - this.b.z, 2)
		);
	}

	@Override
	public String toString() {
		return "Segmento: [" + a + "; " + b + "] lunghezza: " + this.length();
	}

	public static void main(String[] args) {
		double lenmin = Double.parseDouble(args[0]);

		Scanner s = new Scanner(System.in);

		ArrayList<Segmento3D> list = new ArrayList<>();

		System.out.println("Inserisci i segmenti nel formato ax ay az bx by bz (temina con CTRL+D)");

		while(s.hasNextLine()) {

			String[] parts = s.nextLine().split(" ");

			list.add(
				new Segmento3D(
					new Punto3D(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]), Double.parseDouble(parts[2])),
					new Punto3D(Double.parseDouble(parts[3]), Double.parseDouble(parts[4]), Double.parseDouble(parts[5]))
				)
			);
		}

		System.out.println("Segmenti di lunghezza superiore a " + lenmin);

		for(Segmento3D s3d : list)
			if(s3d.length() > lenmin)
				System.out.println(s3d); 
	}
}