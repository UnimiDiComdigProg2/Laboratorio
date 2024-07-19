public class UnoOgniNGratis implements PoliticaSconto {
//OVERVIEW: ogni e-simo prodotto gratis

//attributes
    public final int numeroArticoli;
    public final double prezzoArticolo;
    public final int n;

//constructors
    public UnoOgniNGratis(int articoli, double p, int n) throws IllegalArgumentException {
    //MODIFIES: this
    //EFFECTS: inizializza this con numeroArticolo, prezzoArticolo, minimo e percentuale
    //         se p, n o articoli <= 0 lancia IllegalArgumentException
        if (n <= 0 || p <= 0 || articoli <= 0)
            throw new IllegalArgumentException("numero articoli, prezzo o n <= 0");
        
        this.numeroArticoli = articoli;
        this.prezzoArticolo = p;
        this.n = n;
    }

//methods    
    @Override
    public double calcolaSconto() {
    //EFFECTS: calcola lo sconto in modo che ogni n-esimo articolo sia gratis
        return numeroArticoli/this.n*prezzoArticolo;
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
        return "UnoOgniNGratis (ogni:" + n + ") - articoli: "+ numeroArticoli + ", prezzo: " + prezzoArticolo + "€ , sconto: "+ calcolaSconto() + "€";
    }
    
}
