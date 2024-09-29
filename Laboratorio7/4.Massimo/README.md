# Massimo

Progettare, specificare ed implementare la classe generica `Massimo` nella quale si possano inserire, mediante un metodo `insert()`, oggetti di tipo specificato alla costruzione della classe. Un'istanza della classe terrà traccia dell'elemento più grande mai inserito, secondo l'ordine naturale di paragone tra gli oggetti, oppure in base ad un `Comparator` passato in fase di costruzione della classe. Testare la classe con un metodo `main()` che legga da **standard input** una serie di stringhe e cerchi di inserirle in due istanze di `Massimo`, una costruita senza un `Comparator`, l'altra costruita con un `Comparator<String>` secondo il quale una stringa è più grande se ha più lettere. Stampare su **standard output** il contenuto delle due istanze di `Massimo` come da esempio d'esecuzione.

#### Esempio d'esecuzione:

```text
$ java Massimo
Inserisci Stringhe (CTRL+D per terminare)
vado
al
massimo

Massimo (lessicografico): vado
Massimo (lunghezza): massimo
```
