# Calcolatrice con memoria

Scrivere un programma che implementi una calcolatrice sequenziale su numeri decimali, utilizzando il risultato dell'operazione precedente come il primo operando dell'operazione successiva.
Il programma deve includere una classe `SvolgiCalcolo` in grado di conservare uno stato di memoria e applicare al risultato in memoria operazioni algebriche base con un secondo operando dato come parametro.
Modellare, specificare ed implementare i seguenti metodi della classe `Calcolatrice`:
* il costruttore `public SvolgiCalcolo()` che inizializza la calcolatrice impostando lo stato di memoria iniziale a 0;
* il costruttore `public SvolgiCalcolo(double mem)` che inizializza la calcolatrice impostando lo stato di memoria iniziale a `mem`;
* il metodo `public double getMem()` che restituisce il valore correntemente in memoria
* il metodo `public double add(double op2)` che svolge l'operazione somma tra il valore in memoria e `op2`, impostando il valore in memoria al risultato dell'operazione e restituendolo
* il metodo `public double sub(double op2)` che svolge l'operazione differenza tra il valore in memoria e `op2`, impostando il valore in memoria al risultato dell'operazione e restituendolo
* il metodo `public double mul(double op2)` che svolge l'operazione prodotto tra il valore in memoria e `op2`, impostando il valore in memoria al risultato dell'operazione e restituendolo
* il metodo `public double div(double op2) throws DivideByZeroException` che svolge l'operazione divisione tra il valore in memoria e `op2`, impostando il valore in memoria al risultato dell'operazione. Se `op2` è uguale a 0, il metodo lancia una `DivideByZeroException`. A tal fine, definire una nuova eccezione `checked` chiamata `DivideByZeroException`.
* il metodo `public double operate(char operator, double op2) <stabilire le eccezioni>` che esegue, chiamando i metodi opportuni, le operazioni di tipo `operator` tra il valore in memoria e `op2`, impostando il valore in memoria al risultato dell'operazione. Se `operator` non corrisponde a `+`, `-`, `*` e `/` il metodo lancia una InputMismatchException. Ci sono altre eccezioni da considerare? Come sono le specifiche del metodo?
* un metodo `main()` per testare il funzionamento dei metodi implementati che legga da **riga di comando** un valore decimale e inizializzi una nuova istanza di SvolgiCalcolo con quel valore. Se nessun valore è inserito inizializzare la calcolatrice col valore `0`.
Poi, mediante **standard input**, il metodo deve leggere una serie di righe di testo nel seguente formato: `<operatore> <operando2>`, applicando l'operazione sulla calcolatrice e scrivendo il nuovo risultato su **standard output**. La lettura termina quando viene inserito il carattere `=`. 


##### Esempio d'esecuzione:

```text
$ java SvolgiCalcolo 3
Calcolatrice inizializzata, valore: 3
Inserisci <operatore> <operando>. es: + 3
Per terminare inserire il carattere '='.
+ 4 
valore in memoria: 7.0
* 2
valore in memoria: 14.0
=
Il risultato finale e' 14.0

$ java SvolgiCalcolo
Calcolatrice inizializzata, valore: 0
Inserisci <operatore> <operando>. es: + 3
Per terminare inserire il carattere '='.
+ 5
valore in memoria: 5.0
* 5
valore in memoria: 25.0
- 6
valore in memoria: 19.0
/ 0
Non è possibile dividere per 0
Inserisci <operatore> <operando>. es: + 3
Per terminare inserire il carattere '='.
valore in memoria: 19.0
- 1
valore in memoria: 18.0
=
Il risultato finale e' 18.0
```
