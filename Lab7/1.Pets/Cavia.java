public class Cavia extends Pet {
//OVERVIEW: definisce un Pet Cavia

	public Cavia(String nome) {
		super(nome);
	}

	@Override
	void verso() {
		System.out.println(this.getNome() + " dice squit");
	}

	@Override
	public String toString() {
		return "Cavia: " + super.toString();
	}
}