public class Cavia extends Pet {
//OVERVIEW: definisce un Pet Cavia

	public Cavia(String nome) {
		super(nome);
	}

	@Override
	public String verso() {
		return "squit";
	}

	@Override
	public String toString() {
		return "Cavia: " + super.toString();
	}
}