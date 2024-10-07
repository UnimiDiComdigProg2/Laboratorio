public class Conversioni {
	public static void main(String[] args) {
		double result = Double.parseDouble(args[0]);

		switch(args[1]) {
			case "minuti":
				result *= 60;
				break;
			case "ore":
				result *= 60*60;
				break;
			case "giorni":
				result *= 60*60*24;
				break;
			case "mesi":
				result *= 60*60*24*30;
				break;
			case "anni":
				result *= 60*60*24*365;
				break;
		}

		switch(args[3]) {
			case "minuti":
				result /= 60;
				break;
			case "ore":
				result /= 60*60;
				break;
			case "giorni":
				result /= 60*60*24;
				break;
			case "mesi":
				result /= 60*60*24*30;
				break;
			case "anni":
				result /= 60*60*24*365;
				break;
		}

		System.out.println(args[0] + " " + args[1] + " corrispondono a " + result + " " + args[3]);
	}
}