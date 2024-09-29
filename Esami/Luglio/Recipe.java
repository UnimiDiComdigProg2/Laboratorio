import java.util.ArrayList;
import java.util.Iterator;

public class Recipe extends Ingredient implements Iterable<Ingredient> {
//OVERVIEW: Recipe that processes ingredients
	private ArrayList<Ingredient> l = new ArrayList<>();
	private final String proc;

	public Recipe(String name, String proc) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: initialize this
	//         if proc null or empty throw IllegalArgumentException
		super(name);

		if(proc == null || proc.equals(""))
			throw new IllegalArgumentException("E: proc null or empty");

		this.proc = proc;
	}

	public void add(Ingredient i) throws IllegalArgumentException, IngredientException {
	//MODIFIES: this
	//EFFECTS: add i to l. if l contains i merge l.i and i
	//         if i is null or empty throw IllegalArgumentException
	//         if l.i and i cannot be merged throw IngredientException
		if(i == null)
			throw new IllegalArgumentException("E:i is null");

		if(l.contains(i))
				l.set(l.indexOf(i),l.get(l.indexOf(i)).merge(i));
		else
			l.add(i.clone());

		assert repOk();
	}

	private ArrayList<Ingredient> base() {
	//EFFECTS: returns a list of base ingredients recursively added for every sub-recipe
		Recipe tmp = new Recipe("tmp","tmp");

		for(Ingredient i : l)
			if(i.getClass() != Recipe.class)
				tmp.add(i);
			else
				for(Ingredient j : ((Recipe) i).base())
					tmp.add(j);

		return tmp.l;
	}

	@Override
	public Iterator<Ingredient> iterator() {
		ArrayList<Ingredient> t = base();
		t.sort(null);

		return new Iterator<Ingredient>() {
			Iterator<Ingredient> i = t.iterator();

			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public Ingredient next() {
				return i.next();
			}
		};
	}

	@Override
	public String toString() {
		String res = "\n" + super.toString() + " - ingredienti: \n";

		for(Ingredient i : l)
			res+="\t" + i + "\n";

		res+="\nprocedura (" + super.toString() + "):\n" + proc + "\n";

		return res;
	}

	public boolean repOk() {
		for(Ingredient i : l)
			if(i == null)
				return false;
			else if(l.indexOf(i) != l.lastIndexOf(i))
				return false;

		return true;
	}
}