import java.util.HashMap;
import java.util.Map;
import java.lang.IllegalArgumentException;

public class NumeriRomani {

    // Per rendere la procedura totale usiamo le eccezioni.
    // Ci sono due casi che dobbiamo controllare
    // 1: se il numero è superiore al massimo valore rappresentabile
    // 2: se il numero è minore di 0
    // In entrambi i casi il controllo è poco costoso e semplice quindi lo facciamo subito
    // Dobbiamo ricordarci di rimuovere i REQUIRES e di adattare gli EFFECTS
    public static String dec2roman(int n) throws IllegalArgumentException {
    // EFFECTS: return a String representing decimal number n as roman number;
    //          if n is lesser than 0 or greater than 3999 throws NumberFormatException

        if(n<=0) // È un controllo molto semplice, lo possiamo fare subito e senza costo.
            throw new IllegalArgumentException("Cannot accept non-positive numbers");

        if(n>3999) // Posso usare un solo tipo di eccezione dando messaggi diversi
            throw new IllegalArgumentException("Cannot accept numbers greater than 3999");

        int curr = n;
        String res = "";

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanValues = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        for (int i = 0; i<values.length; i++) {
            while(curr-values[i]>=0) {
                curr-=values[i];
                res+=romanValues[i];
            }
        }

        return res;
    }

    // Qua il controllo è più difficile perchè devo scorrere tutti i simboli,
    // verificando per ciascuno se è valido, altimenti devo lanciare un'eccezione
    // Ma per la procedura stessa li devo scorrere tutti quindi il controllo è gratis
    // Anche qua dobbiamo ricordarci di rimuovere i REQUIRES e di adattare gli EFFECTS
    public static int roman2dec(String n) throws IllegalArgumentException {
    // EFFECTS: Returns an decimal representation of the roman number.
    //          If it is not a valid roman number throws IllegalArgumentException

        int res = 0;

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("I",1);
        map.put("IV",4);
        map.put("V",5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC",90);
        map.put("C",100);
        map.put("CD",400);
        map.put("D",500);
        map.put("CM",900);
        map.put("M",1000);

        int i = 0;
        while (i < n.length()) {
            if (i<n.length()-3 && (n.substring(i, i+2).equals(n.substring(i+2, i+4)))){
                throw new IllegalArgumentException("Not a valid roman number");
            }

            if (i<n.length()-1 && map.get(n.substring(i, i+2)) != null) {
                res+=map.get(n.substring(i, i+2));
                i+=2;
            } else if (map.get(n.substring(i, i+1)) != null) {
                res+=map.get(n.substring(i, i+1));
                i++;
            } else { //invece di restituire -1 lanciamo l'eccezione
                throw new IllegalArgumentException("Not a valid roman number");
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int dec = 0; //devo fare questo perchè poi ci servirà fuori dal blocco try.

        try {
        // In questo try metto solo la istruzione parseInt
        // Se mettessi anche dec2roman dovrei catturare anche la IllegalArgumentException
        // MA ATTENZIONE NumberFormatException è sottoclasse di IllegalArgumentException
        // Rischio di gestire l'eccezione nel blocco sbagliato!
        // Per questo è utile fare try minimali!

            dec = Integer.parseInt(args[0]);

        } catch (NumberFormatException e) { // Se quello che ho letto non è un intero...

            try { // ...allora provo a vedere se è un romano...

                System.out.println(roman2dec(args[0])); // ...e nel caso stampo la conversione.
                System.exit(0); //se ho finito esco.

            } catch (IllegalArgumentException f) { // Se anche questo lancia l'eccezione...

                System.out.println("Neither decimal nor roman"); // ...allora non era neanche romano
                // Notate che non stampo il messaggio dell'eccezione che mi è stato restituito in f
                // Perchè il significato dell'errore è diverso! Infatti non solo non è romano...
                // ...ma non è neanche decimale. Sapendo questa cosa è utile gestire l'errore qua...
                // ...e non in roman2dec. Si tratta di un uso buono di Reflection!

                System.exit(0); //se ho finito esco.
            }
        }

        try { // Arrivo qua solo se la conversione a intero è andata bene

            System.out.println(dec2roman(dec)); // Provo a fare dec2roman e stampare il risultato

        } catch(IllegalArgumentException e) { // Ci sono 2 casi di eccezione, ma gestiti con un solo tipo

            System.out.println(e.toString()); // Uso il loro messaggio per comunicare all'utente
            // Potrei fare la stampa dell'eccezione dentro dec2roman visto che già uso il suo messaggio
            // In tal caso si tratterebbe di una forma di Masking
            // (anche se effettivamente non lancerei neanche l'eccezione)
            // Non lo faccio perchè:
            // 1. mi alzerebbe la complessità del metodo dec2roman (va contro la Minimalità)
            // 2. farebbe fare a dec2roman anche la stampa (va contro la Semplicità)
            // 3. la gestione dell'output sarebbe frammentata tra main e dec2roman...
            // ... invece voglio che l'output sia gestito in un posto solo (Modularità)
        }
    }
}
