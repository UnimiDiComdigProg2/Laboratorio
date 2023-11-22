# Bag

`Bag` o `MultiSet` è un insieme di elementi, anche ripetuti. Progettare, specificare ed implementare la classe `Bag`, in grado di contenere gli elementi di tipo generico e che implementi l'interfaccia `Iterable` (sempre sul tipo generico specificato). Implementare un metodo `main()` per testare la classe che legga da **riga di comando** il tipo da inserire (`Integer`, `Double` o `String`) e da **standard input** gli elementi di quel tipo che dovranno essere inseriti in una `Bag`. Infine stampare su **standard output** gli oggetti inseriti, come da esempio di esecuzione.

* Nota: è possibile rappresentare una `Bag` senza memorizzare ciascun elemento ma memorizzando invece gli elementi diversi ed il loro conteggio.

#### Esempio d'esecuzione:

```text
$ java Bag Integer
Inserisci numeri Interi (CTRL+D per terminare)
1
2
3
1
1
2
Bag - elements: [ 1 1 1 2 2 3 ]

$ java Bag String
Inserisci Stringhe (CTRL+D per terminare)
asd
asd
asd
dsa
Bag - elements: [ asd asd asd dsa ]
```
