import java.util.Iterator;
import java.util.ArrayList;

public class Mappa implements Iterable<Guerriero> {
//OVERVIEW: Mappa di gioco

//attributes
	final int w,h;
	private ArrayList<Guerriero> l = new ArrayList<>();

//constructors
	public Mappa(int w, int h) {
	//MODIFIES: this
	//EFFECTS: initializza Mappa
		if(w < 1 || h < 1)
			throw new IllegalArgumentException("w o h < 1");

		this.w = w;
		this.h = h;
		
		assert repOk();
	}

//methods
	private boolean occupied(int x, int y) {
	//EFFECTS: true se esiste p in m con x y, false altrimenti
		for(Guerriero g : l)
			if(g.getX() == x && g.getY() == y)
				return true;

		return false;
	}

	public Guerriero getGuerriero(String nome) {
	//EFFECTS: restituisce Guerriero con nome se esiste, null altrimenti
		if(nome == null || nome.equals(""))
			throw new IllegalArgumentException("nome null o vuoto");

		for (Guerriero g : l)
			if(g.nome.equals(nome))
				return g;

		return null;
	}

	public void crea(Guerriero g) throws CharException, MapException {
	//MODIFIES: this
	//EFFECTS: aggiungi g a this; se null lancia IllegalArgumentException. Se g esiste lancia CharException. Se coordinate errate lancia MapException.
		if(g == null)
			throw new IllegalArgumentException("g null");

		if(l.contains(g))
			throw new CharException("Guerriero esiste");

		if(g.getX() < 0 || g.getX() >= this.w || g.getY() < 0 || g.getY() >= this.h)
			throw new MapException("Coordinate errate");

		if(occupied(g.getX(), g.getY()))
			throw new MapException("Coordinate occupate");

		this.l.add(g);
	}

	public void muovi(String s, int x, int y) throws CharException, MapException {
	//MODIFIES: Guerriero con nome s
	//EFFECTS: muovi g a nuove coordinate. Se troppo distante o coordinate errate lancia MapException. Se morto lancia CharException
		Guerriero g = getGuerriero(s);

		if(g == null)
			throw new IllegalArgumentException("g null");

		if(g.pv == 0)
			throw new CharException(g.nome+" incapacitato");

		if(x < 0 || x >= this.w || y < 0 || y >= this.h)
			throw new MapException("Coordinate errate");

		if(occupied(x, y))
			throw new MapException("Coordinate occupate");

		if(Math.abs(g.getX()-x)+Math.abs(g.getY()-y) > 2)
			throw new MapException("Troppo distante");

		g.muovi(x,y);
	}
	
	public void attacca(String s1, String s2) throws MapException, CharException {
	//MODIFIES: Guerrieri con nome s1 e s2
	//EFFECTS: s1 attacca s2
		getGuerriero(s1).attacca(getGuerriero(s2));
	}

	@Override
	public Iterator<Guerriero> iterator() {
		l.sort(null);

		return new Iterator<Guerriero>() {
			Iterator<Guerriero> i = l.iterator();

			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public Guerriero next() {
				return i.next();
			}
		};
	}

	public boolean repOk() {
		for (Guerriero g : l)
			if(g == null)
				return false;

		return true;
	}

	@Override
	public String toString() {
		String res = "\nPersonaggi sulla mappa:";
		for (Guerriero g : this)
			res+="\n\t" + g;
		return res;
	}
}