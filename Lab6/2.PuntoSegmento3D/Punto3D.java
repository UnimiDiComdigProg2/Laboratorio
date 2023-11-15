public class Punto3D extends Punto2D {

    final double z;

    public Punto3D(double x, double y, double z) {
    //MODIFIES: this
    //EFFECTS: inizializza this con super(x, y) + z
        super(x, y);

        this.z = z;
    }

    @Override
    public String toString() {
        return super.toString() + ", z: " + z;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;

        if(o == null)
            return false;

        if((o instanceof Punto3D)){

            Punto3D tmp = (Punto3D) o;

            if(this.x != tmp.x)
                return false;

            if(this.y != tmp.y)
                return false;

            if(this.z != tmp.z)
                return false;

            return true;
        }

        return super.equals(o);
    }

    public static void main(String[] args) {
        Punto3D p1 = new Punto3D(4, 5, 0);
        Punto3D p2 = new Punto3D(4, 5, 1);
        Punto2D p3 = new Punto2D(4,5);

        if(p1.equals(p2))
            System.out.println("sono uguali");
        else
            System.out.println("sono diversi");
    }
}