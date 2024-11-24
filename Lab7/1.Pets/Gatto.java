public class Gatto extends Pet {
//OVERVIEW: definisce un Pet Gatto

	public Gatto(String nome) {
		super(nome);
	}

	@Override
	void verso() {
		System.out.println(this.getNome() + " dice miao");
	}

	@Override
	public String toString() {
		return "Gatto: " + super.toString();
	}
}