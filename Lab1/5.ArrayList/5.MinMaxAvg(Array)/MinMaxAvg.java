import java.util.Scanner; //userò lo scanner per l'input

public class MinMaxAvg { //classe pubblica al fine di poterla importare da altre classi e package

	public static void main(String[] args) { //metodo main per poter eseguire da riga di comando. Pubblico per poter essere usato da fuori, statico perchè non modifica stato della classe.
		int n = Integer.parseInt(args[0]); //gli argomenti partono da 0
		Scanner s = new Scanner(System.in); //nuovo scanner agganciato a System.in
		int[] values = new int[n]; //inizializzo l'array con la dimensione specificata

		System.out.println("Inserisci i " + args[0] + " numeri");
		for(int i=0;i<n;i++) //uso questa forma del for perchè so quanti ne devo leggere
			values[i] = s.nextInt(); //Lo Scanner è un iteratore. A ogni chiamata nextInt mi da un nuovo int letto

		//richiamo i tre metodi e stampo il risultato.
		System.out.println("Minimo: " + minimo(values));
		System.out.println("Massimo: " + massimo(values));
		System.out.println("Media: " + media(values));

		s.close();
	}

	public static int minimo(int[] in) {
		int min = in[0];

		for (int i=1;i<in.length;i++) //posso fare un ciclo for classico per accedere ai valori per indice
			if(in[i] < min) //se il valore letto è inferiore al min corrente
				min = in[i]; //assegno il valore letto a min

		return min;
	}

	public static int massimo(int[] in) {

		int max = in[0];
		for(int value : in) //stavolta uso la sintassi for each (range in GO). A ogni loop inserisco il valore successivo in value
			if(value > max)
				max = value;

		return max;
	}

	public static float media(int[] in) {

		float media = 0;
		for (Integer value : in) //notare che qua uso integer e java non si lamenta. Casting implicito
			media += value;

		return media/in.length; //come prima uso length per calcolare la dimensione dell'array
	}
}