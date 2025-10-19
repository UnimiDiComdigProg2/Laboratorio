import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calcolatrice {
//OVERVIEW: classe statica per calcolare le operazioni base

	public static double calculate(double o1, double o2, char op) throws InputMismatchException, DivisionByZeroException {
	//EFFECTS: returns the result of the operation op between operands o1 and o2
	//         if op is not + - * or / throws InputMismatchException
	//         if op is / and o2 is 0 throws DivisionByZeroException

		double res = o1;

		switch(op) {
			case '+':
				res += o2;
				break;
			case '-':
				res -= o2;
				break;
			case '*':
				res *= o2;
				break;
			case '/':
				if(o2 == 0)
					throw new DivisionByZeroException("Non è possibile dividere per 0");
				res /= o2;
				break;
			default:
				throw new InputMismatchException("Operatore non riconosciuto");
		}

		return res;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in); //nuovo scanner agganciato a System.in

		System.out.println("Inserisci <operando1> <operatore> <operando2>. es: 4 + 3");

		double a = 0;
		double b = 0;
		String o = "";

		try {
			a = s.nextDouble();
			o = s.next();
			b = s.nextDouble();
		} catch(InputMismatchException e) {
			System.out.println("Operando non è double");
			System.exit(0);
		} catch(NoSuchElementException e) {
			System.out.println("Non sono stati inseriti tutti gli input richiesti");
			System.exit(0);
		}

		try {
			System.out.println("Il risultato è " + calculate(a,b,o.charAt(0)));
		} catch(InputMismatchException | DivisionByZeroException e) {
			System.out.println(e.getMessage());
		}
	}
}