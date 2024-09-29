public class IngVol extends IngWgt {
//OVERVIEW: Ingredient by volume (immutable)

	public IngVol(String name, double vol) throws IllegalArgumentException{
	//MODIFIES: this
	//EFFECTS: initialize this
		super(name, vol);
	}

	@Override
	public String toString() {
		return name + " (" + wgt + "l)";
	}
}