# Ricetta

Un ingrediente (`Ingredient`) di una ricetta (`Recipe`) è definito dal suo nome e può essere:
* `IngQty`, ovvero un ingrediente di cui viene registrata la quantità (es: 3 uova)
* `IngWgt`, ovvero un ingrediente di cui viene registrato il peso (es: 0.2kg di farina)
* `IngVol`, ovvero un ingrediente di cui viene registrato il volume (es: 2.5l di acqua)
* `Recipe`, ovvero una ricetta, definita anche da una procedura di preparazione e dall'insieme di ingredienti che usa (inizialmente vuoto). **NOTA:** una ricetta può essere un ingrediente di un'altra ricetta.
 
Un `Ingredient` presenta le seguenti funzionalità:
* è considerato uguale a un altro `Ingredient` che ha lo stesso nome
* espone un'ordine naturale alfabetico in base al nome
* può essere unito a un `Ingredient` che abbia lo stesso nome e appartenga allo stesso sottotipo. Se nome o tipo degli ingredienti che si cerca di unire sono diversi viene lanciata una `IngredientException` - unchecked. Per gli ingredienti che supportano l'operazione viene prodotto un nuovo `Ingredient` con lo stesso tipo e nome, e il contenuto definito in base al tipo di ingrediente che si sta unendo:
	* per `IngQty` il nuovo ingrediente avrà la quantità calcolata come somma di quelle degli ingredienti uniti
	* per `IngWgt` il nuovo ingrediente avrà il peso calcolato come somma dei pesi degli ingredienti uniti
	* per `IngVol` il nuovo ingrediente avrà il volume calcolato come somma dei volumi degli ingredienti uniti
	* per gli ingredienti che non supportano l'operazione (es: `Recipe`) viene lanciata una `UnsupportedOperationException`

Una `Recipe` presenta le seguenti funzionalità aggiuntive:
* permette di aggiungere nuovi `Ingredient` al proprio insieme di ingredienti. Se l'ingrediente è già presente, viene sostituito dall'ingrediente ottenuto unendo l'ingrediente esistente e quello nuovo.
* permette (come metodo privato), di restituire un insieme di tutti gli ingredienti "base", ovvero che non siano di tipo `Recipe`, della ricetta e ricorsivamente di tutte le sottoricette. Se un ingrediente è presente sia in una ricetta che in una sua sottoricetta, in questo processo questi vengono uniti come specificato sopra.
* permette di restituire un iteratore agli ingredienti "base" calcolati al punto precedente, ordinati nel loro ordine naturale

Progettare, specificare ed implementare le classi descritte ed i loro metodi. Quando opportuno, le classi dovranno avere costruttori, Abstraction Function e Representation Invariant, ed eventuali altri metodi o ridefinizioni dei metodi. Dovranno esserci i controlli opportuni ed eventuali lanci di eccezioni appropriate.

Scrivere una classe `Test` che nel `main()` legga da **riga di comando** il nome e la procedura di una ricetta ("ricetta iniziale") e permetta di leggere da **standard input** gli ingredienti della ricetta, uno alla volta, come segue:
* se è un ingrediente misurabile in pezzi, viene inserito nel formato `Qty <nome> <quantità>`
* se è un ingrediente solido sfuso, viene inserito nel formato `Wgt <nome> <peso in l>`
* se è un ingrediente liquido, viene inserito nel formato `Vol <nome> <volume in kg>`
* se l'ingrediente è una sottoricetta, viene inserito nel formato `Recipe <nome> <procedura>` a questo punto i successivi ingredienti inseriti andranno aggiunti alla nuova sottoricetta creata
* per terminare l'inserimento della (sotto)ricetta si dovrà inserire una riga con il solo carattere `.` a questo punto i successivi ingredienti inseriti andranno aggiunti alla ricetta "di livello superiore" che conteneva la sottoricetta appena completata
* quando viene terminato l'inserimento della ricetta iniziale (come descritto al punto precedente), questa viene stampata su **standard output** (elencando i suoi ingredienti, la sua procedura, e stampando ricorsivamente le sue sottoricette)
* infine stampare su **standard output** l'elenco degli ingredienti base usati dalla ricetta e ricorsivamente di tutte le sue sottoricette, come da **esempi d'esecuzione**.

#### Esempio d'esecuzione 1:

```text
$ java Test torta "mischiare farina latte e uova e cuocere a 200 c per 45 min, coprire con crema"
	Inserisci ingredienti
		se è un ingrediente misurabile in pezzi, viene inserito nel formato 'Qty <nome> <quantità>'
		se è un ingrediente solido sfuso, viene inserito nel formato 'Wgt <nome> <quantità in l>'
		se è un ingrediente liquido, viene inserito nel formato 'Vol <nome> <quantità in kg>'
		se l'ingrediente è una sottoricetta, viene inserito nel formato 'Recipe <nome> <procedura>'
		per terminare l'inserimento della (sotto)ricetta inserire una riga con solo un carattere '.'
Qty uova 3
Wgt farina 0.5
Wgt zucchero 0.3
Vol latte 0.5
Recipe crema mischiare tuorli, farina, zucchero e latte e lasciar riposare in frigo per 1h
Qty uova 2
Wgt farina 0.02
Wgt zucchero 0.1
Vol latte 0.2
.
.
torta - ingredienti: 
	uova (3)
	farina (0.5kg)
	zucchero (0.3kg)
	latte (0.5l)

crema - ingredienti: 
	uova (2)
	farina (0.02kg)
	zucchero (0.1kg)
	latte (0.2l)

procedura (crema):
mischiare tuorli, farina, zucchero e latte e lasciar riposare in frigo per 1h

procedura (torta):
mischiare farina latte e uova e cuocere a 200 gradi per 45 minuti, coprire con uno strato di crema pasticcera

Riassunto ingredienti:
farina (0.52kg)
latte (0.7kg)
uova (5)
zucchero (0.4kg)
```

#### Esempio d'esecuzione 2:

```text
$ java Test grog "Il grog è un miscuglio segreto che contiene una o più di queste sostanze: Cherosene,
Glicole Propilenico, Dolcificanti Artificiali, Acido Fosforico, Rum, Acetone, Colorante Rosso numero 2,
Detriti, Grasso per Motore, Acido per la batteria e/o peperone"
        Inserisci ingredienti
                se è un ingrediente misurabile in pezzi, viene inserito nel formato 'Qty <nome> <quantità>'
                se è un ingrediente solido sfuso, viene inserito nel formato 'Wgt <nome> <quantità in l>'
                se è un ingrediente liquido, viene inserito nel formato 'Vol <nome> <quantità in kg>'
                se l'ingrediente è una sottoricetta, viene inserito nel formato 'Recipe <nome> <procedura>'
                per terminare l'inserimento della (sotto)ricetta inserire una riga con solo un carattere '.'
Qty detriti 3
Wgt detriti 0.5
E:different ingredient type
Recipe Dolcificanti cose varie che non sono zucchero
Wgt stevia 0.1
.
Recipe Dolcificanti mettiamone altri
E: Recipes cannot be merged
```
