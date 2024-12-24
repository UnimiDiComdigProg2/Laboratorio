import java.util.Arrays;

public class Base extends Figura {
//OVERVIEW: Figura Base (Gesù, Maria, Giuseppe) del Presepio

//Se l'encapsulation è protetta e l'inserimento degli aggettivi avviene solo in costruzione, la classe è immutabile e il clone non serve
//Se gli aggettivi vengono passati per array o list devono essere clonati.
//Se inseriti con un metodo mutazionale, la classe è mutabile e deve avere un clone
	private final String[] aggettivi;

	//Andava bene anche passare un String[] o una List, ma in tal caso si doveva clonare o copiare per non rompere l'encapsulation
	public Base(String nome, String ... aggettivi) {  // la sintassi "String ... nome" crea un NUOVO String[] con i parametri successivi al primo
	//MODIFIES: this
	//EFFECTS: inizializza una nuova Figura Base con una serie di aggettivi
	//         se nome non è Gesù, Maria o Giuseppe lancia NomeException
	//         se qualunque degli aggettivi è null o vuoto lancia IllegalArgumentException
		super(nome);

		if(!(nome.equals("Gesù") || nome.equals("Giuseppe") || nome.equals("Maria")))
			throw new NomeException("\tEmergenza: " + nome + " non è una Figura Base del presepio");

		if(aggettivi.length == 0)
			throw new  IllegalArgumentException("\tEmergenza: lista aggettivi vuota");

		for(String a: aggettivi)
			if(a == null || a.equals(""))
				throw new IllegalArgumentException("\tEmergenza: aggettivo null o vuoto");

		this.aggettivi = aggettivi; //non rompe l'encapsulation perché aggettivi è un array che non esiste fuori
	}

	@Override
	public int valore() {
	//EFFECTS: il valore è la somma delle lunghezze di tutti gli aggettivi
		return Arrays.stream(aggettivi).mapToInt(i -> i.length()).sum(); //genera uno stream di interi con le lunghezze degli aggettivi e lo somma

		/* variante con una variabile accumulatore e un ciclo for
		int r = 0
		for(a: aggettivi)
			r+=a.length();
		return r;
		*/
	}

	@Override
	public String toString() {
		return "Base: " + super.toString() + " " + Arrays.asList(aggettivi);
	}
}