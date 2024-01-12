# Erogatore

Un `Prodotto` è definito da un nome e dal suo prezzo. I prodotti hanno i seguenti comportamenti:
* possono modificare il proprio prezzo
* sono ordinati naturalmente in base all'ordine lessicografico del nome
* due prodotti con lo stesso nome sono considerati uguali

Un `ProdottoControllato` è un `Prodotto` che definisce un'età sotto la quale il prodotto non può essere venduto.

Un `Erogatore` automatico può cotenere diversi prodotti e per ciascuno memorizza la quantità contenuta. Inoltre l'erogatore tiene traccia del credito inserito. Un erogatore ha i seguenti comportamenti:
* permette di aggiungere del credito e restituire il credito totale così ottenuto
* permette di validare l'età dell'acquirente per l'acquisto del *prossimo* prodotto. Per semplicità, basta inserire gli anni dell'acquirente.
* permette di caricare prodotti nuovi o già presenti (in tal caso la loro quantità presente dovrà essere incrementata con la quantità caricata)
* permette di iterare sui prodotti inseriti che dovranno essere restituiti nel loro ordine naturale
* permette di erogare un prodotto (indicato per nome), decrementando il credito (restituendo il rimanente) ed il conteggio del prodotto (se il prodotto viene esaurito è rimosso del tutto dalla memoria). Inoltre, se è stata validata l'età dell'acquirente questa viene resettata.
	* se il prodotto non è presente viene lanciato un `NoSuchElementException`
	* se il credito non è sufficiente viene lanciato un `CreditException` (unchecked)
	* se è un `ProdottoControllato` e non è stata validata un'età sufficiente viene lanciato un `AgeException` (checked) 

Progettare, specificare ed implementare le classi descritte sopra ed i loro metodi. Quando opportuno, le classi devono avere uno o più costruttori, delle Abstraction Function e Representation Invariant, ed eventuali altri metodi utili o ridefinizioni dei metodi default di Object.

Scrivere una classe `Test` e nel `main()` leggere da **riga di comando** i comandi per interagire con l'erogatore. I comandi possono essere:
* `Carica <nome> <prezzo> [etàMin] <qty>` per caricare un prodotto definito dal `nome`. Il parametro opzionale `[etàMin]` è presente nel caso di un `ProdottoControllato`
* `Aggiungi <credito>` per aggiungere del credito e farsi restituire il credito totale
* `Valida <età>` per validare l'età per il prossimo acquisto
* `Eroga <nome>` per erogare il prodotto definito dal `nome`.

La lettura termina quando viene inserito, con la combinazione `Ctrl+D` il comando `End-Of-File`.

Infine, stampare su **standard output** le informazioni sull'erogatore e sui prodotti contenuti

#### Esempio d'esecuzione:

```text
$ java Test 
Inserisci comandi (Ctrl+D termina)
        Carica <nome> <prezzo> [etàMin] <qty>
        Aggiungi <credito>
        Valida <età>
        Eroga <nome>
Carica Acqua 1.5 10
Carica Sigarette 10 18 10
Carica Acqua 1.5 5
Eroga Acqua
        credito < 1.5
Aggiungi 15
        Credito: 15.0
Eroga Acqua
        Credito: 13.5
Eroga Sigarette
        età < min
Valida 20
Eroga Sigarette
        Credito: 3.5
Eroga Birra
        Birra non presente

Erogatore (età validata: 0):
        Prodotto: Acqua prezzo: 1.5 qty: 14
        Prodotto: Sigarette prezzo: 10.0 (min 18 anni) qty: 9
```
