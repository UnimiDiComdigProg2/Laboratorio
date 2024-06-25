# Futsal

Nel futsal (o calcio a 5), una squadra (`Team`) ha 5 giocatori (`Player`). Un `Player` è definito dal suo nome e dal suo numero della maglia e presenta le seguenti funzionalità:
* è considerato uguale a un altro `Player` avente lo stesso numero della maglia
* espone un'ordine naturale in base al numero della maglia

Un `Player` può essere portiere (`Goalie`), oppure uno dei giocatori di campo (`FieldPlayer`).
* Un `Goalie` può restituire la propria frazione di gol parati (tra `0` e `1`)
* i `FieldPlayer` possono restituire i propri punteggi di attacco e difesa (tra `1` e `10` inclusi)

Un `Team` è definito da un nome e dai suoi giocatori e presenta le seguenti funzionalità:
* permette di aggiungere un giocatore alla squadra, con i seguenti vincoli
	* non ci possono essere più giocatori con lo stesso numero di maglia
	* limite di `5` giocatori
	* limite di `1` portiere
	* limite di `4` giocatori di campo
	* in qualunque caso di errore avviene una `TeamException` (checked)
* può giocare contro un'altra squadra restituendo i goal segnati dalla squadra giocante `s1` alla squadra avversaria `s2`, calcolati come: `(s1.a - s2.d) * (1 - s2.p)`, dove:
	* `s1.a` è la somma dei valori di attacco di tutti i giocatori della squadra `s1`
	* `s2.d` è la somma dei valori di difesa di tutti i giocatori della squadra `s2`
	* `s2.p` è il valore di parata del portiere della squadra `s2`
	* la stessa funzionalità invocata dalla squadra `s2` sulla squadra `s1` restituisce i goal segnati da `s2` a `s1`
	* per giocare le squadre devono essere entrambe complete (`5` giocatori di cui `1` portiere e `4` giocatori di campo), se no avviene una `TeamException` 
* permette di iterare su tutti i propri giocatori, ordinati nel loro ordine naturale

Progettare, specificare ed implementare le classi descritte ed i loro metodi. Quando opportuno, le classi dovranno avere costruttori, Abstraction Function e Representation Invariant, ed eventuali altri metodi o ridefinizioni dei metodi. Dovranno esserci i controlli opportuni ed eventuali lanci di eccezioni appropriate.

Scrivere una classe `Test` e nel `main()` che legga da **riga di comando** nomi di due squadre. Poi, per ciascuna squadra, leggere da **standard input** i nomi dei 5 giocatori nel formato:
* `portiere,<numero>,<frazione parate>,<nome>` per creare il portiere
* `giocatore,<numero>,<attacco>,<difesa>,<nome>` per creare un giocatore di campo

La lettura termina quando vengono inseriti tutti i giocatori. Al termine della lettura vengono stampate su **standard output** le due squadre e il risultato della partita, come da **esempi d'esecuzione**.

#### Esempio d'esecuzione 1:

```text
$ java Test Newppy Muppet
	Inserisci i giocatori della squadra: Newppy
		portiere,<numero>,<frazione parate>,<nome>
		giocatore,<numero>,<attacco>,<difesa>,<nome>
giocatore,14,6,3,Bruce Harper
giocatore,10,8,2,Oliver Hutton
portiere,1,0.8,Benjamin Price
giocatore,9,2,6,Johnny Mason
giocatore,11,5,3,Tom Becker

	Inserisci i giocatori della squadra: Muppet
		portiere,<numero>,<frazione parate>,<nome>
		giocatore,<numero>,<attacco>,<difesa>,<nome>
giocatore,4,3,5,Nick Star
portiere,17,0.7,Ed Warner
giocatore,15,7,2,Danny Mellow
giocatore,11,2,6,Keith Coleman
giocatore,10,9,1,Mark Lenders

Squadra: Newppy
	[1] Benjamin Price - portiere (parry: 0.8)
	[9] Johnny Mason - giocatore di campo (atk:2, def:6)
	[10] Oliver Hutton - giocatore di campo (atk:8, def:2)
	[11] Tom Becker - giocatore di campo (atk:5, def:3)
	[14] Bruce Harper - giocatore di campo (atk:6, def:3)

Squadra: Muppet
	[4] Nick Star - giocatore di campo (atk:3, def:5)
	[10] Mark Lenders - giocatore di campo (atk:9, def:1)
	[11] Keith Coleman - giocatore di campo (atk:2, def:6)
	[15] Danny Mellow - giocatore di campo (atk:7, def:2)
	[17] Ed Warner - portiere (parry: 0.7)

Risultato 2:1
```

#### Esempio d'esecuzione 2:

```text
$ java Test Gondor Moria
	Inserisci i giocatori della squadra: Gondor
		portiere,<numero>,<frazione parate>,<nome>
		giocatore,<numero>,<attacco>,<difesa>,<nome>
giocatore,4,6,3,Boromir
giocatore,4,4,5,Faramir
	ERR: number exists
giocatore,5,4,5,Faramir
portiere,99,0.9,Isildur
giocatore,10,8,2,Aragorn
portiere,2,0.1,Denethor
	ERR: Goalie exists
giocatore,2,1,1,Denethor
	Inserisci i giocatori della squadra: Moria
		portiere,<numero>,<frazione parate>,<nome>
		giocatore,<numero>,<attacco>,<difesa>,<nome>
giocatore,6,4,3,Balin
giocatore,9,7,3,Durin
giocatore,7,5,5,Bifur
giocatore,1,4,6,Thorin
giocatore,10,1,6,Bombur
	ERR: too many FieldPlayers
portiere,10,0.93,Bombur
Squadra: Gondor
	[2] Denethor - giocatore di campo (atk:1, def:1)
	[4] Boromir - giocatore di campo (atk:6, def:3)
	[5] Faramir - giocatore di campo (atk:4, def:5)
	[10] Aragorn - giocatore di campo (atk:8, def:2)
	[99] Isildur - portiere (parry: 0.9)

Squadra: Moria
	[1] Thorin - giocatore di campo (atk:4, def:6)
	[6] Balin - giocatore di campo (atk:4, def:3)
	[7] Bifur - giocatore di campo (atk:5, def:5)
	[9] Durin - giocatore di campo (atk:7, def:3)
	[10] Bombur - portiere (parry: 0.93)

Risultato 0:0
```
