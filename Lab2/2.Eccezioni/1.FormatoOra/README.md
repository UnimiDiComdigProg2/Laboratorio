# Formato Ora

Scrivere un programma che legga da **riga di comando** un orario espresso in 24 ore e lo converta in orario espresso in 12 ore. Il formato corretto è `hh:mm`, dove `hh` deve essere un numero di due cifre inferiore a `24` e `mm` è un numero a due cifre inferiore a `60` (gli zeri iniziali sono richiesti per ore e minuti inferiori a `10`).
Generare e gestire un'eccezione di tipo DateTimeException se il formato non è corretto.

Oltre al metodo `main()`, deve essere specificata, implementata ed utilizzata almeno la seguente procedura:
* `public static String converti(String s) throws DateTimeException`

##### Esempio d'esecuzione:

```text
$ java FormatoOra 14:30
2:30 PM

$ java FormatoOra 09:30
9:30 AM

$ java FormatoOra 13-23
Formato ora non valido 13-23
```
