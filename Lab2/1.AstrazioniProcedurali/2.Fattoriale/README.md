# Fattoriale

**Definizione**: Si definisce fattoriale di un numero intero positivo, il prodotto dei numeri interi positivi minori o uguali a tale numero. Il fattoriale di `k` è uguale a `1*2*3*...*(k-3)*(k-2)*(k-1)*k`.

Scrivere un programma che legga da **riga di comando** un numero intero `n` e stampi a video il fattoriale di tutti i numeri compresi tra `1` e `n` (estremi inclusi).

Oltre al metodo `main()`, devono essere specificate, implementate ed utilizzate almeno le seguenti **procedure totali**:
* `public static int fattoriale(int n)` che restituisce il fattoriale del numero `n`
* `public static List<Integer> listaFattoriali(int n)` che restituisce una `List` nella quale, all'indice `0` è memorizzato il fattoriale di `1`, all'indice `1` il fattoriale di `2`, ..., all'indice `n-1` è memorizzato il fattoriale di `n`.
* `public static void stampaFattoriali(List<Integer> lista)` che stampa a **standard output** la lista dei fattoriali trovata al punto precedente.

##### Esempio d'esecuzione:

```text
$ java Fattoriale 2
Fattoriali:
1: 1
2: 2

$ java Fattoriale 3
Fattoriali:
1: 1
2: 2
3: 6

$ java Fattoriali 10
Fattoriali:
1: 1
2: 2
3: 6
4: 24
5: 120
6: 720
7: 5040
8: 40320
9: 362880
10: 3628800
```
