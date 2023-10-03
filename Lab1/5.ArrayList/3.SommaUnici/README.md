# Somma unici

Scrivere un programma che legga da **riga di comando** una sequenza di valori e stampi a video la somma dei valori letti che rappresentano numeri interi e che compaiono nella sequenza una sola volta.

Oltre al metodo `main()`, devono essere definiti ed utilizzati i seguenti metodi:
* `public static ArrayList<Integer> leggiNumeri()` che restituisce una `ArrayList` nella quale sono memorizzati i valori numerici interi specificati a **riga di comando**;
* `public static int occorrenze(ArrayList<Integer> numeri, int n)` che restituisce un valore `int` pari al numero di occorrenze di `n` in `numeri`.

##### Esempio d'esecuzione:

```text
$ java SommaUnici 1 2 % 4 3 2 1 5
12

$ java SommaUnici 4 3 5 4 2 2 3 2
5

$ java SommaUnici 1 2 sarà zero 1 2
0

$ java SommaUnici 1 2 3 2 2 2
4

$ java SommaUnici che 10 4 7 12 4 12 sfortuna
17
``` 
