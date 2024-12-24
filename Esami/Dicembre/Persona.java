public class Persona extends Figura {
//OVERVIEW: Figura di una Persona del Presepio

	public Persona(String nome) {
	//MODIFIES: this
	//EFFECTS: inizializza una Figura di tipo Persona
	//         se nome non finisce in "re" lancia NomeException
		super(nome);

		if(!(getNome().endsWith("re")))
			throw new NomeException("\tEmergenza: " + nome + " non è una Figura Persona del presepio");
	}

	@Override
	public int valore() {
	//EFFECTS: il valore è la lunghezza del nome
		return getNome().length();
	}

	@Override
	public String toString() {
		return "Persona: " + super.toString();
	}
}