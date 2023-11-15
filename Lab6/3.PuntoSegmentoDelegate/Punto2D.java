public class Punto2D implements Punto {
//OVERVIEW modella un punto in 2D - immutabile
    public final double x,y;

    public Punto2D(double x, double y) {
    //MODIFIES: this
    //EFFECTS: inizializza this con x e y
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Punto - x: " + this.x + ", y: " + this.y;
    }

    @Override
	public boolean equals(Object o) {
        if(this == o)
            return true;

        if(o == null)
            return false;

        if(!(o instanceof Punto2D))
            return false;

        Punto2D tmp = (Punto2D) o;

        if(this.x != tmp.x)
            return false;

        if(this.y != tmp.y)
            return false;

        return true;
    }
}