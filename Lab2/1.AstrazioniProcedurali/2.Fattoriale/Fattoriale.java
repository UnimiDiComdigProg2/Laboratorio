//grazie a Gabriele Nicchi per la base della classe
import java.util.ArrayList;

public class Fattoriale {
//OVERVIEW: classe statica che permette il calcolo di una lista di fattoriali

//metodi
	public static ArrayList<Integer> listaFattoriali(int n) {
	//REQUIRES: n > 0
	//EFFECTS: restituisce una lista di fattoriali da 1 a n
		ArrayList<Integer> v = new ArrayList<Integer>();

		for(int i = 1 ; i <= n ; i++)
			v.add(fattoriale(i));

		return v;
	}

	public static void stampaFattoriali(ArrayList<Integer> l) {
	//REQUIRES: l non nulla
	//EFFECTS: stampa per ciascun elemento il suo indice e il suo valore
		for(int i = 0; i < l.size(); i++)
			System.out.println(i + " : " + l.get(i));
	}

	public static int fattoriale(int n) {
	//REQUIRES: n > 0
	//EFFECTS: restituisce il fattoriale di n
		int res = 1;
		for (int i = 2; i <= n; i++) 
			res *= i;

		return res; 
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ArrayList<Integer> v = listaFattoriali(n);
		stampaFattoriali(v);
	}
}