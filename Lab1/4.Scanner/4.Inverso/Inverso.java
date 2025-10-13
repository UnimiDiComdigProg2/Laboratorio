import java.util.Scanner;

public class Inverso {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		System.out.println("Inserisci il testo: ");
		while(s.hasNextLine())
			sb.append(s.nextLine()+"\n");

		s.close();

		System.out.println("Testo inverso: \n" + inverso(sb.toString()));
	}

	//metodo per invertire la stringa , lavoro su riga , parto dall'ultimo elemento e lo attacco alla stringa testo
	public static String inverso(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = s.length() - 1 ; i >= 0 ; i--)
			sb.append(s.charAt(i));

		return sb.toString();
	}
}
