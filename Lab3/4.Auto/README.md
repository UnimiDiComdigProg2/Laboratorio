Modellare, specificare e implementare una classe `Auto` che rappresenta un'automobile. La classe deve avere un costruttore per inizializzare un nuovo oggetto di tipo `Auto` con una certa capacità di serbatoio, velocità massima, e consumo medio (km per litro). Inoltre, la classe prevede dei metodi per le seguenti attività:

* cambiare la velocità dell'auto;
* pianificare un viaggio con in input: una distanza e una velocità di percorrenza. Il metodo deve calcolare il tempo di percorrenza ed aggiornare il carburante sottraendo quello consumato.
* riempire il serbatoio con una certa quantità di carburante; 

Inoltre, implementare un metodo `main()` per collaudare la classe che legga da **riga di comando** i parametri iniziali della macchina nell'ordine specificato sopra  e da **standard input** tratte del percorso da fare (finchè la lettura non termina con `CTRL+D`). Per ogni tratta inserire tre valori numerici `<litri riforniti> <km da fare> <velocità>`. Alla fine stampare i km totali percorsi. Gestire i casi limite che potrebbero avvenire, come da esempio d'esecuzione.

##### Esempio d'esecuzione:

```text
$ java Auto 40 200 20
Inserisci una tratta (<L. riforniti> <km da fare> <velocità>)
30 120 50
Tempo necessario: 2 ore e 24 minuti
Ti rimangono 24.0 L di carburante
Inserisci una tratta (<L. riforniti> <km da fare> <velocità>)
0 300 100
Tempo necessario: 3 ore e 0 minuti
Ti rimangono 9.0 L di carburante
Inserisci una tratta (<L. riforniti> <km da fare> <velocità>)
0 200 80
Non hai carburante sufficiente
Ti rimangono 9.0 L di carburante
Inserisci una tratta (<L. riforniti> <km da fare> <velocità>)
0 100 250
L'auto non va così veloce. velocità limitata a 200 km/h
Tempo necessario: 0 ore e 30 minuti
Ti rimangono 4.0 L di carburante
10 100 0
Non puoi andare a velocità negativa o nulla
Ti rimangono 14.0 L di carburante
Inserisci una tratta (<L. riforniti> <km da fare> <velocità>)

Hai percorso 520 km totali
```
