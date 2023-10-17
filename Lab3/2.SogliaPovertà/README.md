# Soglia di povertà

Scrivere una classe `Famiglia` che modelli una famiglia con un certo numero di persone e un reddito complessivo. Oltre al metodo `main()` specificare e implementare i seguenti metodi:
* il **costruttore** `public Famiglia(double reddito, int dimensione) throws InputMismatchException` che inizializza un nuovo oggetto di tipo `Famiglia` e lancia una `InputMismatchException` se `dimensione` è non-positiva;
* il metodo `public boolean sottoSogliaPoverta(double costoCasa, double costoCibo) throws InputMismatchException` che restituisce `true` se la somma tra `costoCasa` e `costoCibo` (moltiplicato per la `dimensione` della famiglia) è maggiore della metà del `reddito` della famiglia (costoCibo è il costo medio mensile del cibo per ogni individuo, mentre costoCasa è unico mensile per la famiglia); Il metodo lancia una `InputMismatchException` se costoCasa o costoCibo non sono positivi;
* il metodo `public String toString()` ch ridefinisce il metodo `toString` del supertipo `Object` e restituisce una stringa contenente le informazioni della famiglia;

Il metodo `main()` deve leggere da **riga di comando** due numeri che definiscono rispettivamente il costo medio di vitto e di alloggio. Poi, da **standard input** dovrà leggere una serie di righe di testo costituite da reddito e dimensione di diverse famiglie, fermando la lettura quando l'utente preme la combinazione dei tasti `CTRL+D`. Dopo la lettura, visualizzare le famiglie che sono sotto la soglia di povertà.


##### Esempio d'esecuzione:

```text
$java Famiglia 400 500
Inserisci il reddito e la dimensione di una famiglia (Ctrl+D per terminare la lettura)
2000 4
Inserisci il reddito e la dimensione di una famiglia (Ctrl+D per terminare la lettura)
2500 5
Inserisci il reddito e la dimensione di una famiglia (Ctrl+D per terminare la lettura)
4000 2

2 famiglie sotto la soglia di povertà:
Famiglia 1: 4 persone con reddito complessivo di 2000.0
Famiglia 2: 5 persone con reddito complessivo di 2500.0
```
