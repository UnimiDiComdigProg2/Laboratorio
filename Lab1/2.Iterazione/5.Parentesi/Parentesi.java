public class Parentesi {
	public static void main(String[] args) {
		String s = args[0];

		int counter = 0;

		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '[')
				counter++;
			else //se non e' [ allora è ]
				counter--;

			if(counter < 0) //chiusure > aperture = non bilanciata
				break;
		}

		if(counter != 0)
			System.out.println("Non bilanciate");
		else
			System.out.println("Bilanciate");
	}
}