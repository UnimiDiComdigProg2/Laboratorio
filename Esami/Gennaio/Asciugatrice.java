public class Asciugatrice extends Macchina {
//OVERVIEW: concrete dryer

	public Asciugatrice(double cost) {
		super(cost);
	}

	@Override
	public String toString() {
		return "Asciugatrice" + super.toString();
	}
}