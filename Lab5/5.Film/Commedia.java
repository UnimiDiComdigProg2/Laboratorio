import java.time.LocalDate;

public class Commedia extends Film {
//OVERVIEW: modella un film comico, sottotipo di Film (penale 2.5€)

	public Commedia(String nome, int codice, LocalDate data) throws NotValidFilmException {
	//MODIFIES: this
	//EFFECTS: inizializza this con nome, codice e data.
		super(nome, codice, data);
	}

	@Override
	public double getPenale() {
		return 2.5;
	}
}