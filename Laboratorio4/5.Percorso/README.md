# Percorso

Progettare, specificare e implementare una classe `Percorso` che modelli un percorso costituito da una sequenza di dati di tipo `Punto`. La classe deve essere in grado di gestire l'aggiunta di un `Punto` in coda alla sequenza, di rimuovere l'ultimo punto in coda alla sequenza, e di calcolare la lunghezza totale del percorso.

Progettare, specificare e implementare anche la classe `Punto` che modelli un punto immutabile, costituito dalle sue coordinate (decimali) x e y. Un'istanza della classe `Punto` deve poter creare un nuovo punto alle coordinate x e y date; deve saper restituire le proprie coordinate x e y; deve avere la capacità di calcolare la distanza con un altro punto, e deve poter generare un punto nuovo con uno scostamento x e y dato.

Nella classe `Percorso` implementare un metodo `main()` per il testing della classe. Il metodo deve leggere da **standard input** una serie di righe nel formato `x y` e aggiungere i punti così definiti in un'istanza di tipo `Percorso`. Al termine della lettura (CTRL+D), restituire i segmenti del percorso con le loro lunghezze e la lunghezza totale del percorso.

Ragionare sulle **Astrazioni** da utilizzare per i tipi di dati implementati e sulla loro **Rappresentazione**. Implementare gli appositi metodi **Funzione di Astrazione** ed **Invariante di Rappresentazione**

##### Esempio d'esecuzione:

```text
$ java Percorso 
Inserisci le coordinate di un punto per riga nel formato <x y> (termina con CTRL+D)
1 2
3 2
4 4
6 5
6 4.5

Tratto 1: distanza 2
Tratto 2: distanza 2.236
Tratto 3: distanza 2.236
Tratto 4: distanza 0.5
Totale: 6.972
```
