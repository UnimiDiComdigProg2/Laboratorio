import java.time.LocalDate;

public class BlackFriday implements PoliticaSconto {
//OVERVIEW: sconto di di numerogiorno% se il mese è novembre
    
//attributes
    public final int numeroArticoli;
    public final double prezzoArticolo;

//constructor
    public BlackFriday(int n, double p) throws IllegalArgumentException {
        //MODIFIES: this
        //EFFECTS: inizializza this con numeroArticolo, prezzoArticolo, minimo e percentuale
        //         se p o n <= 0 lancia IllegalArgumentException
            if (p <= 0 || n <= 0)
                throw new IllegalArgumentException("numero articolo o prezzo <= 0");
            
            this.numeroArticoli = n;
            this.prezzoArticolo = p;
    }

//methods
    @Override
    public double calcolaSconto() {
    //EFFECTS: restituisce lo sconto in percentuale pari alla data nel mese di Novembre
    //         se il mese non è novembre restituisce 0
        if (LocalDate.now().getMonth() != java.time.Month.NOVEMBER)
            return 0;
        
        return LocalDate.now().getDayOfMonth()*numeroArticoli*prezzoArticolo/100;
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
        return "BlackFriday - articoli: "+ numeroArticoli + ", prezzo: " + prezzoArticolo + "€ , sconto: "+ calcolaSconto() + "€";
    }
}
