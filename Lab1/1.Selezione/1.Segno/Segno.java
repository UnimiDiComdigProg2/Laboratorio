public class Segno {
	public static void main(String[] args) {
		// Check if there's at least one argument
		if (args.length == 0) {
			System.out.println("Please provide an integer as a command line argument.");
			return;
		}

		// Parse the command line argument to an integer
		int n = Integer.parseInt(args[0]);

		// Print the integer with its sign
		if (n >= 0) {
			System.out.println("+" + n);  // Add '+' sign for positive numbers and zero
		} else {
			System.out.println(n);  // Negative numbers already have a '-' sign
		}
	}
}