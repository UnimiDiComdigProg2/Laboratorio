public class Gatto extends Pet {
//OVERVIEW: definisce un Pet Gatto

	public Gatto(String nome) {
		super(nome);
	}

	@Override
	public String verso() {
		return "miao";
	}

	@Override
	public String toString() {
		return "Gatto: " + super.toString();
	}
}