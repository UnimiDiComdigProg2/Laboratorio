# PuntoSegmento3D

Progettare, specificare ed implementare una classe Punto3D che estende Punto2D con aggiunta di coordinata z, ridefinendo opportunamente i metodi del Punto2D. Scrivere Segmento3D, ridefinendo opportunamente i metodi del Segmento2D. Scrivere un metodo `main()` in Segmento3D per testare la classe in modo analogo allo scorso esercizio, come da esempio di esecuzione.

Ragionare inoltre sulle seguenti domande:
* Quali attributi di Punto2D può riutilizzare Punto3D? Quali metodi?
* Quali attributi di Segmento2D può riutilizzare Segmento3D? Quali metodi?
* Ha senso costruire Segmento3D estendendo Segmento2D? perchè cosa 
* Ha senso riscrivere Punto3D per ottenere lo stesso effetto per composizione e delega invece che per estensione?
* Ha senso scrivere un'interfaccia per mettere in relazione Punto2D e Punto3D?
* Ha senso riscrivere Segmento3D per ottenere lo stesso effetto per composizione e delega invece che per estensione?
* Ha senso scrivere un'interfaccia per mettere in relazione Segmento2D e Segmento3D?


##### Esempio d'esecuzione:

```text
$ java Segmento3D 6.2
Inserisci i segmenti nel formato ax ay bx by (temina con CTRL+D)
-10 4 2 3 4 2
5.5 3.2 2 4 4 4
7.2 -2.1 -5.7 2 1 -2
6.6 9.9 2.2 2.2 9.9 6.6
1 2 3 4 5 6
2 4 6 8 10 12
4 6 8 10 12 14
Segmenti di lunghezza superiore a 6.2
Segmento: [Punto - x: -10.0, y: 4.0, z: 2.0; Punto - x: 3.0, y: 4.0, z: 2.0] lunghezza: 13.0
Segmento: [Punto - x: 7.2, y: -2.1, z: -5.7; Punto - x: 2.0, y: 1.0, z: -2.0] lunghezza: 7.0950687100267045
Segmento: [Punto - x: 6.6, y: 9.9, z: 2.2; Punto - x: 2.2, y: 9.9, z: 6.6] lunghezza: 6.2225396744416175
Segmento: [Punto - x: 2.0, y: 4.0, z: 6.0; Punto - x: 8.0, y: 10.0, z: 12.0] lunghezza: 10.392304845413264
Segmento: [Punto - x: 4.0, y: 6.0, z: 8.0; Punto - x: 10.0, y: 12.0, z: 14.0] lunghezza: 10.392304845413264
```
