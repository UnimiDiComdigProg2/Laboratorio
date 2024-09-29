public class IngWgt extends Ingredient {
//OVERVIEW: Ingredient by weight (immutable)
	final double wgt;

	public IngWgt(String name, double wgt) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: initialize this
	//         if wgt <= 0 throw IllegalArgumentException
		super(name);

		if(wgt <= 0)
			throw new IllegalArgumentException("E:wgt <= 0");

		this.wgt = wgt;
	}

	public IngWgt merge(Ingredient i) {
		if(i == null)
			throw new IllegalArgumentException("E: i null");

		if(!i.getClass().equals(this.getClass()))
			throw new IngredientException("E:different ingredient type");

		if(!i.equals(this))
			throw new IngredientException("E:different ingredients");

		return new IngWgt(name, wgt+((IngWgt) i).wgt);
	}

	@Override
	public String toString() {
		return name + " (" + wgt + "kg)";
	}
}