# Solido

Un `Solido` geometrico ha un metodo `double volume()` per restituirne il volume. Inoltre implementa l'interfaccia `Comparable<Solido>`, il cui unico metodo, `compareTo(Solido s)` restituisce `-1` se `this` ha un volume minore di `s`, `0` se il volume dei due è uguale, e `1` se `this` ha un volume maggiore. Una `Sfera` ed un `Cono` estendono `Solido` definendo rispettivamente le loro rappresentazioni e implementando rispettivamente i metodi appropriati.

Progettare, specificare ed implementare la gerarchia di classi descritta e creare una classe di servizio `Main` con il solo metodo `main()` per testare il codice creato. Nel `main()` leggere da **standard input** il raggio di una sfera e poi il raggio e l'altezza di un cono. Usando il metodo `compareTo` verificare quale dei due ha un volume maggiore e scriverlo su **standard output** come da esempio d'esecuzione.


##### Esempio d'esecuzione:

```text
$ java Main
Inserisci il raggio di una sfera
5
Inserisci il raggio e l'altezza di un cono
5 6 
La sfera ha un volume maggiore del cono
```
