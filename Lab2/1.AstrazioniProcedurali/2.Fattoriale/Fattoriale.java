import java.util.ArrayList;
import java.util.List;

public class Fattoriale {

    public static int fattoriale(int n) {
    //EFFECTS: restituisce il fattoriale di n
    //         se n è <= 0 restituisce 0
        int res = 1;

        for(int i = 1; i <= n; i++)
            res = res*i;

        return res;
    }

    public static List<Integer> listaFattoriali(int n) {
    //EFFECTS: restituisce una lista contenente tutti i fattoriali da 1 a n
    //         dove l'indice del fattoriale n è n-1
    //         se n è <= 0 restituisce una lista vuota
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            res.add(fattoriale(i));
        }
        
        return res;
    }

    public static void stampaFattoriali(List<Integer> lista) {
    //MODIFIES: System.out
    //EFFECTS: scrive a standard output lista (lista dei fattoriali)
    //         se la lista è nulla o vuota stampa a System.out "la lista è nulla o vuota"
        if(lista == null || lista.equals(""))
            System.out.println("la lista è nulla o vuota");

        for (int i = 0; i < lista.size(); i++)
            System.out.println(i + ": " + lista.get(i));
    }

    public static void main(String[] args) {

        stampaFattoriali(listaFattoriali(Integer.parseInt(args[0])));
        
    }
}
