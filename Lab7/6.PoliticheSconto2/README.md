# PoliticheSconto2

Modificare l'esercizio `7.PoliticheSconto` del `Laboratorio6` come segue:

* Ridefinire `PoliticaSconto` come interfaccia e modificare le altre classi di conseguenza.
* Definire una nuova `PoliticaSconto` chiamata `BlackFriday` che applichi uno sconto in percentuale pari alla data (es: `29%` per il giorno 29) nel mese di Novembre (Utilizzare la classe `LocalDate` ed il metodo now(), come visto nell'esercizio `5.Film` del `Laboratorio6`)
* Definire una nuova `PoliticaSconto` chiamata `ScontoAmici` che applichi al prodotto uno sconto in percentuale passato (in aggiunta a quelli già presenti) al costruttore della classe
* Ridefinire `ScontoCombinato` per avere un costruttore che riceva in input una Lista di oggetti che siano sottotipi di `PoliticaSconto`. Lo sconto calcolato dal metodo `calcolaSconto` sarà il massimo tra gli sconti passati al costruttore.

Scrivere una classe `Negozio` con un metodo `main()` per il testing della gerarchia di classi. A tal fine leggere da **standard input** una serie di prodotti nel formato `nome costo sconto`, dove `sconto` è una stringa nel formato:
* `SQ-n-m` per `ScontoQuantita`, dove `n` è il numero di prodotti e `m` è la percentuale di sconto
* `SU-n` per `UnoOgniNGratis`, dove `n` specifica il numero di prodotti che bisogna acquistare per averne uno gratis
* `BF` per `BlackFriday`
* `SA-m` per `ScontoAmici`, dove `m` è la percentuale di sconto da applicare
* `SC[sconto1,sconto2,...]` per `ScontoCombinato`, con diversi sconti inseriti come sopra.

Per ciascuna riga letta scrivere a **standard output** il prezzo del prodotto scontato.
