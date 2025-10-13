public class Cerchio {
	// Method to calculate the area of the circle
	public static double CalcolaArea(double raggio) {
		return Math.PI * raggio * raggio; // Area formula: π * r^2
	}

	// Method to calculate the circumference of the circle
	public static double CalcolaCirconferenza(double raggio) {
		return 2 * Math.PI * raggio; // Circumference formula: 2 * π * r
	}

	public static void main(String[] args) {
		// Check if exactly one argument is passed
		if (args.length != 1) {
			System.out.println("Please provide exactly one argument for the radius.");
			return;
		}

		// Parse the input argument as a double
		double raggio = Double.parseDouble(args[0]);

		// Calculate the area and circumference
		double area = CalcolaArea(raggio);
		double circonferenza = CalcolaCirconferenza(raggio);

		// Print the results
		System.out.println("Area del cerchio: " + area);
		System.out.println("Circonferenza del cerchio: " + circonferenza);
	}
}