# Lavanderia

Una `Macchina` (di una `Lavanderia`) può essere `Lavatrice` o `Asciugatrice`. Ciascuna `Macchina` presenta le seguenti funzionalità:
* può essere chiusa. Se lo è già viene lanciata una `LockException` (unchecked)
* può essere aperta. Se lo è già viene lanciata una `LockException` (unchecked)
* può essere verificato il suo stato di apertura
* espone un'ordine naturale in base al costo d'utilizzo

Una `Lavanderia` contiene diverse macchine lavatrici o asciugatrici e tiene traccia del credito inserito (comune a tutta la lavanderia). Ciascuna macchina inserita è associata ad un identificativo numerico. Inoltre, una `Lavanderia` espone i seguenti comportamenti:
* permette di aggiungere del credito e restituire il credito totale così ottenuto
* permette di installare una nuova macchina e restituire l'identificativo (consecutivo e crescente) ad essa assegnato automaticamente
* permette di rimuovere una macchina inserita dato il suo identificativo.
* permette di azionare una lavatrice dato il suo identificativo, chiudendo la macchina corrispondente, riducendo il credito del costo d'esercizio della macchina e restituendo il credito residuo
	* se la macchina non è una lavatrice viene lanciata una `UnsupportedOperationException`
	* se il credito inserito non è sufficiente viene lanciata una `CreditException` (checked)
* permette di azionare un'asciugatrice (in maniera simile a quanto scritto sopra)
* permette di aprire una macchina
* permette di iterare su tutte le macchine presenti nella lavanderia

Progettare, specificare ed implementare le classi descritte sopra ed i loro metodi. Quando opportuno, le classi devono avere uno o più costruttori, delle Abstraction Function e Representation Invariant, ed eventuali altri metodi utili o ridefinizioni dei metodi default di Object. I metodi devono svolgere i controlli opportuni ed eventualmente lanciare eccezioni appropriate.

Scrivere una classe `Test` e nel `main()` leggere da **standard input** i comandi per interagire con la lavanderia. I comandi possono essere:
* `installa <lavatrice/asciugatrice> <costo>` per installare una nuova macchina corrispondente
* `lava/asciuga/rimuovi/apri <id>` per svolgere l'operazione corrispondente sulla macchina identificata da `<id>`
* `aggiungi <credito>` per aggiungere del credito e farsi restituire il credito totale
* `status` per stampare a schermo lo stato della lavanderia, come da esempio sottostante

La lettura termina quando viene inserito, con la combinazione `Ctrl+D` il comando `End-Of-File`.

#### Esempio d'esecuzione:

```text
$ java Test 
	Inserisci comandi (Ctrl+D termina)
		installa <lavatrice/asciugatrice> <costo>
		lava/asciuga/rimuovi/apri <id>
		aggiungi <credito>
		status
installa lavatrice 2.5
	Installata lavatrice: 0
installa asciugatrice 3
	Installata asciugatrice: 1
rimuovi 1
installa asciugatrice 4
	Installata asciugatrice: 1
aggiungi 5
	Credito: 5.0
lava 1
	m non è Lavatrice
lava 0
	Credito: 2.5
status
	Lavanderia - credito: 2.5 macchine:
		[0] Lavatrice costo: 2.5 chiusa
		[1] Asciugatrice costo: 4.0 aperta
asciuga 1
	costo > credito
apri 1
	già aperta
apri 0
status
	Lavanderia - credito: 2.5 macchine:
		[0] Lavatrice costo: 2.5 aperta
		[1] Asciugatrice costo: 4.0 aperta
```
