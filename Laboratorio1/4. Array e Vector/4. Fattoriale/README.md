# Fattoriale

**Definizione**: Si definisce fattoriale di un numero intero positivo, il prodotto dei numeri interi positivi minori o uguali a tale numero. Il fattoriale di `k` è uguale a `1*2*3*...*(k-3)*(k-2)*(k-1)*k`.

Scrivere un programma che legga da **riga di comando** un numero intero `n` e stampi a video il fattoriale di tutti i numeri compresi tra `1` e `n` (estremi inclusi).

Oltre al metodo `main()`, devono essere definiti ed utilizzati almeno i seguenti metodi:
*`public static List<Integer> Fattoriali(int n)` che restituisce una `List` nella quale, all'indice `0` è memorizzato il fattoriale di `1`, all'indice `1` il fattoriale di `2`, ..., all'indice `n-1` è memorizzato il fattoriale di `n`.

##### Esempio d'esecuzione:

```java fattoriale 2
Fattoriali:
1
2

$ java fattoriale 3
Fattoriali:
1
2
6

$ java fattoriali 10
Fattoriali:
1
2
6
24
120
720
5040
40320
362880
3628800
```
