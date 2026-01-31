### Olimpiadi Invernali

Progettare, specificare ed implementare le classi descritte sotto ed i loro metodi. Quando opportuno, le classi dovranno avere costruttori, Abstraction Function e Representation Invariant, ed eventuali altri metodi o ridefinizioni dei metodi di classi estese o interfacce implementate. Dovranno esserci i controlli opportuni ed eventuali lanci di eccezioni appropriate.

Un `Evento` delle olimpiadi invernali è definito dal suo nome e due eventi sono considerati uguali se hanno lo stesso nome. Un `Evento` può restituire la sua durata in minuti che dipende dal tipo di `Evento` e gli eventi sono naturalmente ordinati in base alla loro durata.
* Per gli eventi di tipo `Cerimonia`, che possono essere di apertura o di chiusura, la durata è di 60 minuti fissi.
* Per gli eventi di tipo `Gara`, definiti anche dal numero di atleti che vi partecipano, la durata è di 5 min per ciascun atleta.

Scrivere nella classe `Evento` un metodo `main()` per:
1. Creare una `Cerimonia` di apertura di nome `Apertura2026` e scrivere le informazioni su di essa su **standard output**.
2. Creare una `Gara` di nome `Slittino1` con 15 atleti e scrivere le informazioni su di essa su **standard output**.
3. Creare una `Cerimonia` di chiusura di nome `Slittino1` e scrivere le informazioni su di essa su **standard output**.
4. Scrivere su **standard input** il risultato del controllo dell'uguaglianza tra i primi due oggetti e tra gli ultimi due oggetti.
5. Scrivere su **standard input** se il primo oggetto è più grande del secondo oggetto.

#### Esempio d'esecuzione:

```text
$ java Evento
Cerimonia apertura nome: Apertura2026 durata: 60
Gara nome: Slittino1 durata: 75 con 15 atleti
Cerimonia chiusura nome: Slittino1 durata: 60
I primi due sono uguali? false
Gli ultimi due sono uguali? true
Il primo è più grande del secondo? false
```

Una `Olimpiade` invernale è definita dall'anno in cui avviene e dagli eventi calendarizzati durante i 19 giorni della stessa, uno per giorno (dal giorno 1 al giorno 19). Una `Olimpiade` espone le seguenti funzionalità:
* Inserire un `Evento` per un certo giorno. Se quel giorno contiene già un `Evento` viene lanciata una `GiornoException` (checked). Se lo specifico `Evento` che si vuole inserire è già presente, viene lanciata una `EventoException` (unchecked). Se l'`Evento` che si vuole inserire è una `Cerimonia` di apertura e il giorno non è il primo, viene lanciata una `GiornoException`, e similmente se la `Cerimonia` è di chiusura e il giorno non è l'ultimo.
* Rimuovere l'`Evento` di un certo giorno. Se nessun `Evento` è presente per il giorno specificato, viene lanciata la `GiornoException`.
* Iterare gli eventi dell'`Olimpiade`, ordinati in base al loro ordine naturale (ovvero la loro durata).
Inoltre, la funzione di astrazione di `Olimpiade` dovrà restituire una rappresentazione della stessa, specificando il suo anno e di seguito, in ordine di giorno, gli eventi previsti (come da esempio d'esecuzione).

Scrivere una classe `Test` che nel metodo `main()` legga da **riga di comando** l'anno dell'`Olimpiade` e successivamente, da **standard input** delle istruzioni nel formato:
* `aggiungi <giorno> Cerimonia <nome> <apertura / chiusura>` per aggiungere una nuova `Cerimonia`, di apertura o chiusura, nel giorno specificato e con il nome specificato
* `aggiungi <giorno> Gara <nome> <numero atleti>` per aggiungere una nuova `Gara` nel giorno specificato, con il nome e il numero di atleti specificati
* `rimuovi <giorno>` per rimuovere l'`Evento` del giorno specificato
La lettura termina quando viene inserito, con la combinazione `Ctrl+D` il comando `End-Of-File`. Al termine della lettura, stampare su **standard output** l'`Olimpiade`, indicando il suo anno e gli eventi previsti, ordinati per giorno dell'`Olimpiade`. Successivamente, stampare su **standard output** gli eventi ordinati nel loro ordine naturale, come da esempio d'esecuzione.

#### Esempio d'esecuzione:

```text
$ java Test 2026
Comandi possibili (Ctrl+D termina)
	aggiungi <giorno> Cerimonia <nome> <apertura / chiusura>
	aggiungi <giorno> Gara <nome> <numero atleti>
	rimuovi <giorno>

aggiungi 1 Cerimonia Apertura2026 apertura
aggiungi 1 Gara Sci1 10
	ECCEZIONE: un evento già presente per il giorno
aggiungi 3 Gara Sci1 10
aggiungi 5 Gara Sci1 10
	ECCEZIONE: evento esiste
aggiungi 7 Gara Curling1 15
rimuovi 5
	ECCEZIONE: giorno non esiste
rimuovi 3
aggiungi 14 Gara Luge1 20
aggiungi 18 Cerimonia Chiusura2026 chiusura
	ECCEZIONE: cerimonia nel giorno sbagliato
aggiungi 19 Cerimonia Chiusura2026 chiusura

Olimpiade Invernale 2026:
	1: Cerimonia apertura nome: Apertura2026 durata: 60
	7: Gara nome: Curling1 durata: 75 con 15 atleti
	14: Gara nome: Luge1 durata: 100 con 20 atleti
	19: Cerimonia chiusura nome: Chiusura2026 durata: 60

Eventi in ordine di durata:
	Cerimonia apertura nome: Apertura2026 durata: 60
	Cerimonia chiusura nome: Chiusura2026 durata: 60
	Gara nome: Curling1 durata: 75 con 15 atleti
	Gara nome: Luge1 durata: 100 con 20 atleti
```
