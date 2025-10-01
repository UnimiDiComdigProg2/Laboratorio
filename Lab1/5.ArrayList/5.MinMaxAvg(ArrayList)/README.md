# Minimo, massimo e valor medio (ArrayList)

Scrivere un programma che riceva in input da **standard input** una sequenza di lunghezza arbitraria di valori interi e deve stampare a video il valore minimo, massimo e medio tra i valori letti.

Oltre al metodo `main`, devono essere definiti ed utilizzati almeno i seguenti metodi:
* `public static int minimo(ArrayList<Integer> in)` che restituisce il minimo valore intero presente in `in`.
* `public static int massimo(ArrayList<Integer> in)` che restituisce il massimo valore intero presente in `in`.
* `public static float media(ArrayList<Integer> in)` che restituisce un valore reale pari alla media aritmetica dei valori interi presenti in `in`.

##### Esempio d'esecuzione:

```text
$ java MinMaxAvg
Inserisci i numeri (Ctrl+D per terminare):
1
2
3
4
Minimo: 1
Massimo: 4
Valore medio: 2.5

$ java MinMaxAvg
Inserisci i numeri (Ctrl+D per terminare):
-1
10
6 
Minimo: -1
Massimo: 10
Valore medio: 5
```
