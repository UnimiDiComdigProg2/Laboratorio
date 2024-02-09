public class Lavatrice extends Macchina {
//OVERVIEW: concrete Washer

	public Lavatrice(double cost) {
		super(cost);
	}

	@Override
	public String toString() {
		return "Lavatrice" + super.toString();
	}
}