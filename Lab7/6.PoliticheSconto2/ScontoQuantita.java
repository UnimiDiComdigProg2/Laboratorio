public class ScontoQuantita implements PoliticaSconto {
//OVERVIEW: sconto di percentuale s in base alla quantità minima m

//attributes
    public final int numeroArticoli;
    public final double prezzoArticolo;
    public final int minimo;
    public final double percentuale;

//constructors    
    public ScontoQuantita(int n, double p, int minimo, double percentuale) throws IllegalArgumentException {
    //MODIFIES: this
    //EFFECTS: inizializza this con numeroArticolo, prezzoArticolo, minimo e percentuale
    //         se p, n, minimo o percentuale <= 0 lancia IllegalArgumentException
        if (n <= 0 || p <= 0 || minimo <= 0 || percentuale <= 0)
            throw new IllegalArgumentException("numero articolo, prezzo, minimo o percentuale <= 0");

        this.numeroArticoli = n;
        this.prezzoArticolo = p;
        this.minimo = minimo;
        this.percentuale = percentuale;
    }

//methods
    @Override
    public double calcolaSconto() {
    //EFFECTS: restituisce lo sconto: se la quantità di un articolo acquistato è maggiore del minimo, lo sconto è di percentuale sul totale
    //         altrimenti lo sconto è pari a 0
        if (numeroArticoli > minimo)
            return prezzoArticolo*percentuale/100*numeroArticoli;
        
        return 0;
    }

    @Override
    public int getNumeroArticoli() {
       return numeroArticoli;
    }

    @Override
    public double getPrezzoArticolo() {
        return prezzoArticolo;
    }
    

    @Override
    public String toString() {
        return "ScontoQuantita (minimo: "+minimo+", percentuale: "+percentuale+") - articoli: "+ numeroArticoli + ", prezzo: " + prezzoArticolo + "€ , sconto: "+ calcolaSconto() + "€";
    }
}
