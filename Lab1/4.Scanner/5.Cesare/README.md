# Il cifrario di Cesare

Giulio Cesare usava per le sue corrispondenze riservate un codice di sostituzione molto semplice, nel quale la lettera chiara viene sostituita dalla lettera che la segue di tre posti nell’alfabeto: la lettera A è sostituita dalla D, la B dalla E, e così via fino alle ultime lettere che sono cifrate con le prime.

Chiaro:   A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

Cifrato:  D E F G H I J K L M N O P Q R S T U V W X Y Z A B C

Più in generale si dice cifrario di Cesare un codice nel quale ogni lettera del messaggio chiaro viene spostata di un numero fisso `k` di posti (non necessariamente tre), dove `k` è detto **chiave di cifratura**. 

Scrivere un programma che:
* legga da **riga di comando** un numero intero `k` (la chiave di cifratura);
* legga da **standard input** un messaggio in chiaro su più righe, terminando la lettura quando, premendo la combinazione di tasti `Ctrl+D`, viene inserito da **standard input** l'indicatore End-Of-File (EOF);
* stampi il messaggio cifrato (ottenuto con chiave di cifratura `k`) corrispondente al messaggio in chiaro letto.

Oltre al metodo `main()`, il programma deve definire e utilizzare i seguenti metodi:
* `public static string leggiTesto()` che legge da **standard input** un testo su più righe terminato dall'indicatore EOF, restituendo un valore `string` in cui è memorizzato il testo letto;
* `public static char cifraCarattere(char c, int chiave)` che restituisce il carattere cifrato partendo da `c`, ottenuto con chiave di cifratura `chiave`.Il valore cifrato deve essere minuscolo se `c` è minuscolo e maiuscolo se `c` è maiuscolo;
* `public static String CifraTesto(String s, int chiave)` che restituisce una `String` ottenuta cifrando ogni carattere di `s` tramite la funzione `CifraCarattere()`.

##### Esempio d'esecuzione:
 
 ```text
$ java Cesare 1
Inserisci un testo su più righe (termina con CTRL D):
Testo di esempio
diviso su righe diverse
Testo cifrato:
Uftup ej ftfnqjp
ejwjtp tv sjhif ejwfstf

$ java Cesare -2
Inserisci un testo su più righe (termina con CTRL D):
AbC

dEf
Testo cifrato:
YzA

bCd
```
