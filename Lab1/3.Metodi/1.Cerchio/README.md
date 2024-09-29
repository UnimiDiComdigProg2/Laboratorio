# Cerchio

Scrivere un programma che legga da **riga di comando** un numero reale `raggio` e stampi i valori di circonferenza e area di un cerchio di raggio `raggio`.

Oltre al metodo `main()`, il programma deve definire e utilizzare i seguenti metodi:
* `public static double CalcolaArea(double raggio)` che restituisce il valore dell'area del cerchio associato;
* `public static double CalcolaCirconferenza(double raggio)` che restituisce il valore della circonferenza del cerchio associato.

NOTA: per convertire dalla stringa letta a double, potete utilizzare il metodo `parseDouble()` della classe `Double`

##### Esempio d'esecuzione:

```text
$ java Cerchio 10.5
Area del cerchio: 346.36059005827474
Circonferenza del cerchio: 65.97344572538566

$ java Cerchio 3.6
Area del cerchio: 40.71504079052372
Circonferenza del cerchio: 22.61946710584651
```
