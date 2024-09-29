# TrattePercorsi

Una `Tratta` di viaggio è definita da:
* Nome del luogo d'origine
* Nome del luogo di destinazione
* Lunghezza del percorso (in km)
* Velocità media del mezzo (in kmh)

Per una `Tratta` deve essere possibile:
* Calcolare la durata della `Tratta` in ore
* Calcolare la quantita di CO2 prodotta durante la `Tratta`

In particolare, una Tratta può essere:
* `TrattaTreno` - per la quale la CO2 prodotta è calcolata come il prodotto dei km percorsi e di un quantitativo fisso per km, fornito alla creazione della tratta.
* `TrattaBus` - per la quale la CO2 prodotta è calcolata come il prodotto delle ore di percorrenza e di un quantitativo fisso per ora, fornito alla creazione della tratta.
* `TrattaAereo` - per la quale la CO2 prodotta è la somma di un fisso per il decollo e di una quota calcolata in base ai km percorsi (come per la `TrattaTreno`), entrambi forniti alla creazione della tratta.

Un `Percorso` è costituito da una sequenza di `Tratte`. La prima tratta parte da un luogo d'origine e arriva al punto di partenza della tratta successiva e così via fino all'ultima tratta.

Per un `Percorso` deve essere possibile:
* Aggiungere una tratta. Se vi sono già delle tratte nel percorso, la tratta aggiunta deve continuare il percorso correttamente (avere il luogo d'origine = al luogo di destinazione dell'ultima tratta.) Altrimenti dovrà lanciare una `TrattaNonValidaException` (checked)
* Calcolare la durata, come somma delle durate delle `Tratte` che compongono il `Percorso`
* Calcolare la CO2 prodotta come la somma delle quantità di CO2 prodotte per ciascuna `Tratta` del `Percorso`
* Definire l'ordine naturale dei percorsi per durata
* Restituire un Iteratore delle tratte del `Percorso`

Progettare, specificare ed implementare le classi descritte sopra ed i loro metodi.

Scrivere una classe `Test` con un metodo `main()` per testare le classi create. A tal fine, leggere da **standard input** una serie di righe che definiscono tratte nel formato `<tipoTratta> <nomeOrigine> <nomeDestinazione> <lunghezza> <velocità>`. Inoltre, ci saranno ulteriori parametri in base al tipo della tratta. `<CO2km>` per `TrattaTreno`; `<CO2ora>` per `TrattaBus`; e `<CO2decollo> <CO2km>` per `TrattaAereo`. Le righe consecutive formano un `Percorso` unico, che può essere terminato per iniziarne uno nuovo mediante una riga contenente il solo carattere `-`. La lettura di tutti i percorsi termina quando viene premuta la combinazione dei tasti `CTRL+D`.
Infine, stampare su **standard output** le informazioni relative ai percorsi inseriti, e per ciascuno le tratte che lo compongono (usando l'iterator creato in precedenza) come da esempio d'esecuzione.

#### Esempio d'esecuzione:

```text
$ java Main
TrattaTreno Torino Napoli 886 280 1
TrattaBus Napoli Salerno 57 70 2
-
TrattaAereo Roma Milano 477 600 2 400
TrattaTreno Milano Bergamo 56 80 1
TrattaBus Bergamo Ponte 9 40 3

Percorso (durata: 1.7200000000000002, co2: 1410.675)
	(Aereo) Tratta tra Roma e Milano; lunghezza: 477.0, velocità: 600.0, qKm: 2.0, qFix: 400.0
	(Treno) Tratta tra Milano e Bergamo; lunghezza: 56.0, velocità: 80.0, qKm: 1.0
	(Bus) Tratta tra Bergamo e Ponte; lunghezza: 9.0, velocità: 40.0, qHr: 3.0

Percorso (durata: 3.9785714285714286, co2: 887.6285714285714)
	(Treno) Tratta tra Torino e Napoli; lunghezza: 886.0, velocità: 280.0, qKm: 1.0
	(Bus) Tratta tra Napoli e Salerno; lunghezza: 57.0, velocità: 70.0, qHr: 2.0

$ java Main 
TrattaAereo Roma Berlino 1184 600 2 400
TrattaAereo Milano Helsinki 1936 600 2 400
tratta non continua il percorso 
```
