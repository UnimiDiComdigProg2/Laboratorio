import java.util.ArrayList;
import java.util.Scanner;

public class Segmento2D implements Segmento {
//OVERVIEW: modella un segmento in 2D - Immutabile

    private final Punto2D a,b;

    public Segmento2D(Punto2D a, Punto2D b) throws IllegalArgumentException, NullPointerException {
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
        //this.a = (A) a.clone() //fossero stati mutabili
        this.b = b;
    }

    public Punto2D getA() {
        return a;
    }

    public Punto2D getB() {
        return b;
    }

    public double length() {
    //EFFECTS: restituisce la lunghezza del segmento
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    @Override
    public String toString() {
        return "Segmento: [" + a + " " + b + "] lunghezza: " + this.length();
    }

    public static void main(String[] args) {
        double lenmin = Double.parseDouble(args[0]);

        Scanner s = new Scanner(System.in);

        ArrayList<Segmento2D> list = new ArrayList<>();

        System.out.println("Inserisci i segmenti nel formato ax ay bx by (temina con CTRL+D)");
        while(s.hasNextLine()) {

            String line = s.nextLine();

            String[] parts = line.split(" ");
            
            list.add(
                new Segmento2D(
                    new Punto2D(Double.parseDouble(parts[0]), Double.parseDouble(parts[1])),
                    new Punto2D(Double.parseDouble(parts[2]), Double.parseDouble(parts[3]))
                )
            );
        }

        System.out.println("Segmenti di lunghezza superiore a " + lenmin);

        for(Segmento2D s2d : list)
           if(s2d.length() > lenmin)
                System.out.println(s2d); 
    }
}
