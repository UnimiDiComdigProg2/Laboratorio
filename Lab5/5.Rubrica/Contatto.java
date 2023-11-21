import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;

public class Contatto{
//OVERVIEW: modella Contatto con nome, cognome, numeri di telefono e email

//attributi
	private String nome;
	private String cognome;
	private ArrayList<String> numeri;
	private ArrayList<String> mail;

//costruttore
	public Contatto(String nome, String cognome) throws InputMismatchException, NullPointerException {
	//MODIFIES: this
	//EFFECTS: inizializza un contatto con nome e cognome
	//         se nome o cognome null lancia NullPointerException
	//         se nome o cognome vuoti lancia InputMismatchException
		if(nome == null)
			throw new NullPointerException("Il nome non può essere nullo");

		if(nome.equals(""))
			throw new InputMismatchException("Il nome non può essere vuoto");

		if(cognome == null)
			throw new NullPointerException("Il cognome non può essere nullo");

		if(cognome.equals(""))
			throw new InputMismatchException("Il cognome non può essere vuoto");

		this.nome = nome;
		this.cognome = cognome;
		this.numeri = new ArrayList<>();
		this.mail = new ArrayList<>();

		assert repOk();
	}

	@SuppressWarnings("unchecked")
	public Contatto(Contatto c) {
	//MODIFIES: this
	//EFFECTS: copy constructor, una'alternativa al clone
		this.nome = c.nome;
		this.cognome = c.cognome;
		this.numeri = (ArrayList<String>) c.numeri.clone(); //ci basta una shallow copy perchè gli elementi sono immutabili
		this.mail = (ArrayList<String>) c.mail.clone(); //ci basta una shallow copy perchè gli elementi sono immutabili
	}

	public boolean repOk(){
		if(nome.equals("") || nome == null)
			return false;

		if(cognome.equals("") || cognome == null)
			return false;

		for(String n : numeri)
			if(n == null || n.equals(""))
				return false;
			else if(numeri.indexOf(n) != numeri.lastIndexOf(n))
				return false;

		for(String m : mail)
			if(m == null || m.equals(""))
				return false;
			else if(mail.indexOf(m) != mail.lastIndexOf(m))
				return false;

		return true;
	}

	public String getNome(){
		return this.nome;
	}

	public String getCognome(){
		return this.cognome;
	}

	public void setNome(String nome) {
		if(nome == null)
			throw new NullPointerException("Il nome non può essere nullo");

		if(nome.equals(""))
			throw new InputMismatchException("Il nome non può essere vuoto");

		this.nome = nome;

		assert repOk();
	}

	public void setCogome(String cognome) {
		if(cognome == null)
			throw new NullPointerException("Il xognome non può essere nullo");

		if(cognome.equals(""))
			throw new InputMismatchException("Il xognome non può essere vuoto");

		this.cognome = cognome;

		assert repOk();
	}

	public void aggiungiNumero(String num) throws NullPointerException, InputMismatchException{
	//MODIFIES: this
	//EFFECTS: aggiunge numero
	//         se numero null lancia NullPointerException
	//         se numero vuoto lancia InputMismatchException

		if(num == null)
			throw new NullPointerException("La mail non può essere nulla");

		if(num.equals(""))
			throw new InputMismatchException("La mail è vuota");

		this.numeri.add(num);

		assert repOk();
	}

	public void aggiungiMail(String m) throws NullPointerException, InputMismatchException {
	//MODIFIES: this
	//EFFECTS: aggiunge mail
	//         se mail null lancia NullPointerException
	//         se mail vuota lancia InputMismatchException

		if(m == null){
			throw new NullPointerException("La mail non può essere nulla");
		}
		if(m.equals("")){
			throw new InputMismatchException("La mail è vuota");
		}

		this.mail.add(m);

		assert repOk();
	}

	public Iterator<String> iteratorNumeri() {
		return new Iterator<String>() { //restituiamo un Iterator<String> anonimo
			Iterator<String> i = numeri.iterator(); //Per mantenere lo stato dell'iterazione usiamo per composizione l'iterator di numeri

			@Override
			public boolean hasNext() {
				return i.hasNext(); //per delega chiamiamo hasNext() di i. lo saprà lui se c'è altro su cui iterare
			}

			@Override
			public String next() {
				return i.next(); //per delega chiamiamo next() di i. si occuperà lui di tenere lo stato dell'iteratore aggiornato e di restituire il next giusto
			}

			//NON creiamo un delegate di remove() perchè non vogliamo questa funzionalità nel nostro iteratore
		};
	}

	public Iterator<String> iteratorMail() {
		return new Iterator<String>(){
			Iterator<String> i = mail.iterator();

			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public String next() {
				return i.next();
			}
		};
	}

	@Override
	public String toString(){
		String ret = this.nome + " " + this.cognome + "\n";

		ret += "\ttel: ";
		for(String n : numeri)
			ret+= n + " ";

		ret += "\n\tmail: ";
		for(String m : mail)
			ret+= m + " ";

		return ret + "\n";
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;

		if(o == null)
			return false;

		if(!(this.getClass().equals(o.getClass())))
			return false;

		Contatto tmp = (Contatto) o;

		if(this.nome != tmp.nome)
			return false;

		if(this.cognome != tmp.cognome)
			return false;

		return true;
	}
}