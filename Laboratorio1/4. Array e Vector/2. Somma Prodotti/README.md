# Somma di prodotti

Scrivere un programma che legga da **riga di comando** una sequenza di lunghezza pari di numeri interi. Data la sequenza, il programma deve moltiplicare ciascun numero in una posizione di indice pari per il successivo numero in posizione di indice dispari e sommare i prodotti ottenuti. 

*Esempio:* Se `10 2 3 4 5 6` è la sequenza letta, allora la somma calcolata deve essere `10*2 + 3*4 + 5*6 = 62`.

Il programma deve infine stampare a video il valore della somma calcolata.
 
Oltre al metodo `main()`, deve essere definito ed utilizzato un metodo:
* `public static int calcola(int[] n)` che restituisce la somma dei prodotti ottenuti moltiplicando ciascun numero in una posizione di indice pari di `n` per il successivo numero in posizione di indice dispari.

##### Esempio d'esecuzione:

```text
$ java sommaProdotti 1 2 3 4 5 6
La somma è 44

$ java sommaProdotti 7 3 1 8
La somma è 29
```
