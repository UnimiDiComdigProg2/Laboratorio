# FigurePiane2

Modificare l'interfaccia `Figura` dell'esercizio precedente aggiungendo un ulteriore metodo `area()` per calcolare l'area della figura. Aggiungere l'implementazione del metodo in tutte le classi che implementano l'interfaccia `Figura`.

Modificare la classe `Collage` aggiungendo un metodo `areaTotale()` che restituisca la somma di aree di tutte le figure contenute, e un metodo `ordinaPerArea()` per riordinare gli elementi secondo la loro area. Per fare questo, sarà necessario passare al metodo `sort()` della lista un `Comparator` in grado di comparare due oggetti di tipo `Figura` per la loro area.

Modificare il metodo `main()` per stampare anche l'area totale delle figure e gli elementi ordinati per area, come da esempio d'esecuzione.

```text
$ java Collage
Inserisci delle figure (Termina con CTRL+D)
Triangolo 3 4 5
Cerchio 2
Rettangolo 7 2
Quadrato 4
Cerchio 3

Area totale: 76.8407044967

Ordinati per area:
Cerchio 3.0 - Area: 28.2743338823, Perimetro: 18.8495559215
Quadrato 4.0 - Area: 16.0, Perimetro:  16.0
Rettangolo 7.0 2.0 - Area: 14.0, Perimetro: 18.0
Cerchio 2.0 - Area: 12.5663706144, Perimetro: 12.5663706144
Triangolo 3.0 4.0 5.0 - Area: 6.0, Perimetro: 12.0

Ordinati per perimetro:
Cerchio 3.0 - Area: 28.2743338823, Perimetro: 18.8495559215
Rettangolo 7.0 2.0 - Area: 14.0, Perimetro: 18.0
Quadrato 4.0 - Area: 16.0, Perimetro:  16.0
Cerchio 2.0 - Area: 12.5663706144, Perimetro: 12.5663706144
Triangolo 3.0 4.0 5.0 - Area: 6.0, Perimetro: 12.0
```
