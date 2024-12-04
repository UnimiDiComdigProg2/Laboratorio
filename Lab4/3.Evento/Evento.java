import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public final class Evento {
//OVERVIEW: modella un Evento di una Agenda, con data e nome. Modelliamo il dato come immutabile
//          mi aspetto che un evento sia definito dalla sua data e nome. Con altra data e nome si tratta di un altro evento
	private final String nome; //definisco gli attributi final perchè non devono essere modificabili. Però non basta...
	private final Date data;

	public Evento(Date data, String nome) {
	//EFFECTS: inizializza Evento con data e nome specificati
	//          se data o nome null oppure nome vuoto, lancia IllegalArgumentException
		if(data == null)
			throw new IllegalArgumentException("Data nulla");

		if(nome == null)
			throw new IllegalArgumentException("Nome nullo");

		if(nome == "")
			throw new IllegalArgumentException("Nome vuoto");

		this.nome = nome;
		//this.data = data; //se faccio questo, la data passata come parametro sarà ancora modificabile e cambia anche this.data!
		this.data = (Date)(data.clone()); //invece uso clone per evitare di rendere la classe mutabile

		assert repOk(); //aggiunto alla fine per verificare la RI. eseguire con java -ea <Classe>
	}

	public String getNome() {
		return this.nome;
	}

	public Date getData() {
		return (Date)(this.data.clone()); //invece uso clone per evitare di rendere la classe mutabile
	}

	public Evento copiaEvento(int offset) {
	//EFFECTS: restituisce un nuovo Evento a distanza di offset dal precedente
		Date newData = new Date(this.data.getTime() + TimeUnit.DAYS.toMillis(offset));
		return new Evento(newData, this.nome);
	}

	private boolean repOk() {
		if((this.data != null) && (this.nome != null) && (this.nome != "")) //si può anche controllare uno alla volta ritornando false, e true infine se passa tutti i controlli
			return true;
			
		return false;
	}

	@Override //Uso override per segnalare che sto ridefinendo il metodo. se sbaglio a ridefinire succede un errore di compilazione.
	public String toString() {
		//return "Evento: " + this.nome + " in data: " + this.data; //usando + sull'oggetto viene invocato il loro toString, permettendomi di fare questo. tuttavia stampa troppe cose. riduco sotto
		return "Evento: " + this.nome + " in data: " + this.data.getDate() + "/" + (this.data.getMonth()+1) + "/" + (this.data.getYear()+1900);
	}

	@Override
	public Evento clone() {
		return copiaEvento(0); //posso usare copiaEvento(0) in questo caso perchè crea un Evento identico ed è più facile da fare
	}

	@Override
	public boolean equals(Object o) {
		if(o == null) //se o nullo non saranno uguali
			return false;

		if (!(o instanceof Evento))
			return false; //se o non è un Evento non saranno ugali

		Evento tmpo = (Evento)o; //altrimenti cast di o a evento

		if(this.data.equals(tmpo.data) && this.nome.equals(tmpo.nome)) //controllo attributi
			return true;

		return false;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Inserisci data del primo evento");
		String[] sdate1 = s.next().split("/");
		int day1 = Integer.parseInt(sdate1[0]);
		int month1 = Integer.parseInt(sdate1[1])-1; //mesi vanno da 0
		int year1 = Integer.parseInt(sdate1[2])-1900; //anni vanno da 0 = 1900

		System.out.println("Inserisci nome del primo evento");
		String nome1 = s.next();

		Date data1 = new Date(year1, month1, day1);
		//data1.setDate(2); //se non uso clone nel costruttore questo cambia anche l'evento
		Evento evento1 = new Evento(data1, nome1);
		//evento1.getData().setDate(2); //se non uso clone nel costruttore questo cambia anche l'evento

		System.out.println("Inserisci data del secondo evento");
		String[] sdate2 = s.next().split("/");
		int day2 = Integer.parseInt(sdate2[0]);
		int month2 = Integer.parseInt(sdate2[1])-1; //mesi vanno da 0
		int year2 = Integer.parseInt(sdate2[2])-1900; //anni vanno da 0 = 1900

		System.out.println("Inserisci nome del secondo evento");
		String nome2 = s.next();

		Date data2 = new Date(year2, month2, day2);
		Evento evento2 = new Evento(data2, nome2);

		if(evento1.equals(evento2)) //il paragone deve essere fatto con equals
			System.out.println("I due eventi sono uguali");

		//test della copia
		Evento promemoria = evento1.copiaEvento(-5);
		System.out.println(promemoria);
	}
}