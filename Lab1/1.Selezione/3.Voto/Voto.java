public class Voto {
	public static void main(String[] args) {
		// Check if one argument is passed
		if (args.length != 1) {
			System.out.println("Please provide exactly one integer argument for the grade.");
			return;
		}

		// Parse the input argument as an integer
		int voto = Integer.parseInt(args[0]);

		// Check the range of the grade and print the corresponding evaluation
		if (voto < 0 || voto > 100) {
			System.out.println("Errore");
		} else if (voto < 60) {
			System.out.println("Insufficiente");
		} else if (voto < 70) {
			System.out.println("Sufficiente");
		} else if (voto < 80) {
			System.out.println("Buono");
		} else if (voto < 90) {
			System.out.println("Distinto");
		} else {
			System.out.println("Ottimo");
		}
	}
}