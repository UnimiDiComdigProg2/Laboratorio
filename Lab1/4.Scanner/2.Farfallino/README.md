# Linguaggio farfallino

Nel linguaggio farfallino ciascuna vocale non accentata (`vocale`) viene sostituita da una sequenza di tre caratteri `vocale-f-vocale`. Per esempio, la vocale `a` viene sostituita dalla sequenza `afa`, la vocale `e` dalla sequenza `efe` e così via. Se una vocale è maiuscola, anche la sequenza di tre caratteri che sostituisce la vocale deve essere definita da caratteri maiuscoli (ad esempio, la vocale `A` viene sostituita dalla sequenza `AFA`).

Scrivere un programma che: 
* legga da **standard input** un testo su più righe;
* termini la lettura quando, premendo la combinazione di tasti `Ctrl+D`, viene inserito da **standard input** l'indicatore End-Of-File (EOF);
* ristampi il testo letto dopo averlo tradotto in linguaggio farfallino.

##### Esempio d'esecuzione:

```text
$ java Farfallino
Inserisci un testo su più righe (termina con CTRL+D):
Questo è un testo di prova
da trasformare IN ALFABETO FARFALLINO
Risultato:
Qufuefestofo èfè ufun tefestofo difi profovafa
dafa trafasfoformafarefe IFIN AFALFAFABEFETOFO FAFARFAFALLIFINOFO
```
