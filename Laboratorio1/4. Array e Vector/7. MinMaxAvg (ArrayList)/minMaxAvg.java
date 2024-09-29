import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class minMaxAvg {

    public static void main(String[] args) {

        List<Integer> values = new ArrayList<Integer>(); //nuovo ArrayList. Uso come tipo List che è l'interfaccia implementata da ArrayList (e altri). Uso le generics per restringere il tipo di dato a Integer
        //posso omettere <Integer> nel new ma avrò un warning durante la compilazione

        Scanner s = new Scanner(System.in); //prima mi diceva che s non è mai chiuso. Me ne potevo infischiare perchè c'è il garbage collector ma stavolta faccio il bravo

        while(s.hasNextInt()) { //uso hasNextInt per verificare se c'è un valore nuovo. Per terminare la lettura devo usare Ctrl+D
            values.add(s.nextInt()); //uso nextInt per recuperare il nuovo valore inserito e lo aggiungo all'ArrayList
        }

        System.out.println("Minimo: " + minimo(values));
        System.out.println("Massimo: " + massimo(values));
        System.out.println("Media: " + media(values));

        s.close(); //chiudo lo scanner per liberare un po' di risorse.
    }

    public static int minimo(List<Integer> in) {

        int min = Integer.MAX_VALUE;
        for (int i=0;i<in.size();i++) { //for classico. uso il metodo size() per sapere la dimensione della List.
            if(in.get(i) < min) { //uso il metodo get per prendere il valore della List all'indice i
                min = in.get(i); //qua sto facendo unboxing da Integer a int!
            }
        }

        return min;
    }

    public static int massimo(List<Integer> in) {

        int max = Integer.MIN_VALUE;
        for (Integer value : in) { //funziona benissimo anche for each
            if(value > max) {
                max = value.intValue(); //prendo proprio l'int usando intValue(), senza casting implicito. Essendoci l'unboxing non serve a molto..
            }
        }

        return max;
    }

    public static float media(List<Integer> in) {

        float media = 0;
        Iterator<Integer> i = in.iterator(); //posso anche usare un iterator. Uso le generics per restringere il tipo di dato a Integer
        while (i.hasNext()) { //hasNext() restituisce true finchè ci sono elementi che l'iteratore può fornire
            media += i.next(); //prendo il prossimo elemento
        }

        return media/in.size();
    }
}