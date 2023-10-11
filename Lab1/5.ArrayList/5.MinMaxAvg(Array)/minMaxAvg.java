import java.util.Arrays;
import java.util.Scanner;

public class minMaxAvg {

    public static int minimo(int[] arrayinteri){
        int minimo = Integer.MAX_VALUE;

        for (int i= 0; i < arrayinteri.length; i++) {
            if (arrayinteri[i]<minimo)
            minimo =arrayinteri[i];
                         
        }
        return minimo;

    }
    public static int massimo(int[] arrayinteri){
        int massimo = Integer.MIN_VALUE;

        for (int i= 0; i < arrayinteri.length; i++) {
            if (arrayinteri[i]>massimo)
            massimo =arrayinteri[i];
                         
        }
        return massimo;

    }

    public static float media(int[] arrayinteri){
        float media = 0;

     for (Integer value : arrayinteri) {
        media += value;
     }
      return media/arrayinteri.length;

    }



    public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    Scanner scan = new Scanner(System.in);
    int [] values = new int[n];
    
    for (int i = 0; i < values.length; i++) 
        values[i] = scan.nextInt();

    System.out.println("Stampo minimo " + minimo(values));
    System.out.println("Stampo minimo " + massimo(values));
    System.out.println("Stampo media " + media(values));

  scan.close();
        
    
 
    

    }
}
