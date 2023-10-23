# Razionale

Progettare, specificare e implementare una classe `Razionale` che rappresenti un numero razionale con il suo numeratore (intero) ed il suo denominatore (intero, diverso da 0). La classe deve avere un costruttore (`Razionale(int num, int den)`), i metodi getter e setter per il numeratore ed il denominatore, ed un metodo `double valore()` che restituisca il rapporto fra il numeratore ed il denominatore. Si deve utilizzare un’eccezione `ArithmeticException` per garantire che il denominatore non sia mai uguale a `0`.

Implementare un metodo `main()` per il testing della classe. Il metodo deve leggere da **riga di comando** il numeratore ed il denominatore, e stampare a schermo il risultato di `getValue` se il denominatore è diverso da `0`, terminando con l'eccezione altrimenti

Ragionare sulle **Astrazioni** da utilizzare per i tipi di dati implementati e sulla loro **Rappresentazione**. Implementare gli appositi metodi **Funzione di Astrazione** ed **Invariante di Rappresentazione**. Usare la **Invariante di Rappresentazione** per garantire che il denominatore non sia mai uguale a `0`.

##### Esempio d'esecuzione:

```text
$ java Razionale 12 3
Il razionale e' 12/3 o 4.0

$ java Razionale 123 3
Il razionale e' 123/3 o 41.0

$ java Razionale 23 0
Exception in thread "main" java.lang.ArithmeticException: Denominatore del razionale e' zero
        at Razionale.setDenominatore(Razionale.java:31)
        at Razionale.<init>(Razionale.java:15)
        at Razionale.main(Razionale.java:64)
```
