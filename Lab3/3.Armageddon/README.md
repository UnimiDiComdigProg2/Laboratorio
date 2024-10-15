# Armageddon

Modellare, specificare e implementare una classe `Asteroide` che definisce questi oggetti in base alla loro massa (in kg) e distanza dalla terra (in km). Definire i metodi per costruire e leggere le informazioni dell'asteroide. Inoltre definire un metodo per leggere la forza gravitazionale esercitata tra l'asteroide e la terra secondo la formula matematica: forza = massa/distanza^2
Identificare e gestire i casi limite dei metodi della classe.

Implementare un metodo `main()` per testare la classe. Il metodo main dovrà leggere da **riga di comando** un valore soglia. Le forze gravitazionali superiori alla soglia indicano asteroidi pericolosi per la terra. Leggere da **standard input**, fino a quando non viene premuto `CTRL+D`, una serie di coppie di valori `<massa> <distanza>` che rappresenteranno gli asteroidi osservati. Al termine della lettura segnalare gli asteroidi pericolosi.

##### Esempio d'esecuzione:

```text
$ java Armageddon 0.02
67620000 74798
10140000 38014
50200000 103360
68300000 85857
26990000 34557
30310000 95752

Asteroide pericoloso a distanza 34557km del peso di 26990000kg
Lanciate Bruce Willis!
```
