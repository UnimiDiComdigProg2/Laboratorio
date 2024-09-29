import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ArrayList<Percorso> ap = new ArrayList<>();

        Percorso p = new Percorso();

        ap.add(p);

        while(s.hasNext()) {
            String tipoTratta = s.next();

            try {
                switch (tipoTratta) {
                    case "TrattaTreno":
                        p.aggiungi(new TrattaTreno(s.next(), s.next(), s.nextDouble(), s.nextDouble(), s.nextDouble()));
                        break;
                    case "TrattaBus":
                        p.aggiungi(new TrattaBus(s.next(), s.next(), s.nextDouble(), s.nextDouble(), s.nextDouble()));
                        break;
                    case "TrattaAereo":
                        p.aggiungi(new TrattaAereo(s.next(), s.next(), s.nextDouble(), s.nextDouble(), s.nextDouble(), s.nextDouble()));
                        break;
                    case "-":
                        p = new Percorso();
                        ap.add(p);
                        break;
                }
            } catch(TrattaNonValidaException e) {
                System.out.println(e.getMessage());
            }
        }

        ap.sort(null);

        for (Percorso pe : ap) {
            System.out.println(pe);

            for (Tratta tratta : pe)
                System.out.println("\t"+tratta);
        }
    }
}
