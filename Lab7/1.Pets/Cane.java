public class Cane extends Pet {
//OVERVIEW: definisce un Pet Cane

	public Cane(String nome) {
		super(nome);
	}

	@Override
	public String verso() {
		return "bau";
	}

	@Override
	public String toString() {
		return "Cane: " + super.toString();
	}
}