# Documentale

In un sistema documentale un `Contenuto`, definito dal suo nome (che non può essere vuoto), può essere un `Documento` o una `Cartella`. Qualsiasi `Contenuto` presenta le seguenti funzionalità:
* permette di restituire il suo nome
* permette di restituire la sua dimensione
* espone un'ordine naturale in base alla dimensione
* è considerato uguale a un altro `Contenuto` avente lo stesso nome

Un `Documento` è definito anche dalla sua dimensione, nota alla creazione del documento.

Invece una `Cartella` può contenere altri contenuti e tiene traccia anche della propria `Cartella` superiore (se presente). Una `Cartella` presenta le seguenti funzionalità:
* permette di restituire la sua dimensione (somma delle dimensioni di tutti i suoi contenuti)
* permette di restituire la propria `Cartella` superiore
	* Se non ve n'è una dovrà lanciare una `NoSuchElementException`
* permette di restituire una `Cartella` contenuta dato il suo nome
	* Nel caso il nome non corrisponda a un `Contenuto` dovrà lanciare una `NoSuchElementException`
	* Nel caso il nome corrisponda a un `Documento` dovrà lanciare una `NoSuchDirException` (checked)
* permette di aggiungere un nuovo `Contenuto`
	* Se il `Contenuto` esiste già, dovrà lanciare una `ElementExistsException` (unchecked)
	* Se il `Contenuto` è una `Cartella`, `this` dovrà essere messo come la sua `Cartella` superiore.
*  permette di rimuovere un proprio `Contenuto` dato il suo nome
	* Nel caso il nome non corrisponda a un `Contenuto` dovrà lanciare una `NoSuchElementException`
* permette di iterare su tutti i propri contenuti, ordinati nel loro ordine naturale

Progettare, specificare ed implementare le classi descritte ed i loro metodi. Quando opportuno, le classi dovranno avere costruttori, Abstraction Function e Representation Invariant, ed eventuali altri metodi o ridefinizioni dei metodi. Dovranno esserci i controlli opportuni ed eventuali lanci di eccezioni appropriate.

Scrivere una classe `Test` e nel `main()` creare una `Cartella` root `\` nella variabile `current`. leggere da **standard input** i comandi per interagire con questa variabile. I comandi possono essere:
* `crea cartella <nome>` per creare una nuova `Cartella` dentro `current`
* `crea documento <nome> <dimensione>` per creare un nuovo `Documento` dentro `current`
* `rimuovi <nome>` per rimuovere il `Contenuto` specificato da `current`
* `entra <nome>` per assegnare la `Cartella` specificata a `current`
* `esci` per assegnare la `Cartella` superiore di `current` a `current`
* `elenca` per scrivere su **standard output** informazioni sulla `Cartella` `current` e quello che contiene, come da esempio d'esecuzione.

La lettura termina quando viene inserito, con la combinazione `Ctrl+D` il comando `End-Of-File`.

#### Esempio d'esecuzione:

```text
$ java Test 
	Inserisci comandi (Ctrl+D termina)
		crea cartella <nome>
		crea documento <nome> <dimensione>
		rimuovi <nome>
		entra <nome>
		esci
		elenca
crea cartella famiglia
entra famiglia 
crea cartella foto
entra foto
crea documento 1.jpg 500
crea documento 2.jpg 450
esci
crea documento password 18
esci
crea cartella lavoro
entra lavoro
crea documento todo 212
entra todo
ECCEZIONE:contenuto non è una cartella
crea documento todo 300
ECCEZIONE:contenuto esiste
crea cartella progetti
crea documento conquistaMondo 25
entra progetti
crea documento videoGattini 434
esci
elenca
Cartella lavoro dimensione: 671
	Documento conquistaMondo dimensione: 25
	Documento todo dimensione: 212
	Cartella progetti dimensione: 434
		Documento videoGattini dimensione: 434
rimuovi conquistaMondo
esci
elenca
Cartella / dimensione: 1614
	Cartella lavoro dimensione: 646
		Documento todo dimensione: 212
		Cartella progetti dimensione: 434
			Documento videoGattini dimensione: 434
	Cartella famiglia dimensione: 968
		Documento password dimensione: 18
		Cartella foto dimensione: 950
			Documento 2.jpg dimensione: 450
			Documento 1.jpg dimensione: 500
esci
ECCEZIONE:non ha una cartella superiore
rimuovi inesistente
ECCEZIONE:contenuto non esiste
crea documento leggerissimo -3
ECCEZIONE:dimensione documento < 0
```