import java.util.HashMap;
import java.util.Map;

public class NumeriRomani {

    // Per fare questa procedura pensiamo a come sono costituiti i numeri romani.
    // Intanto possiamo dire che sono solamente positivi,
    // quindi dovremmo limitare la procedura a input positivi.
    // Ci sono dei simboli singoli che hanno un valore fisso,
    // e coppie in cui al simbolo più grande viene sottratto uno più piccolo che lo precede.
    // Per semplificarci la vita possiamo trattare anche queste coppie come dei simboli.
    // Che tipo di dato potremmo utilizzare? Per caratteri singoli avremmo detto char,
    // Essendoci le coppie usiamo String. Associamo a ciascun simbolo un valore usando 2 array.
    // Sappiamo che da sinistra verso destra i simboli vanno dal più grande al più piccolo.
    // A questo punto facciamo una sorta di "conversione di base":
    // Partendo dal simbolo più grande, se possiamo sottrarre il suo valore dal numero n,
    // vuol dire che ci sarà quel simbolo e lo aggiungiamo al risultato.
    // Se non possiamo sottrarre, passiamo al successivo.
    // Arrivati a 0 vuol dire che abbiamo trovato tutti i simboli

    public static String dec2roman(int n) {
    // REQUIRES: n is positive and less than 3999
    // EFFECTS: return a String representing decimal number n as roman number;

        int curr = n; // Teniamo traccia di quanto ci rimane ogni volta che sottraiamo un simbolo
        String res = ""; // Creiamo una stringa risultato per ora vuota

        // Dato che dovrò trovare il simbolo dato il suo valore uso due array
        // Questi tengono rispettivamente i simboli e i valori dei numeri romani base
        // Gli indice dei due array danno la corrispondenza numero-simbolo
        String[] romanValues = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        for (int i = 0; i<values.length; i++) { // Per tutti i simboli, dal più grande al più piccolo
            while(curr-values[i]>=0) { // Finchè posso, sottraggo il valore del simbolo
                curr-=values[i];
                res+=romanValues[i]; // E aggiungo il simbolo nella sequenza
            }
        }

        return res; // Ritorno la sequenza finale
    }

    // Per fare la procedura inversa facciamo il ragionamento inverso
    // Guardiamo la stringa del numero romano da sinistra verso destra,
    // e ogni volta che troviamo un simbolo (di uno o due caratteri),
    // sommiamo il suo valore al totale, che poi sarà il risultato.
    public static int roman2dec(String n) {
    // REQUIRES: String is a valid roman number.
    // EFFECTS: Returns an decimal representation of the roman number.
    // DURANTE LA SCRITTURA DEL MAIN: togliere il REQUIRES e aggiungere in EFFECTS:
    //          If the string is not a valid roman number return -1

        int res = 0; // Creiamo un valore di ritorno per ora = 0

        // Qua devo fare l'opposto di prima, devo trovare il valore dato un simbolo.
        // Per fare questo usiamo una Map (HashMap precisamente).
        // Funziona in maniera simile a una mappa di GO.
        // Posso chiedere un elemento con una chiave e se non c'è ottengo null
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
        while (i < n.length()) { //finchè ho qualcosa nella stringa (partendo da sinistra)
            if (i<n.length()-1 && map.get(n.substring(i, i+2)) != null) { // Se ho simboli di due caratteri validi
                res+=map.get(n.substring(i, i+2)); // Prendo il loro valore e lo aggiungo al risultato
                i+=2; //mi sposto di due caratteri
            } else if (map.get(n.substring(i, i+1)) != null) { // Altrimenti se ho simboli di un carattere valido
                // Notate che potrei usare un semplice else sopra perchè sto assumendo che il numero romano sia valido
                res+=map.get(n.substring(i, i+1)); // Prendo il loro valore e lo aggiungo al risultato
                i++; // Mi sposto di un carattere
            } else { //DURANTE LA SCRITTURA DEL MAIN scrivere questo per gestire la selezione tra romani e interi
                return -1;
              }
        }

        return res; // Ritorno il risultato finale
    }

    public static void main(String[] args) {
    // Qua mi trovo davanti ad un problema.
    // Come faccio ad assicurarmi che l'utente inserisca o un intero o un numero romano valido?
    // E quindi come posso decidere se invocare dec2roman o roman2dec?
    // Senza usare le eccezioni diventa molto difficile.
    // Potrei trasformare roman2dec in una procedura totale
    // Dovrei restituire un valore negativo se il numero romano non è valido
    // A quel punto se non è un numero romano sarà decimale e posso provare parseInt
    // Se non è neanche intero avrò una NumberFormatException.
    // Quindi mi tocca usare le eccezioni comunque
    
        int n = roman2dec(args[0]); //inizio a vedere se posso convertire da romano a decimale

        if(n >= 0) { //se la conversione è andata bene

            System.out.println(n); //lo stampo

        } else { //se la conversione non è andata bene

            int dec = Integer.parseInt(args[0]); //provo a convertire la stringa in intero
            System.out.println(dec2roman(dec)); //e se va bene faccio conversione dec2roman

            //se non va bene ci sarà un crash con NumberFormatException
            //Senza gestire le eccezioni non posso dire all'utente che i valori inseriti non vanno bene

            //inoltre ci sono dei comportamenti imprevedibili se inserisco un numero <= 0 o > 3999
            //posso gestirli con dei controlli nel main ma diventano troppe cose di cui tenere traccia nel main

            //Allora addattiamo questo programma a usare le eccezioni (6.Eccezioni/6.Romano)
        }
    }
}
