import java.util.Scanner;

public class Cesare {

	public static String leggiTesto() {
		Scanner s = new Scanner(System.in);
		String res = "";

		while(s.hasNextLine())
			res += s.nextLine() + "\n";

		return res;
	}

	public static char cifraCarattere(char c, int chiave) {
		int range = 'Z' - 'A' + 1;
		int clipped = chiave % range;

		if(clipped < 0)
			clipped+=range;

		char base = ' ';

		if(c > 'a' && c < 'z')
			base = 'a';
		else if(c > 'A' && c < 'Z')
			base = 'A';
		else
			return c;

		return (char) (((c - base + clipped) % range) + base);
	}

	public static String CifraTesto(String s, int chiave) {
		String res = "";

		for (int i = 0; i < s.length(); i++) {
			res+=cifraCarattere(s.charAt(i), chiave);
		}

		return res;
	}

	public static void main(String[] args) {
		int chiave = Integer.parseInt(args[0]);

		System.out.println("Inserisci un testo su più righe (termina con CTRL D):");
		String testo = leggiTesto();

		String testoCifrato = CifraTesto(testo, chiave);

		System.out.println("Testo cifrato:");
		System.out.println(testoCifrato);
	}
}