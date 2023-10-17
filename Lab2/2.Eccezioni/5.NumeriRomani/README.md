# Numeri Romani (con eccezioni)

Adattare il programma `5.AstrazioniProcedurali/5.NumeriRomani` per gestire i casi eccezionali attraverso le eccezioni. In particolare gestire le seguenti situazioni:
* Il numero inserito non è un numero decimale valido;
* Il numero inserito non è un numero romano valido;
* Il numero decimale inserito non può essere convertito in un numero romano;

Modificare le specifiche delle procedure di conseguenza.

##### Esempio d'esecuzione:

```text
$ java NumeriRomani 1995
MCMXCV

$ java NumeriRomani MCMXCV
1995

$ java NumeriRomani 7995
Cannot accept numbers greater than 3999

$ java NumeriRomani MCM$XCV
Neither decimal nor roman
```
