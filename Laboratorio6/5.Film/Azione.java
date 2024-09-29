import java.time.LocalDate;

public class Azione extends Film {
// OVERVIEW: modella un film di azione, sottotipo di Film (penale 3€)

// CONSTRUCTORS:
	public Azione(String nome, int codice, LocalDate data) throws NotValidFilmException {
	// MODIFIES: this
	// EFFECTS: inizializza this con nome, codice e data. Imposta penale a 3€
		super(nome, codice, data);
	}

	@Override
	public double getPenale() {// OBSERVER
		return 3;
	}
}
