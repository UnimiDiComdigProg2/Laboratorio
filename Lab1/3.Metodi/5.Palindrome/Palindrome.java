public class Palindrome {

	private static boolean isPalindroma(String s) {

		for(int i = 0; i < s.length()/2; i++)
			if(s.charAt(i) != s.charAt(s.length()-i-1))
				return false;

		return true;
	}

	public static void main(String[] args) {

		String s = args[0];
		System.out.print("[ ");

		for (int i = 0; i < s.length(); i++) {
			for (int j = i+2; j <= s.length(); j++) {

				String temp = s.substring(i, j);

				if(isPalindroma(temp)) //il metodo non stampa, restituisce risultato
					System.out.print(temp + " "); //il main stampa - divido logica dalla presentazione
			}
		}

		System.out.println("]");
	}
}