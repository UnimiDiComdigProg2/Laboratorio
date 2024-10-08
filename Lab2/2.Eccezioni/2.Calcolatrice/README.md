# Calcolatrice

Scrivere un programma che legga da **standard input** un numero reale, `a`, un simbolo di operazione aritmetica (`+`, `-`, `*` o `/`), ed un secondo numero reale `b`.
Il programma deve calcolare e stampare su **standard output** il risultato dell'operazione specificata tra i due numeri. Se l'operatore non è riconosciuto il programma invece deve stampare `Operatore non riconosciuto`. Similmente, se un operando non è un numero reale, il programma deve stampare `Gli operandi devono essere numeri reali` e se non ci sono tutti gli input deve stampare `Non sono stati inseriti tutti gli input richiesti`. Trattare questi casi eccezionali utilizzando le opportune eccezioni. Inoltre,definire almeno il metodo `public static double calculate(double o1, double o2, char op) throws InputMismatchException` che calcola il risultato dell'operazione, lanciando una `InputMismatchException` se l'operatore inserito non è valido.

Cosa succede se si cerca una divisione per `0`? Trattare questo caso creando una nuova eccezione `DivisionByZeroException` che estende `ArithmeticException`. In tal caso stampare `Non è possibile dividere per 0`.

##### Esempio d'esecuzione:

```text
$ java calcolatrice
Inserisci <operando1> <operatore> <operando2>. es: 4 + 3
3.1 + 6.0
Il risultato è 9.1

$ java calcolatrice
Inserisci <operando1> <operatore> <operando2>. es: 4 + 3
4 - 2
Il risultato è 2.0

$ java calcolatrice
Inserisci <operando1> <operatore> <operando2>. es: 4 + 3
10 * 4.5
Il risultato è 45.0

$ java calcolatrice
Inserisci <operando1> <operatore> <operando2>. es: 4 + 3
10 / 2
Il risultato è 5.0

$ java calcolatrice
Inserisci <operando1> <operatore> <operando2>. es: 4 + 3
10 % 2
Operatore non riconosciuto
```
