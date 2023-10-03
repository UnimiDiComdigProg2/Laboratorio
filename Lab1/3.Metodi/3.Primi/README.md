# Numeri primi

Scrivere un programma che legga da **riga di comando** un numero intero `soglia` e stampi tutti i numeri primi inferiori a `soglia`.
Se `soglia <= 0` il programma deve stampare `La soglia inserita non è positiva`. 

Oltre al metodo `main()`, il programma deve definire e utilizzare i seguenti metodi:
* `public static boolean primo(int n)` che restituisce `true` se `n` è primo e `false` altrimenti;
* `public static void numeriPrimi(int limite)` che stampa tutti i numeri primi inferiori a `limite`, utilizzando il metodo `primo`

##### Esempio d'esecuzione:

```text
$ java Primi -3
La soglia inserita non è positiva

$ java Primi 5
Numeri primi inferiori a 5
2 3 

$ java Primi 12
Numeri primi inferiori a 12
2 3 5 7 11
```
