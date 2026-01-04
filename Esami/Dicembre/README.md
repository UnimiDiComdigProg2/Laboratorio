### Calendario delle sorprese

Progettare, specificare ed implementare le classi descritte sotto ed i loro metodi. Quando opportuno, le classi dovranno avere costruttori, Abstraction Function e Representation Invariant, ed eventuali altri metodi o ridefinizioni dei metodi di classi estese o interfacce implementate. Dovranno esserci i controlli opportuni ed eventuali lanci di eccezioni appropriate.

Una `Sorpresa` è definita dal suo nome e due sorprese sono considerate uguali se hanno lo stesso nome. Inoltre, una `Sorpresa` può restituire il suo costo, e le sorprese sono naturalmente ordinate in base al loro costo. Il costo si calcola in maniera dipendente dal tipo della `Sorpresa`:
* Per le sorprese di tipo `Cioccolatino`, definite anche dalla loro percentuale di cacao, il costo è un decimo della percentuale di cacao.
* Per le sorprese di tipo `Giocattolo`, definite anche da una loro descrizione, il costo è pari al numero delle parole della descrizione.

Scrivere nella classe `Sorpresa` un metodo `main()` per:
1. Creare un `Cioccolatino` di nome `Lindt` con 25% di cacao e scrivere le informazioni su di esso su **standard output**.
2. Creare un `Giocattolo` di nome `Yorick` con come descrizione `di infinita allegria` e scrivere le informazioni su di esso su **standard output**.
3. Creare un `Cioccolatino` di nome `Yorick` con 1% di cacao e scrivere le informazioni su di esso su **standard output**.
4. Scrivere su **standard input** il risultato del controllo dell'uguaglianza tra i primi due oggetti e tra gli ultimi due oggetti.
5. Scrivere su **standard input** se il primo oggetto è più grande del secondo oggetto.

#### Esempio d'esecuzione:

```text
$ java Sorpresa
Cioccolatino: Lindt (2.5) cacao: 25%
Giocattolo: Yorick (3.0) descrizione: di infinita allegria
Cioccolatino: Yorick (0.1) cacao: 1%
I primi due sono uguali? false
Gli ultimi due sono uguali? true
Il primo è più grande del secondo? false
```

Un `Calendario` delle sorprese è costituito da una serie di caselle, una per giorno (dal giorno 1 al giorno 31), dentro le quali potrebbe esserci una `Sorpresa`. Un `Calendario` espone le seguenti funzionalità:
* Inserire una `Sorpresa` nel `Calendario` per un certo giorno. Se quel giorno contiene già una sorpresa viene lanciata una `GiornoException` (checked). Se la specifica `Sorpresa` che si vuole inserire è già presente nel `Calendario`, viene lanciata una `SorpresaException` (unchecked).
* Aprire la casella di un certo giorno, ottenendo la `Sorpresa` contenuta e rimuovendola dal `Calendario`. Se nessuna `Sorpresa` è presente per il giorno, viene lanciata la `GiornoException`.
* Restituire il costo del `Calendario` che è calcolato come la somma dei costi di tutte le sorprese in esso contenute.
* Iterare le sorprese contenute nel `Calendario`, ordinate in base al loro ordine naturale (ovvero il loro costo, vedi sotto).

Scrivere una classe `Test` che nel metodo `main()` legga da **standard input** delle istruzioni nel formato:
* `inserisci <giorno> Cioccolatino <nome> <% cacao>` per inserire un nuovo `Cioccolatino` nel giorno specificato con il nome e percentuale cacao specificati
* `inserisci <giorno> Giocattolo <nome> <descrizione>` per inserire un nuovo `Giocattolo` nel giorno specificato con il nome e la descrizione specificata
* `apri <giorno>` per aprire la casella del giorno specificato, rimuovendo l'eventuale `Sorpresa` contenuta dal `Calendario` e scrivendola su **standard output**
* La lettura termina quando viene inserito, con la combinazione `Ctrl+D` il comando `End-Of-File`. Al termine della lettura, stampare su **standard output** il `Calendario`, indicando il suo costo e le sorprese contenute, come da esempio d'esecuzione.

#### Esempio d'esecuzione:

```text
$ java Test
Inserisci sorpresa o apri giorno (Ctrl+D termina)
	inserisci <giorno> Cioccolatino <nome> <% cacao>
	inserisci <giorno> Giocattolo <nome> <descrizione>
	apri <giorno>

inserisci 4 Cioccolatino Venchi 35
inserisci 13 Giocattolo Trippy Gioia e Mistero
inserisci 4 Giocattolo Yorick di infinita allegria
	Eccezione: Una sorpresa già presente per il giorno
inserisci 19 Cioccolatino Trippy 3
	Eccezione: Questa sorpresa già presente nel calendario
inserisci 22 Cioccolatino Lindt 99
apri 4
	trovato: Cioccolatino: Venchi (3.5) cacao: 35%
apri 5
	Eccezione: Nessuna sorpresa per il giorno

Calendario delle sorprese (12.9)
	Giocattolo: Trippy (3.0) descrizione: Gioia e Mistero
	Cioccolatino: Lindt (9.9) cacao: 99%
```