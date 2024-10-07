public class TernePitagoriche {

	public static void ternePitagoriche(int soglia) {
		for (int a = 1; a < soglia; a++)
			for (int b = a; b < soglia; b++)
				for (int c = b+1; c < soglia; c++)
					if(ternaPitagorica(a, b, c))
						System.out.println("("+a+","+b+","+c+")");
	}

	public static boolean ternaPitagorica(int a, int b, int c) {
		return a*a+b*b==c*c;
	}

	public static void main(String[] args) {
		ternePitagoriche(Integer.parseInt(args[0]));
	}
}