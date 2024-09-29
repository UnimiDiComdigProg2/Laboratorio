# Operatore telefonico

Una singola `Utenza` telefonica è caratterizzata da un numero telefonico e dal nome dell'utente.
* Un numero telefonico è composto da 10 cifre arbitrarie e, poiché non ci possono essere numeri uguali, due utenze sono considerate identiche se hanno lo stesso numero telefonico.
* Una `Utenza` tiene traccia del numero di secondi di conversazione effettuati, incrementati con un metodo.
* Le utenze sono naturalmente ordinate per la durata delle chiamate effettuate.

Ci possono essere diversi tipi di utenze:
* Una `UtenzaPrepagata` ha un credito residuo di secondi di conversazione che viene decrementato. Questa utenza può essere ricaricata con un certo numero di secondi attraverso un apposito metodo. Se si cerca di effettuare conversazioni più lunghe del credito residuo, viene lanciata una `TempoEsauritoException` (unchecked).
* Una `UtenzaSoglia` ha un numero fisso settimanale di secondi disponibili, corrispondente ad una soglia inserita alla creazione dell'utenza, che si resettano ogni settimana (i secondi non usati sono persi). Il reset viene effettuato attraverso un metodo apposito. Se si cerca di effettuare conversazioni più lunghe della disponibilità residua, viene lanciata una `TempoEsauritoException` (unchecked). 

Un `Operatore` contiene l'elenco delle proprie utenze, e:
* permette l'inserimento di nuove utenze, lanciando una `UtenzaNonValidaException` (checked) se questa è già presente
* permette di restituire una `Utenza` dato il suo numero, lanciando una `UtenzaNonValidaException` (checked) se questa non è presente
* presenta un iteratore che attraversa le utenze in base al loro ordine naturale specificato sopra.

Progettare, specificare ed implementare le classi descritte sopra ed i loro metodi. Quando opportuno, le classi devono avere uno o più costruttori, delle Abstraction Function e Representation Invariant, ed eventuali altri metodi utili.

Scrivere una classe Test e nel `main()` leggere da **riga di comando** il nome dell'operatore e poi, da **standard input**, una serie di righe nel formato `NumeroUtenza parametri`, dove i `parametri` possono essere:
* `add` per creare una nuova `Utenza`. In tal caso seguirà il tipo di utenza (`Soglia-ValoreSoglia`, `Prepagata`) e il nome dell'utente
* `call` seguita dalla durata della chiamata
* `load` seguita dal numero dei secondi di ricarica (valido solo per `UtenzaPrepagata`)
* `reset` (valido solo per `UtenzaSoglia`)

Gestire gli ultimi due casi anche per utenze di tipo errato.

La lettura delle utenze termina quando viene inserito, con la combinazione `Ctrl+D` il comando `End-Of-File`.
Infine, se non ci sono state eccezioni, stampare su **standard output** le utenze del operatore, ordinate nel loro ordine naturale, con il loro numero, nome e durata delle chiamate

#### Esempio d'esecuzione:

```text
$ java Test TIM
Inserisci Utenza e comando (add/call/load/reset):
1234567890 add Soglia-100 Fumagalli Brambilla
0987654321 add Soglia-20 Ajeje Brazorf
6789012345 add Prepagata Johnny Glamour
6789012345 load 100
1234567890 call 80
0987654321 call 6
6789012345 call 70
0987654321 reset
0987654321 call 10

Utenze di TIM:
	Utenza di Ajeje Brazorf, numero: 0987654321; durata: 16, credito: 10, soglia: 20
	Utenza di Johnny Glamour, numero: 6789012345; durata: 70, credito: 30
	Utenza di Fumagalli Brambilla, numero: 1234567890; durata: 80, credito: 20, soglia: 100

$ java Test Wind
4561237890 add Prepagata Maestrale
4561237890 add Soglia-20 Libeccio
UtenzaNonValidaException: utenza esiste

$ java Test Iliad
Inserisci Utenza e comando (add/call/load/reset):
1111111111 add Prepagata Achille Pelide
1111111111 reset
java.lang.ClassCastException: UtenzaPrepagata cannot be cast to UtenzaSoglia

$ java Test Fastweb
Inserisci Utenza e comando (add/call/load/reset):
5454545454 add Soglia-20 Peter Parker
5454545454 load 20
java.lang.UnsupportedOperationException: ricarica non supportata

$ java Test Vodafone
Inserisci Utenza e comando (add/call/load/reset):
1029384756 add Soglia-50 Rolando
1029384756 call 60
TempoEsauritoException: credito esaurito
```
