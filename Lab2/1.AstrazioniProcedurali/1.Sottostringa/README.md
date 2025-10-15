# Sottostringa

Scrivere una programa che legga da **riga di comando** due stringhe. Se la seconda stringa è contenuta nella prima, scrivere a **standard output** `<stringa2> è sottostringa di <stringa1>`, altrimenti `<stringa2> non è sottostringa di <stringa1>`, come da esempi d'esecuzione.

A tal fine specificare, implementare e utilizzare la seguente **procedura parziale**:
* `public static boolean sottoStringa(String testo, String parola)` che restituisce se `true` se `parola` è sottostringa di `testo` e `false` altrimenti.

Infine, scrivere una seconda versione del programma rendendo la **procedura totale** aggiornando opportunamente le specifiche.

##### Esempio d'esecuzione:

```text
$ java Sottostringa sfigmomanometro mano
mano è sottostringa di sfigmomanometro

$ java Sottostringa paretimologia parete
parete non è sottostringa di paretimologia

$ java Sottostringa Maiuscoletto mai
mai è sottostringa di Maiuscoletto
```

Notate l'ultimo esempio. Avete considerato questo caso nella specifica della procedura parziale?
Avete davvero reso la procedura totale? Se no sistemate la procedura e le specifiche
