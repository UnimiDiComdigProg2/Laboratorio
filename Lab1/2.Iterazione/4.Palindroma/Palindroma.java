public class Palindroma {
	public static void main(String[] args) {

		String s = args[0];
		int n = s.length();

		for(int i = 0; i < n/2; i++) {
			if(s.charAt(i) != s.charAt(n-i-1)) {
				System.out.println("Non Palindroma");
				return;
			}
		}

		System.out.println("Palindroma");
	}
}
