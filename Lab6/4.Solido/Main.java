import java.util.Scanner;

public class Main  {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Inserisci il raggio di una sfera");
		double rs = s.nextDouble();
		System.out.println("Inserisci il raggio e l'altezza di un cono");
		double rc = s.nextDouble();
		double hc = s.nextDouble();

		Sfera sf = new Sfera(rs);
		Cono co = new Cono(rc, hc);

		if(sf.compareTo(co) > 0)
			System.out.println("La sfera ha un volume maggiore del cono");
		else if(sf.compareTo(co) < 0)
			System.out.println("Il cono ha un volume maggiore della sfera");
		else
			System.out.println("Il cono e la sfera hanno lo stesso volume");
	}
}