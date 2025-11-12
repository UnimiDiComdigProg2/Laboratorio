# Pretendenti

In un antico regno, la bella principessa Eva aveva molti pretendenti. Stabilì una procedura per decidere quale avrebbe sposato. Per prima cosa, i pretendenti sarebbero stati allineati e a ciascuno sarebbe stato assegnato un numero. Il primo pretendente avrebbe ricevuto il numero 1, il secondo il 2 e così via fino all’ultimo, con il numero n. 
Partendo dal primo, avrebbe contato tre (come il numero delle lettere del suo nome) pretendenti lungo la fila e il terzo pretendente sarebbe stato eliminato e tolto dalla fila. 
Eva avrebbe quindi continuato contando ogni volta tre pretendenti ed eliminandone uno ogni tre. Una volta arrivata alla fine della lista, avrebbe invertito la direzione e continuato tornando all’inizio. Allo stesso modo, una volta raggiunta la prima persona della lista, avrebbe invertito nuovamente la direzione, e così via fino ad avere un solo pretendente rimasto.

Progettare, specificare e implementare una Classe `Pretendenti` che, quando inizializzata con un numero n di pretendenti, crei la lista dei numeri a loro assegnati.
La classe dovrà implementare l'interfaccia `Iterable`, restituendo un `Iterator` che permetta di identificare il successivo pretendente da eliminare. Pertanto dovrà essere presente anche un metodo remove che elimini il pretendente identificato (mantenendo funzionante il comportamento dell'iteratore). Inoltre, dovrà essere possibile ottenere il vincitore una volta che un solo pretendente è rimasto. Infine, sia la classe `Pretendenti` che la classe `Iterator` dovranno rendere disponibile un metodo `toString()` che sarà usato per osservare il loro stato corrente.

Scrivere inoltre un metodo `main()` che testi la classe `Pretendenti`. Si dovrà leggere da **riga di comando** il numero `n` di pretendenti ed inizializzare la classe `Pretendenti`. Poi si dovrà iterare sui suoi elementi fino all'ultimo pretendente, stampando infine il vincitore, come da esempio di esecuzione.

##### Esempio d'esecuzione:

```text
java Pretendenti 5
Pretendenti: 1 2 3 4 5 
Si conta da 1 direzione avanti
Eliminato: 3
Pretendenti: 1 2 4 5 
Si conta da 4 direzione avanti
Eliminato: 4
Pretendenti: 1 2 5 
Si conta da 2 direzione indietro
Eliminato: 2
Pretendenti: 1 5 
Si conta da 5 direzione indietro
Eliminato: 5
il numero 1 è il fortunato vincitore
```
