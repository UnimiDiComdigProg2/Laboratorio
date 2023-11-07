# Matrice

Progettare, specificare e implementare una classe `Matrice` che modelli una matrice di interi di dimensione `n * m`, dove `n` ed `m` sono due valori interi passati al costruttore della classe. Inoltre, dovranno essere presenti anche i metodi getter e setter per osservare e modificare i valori singoli degli elementi della matrice.
Definire un metodo `iterator()` che dovrà restituire un `Iterator<Iterator<Integer>>`. In altre parole, il metodo `next()` dell' `Iterator` dovrà generare a ogni chiamata un nuovo `Iterator<Integer>` rappresentante l'iteratore di una riga della matrice. Questo nuovo `Iterator` invece genererà mediante il proprio metodo `next()` gli interi costituenti la riga.

Implementare un metodo `main()` per il testing della classe. Il metodo dovrà leggere da **riga di comando** le dimensioni della matrice ed inizializzare con essi una nuova matrice. Questa dovrà poi essere popolata con numeri inseriti da **standard input**.
Utilizzare il metodo `iterator()` della classe per restituire l'`Iterator` delle righe. Ciclare sulle righe e per ciascuna farsi restituire l'iterator degli elementi della riga. Infine, con questo stampare gli elementi della matrice, come da esempio di esecuzione.


##### Esempio d'esecuzione:

```text
$ java Matrice 2 3
Inserisci i 3 numeri (separati da spazio) della riga 1
3 5 2 
Inserisci i 3 numeri (separati da spazio) della riga 2
4 7 8
Matrice inserita:
3 5 2 
4 7 8
```
