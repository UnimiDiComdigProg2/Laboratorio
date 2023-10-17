//grazie a Gabriele Nicchi per la base della classe
import java.util.Scanner;

public class Farfallino {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(); //uso StringBuilder (mutabile) perchè servono tanti append e String (immutabile) è più pesante

		System.out.println("Inserisci testo: ");
		while(scanner.hasNext())
			sb.append(scanner.nextLine()+"\n"); //appendo ogni riga

		scanner.close();
		System.out.print("Testo in linguaggio farfallino: " + "\n" + farfallino(sb.toString()));
	}

	public static String farfallino(String s) {
		StringBuilder sb = new StringBuilder();

		for(char c : s.toCharArray()) //toCharArray converte testo in un array di char
			if(isVocale(c))
				if(Character.isUpperCase(c))
					sb.append(c+"F"+c);
				else
					sb.append(c+"f"+c);
			else
				sb.append(c);

		return sb.toString();
	}

	public static boolean isVocale(char c) {
		String ns = "AÀÁEÈÉIÌÍOÒÓUÙÚaàáeèéiìíoòóuùú";

		if(ns.indexOf(c) != -1)
			return true;

		return false;
	}
}