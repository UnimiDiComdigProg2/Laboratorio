# Numeri abbondanti

**Definizione**: Un numero naturale è abbondante se è inferiore alla somma dei suoi divisori propri (per esempio, `12` è abbondante perché la somma dei suoi divisori propri (`1`, `2`, `3`, `4`, `6`) è `16`).

Scrivere un programma che legga da **riga di comando** un numero intero `soglia` e stampi tutti i numeri abbondanti inferiori a `soglia`.
Se `soglia <= 0` il programma deve stampare `La soglia inserita non è positiva`.

Oltre al metodo `main()`, il programma deve specificare, implementare e utilizzare le seguenti **procedure parziali**:
* `public static List<Integer> elencoDivisoriPropri(int n)` che restituisce una `List` di `Integer` contenente tutti i divisori propri di `n`;
* `public static int sommaDivisoriPropri(int n)` che restituisce la somma dei divisori propri di `n`. Se `n` non ha divisori propri la funzione restituisce `0`;
* `public static boolean abbondante(int n)` che restituisce `true` se `n` è abbondante, `false` altrimenti;
* `public static List<Integer> numeriAbbondanti(int limite)` che restituisce tutti i numeri abbondanti inferiori a `limite`;
* `public static void stampaNumeriAbbondanti(List<Integer> numeri)` che stampa i numeri abbondanti trovati su **standard output**;

##### Esempio d'esecuzione:

```text
$ java abbondanti 20
Numeri abbondanti: 12 18

$ java abbondanti 30
Numeri abbondanti: 12 18 20 24

$ java abbondanti -3
La soglia inserita non è positiva
```