# Orario

Progettare, specificare e implementare una classe `Orario` che rappresenta un'orario con un valore delle ore tra 0 e 23 e dei minuti tra 0 e 59. Gestire opportunamente i controlli dei valori utilizzando le eccezioni.

Definire i seguenti costruttori:
* `Orario()` costruttore di default che inizializza un nuovo `Orario` con l'ora e i minuti a 0
* `Orario(int ore, int minuti)` costruttore che inizializza un nuovo `Orario` con l'ora (nel range 0-23) e i minuti dati come parametri
* `Orario(int ore, int minuti, boolean PM)` costruttore che inizializza un nuovo `Orario` con l'ora (nel range 1-12), i minuti, e un valore booleano che specifica se l'orario è di mattina (`false`) o pomeriggio (`true`)

Definire i seguenti metodi:
* `int getOre()` e `int getMinuti()` che restituiscono l'ora (0-23) e i minuti
* `avanza(int ore, int minuti)` che fa avanzare l'orario di ore e minuti specificati, gestendo opportunamente il cambio d'ora
* `String getOra24()` che restituisce una stringa che rappresenta l’orario nel formato a 24 ore (hh:mm)
* `String getOra12()` che restituisce le ore in una notazione a 12 ore (h:mm xx) dove xx è `AM` o `PM`.

Inoltre, implementare gli appositi metodi **Funzione di Astrazione** ed **Invariante di Rappresentazione** e ridefinire il metodo `equals`.

Nella classe `Orario` implementare un metodo `main()` per il testing della classe. Il metodo deve leggere da **riga di comando** l'orario iniziale nel formato a 24 o a 12 ore, come specificato negli ultimi due metodi definiti. Se l'orario non è specificato, sarà inizializzato a 0 ore e 0 minuti. Poi, da **standard input** si dovrà leggere una stringa nel formato `+ ore minuti` e si dovrà far avanzare l'orario in maniera corrispondente. Infine, si dovrà stampare l'orario nel formato a 24h e a 12h.

##### Esempio d'esecuzione:

```text
$ java Orario 
Orario: 00:00
Orario: 12:00 AM
+ 5 12
Orario: 05:12
Orario: 5:12 AM

$ java Orario 15:40
Orario: 15:40
Orario: 3:40 PM
+ 9 5
Orario: 00:45
Orario: 12:45 AM

$ java Orario 2:30 PM
Orario: 14:30
Orario: 2:30 PM
+ 2 35
Orario: 17:05
Orario: 5:05 PM
```
