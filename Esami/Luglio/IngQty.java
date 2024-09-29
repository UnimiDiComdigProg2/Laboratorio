public class IngQty extends Ingredient {
//OVERVIEW: Ingredient by quantity (immutable)
	final int qty;

	public IngQty(String name, int qty) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: initialize this
	//         if qty <= 0 throw IllegalArgumentException
		super(name);

		if(qty <= 0)
			throw new IllegalArgumentException("E:qty <= 0");

		this.qty = qty;
	}

	public IngQty merge(Ingredient i) {
		if(i == null)
			throw new IllegalArgumentException("E: i null");

		if(!i.getClass().equals(this.getClass()))
			throw new IngredientException("E:different ingredient type");

		if(!i.equals(this))
			throw new IngredientException("E:different ingredients");

		return new IngQty(name, qty+((IngQty) i).qty);
	}

	@Override
	public String toString() {
		return name + " (" + qty + ")";
	}
}