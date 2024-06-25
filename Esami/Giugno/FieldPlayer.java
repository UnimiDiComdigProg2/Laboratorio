public class FieldPlayer extends Player {
//OVERVIEW: models a FieldPlayer (not a Goalie)
	private final int def;
	private final int atk;

	public FieldPlayer(String name, int number, int atk, int def) {
	//MODIFIES: this
	//EFFECTS: initialize this
	//         throw IllegalArgumentException if def or atk <= 0
		super(name, number);

		if(def < 1 || def > 10)
			throw new IllegalArgumentException("ERR: def < 0 or > 10");

		if(atk < 0 || atk > 10)
			throw new IllegalArgumentException("ERR: atk < 0 or > 10");

		this.atk = atk;
		this.def = def;
	}

	public int getDef() {
		return def;
	}

	public int getAtk() {
		return atk;
	}

	@Override
	public String toString() {
		return super.toString() + " - giocatore di campo (atk:" + atk + ", def:" + def + ")";
	}
}