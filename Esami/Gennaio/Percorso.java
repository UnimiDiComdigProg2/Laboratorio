import java.util.ArrayList;
import java.util.Iterator;

public class Percorso implements Comparable<Percorso>, Iterable<Tratta> {
//OVERVIEW: modella un Percorso costituito da una serie di tratte

//attributi
    private ArrayList<Tratta> tratte = new ArrayList<>();

//costruttori non servono

//metodi
    public void aggiungi(Tratta t) throws IllegalArgumentException, TrattaNonValidaException {
    //MODIFIES: this
    //EFFECTS: aggiunge t a this
    //         se t == null lancia IllegalArgumentException
    //         se t non continua il percorso (t.origine != destinazione ultima tratta del percorso) lancia una TrattaNonValidaException

        if(t == null)
            throw new IllegalArgumentException("tratta nulla");

        if(tratte.size() > 0)
            if(!(tratte.get(tratte.size()-1).getDst().equals(t.getOri())))
                throw new TrattaNonValidaException("tratta non continua il percorso");

        tratte.add(t);

        assert repOk();
    }

    public boolean repOk() {

        Tratta lastTratta = null;
        for(Tratta tratta : tratte) {
            if(tratta == null)
                return false;
            
            if(lastTratta != null)
                if(!(lastTratta.getDst().equals(tratta.getOri())))
                    return false;
            
            lastTratta = tratta;
        }

        return true;
    }

    public double durata() {
    //EFFECTS: calcula durata percorso come somma durata delle tratte
        double durataTot = 0;

        for(Tratta tratta : tratte)
            durataTot += tratta.durata();

        return durataTot;
    }

    public double co2prodotta() {
    //EFFECTS: calcula quantità di co2 prodotta dal percorso come somma delle quantita di co2 prodotta dalle tratte
        double co2tot = 0;

        for(Tratta tratta : tratte)
            co2tot += tratta.co2prodotta();

        return co2tot;
    }

    @Override
    public int compareTo(Percorso o) {
        if(this.durata() > o.durata())
            return 1;

        if(this.durata() < o.durata())
            return -1;
        
        return 0;
    }

    @Override
    public String toString() {
        return "\nPercorso (durata: "+this.durata()+", co2: "+this.co2prodotta()+")";
    }

    @Override
    public Iterator<Tratta> iterator() {
        return new Iterator<Tratta>() {

            Iterator<Tratta> i = tratte.iterator();

            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public Tratta next() {
                return i.next();
            }
        };
    }
}