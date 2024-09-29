import java.util.Comparator;
import java.util.Scanner;

public class Massimo<T> {
	T max = null;
	Comparator<T> comp = null;

	public Massimo() {}

	public Massimo(Comparator<T> comp) {
		this.comp = comp;
	}

	public T getMax() {
		return this.max;
	}

	public void insert(T t) {
		if(this.max == null)
			this.max = t;
		else if(this.comp != null && comp.compare(max, t) < 0)
			this.max = t;
	}

	public static void main(String[] args) {
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		};

		Massimo<String> mLex = new Massimo<>();
		Massimo<String> mLen = new Massimo<>(comp);

		Scanner s = new Scanner(System.in);

		System.out.println("Inserisci Stringhe (CTRL+D per terminare)");
		while(s.hasNext()) {
			String str = s.next();

			mLen.insert(str);
			mLex.insert(str);
		}

		System.out.println("\nMassimo (lessicografico): " + mLex.getMax());
		System.out.println("Massimo (lunghezza): " + mLen.getMax());
	}
}