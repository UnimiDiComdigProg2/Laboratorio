# PuntoSegmento

Progettare, specificare ed implementare una classe astratta `Solido` che modelli un solido geometrico. La classe avrà i metodi `string tipo()` per restituire il tipo di solido e `double volume()` per restituirne il volume. La classe inoltre dovrà implementare l'interfaccia Comparable<Solido>, il cui unico metodo, `compareTo(Solido s)` restituirà `-1` se `this` ha un volume minore di `s`, `0` se il volume dei due è uguale, e `1` se `this` ha un volume maggiore. La classe astratta non deve implementare il codice di `compareTo`, ma le classi che la estendono dovranno farlo. Progettare, specificare ed implementare poi una classe concreta `Sfera` che estanda `Solido` implementando i metodi appropriati e definendo una appropriata rappresentazione del tipo. Similmente, progettare, specificare ed implementare una classe `Cono` che estenda `Solido`. Creare una classe di servizio `Main` con il solo metodo `main` per testare il codice creato. Nel `main()` leggere da **standard input** il raggio di una sfera e poi il raggio e l'altezza di un cono. Usando il metodo `compareTo` verificare quale dei due ha un volume maggiore come da esempio d'esecuzione.

##### Esempio d'esecuzione:

```text
$ java Main
Inserisci il raggio di una sfera
5
Inserisci il raggio e l'altezza di un cono
5 6 
La sfera ha un volume maggiore del cono
```
