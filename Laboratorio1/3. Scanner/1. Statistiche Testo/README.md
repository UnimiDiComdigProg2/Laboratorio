# Statistiche testo

Scrivere un programma che: 
* legga da **standard input** un testo su più righe;
* termini la lettura quando, premendo la combinazione di tasti `Ctrl+D`, viene inserito da **standard input** l'indicatore End-Of-File (EOF);
* stampi a video le seguenti statistiche relative al testo letto:
  1. il numero di linee
  1. il numero di parole presenti nel testo;
  2. la lunghezza media delle parole presenti nel testo.

**Nota:** una parola è una sequenza di caratteri consecutivi. I caratteri di spaziatura intervallano parole diverse.

##### Esempio d'esecuzione:

```text
$ java statText
Inserisci un testo su più righe (termina con Ctrl+D):
testo di prova
su cui provare le statistiche
Statistiche:
Numero linee: 2
Numero parole: 8
Lunghezza media: 4.625
```
