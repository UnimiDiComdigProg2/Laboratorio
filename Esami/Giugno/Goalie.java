public class Goalie extends Player {
//OVERVIEW: models a Goalie
	private final double parry;

	public Goalie(String name, int number, double parry) {
	//MODIFIES: this
	//EFFECTS: initialize this
	//         throw IllegalArgumentException if parry < 0 or > 1
		super(name, number);

		if(parry < 0 || parry > 1)
			throw new IllegalArgumentException("ERR: parry < 0 or > 1");

		this.parry = parry;
	}

	public double getParry() {
		return parry;
	}

	@Override
	public String toString() {
		return super.toString() + " - portiere (parry: " + parry + ")";
	}
}