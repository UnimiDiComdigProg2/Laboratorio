abstract class Player implements Cloneable, Comparable<Player> {
//OVERVIEW: models an abstract futsal Player
	private final String name;
	private final int number;

	public Player(String name, int number) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: initializes this
	//         throw IllegalArgumentException if name empty or null, or number is negative
		if(name == null || name.equals(""))
			throw new IllegalArgumentException("ERR: name null or empty");

		if(number < 0)
			throw new IllegalArgumentException("ERR: number < 0");

		this.name = name;
		this.number = number;
	}

	@Override
	public String toString() {
		return "[" + number + "] " + name;
	}

	@Override
	public Player clone() {
		try {
			return (Player) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	@Override
	public int compareTo(Player p) {
		if(p == null)
			throw new NullPointerException("ERR: p null");

		return Integer.compare(number, p.number);
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;

		if(!(o instanceof Player))
			return false;

		return ((Player) o).number == number;
	}
}