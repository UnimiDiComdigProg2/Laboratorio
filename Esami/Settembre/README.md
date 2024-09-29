# Strategy

In un gioco di strategia, un `Guerriero` è definito dalle sue coordinate `x` e `y` sulla `Mappa`, un `nome`, un valore punti vita (`pv`) ed un valore `attacco`. I valori devono essere positivi alla creazione del guerriero. Inoltre, la classe `Guerriero` presenta le seguenti funzionalità:
* Un `Guerriero` che `attacca` un altro fa danno pari al proprio `attacco` ai `pv` dell'avversario (al massimo pari ai `pv` rimanenti). Per fare questo i due devono essere adiacenti (distanza di Manhattan = 1), altrimenti viene lanciata una `MapException` (checked). Inoltre, entrambi  devono essere ancora con pv > 0 , altrimenti viene lanciata una `CharException` (unchecked)
* due guerrieri sono considerati uguali se hanno lo stesso nome
* i guerrieri sono naturalmente ordinati per i loro punti vita (dal più alto al più basso)

Ci sono inoltre 2 tipi di guerrieri speciali:
* `Arciere`, che può attaccare anche a distanza 2
* `Barbaro`, che a ogni attacco perde 1 pv ma fa 2 danni aggiuntivi

Una `Mappa` definisce una griglia con una `larghezza` ed una `altezza` e può contenere guerrieri, Inoltre presenta le seguenti funzionalità:
* `crea` un nuovo guerriero. Se la posizione non è valida (ad esempio è fuori dalla mappa o già occupata) viene lanciata una `MapException`. Se esiste già quel guerriero nella mappa viene lanciata una `CharException`.
* `muovi` un guerriero ad una posizione a distanza di Manhattan massima di due caselle. Se la posizione è troppo distante o non è valida viene lanciata una `MapException`, e se il guerriero ha 0 pv viene lanciata una `CharException`.
* iterare tutti i guerrieri sulla mappa, ordinati nel loro ordine naturale

Progettare, specificare ed implementare le classi descritte sopra ed i loro metodi. Quando opportuno, le classi devono avere uno o più costruttori, delle Abstraction Function e Representation Invariant, ed eventuali altri metodi utili.

Scrivere una classe `Test` e nel `main()` leggere da **riga di comando** la `larghezza` e l'`altezza` della `Mappa`, e poi, da **standard input**, una serie di righe nel seguente formato: `comando parametri`, dove i comandi e i loro parametri possono essere
* `crea` seguito dal tipo, nome, coordinate, ed i valori (pv, attacco) del guerriero da creare
* `muovi` seguito dal nome e dalla coordinata di arrivo
* `attacca` seguito dai nomi dell'attaccante e del difensore

La lettura delle utenze termina quando viene inserito, con la combinazione `Ctrl+D` il comando `End-Of-File`.
Infine, stampare su **standard output** i guerrieri, ordinati nel loro ordine naturale, con il loro nome, coordinate ed i loro valori.

NOTA: la distanza di Manhattan è la somma tra la distanza (in valore assoluto) delle coordinate x e la distanza delle coordinate y. Ad esempio, tra la posizione 2,3 e la posizione 4,1 la distanza di Manhattan è abs(4-2)+abs(1-3)=4

#### Esempio d'esecuzione:

```text
$ java Test 5 5
Inserisci comando e parametri
crea Arciere Legolas 4 4 6 4
crea Barbaro Conan 0 2 9 5
muovi Legolas 4 2
muovi Conan 2 2
attacca Legolas Conan
muovi Conan 3 2
attacca Legolas Conan
attacca Conan Legolas
attacca Legolas Conan
	Legolas incapacitato
muovi Conan 1 2
	Conan incapacitato

Guerrieri sulla mappa:
	Legolas Arciere 4 2 0 4
	Conan Barbaro 3 2 0 5

$ java Test 4 5
Inserisci comando e parametri
crea Barbaro Attila 4 5 8 2
	Coordinate errate
crea Arciere Robin 2 2 3 2
crea Arciere Robin 1 2 3 2
	Guerriero esiste
crea Arciere Tell 2 2 4 1
	Coordinate occupate

Guerrieri sulla mappa:
	Robin Arciere 2 2 3 2

$ java Test 5 3
Inserisci comando e parametri
crea Barbaro Barbero 0 1 10 3
crea Barbaro Berbero 4 1 12 3
muovi Barbero 3 1
	Troppo distante
attacca Berbero Barbero
	Troppo distante

Guerrieri sulla mappa:
	Berbero Barbaro 4 1 12 3
	Barbero Barbaro 0 1 10 3
```
