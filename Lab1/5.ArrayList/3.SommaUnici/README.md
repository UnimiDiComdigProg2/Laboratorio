# Somma unici

Scrivere un programma che legga da **standard input** una sequenza di valori e stampi a video la somma dei valori letti che rappresentano numeri interi e che compaiono nella sequenza una sola volta.

Oltre al metodo `main()`, deve essere definito ed utilizzato il seguente metodo:
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
