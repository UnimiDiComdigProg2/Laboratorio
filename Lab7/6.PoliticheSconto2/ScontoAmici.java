public class ScontoAmici implements PoliticaSconto {
//OVERVIEW: applica uno sconto aggiuntivo alla politica fornita

//attributes
    public final PoliticaSconto politicaSconto;
    public final double percentuale;

//constructors
    public ScontoAmici(PoliticaSconto politica, double percentuale){
    //MODIFIES: this
    //EFFECTS: inizializza this con politica e percentuale
    //         se politica è null lancia NullPointerException
    //         se percentuale è <= 0 lancia IllgalArgumentException
        if (politica == null) throw new NullPointerException("politica sconto nulla");
        if (percentuale <= 0) throw new IllegalArgumentException("percentuale <= 0");

        this.politicaSconto = politica;
        this.percentuale = percentuale;
    }

//methods
    @Override
    public double calcolaSconto() {
    //EFFECTS: calcola lo sconto aggiungendo lo sconto in percentuale a quello già applicato dalla politica sconto
        return (politicaSconto.getPrezzoArticolo()*politicaSconto.getNumeroArticoli()*percentuale/100)+politicaSconto.calcolaSconto();
    }

    @Override
    public int getNumeroArticoli() {
        return politicaSconto.getNumeroArticoli();
    }

    @Override
    public double getPrezzoArticolo() {
        return politicaSconto.getPrezzoArticolo();
    }

    @Override
    public String toString() {
        return "Sconto amici: - articoli: "+ politicaSconto.getNumeroArticoli() + ", prezzo: " + politicaSconto.getPrezzoArticolo() + "€ , sconto: "+ calcolaSconto() + "€";
    }
    
}
