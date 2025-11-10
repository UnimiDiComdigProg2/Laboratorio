public abstract class Solido implements Comparable<Solido> {
//OVERVIEW: modella un solido (ASTRATTO,IMMUTABILE)

    public abstract double volume();
    //EFFECTS: restituisce il volume del solido;

    @Override
    public int compareTo(Solido o) {
        //return this.volume() - o.volume();

        return Double.compare(this.volume(), o.volume());
        
    }

    @Override
    public String toString() {
        return "SOLIDO (" + this.volume() + ")"
    }

    
}
