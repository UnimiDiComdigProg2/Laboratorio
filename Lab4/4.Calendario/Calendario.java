import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Calendario {
//OVERVIEW: classe che definisce un Valendario composto da una serie di date e una serie di eventi per data

	HashMap<Date,List<Evento>> cal;

	public Calendario() {
	//EFFECTS: inizializza un nuovo Calendario vuoto
		this.cal = new HashMap<Date,List<Evento>>();
	}

	public boolean esiste(Evento e) {
	//EFFECTS: restituisce true se esiste l'Evento e, false altrimenti
		if(this.cal.containsKey(e.getData()))
			 if(this.cal.get(e.getData()).contains(e))
				 return true;

		return false;
	}

	public void insert(Evento e) throws NullPointerException, IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: aggiunge Evento e a this
	//         se Evento e null, lancia una NullPointerException
	//         se Evento e è già presente lancia una IllegalArgumentException
		if(e == null)
			throw new IllegalArgumentException("Evento nullo");

		if(!(this.cal.containsKey(e.getData())))
			this.cal.put(e.getData(),new ArrayList<Evento>());

		if(this.cal.get(e.getData()).contains(e))
			throw new IllegalArgumentException("Evento già presente");

		this.cal.get(e.getData()).add(e);

		assert repOk();
	}

	public void delete(Evento e) {
	//MODIFIES: this
	//EFFECTS: rimuove Evento e da Date d in this
	//         se Evento e null, lancia una NullPointerException
	//         se Evento e non è presente lancia una IllegalArgumentException
		if(e == null)
			throw new IllegalArgumentException("Evento nullo");

		if(!(this.cal.containsKey(e.getData())))
			throw new IllegalArgumentException("Data non esiste");

		if(!(this.cal.get(e.getData()).contains(e)))
			throw new IllegalArgumentException("Evento non esiste");

		this.cal.get(e.getData()).remove(e);

		if(this.cal.get(e.getData()).size() == 0) //se nella data non ci sono più eventi
			this.cal.remove(e.getData()); //si rimuove la data

		assert repOk();
	}

	public List<Evento> getEventsForDate(Date d) {
	//EFFECTS: restituisce una List di Evento per Date d
	//         se Date d è null, lancia una IllegalArgumentException
	//         se Date d non esiste lancia una IllegalArgumentException
		if(d == null)
			throw new IllegalArgumentException("Data nulla");

		if(!(this.cal.containsKey(d)))
			throw new IllegalArgumentException("Data non esiste");

		//return this.cal.get(d); //così rimane da fuori un accesso alla lista della data
		return new ArrayList<>(this.cal.get(d));
	}

	public void copyEvent(Evento e, int offset) {
	//MODIFIES: this
	//EFFECTS: aggiungi nuovo Evento a this che sia una copia dell'Evento e in data scostata di offset
	//         se Evento e è null, lancia una IllegalArgumentException
		if(e == null)
			throw new IllegalArgumentException("Evento nullo");

		this.insert(e.copiaEvento(offset));

		assert repOk();
	}

	@Override
	public String toString() {
		String ret = "Calendario:\n";

		for(Date d : this.cal.keySet())
			for(Evento e : this.cal.get(d))
				ret += "\t" + e + "\n";

		return ret;
	}

	public boolean repOk() {
		if(this.cal == null)
			return false;

		for(Date d : this.cal.keySet())
			for(int i=0;i<this.cal.get(d).size();i++)
				for(int j=i+1;j<this.cal.get(d).size();i++)
					if(this.cal.get(d).get(i).equals(this.cal.get(d).get(j)))
						return false;

		return true;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		Calendario cal = new Calendario();

		System.out.println("Inserisci +/-/* NomeEvento gg/mm/aaaa [offset]");
		while(s.hasNext()) {
			char cmd = s.next().charAt(0);
			String nome = s.next();
			String[] sdate = s.next().split("/");
			int day = Integer.parseInt(sdate[0]);
			int month = Integer.parseInt(sdate[1])-1;
			int year = Integer.parseInt(sdate[2])-1900;

			Date data = new Date(year, month, day);
			Evento evento = new Evento(data, nome);

			switch(cmd) {
				case '*':
					int offset = s.nextInt();
					cal.copyEvent(evento, offset);
					break;
				case '+':
					cal.insert(evento);
					break;
				case '-':
					cal.delete(evento);
					break;
			}
		}

		System.out.println(cal);
	}
}