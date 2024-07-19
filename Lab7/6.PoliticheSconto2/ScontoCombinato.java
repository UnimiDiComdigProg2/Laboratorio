public class ScontoCombinato implements PoliticaSconto {
//OVERVIEW: massimo tra due politiche sconto

//attributes
    public final PoliticaSconto a, b;

//constructors
    public ScontoCombinato(PoliticaSconto a, PoliticaSconto b) throws IllegalArgumentException {
    //MODIFIES: this
    //EFFECTS: inizializza this con a e b
    //         se a o b sono nulli lancia IllegalArgumentException
    //         se numero articolo o prezzo articolo sono diversi in a e b lancia IllegalArgumentException
        if (a == null) throw new IllegalArgumentException("a è nullo");
        if (b == null) throw new IllegalArgumentException("b è nullo");
        if(a.getNumeroArticoli() != b.getNumeroArticoli() || a.getPrezzoArticolo() != b.getPrezzoArticolo())
            throw new IllegalArgumentException("numero articolo o prezzo articolo diversi in a e b");

        this.a = a;
        this.b = b;
    }

//methods
    public double calcolaSconto() {
    //EFFECTS: restituisce il valore massimo restituito da calcolaSconto per ognuna delle sue politiche di sconto private
        return Double.max(a.calcolaSconto(), b.calcolaSconto());
    }

    @Override
    public int getNumeroArticoli() {
       return a.getNumeroArticoli();
    }

    @Override
    public double getPrezzoArticolo() {
        return a.getPrezzoArticolo();
    }

    @Override
    public String toString() {
        return "ScontoCombinato=" + calcolaSconto() + "\n\t" + a + "\n\t" + b;
    }

}
