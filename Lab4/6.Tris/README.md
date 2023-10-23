# Tris

Progettare, specificare e implementare una classe `Tris` che modelli il gioco del tris con due giocatori. A tal fine è necessario memorizzare un tabellone 3x3 e il giocatore di turno (`X` o `O`). Definire i seguenti metodi:
* il costruttore `Tris()` che crea un nuovo gioco col tabellone vuoto e assegna il turno al giocatore `O`
* `public char turno()` che restituisce il carattere del giocatore di turno (`X` o `O`)
* `public void mossa(int x, int y) throws IllegalArgumentException` che inserisce il carattere del giocatore di turno alle coordinate specificate, lanciando l'eccezione se la posizione è occupata
* `public boolean vittoria()` che restituisce true se il giocatore di turno ha vinto (tre dei suoi simboli in fila su riga, colonna o diagonale)
* `public boolean terminato()` che restituisce true se sono state giocate tutte e 9 le mosse
* inoltre, ridefinire il metodo `toString()` per restituire una rappresentazione in stringa del tabellone

Nella classe `Tris` implementare un metodo `main()` per il testing della classe. Il metodo deve creare una nuova istanza di Tris, chiedere l'inserimento delle mosse dei giocatori da **standard input** e restituire il risultato quando il gioco termina. Poi, potrà essere chiesto di giocare a una nuova partita.


##### Esempio d'esecuzione:

```text
$ java Tris 
Mossa di O
Inserisci: x y
1 1

-----------------
|R\C| 1 | 2 | 3 |
-----------------
| 1 | O |   |   |
-----------------
| 2 |   |   |   |
-----------------
| 3 |   |   |   |
-----------------

Mossa di X
Inserisci: x y
1 2

-----------------
|R\C| 1 | 2 | 3 |
-----------------
| 1 | O | X |   |
-----------------
| 2 |   |   |   |
-----------------
| 3 |   |   |   |
-----------------

Mossa di O
Inserisci: x y
2 1

-----------------
|R\C| 1 | 2 | 3 |
-----------------
| 1 | O | X |   |
-----------------
| 2 | O |   |   |
-----------------
| 3 |   |   |   |
-----------------

Mossa di X
Inserisci: x y
2 2

-----------------
|R\C| 1 | 2 | 3 |
-----------------
| 1 | O | X |   |
-----------------
| 2 | O | X |   |
-----------------
| 3 |   |   |   |
-----------------

Mossa di O
Inserisci: x y
3 1

-----------------
|R\C| 1 | 2 | 3 |
-----------------
| 1 | O | X |   |
-----------------
| 2 | O | X |   |
-----------------
| 3 | O |   |   |
-----------------

Ha vinto O
Un'altra partita? (S/s per si)
n
```
