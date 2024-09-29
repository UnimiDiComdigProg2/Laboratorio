# Calcolatrice

Scrivere un programma che implementi una calcolatrice sequenziale, utilizzando il risultato dell'operazione precedente come il primo operando dell'operazione successiva. 
Il programma deve leggere da **standard input** una serie di righe di testo nel seguente formato: `<operatore> <operando2>`, applicando l'operazione al risultato ottenuto precedentemente (per iniziare, il primo operatore vale `0`) e scrivendo il nuovo risultato su **standard output**.

Inoltre gestire i seguenti casi eccezionali (usando eccezioni esistenti o nuove):
* Se viene inserito un operatore errato scrivere `Operatore non riconosciuto` .
* Se viene inserito un operando errato scrivere `Operando non valido`.
* Se non sono inseriti tutti gli input scrivere `Non sono stati inseriti tutti gli input richiesti`.
* Se nella divisione viene inserito `0` come secondo operando scrivere `Non è possibile dividere per 0`.

In tutti i casi proseguire l'esecuzione chiedendo nuovamente l'inserimento dell'operazione.

##### Esempio d'esecuzione:

```text
$ java CalcolatriceSequenziale
Inserisci <operatore> <operando>. es: + 3
Per terminare inserire il carattere '='.
risultato = 0.0
+ 4 
risultato + 4.0 = 4.0
* 2
risultato * 2.0 = 8.0
=
Il risultato finale e' 8.0

$ java Calcolatrice
Inserisci <operatore> <operando>. es: + 3
Per terminare inserire il carattere '='.
risultato = 0.0
+ 5
risultato + 5.0 = 5.0
* 5
risultato * 5.0 = 25.0
- 6
risultato - 6.0 = 19.0
/ 0
Non è possibile dividere per 0
Inserisci <operatore> <operando>. es: + 3
Per terminare inserire il carattere '='.
risultato = 19.0
- 1
risultato - 1.0 = 18.0
=
Il risultato finale e' 18.0

$ java Calcolatrice
Calcolatrice attivata.
Inserisci <operatore> <operando>. es: + 3
Per terminare inserire il carattere '='.
risultato = 0.0
+ 3
risultato + 3.0 = 3.0
# 2
# e' un operatore sconosciuto.
Inserisci <operatore> <operando>. es: + 3
Per terminare inserire il carattere '='.
risultato = 3.0
=
Il risultato finale e' 3.0
```
