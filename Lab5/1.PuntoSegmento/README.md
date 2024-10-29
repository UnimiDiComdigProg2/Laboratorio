# PuntoSegmento

Progettare, specificare ed implementare una classe `Punto2d` che modella un punto in due dimensioni, `x` e `y`, su numeri razionali.
Progettare, specificare ed implementare una classe `Segmento2d` utilizzando la classe Punto2D. Oltre ai metodi di utilità definire un metodo `length()` che ritorna la lunghezza del segmento. Scrivere un metodo `main()` per testare `Segmento2d` che legga un numero razionale `n` da **riga di comando** e una serie di segmenti nel formato `ax ay bx by` da **standard input**, stampando, tra tutti i segmenti, quelli con `length() > n`, come da esempio di esecuzione.

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
