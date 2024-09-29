# TopN

Scrivere un programma che trovi gli `n` numeri più grandi, dove `n` è inserito da **riga di comando**, tra una serie di numeri inseriti da **standard input**.

A tal fine specificare, implementare e utilizzare le seguenti **procedure parziali**:

* `private static int[] readIntArray()` che legge da **standard input** una serie di almeno `n` numeri interi **diversi tra loro**, fino a quando con `ctrl+D` non viene terminata la lettura
* `public static int[] highest(int[] numbers, int n)` che calcola e restituisce un array con gli `n` interi più alti tra quelli inseriti a **standard input**
* `private static void printArray(int[] numbers)` che stampa a **standard output** l'array ottenuto dalla procedura precedente.

##### Esempio d'esecuzione:

```text
$java TopN 2
Inserisci almeno 2 numeri interi diversi tra loro (CTRL+D per terminare):
5
2
7
9
Numeri più alti: [ 9, 7 ]

$java TopN 1
Inserisci almeno 1 numeri interi diversi tra loro (CTRL+D per terminare):
734
8
3
22
2000
Numeri più alti: [ 2000 ]

```

In seguito, riflettete sulle seguenti questioni:
* È possibile rendere ciascuna **procedura totale**? Senza l'uso di **eccezioni**?
