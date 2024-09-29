# Numeri perfetti

**Definizione**: Un numero naturale è perfetto se è uguale alla somma dei suoi divisori propri (per esempio, `6` è perfetto perché `6 = 1 + 2 + 3`).

Scrivere un programma che legga da **riga di comando** un numero intero `n` e stampi se `n` è perfetto oppure no.

Oltre al metodo `main()`, il programma deve definire e utilizzare i seguenti metodi:
* `public static int sommaDivisoriPropri(int n)` che restituisce la somma dei divisori propri di `n`. Se `n` non ha divisori propri il metodo restituisce `0`;
* `public static boolean perfetto(int n)` che restituisce `true` se `n` è perfetto e `false` altrimenti, utilizzando il metodo `sommaDivisoriPropri()`.

##### Esempio d'esecuzione:

```text
$ java perfetti 0
0 non è perfetto

$ java perfetti 1
1 non è perfetto

$ java perfetti 6
6 è perfetto

$ java perfetti 28
28 è perfetto
```
