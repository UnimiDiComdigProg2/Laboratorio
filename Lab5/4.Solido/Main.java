import java.util.ArrayList;
import java.util.Comparator;
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
		System.out.println(sf);
		Cono co = new Cono(rc, hc);
		System.out.println(co);

		ArrayList<Solido> als = new ArrayList<>();

		als.add(sf);
		als.add(co);

		Comparator<Solido> c = new Comparator<Solido>() {
			
			@Override
			public int compare(Solido a, Solido b) {
				return Double.compare(b.volume(), a.volume());
			}

		};

		als.sort(c);

		System.out.println(als);
		
	}
}