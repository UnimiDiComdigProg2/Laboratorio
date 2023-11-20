public abstract class Solido implements Comparable<Solido> {
//OVERVIEW: modella un Solido Astratto, comparabile

	public abstract String tipo();
	//EFFECTS: restituisce una stringa con il tipo del solido

	public abstract double volume();
	//EFFECTS: restituisce il volume del solido

	@Override
	public int compareTo(Solido o) {
		return Double.compare(this.volume(),o.volume());
	}
}