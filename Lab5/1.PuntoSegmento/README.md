# PuntoSegmento

Un `Punto2d` modella un punto in due dimensioni su numeri razionali. Due punti sono uguali se hanno le stesse coordinate.
Un `Segmento2d` collega due istanze di `Punto2D` e può restituire la propria lunghezza attraverso un metodo `length()`.

Progettare, specificare ed implementare le classi descritte ed i loro metodi. Quando opportuno, le classi dovranno avere costruttori, Abstraction Function e Representation Invariant, ed eventuali altri metodi o ridefinizioni dei metodi di classi estese o interfacce implementate. Dovranno esserci i controlli opportuni ed eventuali lanci di eccezioni appropriate.

Scrivere i metodi `main()` per testare `Punto2d` e `Segmento2d`. Il metodo `main()` di `Punto2d` dovrà inizializzare tre punti: due con le stesse coordinate e uno con coordinate diverse, e poi scrivere su **standard output** i punti stessi e il loro confronto per uguaglianza.
Il metodo `main()` di `Segmento2d` dovrà leggere un numero razionale `n` da **riga di comando** e una serie di segmenti nel formato `ax ay bx by` da **standard input**, stampando su **standard output**, tra tutti i segmenti, quelli con `length() > n`, come da esempio di esecuzione.

##### Esempio d'esecuzione:

```text
$ java Segmento2D 6.5
Inserisci i segmenti nel formato ax ay bx by (temina con CTRL+D)
0 1 4 6
-2.5 7 3 3
4 -1 2.5 8
0 0 5 0
3 6 3 -1
7 -0.3 4 5
Segmenti di lunghezza superiore a 6.5
Segmento: [Punto - x: -2.5, y: 7.0; Punto - x: 3.0, y: 3.0] lunghezza: 6.800735254367722
Segmento: [Punto - x: 4.0, y: -1.0; Punto - x: 2.5, y: 8.0] lunghezza: 9.12414379544733
Segmento: [Punto - x: 3.0, y: 6.0; Punto - x: 3.0, y: -1.0] lunghezza: 7.0
```
