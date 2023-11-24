# Punto

Modellare, specificare e implementare una classe `Punto`, i cui oggetti rappresentano punti nel piano cartesiano.
La classe contiene i seguenti costruttori
* `public Punto(double x, double y)`: costruisce il punto di coordinate (x,y).
* `public Punto(double x)`: costruisce il punto di coordinate (x,x).
* `public Punto()`: costruisce il punto di coordinate (0,0).

Inoltre, la classe contiene i seguenti metodi:
* `public double getX()` : restituisce l'ascissa del punto.
* `public double getY()` : restituisce l'ordinata del punto.
* `public void setX(double x)` : modifica l'ascissa del punto (rendendola uguale a x).
* `public void setY(double y)` : modifica l'ordinata del punto (rendendola uguale a y).
* `public void setXY(double x, double y)` : modifica le coordinate del punto, rendendolo uguale a (x,y).
* `public String toString()` : restituisce una versione "stringa" del punto.
* `public boolean equals(Object o)` : restituisce true se il punto p coincide (cioè, se ha le stesse coordinate) con l'oggetto su cui il metodo viene invocato.
* `public double distanza(Punto p)` : restituisce la distanza euclidea fra il punto p e il punto su cui il metodo viene invocato.

Scrivere un metodo `main()` di test che legga da **standard input** una serie di righe nel formato `<x> <y>` e termini la lettura quando si preme `CTRL+D`. Al termine della lettura stampare i due punti più distanti tra di loro. Gestire in maniera opportuna i casi limite.

##### Esempio d'esecuzione:

```text
$ java Punto
Inserire i punti (<x> <y>)
Terminare la lettura con CTRL+D
3 4
1 6
-1.5 0
7 -8

I punti più distanti sono:
{Punto: 1, 6}
{Punto: 7 -8}
```
