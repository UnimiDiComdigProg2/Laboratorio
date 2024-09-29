# Radice quadrata

Scrivere un programma che legga da **riga di comando** un numero reale `n` e stampi a video il valore della radice quadrata di `n` solo se `n > 0`. Se `n <= 0` il programma deve stampare `Il valore inserito non appartiene al dominio della funzione`.

Oltre al metodo `main()`, il programma deve definire e utilizzare il seguente metodo:
* `public static double radiceQuadrata(double numero)` che restituisce il valore della radice quadrata di `numero`, se `numero>0`, altrimenti restituisce un valore reale `0`.

*NOTA:* per calcolare la radice quadrata potete usare il metodo `sqrt()` della classe `java.lang.Math`

##### Esempio d'esecuzione:

```text
$ java radice 10
Radice quadrata: 3.1622776601683795

$ java radice 4
Radice quadrata: 2

$ java radice -1
Il valore inserito non appartiene al dominio della funzione
```