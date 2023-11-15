public class Segmento3D implements Segmento {

    private final Punto3D a, b;

    public Segmento3D(Punto3D a, Punto3D b) {
    //MODIFIES: this
    //EFFECTS: inizializza this
    //         se a o b null lancia NullPointerException
    //         se a == b lancia IllegalArgumentException

        if(a == null)
            throw new NullPointerException("a null");

        if(b == null)
            throw new NullPointerException("b null");

        if(a.equals(b))
            throw new IllegalArgumentException("a equals b");

        this.a = a;
        this.b = b;
    }
  
    public Punto3D getA() {
        return a;
    }



    public Punto3D getB() {
        return b;
    }



    public double length() {
        return Math.sqrt(
            Math.pow(this.a.p.x - this.b.p.x, 2) +
            Math.pow(this.a.p.y - this.b.p.y, 2) +
            Math.pow(this.a.z - this.b.z, 2)
        );
    }
}
