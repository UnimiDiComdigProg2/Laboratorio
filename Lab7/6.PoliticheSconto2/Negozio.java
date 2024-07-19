import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Negozio {

    private static PoliticaSconto parsePoliticaSconto(String str, int quantita, double costo) throws IllegalArgumentException {
    //EFFECTS: restituisce la politica sconto corrispondente alla stringa indicata, con il relativo numero articoli e prezzo articolo
    //         se la politica sconto non ha un codice valido lancia IllegalArgumentException
        String[] scontoArguments = str.split("-");
        PoliticaSconto sconto = null;
        switch (scontoArguments[0]){
            case "SQ":
                sconto = new ScontoQuantita(quantita, costo, Integer.parseInt(scontoArguments[1]), Double.parseDouble((scontoArguments[2])));
                break;
            case "SU":
                sconto = new UnoOgniNGratis(quantita, costo, Integer.parseInt(scontoArguments[1]));
                break;
            case "BF":
                sconto = new BlackFriday(quantita, costo);
                break;
            case "SA":
                sconto = new ScontoAmici(new ScontoQuantita(quantita, costo, Integer.MAX_VALUE, 1), Double.parseDouble(scontoArguments[1]));
                break;
            default:
                if (!(str.startsWith("SC[") && str.charAt(str.length()-1) == ']'))
                    throw new IllegalArgumentException("Sconto specificato in un formato errato");
                String[] split = str.substring(3, str.length()-1).split(",");
                sconto = new ScontoCombinato(parsePoliticaSconto(split[0], quantita, costo), parsePoliticaSconto(split[1], quantita, costo));
        }
        return sconto;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, PoliticaSconto> sconti = new HashMap<>();
        System.out.println("Inserisci righe nel formato `nome costo sconto quantita` (CTRL+D per terminare)");

        while (sc.hasNextLine()){
            String[] split = sc.nextLine().split(" ");
            String nome = split[0];
            double costo = Double.parseDouble(split[1]);
            int quantita = Integer.parseInt(split[3]);
            sconti.put(nome, parsePoliticaSconto(split[2], quantita, costo));
        }

        sc.close();

        System.out.println();
        System.out.println("Ecco gli sconti:");

        for (String nome : sconti.keySet()){
            PoliticaSconto ps = sconti.get(nome);
            double prezzoScontato = ps.getPrezzoArticolo()*ps.getNumeroArticoli()-ps.calcolaSconto();
            System.out.printf("%s - prezzo scontato: %.2f€\n", nome, prezzoScontato);
        }
    }
}
