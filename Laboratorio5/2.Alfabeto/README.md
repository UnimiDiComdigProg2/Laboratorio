# Alfabeto

Progettare, specificare e implementare un Iteratore standalone `Alfabeto` che a ogni nuova chiamata di `next()` restituisca una successiva lettera dell'alfabeto.
La classe deve prevedere un costruttore (oltre a quello default), che accetti in ingresso la lettera iniziale e la lettera finale della sequenza, gestendo opportunamente le eventuali eccezioni.

Implementare un metodo `main()` per il testing della classe. Il metodo deve poter leggere da **riga di comando** due caratteri (se inseriti) e stampare a schermo le lettere dell'alfabeto tra i due caratteri.

##### Esempio d'esecuzione:

```text
$ java Alfabeto c f
c
d
e
f

$ java Alfabeto 1 x
primo carattere non valido

$ java Alfabeto z c
la prima lettera è successiva alla seconda
```
