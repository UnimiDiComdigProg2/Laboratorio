# Presepio Imminente

Una `Figura` di un `Presepio` è definita dal suo nome. Può essere `Base`, `Persona` o `Animale` e presenta le seguenti funzionalità:
* restituire il proprio nome.
* restituire il proprio valore, calcolato in maniera diversa per ciascun tipo di `Figura`.
* espone un ordine naturale in base al proprio valore.
* è considerata uguale ad un altra `Figura` avente lo stesso tipo e lo stesso nome.

Una `Figura` `Persona` deve avere un nome che finisce in `re` (es: `Pescatore`, `Melchiorre`), altrimenti lancia una `NomeException` (unchecked). Il suo valore è pari al numero dei caratteri che ha il suo nome.

Una `Figura` `Animale` oltre al nome deve avere anche un aggettivo (es: `Bue riscaldante`) ed il suo valore è pari al numero dei caratteri che ha il suo aggettivo.

Una `Figura` `Base` è una delle tre figure principali del `Presepio`, e può avere come nome solamente `Gesù`, `Giuseppe` o `Maria` (altrimenti lancia una `NomeException`). È definita, oltre che dal nome, anche da una serie (1 o +) di aggettivi (es: `Giuseppe vecchio saggio`) e il suo valore è calcolato come la somma delle lunghezza di tutti i suoi aggettivi.

Un `Presepio` contiene le varie figure e permette le seguenti funzionalità:
* aggiungere una `Figura`. Se la figura è già presente lancia una `FiguraException` (checked).
* togliere una `Figura` in base al suo nome. Se non è presente una `Figura` con quel nome lancia una `FiguraException`.
* restituire la somma dei valori di tutte le figure del `Presepio`
* restituire un iteratore alle figure del `Presepio`, ordinate nel loro ordine naturale

Progettare, specificare ed implementare le classi descritte ed i loro metodi. Quando opportuno, le classi dovranno avere costruttori, Abstraction Function e Representation Invariant, ed eventuali altri metodi o ridefinizioni dei metodi di classi estese o interfacce implementate. Dovranno esserci i controlli opportuni ed eventuali lanci di eccezioni appropriate.

Scrivere una classe `Test` che nel `main()` legga da **standard input** istruzioni nel formato:
* `aggiungi <nome> Persona` per inserire una `Figura` di tipo `Persona`.
* `aggiungi <nome> Animale <aggettivo>` per inserire una `Figura` di tipo `Animale`.
* `aggiungi <nome> Base [aggettivo1 aggettivo2 ...]` per inserire una `Figura` di tipo `Base`.
* `togli <nome>` per rimuovere una `Figura`

La lettura termina quando viene inserito, con la combinazione `Ctrl+D` il comando `End-Of-File`.
Infine, stampare su **standard output** il valore totale del `Presepio` e le sue figure, ordinate nel loro ordine naturale e con specificato il loro nome, valore e aggettivi (se ve ne sono), come da esempio d'esecuzione.

#### Esempio d'esecuzione 1:

```text
$ java Test 
Aggiungi o togli Figura (Ctrl+D termina)
	aggiungi <nome> Persona
	aggiungi <nome> Animale <aggettivo>
	aggiungi <nome> Base [aggettivo1 aggettivo2 ...]
	togli <nome>

aggiungi Pastore Persona
aggiungi Asinello Animale bello
aggiungi Gesù Base bello intelligente affascinante simpatico
aggiungi Bue Animale riscaldante
aggiungi Usciere Persona
aggiungi Melchiorre Persona
aggiungi Maria Base vergine graziosa
aggiungi Giuseppe Base vecchio saggio
togli Usciere 
aggiungi Gasparre Persona
aggiungi Baldasarre Persona
aggiungi Mummia Persona
	Emergenza: Mummia non è una Figura Persona del presepio

Presepio Imminente (117)
	Animale: Asinello (5) <bello>
	Persona: Pastore (7)
	Persona: Gasparre (8)
	Persona: Melchiorre (10)
	Persona: Baldasarre (10)
	Animale: Bue (11) <riscaldante>
	Base: Giuseppe (13) [vecchio, saggio]
	Base: Maria (15) [vergine, graziosa]
	Base: Gesù (38) [bello, intelligente, affascinante, simpatico]
```

#### Esempio d'esecuzione 2:
```text
$ java Test 
Aggiungi o togli Figura (Ctrl+D termina)
	aggiungi <nome> Persona
	aggiungi <nome> Animale <aggettivo>
	aggiungi <nome> Base [aggettivo1 aggettivo2 ...]
	togli <nome>

aggiungi Anakin Base jedi potente
	Emergenza: Anakin non è una Figura Base del presepio
aggiungi Imperatore Persona
togli ObiWan
	Emergenza: Figura ObiWan assente
aggiungi Imperatore Persona
	Emergenza: Figura Persona: Imperatore (10) già presente

Presepio Imminente (10)
	Persona: Imperatore (10)
```
