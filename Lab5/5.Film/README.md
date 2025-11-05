# Film

Un `Film` rappresenta un film noleggiabile da una videoteca, definito da un codice identificativo, un titolo, e la data di noleggio del film (usando la classe `LocalDate`). Definire anche i suoi metodi d'utilizzo, incluso un metodo `calcolaPenaleRitardo` che restituisce la penale di ritardo di restituzione per quel film se sono passati più di 7 giorni dal noleggio, e in base al numero dei giorni di ritardo. Si creino, inoltre, tre classi derivate dalla classe `Film` chiamate `Azione`, `Commedia` e `Dramma`. La penale predefinita è di 2€ al giorno. I film di azione hanno una penale pari a 3€ al giorno e le commedie 2.50€ al giorno.

Progettare, specificare ed implementare le classi descritte e creare una classe `Main` di test, che nel suo `main()` legga da **standard input** una serie di film definiti da `nome tipo e data di noleggio` e stampi su **standard output** la somma delle penali, come da esempio d'esecuzione.

#### Esempio d'esecuzione:

```text
$ java Film
Inserisci i film noleggiati nel formato `nome tipo data` (CTRL+D per terminare)
KillBill Azione 8-11-2022
MeanGirls Commedia 10-11-2022
MysticRiver Dramma 3-11-2022

Penale totale: 15€
```
