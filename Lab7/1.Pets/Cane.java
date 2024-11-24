public class Cane extends Pet {
//OVERVIEW: definisce un Pet Cane

	public Cane(String nome) {
		super(nome);
	}

	@Override
	void verso() {
		System.out.println(this.getNome() + " dice bau");
	}

	@Override
	public String toString() {
		return "Cane: " + super.toString();
	}
}