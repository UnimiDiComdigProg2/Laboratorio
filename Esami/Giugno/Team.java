import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Team implements Iterable<Player> {
//OVERVIEW: models a futsal Team
	private final String name;
	private ArrayList<Player> l = new ArrayList<>();

	public Team(String name) throws IllegalArgumentException {
	//MODIFIES: this
	//EFFECTS: initialize this
	//         throw IllegalArgumentException if name empty or null
		if(name == null || name.equals(""))
			throw new IllegalArgumentException("ERR: name null or empty");

		this.name = name;
	}

	public void add(Player p) throws IllegalArgumentException, TeamException {
	//MODIFIES: this
	//EFFECTS: adds p to l
	//         throw IllegalArgumentException if p null
	//         throw TeamException if Goalie exists, FieldPlayer over 3, or p contained in l
		if(p == null)
			throw new IllegalArgumentException("ERR: p null");

		if(p instanceof Goalie)
			if(countPlayers(Goalie.class) > 0)
				throw new TeamException("ERR: Goalie exists");

		if(p instanceof FieldPlayer)
			if(countPlayers(FieldPlayer.class) > 3)
				throw new TeamException("ERR: too many FieldPlayers");

		if(l.contains(p))
			throw new TeamException("ERR: number exists");

		l.add(p.clone());

		assert repOK();
	}

	public int countPlayers() {
	//EFFECTS: returns number of players
		return l.size();
	}

	private int countPlayers(Class c) {
	//REQUIRES: c is Player or any Subclass
	//EFFECTS: returns number of players of type c
		int i = 0;
		for(Player p : l)
			if(p.getClass().equals(c))
				i++;

		return i;
	}

	public int score(Team t) throws IllegalArgumentException, TeamException {
	//EFFECTS: returns goals scored  to t
	//         throw IllegalArgumentException if t null 
	//         throw TeamException if t or this not complete
		if(t == null)
			throw new IllegalArgumentException("ERR: t null");

		if(t.l.size() != 5 || l.size() != 5)
			throw new TeamException("ERR: incomplete teams");

		int i = 0;
		for(Player p : l)
			if(p instanceof FieldPlayer)
				i += ((FieldPlayer) p).getAtk();

		for(Player p : t)
			if(p instanceof FieldPlayer)
				i -= ((FieldPlayer) p).getDef();

		return (int) (i*(1-t.getGoalie().getParry()));
	}

	private Goalie getGoalie() throws TeamException {
	//EFFECTS: return Goalie
	//         throw TeamException if none
		for(Player p : l)
			if(p instanceof Goalie)
				return (Goalie) p;

		throw new TeamException("ERR: no Goalie");
	}

	@Override
	public Iterator<Player> iterator() {
		l.sort(null);

		return new Iterator<Player>() {
			Iterator<Player> i = l.iterator();

			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public Player next() {
				return i.next();
			}
		};
	}

	@Override
	public String toString() {
		String res = "Squadra: " + name + "\n";

		for(Player p : this)
			res += "\t" + p + "\n";

		return res;
	}
	
	public boolean repOK() {
		if(name == null || name.equals(""))
			return false;

		if(l.size() > 5)
			return false;

		if(countPlayers(Goalie.class) > 1)
			return false;

		if(countPlayers(FieldPlayer.class) > 4)
			return false;

		for(Player p : l)
			if(l.indexOf(p) != l.lastIndexOf(p))
				return false;

		return true;
	}
}