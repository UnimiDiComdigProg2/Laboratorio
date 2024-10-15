# Rubrica

Modellare, specificare e implementare una classe `Contatto` che rappresenta un elemento di una rubrica e contiene il nome, il cognome, il numero di telefono (opzionale) e l'indirizzo mail (opzionale) della persona.
In particolare, definire i metodi per:

* Creare un nuovo oggetto di tipo `Contatto`;
* Accedere e modificare le informazioni dell'oggetto;
* Verificare se due contatti sono uguali sulla base delle loro informazioni, ridefinendo il metodo `equals()`.

Scrivere inoltre una classe `Rubrica` con un metodo `main()` per testare la classe `Contatto`. A tal fine leggere da **standard input** una serie di contatti, come da esempio d'esecuzione. Terminata la lettura con la combinazione dei tasti `CTRL+D`, verificare se vi sono contatti uguali nella rubrica e stamparli su **standard output**. Gestire i casi limite in maniera opportuna.

Come modellereste

##### Esempio d'esecuzione:

```text
$ java Rubrica
Joe Henry jhenry@bix.net 5553456
JimBob Johnson jbj@email.com -
Jack Ripper slice@dice.org 3116535
Joe Henry jhenry@bix.net 5553456

Contatti uguali:
Joe Henry jhenry@bix.net 5553456


$ java Rubrica
Armand d'Autevielle athos@musketeers.net 0298765432
Isaac Portau portos@musketeers.net -
Henri d'Aramitz aramis@musketeers.net 3898765432
Charles d'Artagnan dartagnan@musketeers.net +135573125

Non ci sono contatti uguali
```
