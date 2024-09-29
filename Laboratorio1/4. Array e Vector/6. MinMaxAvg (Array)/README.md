# Minimo, massimo e valor medio (Array)

Scrivere un programma che riceva in input da **riga di comando** un intero `n`.
Il programma deve leggere da **standard input** una sequenza di `n` valori interi e deve stampare a video il valore minimo, massimo e medio tra i valori letti.

Oltre al metodo `main`, devono essere definiti ed utilizzati almeno i seguenti metodi:
* `public static int minimo(int[] in)` che restituisce il minimo valore intero presente in `in`.
* `public static int massimo(int[] in)` che restituisce il massimo valore intero presente in `in`.
* `public static float media(int[] in)` che restituisce un valore reale pari alla media aritmetica dei valori interi presenti in `in`.

##### Esempio d'esecuzione:

```text
$ java min_max_media 4
1
2
3
4
Minimo: 1
Massimo: 4
Valore medio: 2.5

$ java min_max_media 3
-1
10
6 
Minimo: -1
Massimo: 10
Valore medio: 5

$ java min_max_media 3
-1
-2
-3
Minimo: -3
Massimo: -1
Valore medio: -2
```
