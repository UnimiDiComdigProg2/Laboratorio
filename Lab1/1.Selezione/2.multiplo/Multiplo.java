public class Multiplo {
	public static void main(String[] args) {
		// Check if two arguments are passed
		if (args.length != 2) {
			System.out.println("Please provide exactly two integer arguments.");
			return;
		}

		// Parse the input arguments as integers
		int firstNumber = Integer.parseInt(args[0]);
		int secondNumber = Integer.parseInt(args[1]);

		// Check if the second number is zero
		if (secondNumber == 0) {
			System.out.println("The second number cannot be zero.");
			return;
		}

		// Check if the first number is a multiple of the second
		if (firstNumber % secondNumber == 0) {
			System.out.println(firstNumber + " è multiplo di " + secondNumber);
		} else {
			System.out.println(firstNumber + " non è multiplo di " + secondNumber);
		}
	}
}