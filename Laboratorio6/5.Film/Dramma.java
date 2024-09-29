import java.time.LocalDate;

public class Dramma extends Film {
// OVERVIEW: modella un film drammatico, sottotipo di film

	public Dramma(String nome, int codice, LocalDate data) throws NotValidFilmException {
	// MODIFIES: this
	// EFFECTS: inizializza this con nome, codice e data.
		super(nome, codice, data);
	}
}