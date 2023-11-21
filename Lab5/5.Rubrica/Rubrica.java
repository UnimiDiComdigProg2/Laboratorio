import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Rubrica implements Iterable<Contatto> {
//OVERVIEW: modella una Rubrica di Contatti

//attributi
	private List<Contatto> contatti;

	public Rubrica(){
	//MODIFIES: this
	//EFFECTS: inizializza Rubrica
		this.contatti = new ArrayList<Contatto>();
	}

	public void aggiungiContatto(Contatto c) throws NullPointerException, IllegalArgumentException{
	//MODIFIES: this
	//EFFECTS: aggiunge un contatto alla nostra rubrica
	//         se contatto esiste lancia IllegalArgumentException
	//         se contatto nullo lancia NullPointerException
		if(c == null)
			throw new NullPointerException("Contatto null");

		if(contatti.contains(c))
			throw new IllegalArgumentException("Contatto già presente");

		contatti.add(new Contatto(c)); //uso il copy constructor, in alternativa potevo fare un clone classico

		assert repOk();
	}

	public Contatto restituisciContatto(String nome, String cognome) { //cerco contatto per nome e cognome
	//EFFECTS: restituisce contatto
	//         se non esiste lancia IllegalArgumentException

		//Uso questo finto contatto per andare a trovare quello vero. Questo è possibile perchè i contatti sono considerati equal e quindi indexOf sotto mi da l'indice di quello vero
		Contatto tmp = new Contatto(nome, cognome); //il costruttore controllerà la validità

		if(!contatti.contains(tmp))
			throw new IllegalArgumentException("Contatto non esiste");

		return new Contatto(contatti.get(contatti.indexOf(tmp)));  //uso il copy constructor, in alternativa potevo fare un clone classico
	}

	public void rimuoviContatto(String nome, String cognome) throws IllegalArgumentException{
	//MODIFIES: this
	//EFFECTS: rimuove un contatto dalla rubrica
	//         se contatto NON esiste lancia IllegalArgumentException

		Contatto tmp = new Contatto(nome, cognome); //il costruttore controllerà la validità

		if(!(contatti.contains(tmp)))
			throw new IllegalArgumentException("Contatto non esiste");

		contatti.remove(tmp); //non serve clonare perchè rimuovo dalla rep (non lascio accesso a nulla)

		assert repOk();
	}

	public void modificaContatto(String nome, String cognome, Contatto c) throws NullPointerException, IllegalArgumentException{
	//MODIFIES: this
	//EFFECTS: questo metodo modifica un contatto dalla rubrica
	//	  se contatto vecchio non esiste lancia IllegalArgumentException
	//	  se contatto nuovo null lancia NullPointerException
	//	  se contatto nuovo già presente lancia NullPointerException

		if(c == null)
			throw new NullPointerException("Contatto nuovo null");

		Contatto tmp = new Contatto(nome, cognome); //il costruttore controllerà la validità

		if(!contatti.contains(tmp))
			throw new IllegalArgumentException("Contatto vecchio non esiste");

		if(contatti.contains(c))
			throw new IllegalArgumentException("Contatto nuovo già presente");

		contatti.set(contatti.indexOf(tmp), new Contatto(c));  //uso il copy constructor, in alternativa potevo fare un clone classico

		assert repOk();
	}

	@Override
	public Iterator<Contatto> iterator() {
		return new Iterator<Contatto>() {
			Iterator<Contatto> i = contatti.iterator(); //iteratore di contatti mediante composizione

			@Override
			public boolean hasNext() {
				return i.hasNext(); //chiamata per delega a i
			}   

			@Override
			public Contatto next() {
				return i.next(); //chiamata per delega a i
			}
		};
	}

	public boolean repOk() {
		for(Contatto c : this)
			if(c == null)
				return false;
			else if(contatti.indexOf(c) != contatti.lastIndexOf(c))
				return false;

		return true;
	}

	public static void main(String[] args) {
		Rubrica r = new Rubrica();

		Contatto c1 = new Contatto("Joe", "Henry");
		c1.aggiungiNumero("5553456");
		c1.aggiungiNumero("5134902");
		c1.aggiungiMail("jhenry@bix.net");
		c1.aggiungiMail("j.hen@nis.org");

		Contatto c2 = new Contatto("JimBob", "Johnson");
		c2.aggiungiMail("jbj@email.com");
		c2.aggiungiMail("bjb@gmail.com");

		Contatto c3 = new Contatto("Jack", "Ripper");
		c3.aggiungiNumero("3116535");
		c3.aggiungiMail("slice@dice.org");
		c3.aggiungiMail("dice@slice.com");

		r.aggiungiContatto(c1);
		r.aggiungiContatto(c2);
		r.aggiungiContatto(c3);

//modo semplice di stampare tutto
		for(Contatto c : r) //Rubrica ha il metodo iterator e quindi si può usare con foreach
			System.out.println(c); //tostring di ciascun contatto, per come li ho fatti, da già tutto

//in alternativa
		Iterator<Contatto> i = r.iterator(); //l'iteratore di contatti preso da rubrica
		while(i.hasNext()) {
			Contatto c = i.next();
			System.out.println(c.getNome() + " " + c.getCognome());

			Iterator<String> in = c.iteratorNumeri();
			System.out.print("\ttel: ");
			while(in.hasNext())
				System.out.print(in.next() + " ");
			System.out.println();

			Iterator<String> im = c.iteratorMail();
			System.out.print("\tmail: ");
			while(im.hasNext())
				System.out.print(im.next() + " ");
			System.out.println();

			System.out.println();
		}
	}
}