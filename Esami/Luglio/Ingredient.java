abstract class Ingredient implements Cloneable, Comparable<Ingredient> {
//OVERVIEW: models an immutable abstract Ingredient
	final String name;

	public Ingredient(String name) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: initializes this
	//         if name null throw IllegalArgumentException
		if(name == null || name.equals(""))
			throw new IllegalArgumentException("E:name null or empty");

		this.name = name;
	}

	public Ingredient merge(Ingredient i) throws UnsupportedOperationException, IllegalArgumentException, IngredientException {
	//EFFECTS: returns new Ingedient that merges i and this
	//         if i null throw IllegalArgumentException
	//         if ingredients have different name or type throw IngredientException
	//         if not supported (default) throw UnsupportedOperationException
		throw new UnsupportedOperationException("E: Recipes cannot be merged");
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Ingredient i) {
		return name.compareTo(i.name);
	}

	@Override
	public Ingredient clone() {
		try {
			return (Ingredient) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Ingredient))
			return false;

		return ((Ingredient) o).name.equals(name);
	}
}