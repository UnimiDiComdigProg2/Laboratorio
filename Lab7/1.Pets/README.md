# Pets

Un tipo astratto `Pet` è definito dal nome dell'animale domestico e contiene un metodo `verso()` che stampa su **standard output** il verso dell'animale. Progettare, specificare ed implementare la classe `Pet` definendo gli attributi e i metodi della classe. Progettare, specificare ed implementare i tipi concreti `Cane`, `Gatto` e `Cavia` specializzando la classe `Pet`.
Progettare, specificare ed implementare la classe `Persona`, identificata da nome, che può avere diversi animali domestici di vario tipo, aggiungibili, rimuovibili e iterabili mediante appositi metodi.
Creare una classe Pets con un metodo `main()` per leggere da **standard input** una serie di righe di testo nel formato `nomePersona nomeAnimale tipoAnimale` e creare una lista di persone, inizializzate con il loro nome e con aggiunti i loro animali domestici. Stampare per ciascuna persona il coro dei loro animali domestici, come da esempio d'esecuzione.

#### Esempio d'esecuzione:

```text
$ java Pets
Inserisci righe nel formato `nomePersona nomeAnimale tipoAnimale` (CTRL+D per terminare)
Clelia Axel Cane
Francesca Lupin Gatto
Francesca Ryo Gatto
Clelia Frida Gatto
Clelia Kaboto Gatto
Maribel Lillo Cane
Danilo Saetta Cavia

Il coro degli animali di Clelia:
Axel dice bau
Frida dice miao
Kaboto dice miao

Il coro degli animali di Francesca:
Lupin dice miao
Ryo dice miao

Il coro degli animali di Maribel:
Lillo dice bau

Il coro degli animali di Danilo:
Saetta dice squit
```
