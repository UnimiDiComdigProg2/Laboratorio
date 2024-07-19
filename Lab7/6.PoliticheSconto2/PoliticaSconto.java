public interface PoliticaSconto {

    double calcolaSconto();
    //EFFECTS: restituisce lo sconto per l'acquisto di un certo numero di articoli tutti dello stesso tipo

    int getNumeroArticoli();

    double getPrezzoArticolo();

}
