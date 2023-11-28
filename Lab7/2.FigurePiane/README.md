# FigurePiane

Progettare, specificare ed implementare una gerarchia di classi di figure piane (immutabili) e un'interfaccia `Figura` contenente i metodi comuni a tutte le figure piane, incluso un metodo `perimetro()`. L'interfaccia stessa deve estendere l'interfaccia `Comparable<Figura>` e quindi contenere il metodo `compareTo()` che dovrà confrontare una `Figura` con un'altra in base al loro perimetro. Definire almeno le seguenti figure in una gerarchia opportuna: `Triangolo`, `Rettangolo`, `Quadrato` e `Cerchio`.

Creare una classe `Collage` contenente una lista di oggetti di tipo `Figura`, e che abbia un metodo `ordinaPerPerimetro()` per riordinare gli elementi della lista in base al loro perimetro. Per fare questo sarà sufficiente usare il sorting naturale della lista di figure (`sort(null)`), dato che le figure implementano l'interfaccia `Comparable<Figura>`.

Implementare un metodo `main()` che verifichi il funzionamento della classe, creando un nuovo `Collage`, inserendo in esso una serie di figure lette da **standard input**, e stampandole ordinate per perimetro, come da esempio d'esecuzione.

```text
$ java Collage
Inserisci delle figure (Termina con CTRL+D)
Triangolo 3 4 5
Cerchio 2
Rettangolo 7 2
Quadrato 4
Cerchio 3

Ordinati per perimetro:
Cerchio 3.0 - Perimetro: 18.8495559215
Rettangolo 7.0 2.0 - Perimetro: 18.0
Quadrato 4.0 - Perimetro:  16.0
Cerchio 2.0 - Perimetro: 12.5663706144
Triangolo 3.0 4.0 5.0 - Perimetro: 12.0
```
