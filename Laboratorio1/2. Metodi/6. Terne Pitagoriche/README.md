# Terna pitagorica

**Definizione**: Se `a`, `b` e `c` sono numeri naturali e `a² + b² = c²`, si dice che la terna di numeri `a`, `b` e `c` è una terna pitagorica. 

Scrivere un programma che legga da **riga di comando** un intero `soglia>0` e stampi a video tutte le terne pitagoriche tali che `a<soglia`, `b<soglia` e `c<soglia`. 
 
Oltre al metodo `main()`, devono essere definiti ed utilizzati almeno i seguenti metodi:
* `public static boolean ternaPitagorica(int a, int b, int c)` che restituisce `true` se `c²` è uguale a `a² + b²` e `false` altrimenti;
* `public static void ternePitagoriche(int soglia)` che stampa tutte le terne pitagoriche inferiori a `soglia`; la funzione deve utilizzare la funzione `ternaPitagorica()`.

##### Esempio d'esecuzione:
 
```text
$ java ternePitagoriche 10
Terne pitagoriche:
(3, 4, 5)

$ java ternePitagoriche 20
Terne pitagoriche:
(3, 4, 5)
(5, 12, 13)
(6, 8, 10)
(8, 15, 17)
(9, 12, 15)
```