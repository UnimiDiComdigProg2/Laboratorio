<<<<<<< HEAD
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
=======
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public final class Evento {
    //OVERVIEW:  classe che modella un evento di un calendario, definito da una data specificata e dal suo nome. Modelliamo il dato che immutabile
    //
    private final String nome;
    private final Date data;

    //construttore
    public Evento(Date data, String nome) throws IllegalArgumentException {
        //MODIFIES: this
        // EFFECTS: inizializza un evento  con data e nome specificati
        // se il nome è vuoto o la data o il nome sono null lancia una IllegalArgumentException

        if (data==null)
         throw new IllegalArgumentException("Data nulla");
        if (nome==null)
         throw new IllegalArgumentException("Nome nullo");
        if (nome=="")
         throw new IllegalArgumentException("Nome vuoto");

        this.nome=nome;
        this.data=(Date) (data.clone());

        assert repOk();

    }

    //metodi

    public String getNome() {
      return this.nome;
    }
    public Date getData() {
    return (Date) (this.data.clone());


    }

    public Evento copiaEvento (int offset) {
        //EFFECTS: restituisce un evneto nuovo a distanza di offset giorni
         Date newdata = new Date(this.data.getTime()+TimeUnit.DAYS.toMillis(offset));
         return new Evento(newdata, this.nome);

    }

private boolean repOk() {
    if ((this.data!= null)&& (this.nome!=null)&&(this.nome!=""))
     return true;
    return false;
}

     @Override
     public String toString(){

        return this.nome + " in data: " + this.data.getDate() + "/" + (this.data.getMonth()+1) + "/" + (this.data.getYear()+1900);
     }  

   
    public boolean  equals(Object o) {
        if (o==null) 
            return false;
        if (!(o instanceof Evento))
            return false;

        Evento tmpEvento = (Evento)o;
        if (this.data.equals(tmpEvento.data)&& this.nome.equals(tmpEvento.nome))
            return true;
    
    return false;

    }

    public static void main(String[] args) {
        Scanner tastiera = new Scanner (System.in);

        System.out.println ("Inserisci la data del primo evento: ");
        String[] stringData1 = tastiera.next().split("/");
        int giorno1 = Integer.parseInt(stringData1[0]);
        int mese1 = Integer.parseInt(stringData1[1])-1;
        int anno1 = Integer.parseInt(stringData1[2])-1900;

        System.out.println ("Inserisci il nome del primo evento: ");
        String nomeEvento1 = tastiera.next();
      
        Date dataEvento1 = new Date(anno1,mese1,giorno1);
        
        Evento Evento1 = new Evento(dataEvento1,nomeEvento1);
        Evento1.getData().setDate(2);

        System.out.println("Evento 1 è : "+ Evento1);

        System.out.println ("Inserisci la data del secondo evento: ");

        String[] stringData2 = tastiera.next().split("/");
        int giorno2 = Integer.parseInt(stringData2[0]);
        int mese2 = Integer.parseInt(stringData2[1])-1;
        int anno2 = Integer.parseInt(stringData2[2])-1900;

        System.out.println ("Inserisci il nome del secondo evento: ");
        String nomeEvento2 = tastiera.next();
      
        Date dataEvento2 = new Date(anno2,mese2,giorno2);
        Evento Evento2 = new Evento(dataEvento2,nomeEvento2);

        System.out.println("Evento 2 è : "+ Evento2);

        if (Evento1.equals(Evento2))
            System.out.println("I due eventi sono uguali");


        Evento promemoria = Evento1.copiaEvento(2);

 System.out.println("il promemoria è : "+ promemoria);



    }
    
}
>>>>>>> 6aead8b (ste)
