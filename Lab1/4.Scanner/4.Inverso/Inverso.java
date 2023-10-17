import java.util.Scanner;

public class Inverso {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		System.out.println("Inserisci il testo: ");
		while(s.hasNextLine())
			sb.append(s.nextLine()+"\n");

		s.close();

		System.out.println("Testo inverso: \n");
		stampaInverso(sb.toString()); 
	}

	//metodo per invertire la stringa , lavoro su riga , parto dall'ultimo elemento e lo attacco alla stringa testo
	public static void stampaInverso(String s) {
		for(int i = s.length() - 1 ; i >= 0 ; i--)
			System.out.print(s.charAt(i));

		System.out.println();
	}
}
