# Ingressi Contingentati

Definire, specificare e implementare una classe `Stanza` che modelli una stanza con una determinata capienza massima di persone. La capienza massima della `Stanza` dovrà essere indicata nel costruttore della classe. Inoltre, dovrà essere possibile aggiungere persone alla stanza, una alla volta, fino alla capienza massima della stanza e dovrà essere possibile togliere persone dalla stanza, una alla volta, fino a quando ce ne sono. Infine, dovrà essere possibile ottenere il numero di persone presenti nella stanza. Gestire i casi limite mostrati nell'esempio di esecuzione.

Scrivere un metodo `main()` per testare la classe mediante il quale sia possibile leggere da **riga di comando** una serie di numeri interi corrispondenti alle capienze di altrettante stanze.
Leggere da **standard input** una serie di righe nel formato `<numeroStanza> +` o `<numeroStanza> -`. Il primo aggiungerà una persona alla stanza specificata mentre il secondo ne toglierà una.
Terminare la lettura quando viene premuta la combinazione dei tasti `CTRL+D`.
Al termine della lettura stampare il numero di persone presenti in tutte le stanze.

Quali sono i casi limite dei diversi metodi della `Stanze` e quali del metodo `main()`? In quali casi è opportuno lanciare un'eccezione e in quali sarebbe meglio utilizzare un approccio alternativo? 

##### Esempio d'esecuzione:

```text
$ java Stanza 5 3
Create 2 stanze
1 +
2 +
1 -
3 +
Stanza 3 non esiste
2 +
1 -
Nessuno nella stanza 1
2 +
2 +
Capienza massima raggiunta nella stanza 2
2 -

Numero totale di persone presenti: 2

$ java -2
Non è possibile avere una stanza con capienza negativa
```
