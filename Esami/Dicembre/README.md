# AlberoNatalizio

Un `AlberoNatalizio` può essere decorato aggiungendo delle decorazioni:

* Una `Decorazione` ha un nome e un peso.
* Una `DecorazioneElettrica` ha anche una potenza elettrica richiesta, e può essere accesa o spenta con un commando interuttore (inizia spenta). Inoltre, le DecorazioniElettriche sono naturalmente ordinate per potenza richiesta.
* Un `Puntale` è una `Decorazione` speciale e solo un `Puntale` può essere aggiunto ad un 'AlberoNatalizio`.

Quando l'albero viene creato, è necessario fornire il carico massimo dell'albero e la potenza elettrica massima dell'albero. Quando si cerca di aggiungere una decorazione all'albero, viene controllato se con il peso della decorazione aggiunta si supera il carico massimo dell'albero. In tal caso la decorazione non viene aggiunta e viene lanciata una 'WeightReachedException' (checked). Se la decorazione che si cerca di aggiungere è un `Puntale`, e un altro `Puntale` è già presente, viene lanciata una `TopperExistsException` (unchecked) e il nuovo puntale non viene aggiunto.

Inoltre, dovrà essere possibile accendere le decorazioni elettriche dell'albero. Le decorazioni dovranno essere accese, dalla meno richiedente alla più richiedente, fino al raggiungimento della potenza massima dell'albero.

Infine, un `AlberoNatalizio` dovrà poter restituire un iteratore per accedere, una ad una, a tutte le decorazioni inserite.

Progettare, specificare ed implementare le classi descritte sopra ed i loro metodi.

Scrivere un metodo main per testare le classi create. A tal fine, leggere da **riga di comando** il carico massimo e la potenza massima dell'albero.
Poi, leggere da **standard input** una serie di decorazioni da aggiungere all'albero nel formato `<tipo> <nome> <peso>` e, se è una `DecorazioneElettrica`, ci sarà anche un campo `<potenza>`.
Accendere le decorazioni elettriche con il metodo dell'albero che è stato creato prima (fino al raggiungimento della potenza massima dell'albero).
Infine, stampare su **standard output** le informazioni relative all'albero, e poi tutte le decorazioni (usando l'iterator creato in precedenza) come da esempio d'esecuzione.

#### Esempio d'esecuzione:

```text
$ java AlberoNatalizio 50 100
Puntale stellaBella 8
DecorazioneElettrica lucineAngioletto 7 30
Decorazione PalleGrosse 13
Decorazione PallePiccole 7
DecorazioneElettrica candelline 9 30
DecorazioneElettrica faroDaStadio 6 100

Albero (Carico: 50.0, Potenza: 100.0)
	Decorazione: stellaBella; peso: 8.0, puntale
	Decorazione: PalleGrosse; peso: 13.0
	Decorazione: PallePiccole; peso: 7.0
	Decorazione: lucineAngioletto; peso: 7.0, potenza: 30.0, accesa
	Decorazione: candelline; peso: 9.0, potenza: 30.0, accesa
	Decorazione: faroDaStadio; peso: 6.0, potenza: 100.0, spenta

$ java AlberoNatalizio 50 100
Decorazione Piuma 0.001
Decorazione Macigno 1000
Non si può aggiungere: Carico superato

Albero (Carico: 50.0, Potenza: 100.0)
	Decorazione: Piuma; peso: 0.001

$ java AlberoNatalizio 50 100
Puntale angioletto 4
Decorazione stelleFilanti 1
Puntale puntaDiAlabarda 7
Non si può aggiungere: Puntale già aggiunto
DecorazioneElettrica musichettaCarole 5 35

Albero (Carico: 50.0, Potenza: 100.0)
	Decorazione: angioletto; peso: 4.0, puntale
	Decorazione: stelleFilanti; peso: 1.0
	Decorazione: musichettaCarole; peso: 5.0, potenza: 35.0, accesa
```
