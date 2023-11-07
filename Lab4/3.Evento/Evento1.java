import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public final class Evento {
//OVERVIEW: modella un Evento di una Agenda, con data e nome. Modelliamo il dato come immutabile
//          mi aspetto che un evento sia definito dalla sua data e nome. Con altra data e nome si tratta di un altro evento

	private final Date data;
	private final String nome;

//costruttori
	public Evento(Date data, String nome) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: inizializza un nuovo Evento con data e nome specificati
	//         se data o nome sono null oppure nome vuoto lancia IllegalArgumentException
		if(data == null)
			throw new IllegalArgumentException("Data nulla");

		if(nome == null)
			throw new IllegalArgumentException("Nome nullo");

		if(nome == "")
			throw new IllegalArgumentException("Nome vuoto");

		this.data = (Date)(data.clone());
		this.nome = nome;

		assert repOk();
	}

//methods
	public String getNome() {
		return this.nome;
	}

	public Date getData() {
		return (Date)(this.data.clone());
	}

	public Evento copiaEvento(int n) {
	// EFFECTS: restituisce un nuovo Evento a distanza n dal precedente
		Date newDate = new Date(this.data.getTime() + TimeUnit.DAYS.toMillis(n));
		
		return new Evento(newDate, this.nome);
	}

	private boolean repOk() {
		if(this.data == null)
			return false;

		if(this.nome == null)
			return false;

		if(this.nome.equals(""))
			return false;

		return true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Date newData = this.getData();
		String newNome = this.getNome();

		return new Evento(newData, newNome);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;

		if(!(obj instanceof Evento))
			return false;

		Evento tmpo = (Evento)obj;

		if(tmpo.data.equals(this.data) && tmpo.nome.equals(this.nome))
			return true;
		
		return false;
	}

	@Override
	public String toString() {
		return "Evento: (nome: " +this.nome + ", data: " + this.data.getDate() + "/" + (this.data.getMonth()+1) + "/" + (this.data.getYear()+1900) + ")";
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner s = new Scanner(System.in);

		System.out.println("Inserisci la data del primo evento");
		String[] dstr1 = s.next().split("/");
		int day1 = Integer.parseInt(dstr1[0]);
		int month1 = Integer.parseInt(dstr1[1])-1;
		int year1 = Integer.parseInt(dstr1[2])-1900;

		System.out.println("Inserisci il nome del primo evento");
		String nome1 = s.next();

		Evento e1 = new Evento(new Date(year1, month1, day1), nome1);
		System.out.println(e1);

		System.out.println("Inserisci la data del secondo evento");
		String[] dstr2 = s.next().split("/");
		int day2 = Integer.parseInt(dstr2[0]);
		int month2 = Integer.parseInt(dstr2[1])-1;
		int year2 = Integer.parseInt(dstr2[2])-1900;

		System.out.println("Inserisci il nome del secondo evento");
		String nome2 = s.next();

		Evento e2 = new Evento(new Date(year2, month2, day2), nome2);
		
		if(e1.equals(e2))
			System.out.println("stesso evento");
		else
			System.out.println("eventi diversi");
	}
}