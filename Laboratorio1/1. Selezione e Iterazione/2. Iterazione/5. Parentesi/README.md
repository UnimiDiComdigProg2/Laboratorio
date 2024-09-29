# Parentesi

Scrivere un programma che legga da **riga di comando** una stringa composta da parentesi quadre aperte `[` e parentesi quadre chiuse `]`. Il programma stampa `bilanciata` se la stringa ha le parentesi bilanciate o `non bilanciata` altrimenti. Le parentesi sono bilanciate se a ogni parentesi aperta corrisponde una chiusa.
*NOTA*: È indispensabile mettere la stringa di parentesi tra virgolette per permetterne la lettura da **riga di comando**

##### Esempio d'esecuzione:
```text
$ java parentesi "[[]][]"
Bilanciate

$ java parentesi "[[]"
Non bilanciate

$ java parentesi "[[][]]"
Bilanciate

$ java parentesi "[]]["
Non bilanciate
```
