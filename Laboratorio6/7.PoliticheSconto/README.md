# PoliticaSconto

Progettare, specificare ed implementare una classe astratta `PoliticaSconto` con un solo metodo `calcolaSconto` che restituirà lo sconto per l’acquisto di un certo numero di articoli tutti dello stesso tipo. La classe ha due attributi, `numeroArticoli` e `prezzoArticolo`.

Si derivi una classe `ScontoQuantita` da `PoliticaSconto`. Essa dovrebbe avere un costruttore con due parametri, `minimo` e `percentuale`. Inoltre, dovrebbe ridefinire il metodo calcolaSconto in modo che se la quantità di un articolo acquistato è maggiore del `minimo`, lo sconto è di `percentuale` sul totale.

Si derivi una classe `UnoOgniNGratis` da `PoliticaSconto`. La classe dovrebbe avere un costruttore che ha un singolo parametro `n`. In più, la classe dovrebbe ridefinire il metodo `calcolaSconto` così che ogni n-esimo articolo sia gratis. 

Si derivi una classe `ScontoCombinato` da `PoliticaSconto`. Questa dovrebbe avere un costruttore con due parametri di tipo `PoliticaSconto`. Si dovrebbe ridefinire il metodo `calcolaSconto` per restituire il valore massimo restituito da `calcolaSconto` per ognuna delle sue politiche di sconto private.

Scrivere una classe di test per verificare il funzionamento corretto della classe.