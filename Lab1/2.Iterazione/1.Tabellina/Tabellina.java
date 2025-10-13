public class Tabellina {
	public static void main(String[] args) {
		// Check if one argument is passed
		if (args.length != 1) {
			System.out.println("Please provide exactly one integer argument.");
			return;
		}

		// Parse the input argument as an integer
		int n = Integer.parseInt(args[0]);

		// Print the multiplication table from 1 to 10
		for (int i = 1; i <= 10; i++) //non serve {} se dentro for una sola riga di codice 
			System.out.println(i + " x " + n + " = " + (i * n));
	}
}