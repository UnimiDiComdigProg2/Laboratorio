import java.time.LocalDate;
import java.time.Period;

abstract class Film {
// OVERVIEW: classe astratta immutabile che modella un film con il suo nome, codice e la data di noleggio

// Attributi
	private final int codice;
	private final String nome;
	private final LocalDate dataNoleggio;

// Costruttori
	public Film(String nome, int codice, LocalDate data) throws NotValidFilmException {
	// MODIFIES: this
	// EFFECTS: inizializza this con nome, codice e data;
	//          se nome è nullo o vuoto o data è nulla, lancia NotValidFilmException
		if(nome == null)
			throw new NotValidFilmException("Nome nullo");
		if(nome.equals("") )
			throw new NotValidFilmException("Nome vuoto");
		if(data == null)
			throw new NotValidFilmException("Data nulla");
		if(data.isAfter(LocalDate.now()))
			throw new NotValidFilmException("Data nel futuro");

		this.codice = codice;
		this.nome = nome;
		this.dataNoleggio = data;
		assert repOk();
	}

// Metodi concreti
	public int getCodiceIdentificativo() { // OBSERVER
		return codice;
	}

	public LocalDate getDataNoleggio() {// OBSERVER
		return dataNoleggio;
	}

	public String getNome() {// OBSERVER
		return nome;
	}

	public double getPenale() {// OBSERVER
		return 2;
	}

	public boolean repOk() { // REPRESENTATION INVARIANT
		return !(this.getDataNoleggio() == null || this.getNome().equals("") || this.getNome() == null || this.dataNoleggio.isAfter(LocalDate.now()));
	}

	@Override
	public String toString() {// ABSTRACTION FUNCTION: C ---> A
		return "Titolo del film: " + getNome() + ", data del noleggio: " + getDataNoleggio();
	}

	public double calcolaPenaleRitardo() throws IllegalArgumentException { // OBSERVER
	// EFFECTS: restituisce la penale totale per questo film che è il prodotto tra i giorni di ritardo e la penale giornaliera del film.
		int ritardo = Period.between(this.dataNoleggio,LocalDate.now()).getDays() - 7;
		
		if(ritardo > 0)
			return ritardo * this.getPenale();

		return 0;
	}
}