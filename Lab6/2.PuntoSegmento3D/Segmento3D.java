import java.util.ArrayList;
import java.util.Scanner;

public class Segmento3D extends Segmento2D {
//OVERVIEW: Segmento 3D ottenuto estendendo segmento 2D

    public Segmento3D(Punto3D a, Punto3D b) throws IllegalArgumentException, NullPointerException {
        super(a, b);
    }

    @Override
    public Punto3D getA() {
        return (Punto3D) super.getA();
    }

    @Override
    public Punto3D getB() {
        return (Punto3D) super.getB();
    }
    
    @Override
    public double length() {
        return Math.sqrt(
            Math.pow(this.getA().x - this.getB().x, 2) +
            Math.pow(this.getA().y - this.getB().y, 2) +
            Math.pow(this.getA().z - this.getB().z, 2)
        );
    }

    public static void main(String[] args) {
        double lenmin = Double.parseDouble(args[0]);

        Scanner s = new Scanner(System.in);

        ArrayList<Segmento3D> list = new ArrayList<>();

        System.out.println("Inserisci i segmenti nel formato ax ay az bx by bz (temina con CTRL+D)");
        while(s.hasNextLine()) {

            String line = s.nextLine();

            String[] parts = line.split(" ");
            
            list.add(
                new Segmento3D(
                    new Punto3D(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]), Double.parseDouble(parts[2])),
                    new Punto3D(Double.parseDouble(parts[3]), Double.parseDouble(parts[4]), Double.parseDouble(parts[5]))
                )
            );
        }

        System.out.println("Segmenti di lunghezza superiore a " + lenmin);

        for(Segmento3D s3d : list)
           if(s3d.length() > lenmin)
                System.out.println(s3d); 
    }
}