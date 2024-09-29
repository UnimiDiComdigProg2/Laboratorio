# Spesa

Un `Prodotto` di un negozio è definito dal suo nome, e dal suo prezzo (decimale), forniti alla sua creazione. Può essere di tipo `ProdottoBase` oppure `ProdottoPeso`. Inoltre, presenta le seguenti funzionalità:
* restituire il proprio nome
* restituire il proprio prezzo
* modificare il proprio prezzo
* restituire il proprio codice univoco (di 10 cifre)
* inoltre, espone un ordine naturale in base al proprio codice
* è considerato uguale ad un altro `Prodotto` avente lo stesso tipo, lo stesso nome, e lo stesso codice

Un `ProdottoBase`, oltre a quanto detto per `Prodotto`, è definito anche dal suo codice univoco di 10 cifre, fornito alla sua creazione.
* se il codice non ha il numero richiesto di cifre, o contiene caratteri diversi da cifre, viene lanciata una CodeException (unchecked)

Un `ProdottoPeso`, oltre a quanto detto per `Prodotto`, è definito anche dal peso della confezione (intero, in grammi, di massimo 6 cifre), e da un codice base di 4 cifre, forniti alla creazione dell'oggetto.
* se il codice non ha il numero richiesto di cifre, o contiene caratteri diversi da cifre, viene lanciata una CodeException
* questo tipo di `Prodotto` calcola il proprio codice univoco di 10 cifre concatenando il proprio codice base e le 6 cifre corrispondenti al peso del prodotto con eventuali zeri davanti (es: 20g = 000020).
* inoltre, il prezzo restituito dall'apposito metodo è calcolato moltiplicando il prezzo fornito alla costruzione dell'oggetto e il suo peso. 

Una `Spesa` è definita da un insieme di prodotti, associati ad un numero di articoli. Presenta le seguenti funzionalità:
* aggiungere un `Prodotto` all'insieme, o incrementarne il numero se già esiste. se un prodotto diverso con lo stesso codice esiste, viene lanciata una ElementException (checked).
* rimuovere un `Prodotto` dato il suo codice. Se un prodotto con il codice specificato non esiste viene lanciata una ElementException
* restituire un iteratore ai `Prodotti` della spesa, ordinati nel loro ordine naturale
* restituire il totale della spesa (somma, su tutti i prodotti, del prezzo del prodotto moltiplicato per numero di articoli).

Progettare, specificare ed implementare le classi descritte ed i loro metodi. Quando opportuno, le classi dovranno avere costruttori, Abstraction Function e Representation Invariant, ed eventuali altri metodi o ridefinizioni dei metodi. Dovranno esserci i controlli opportuni ed eventuali lanci di eccezioni appropriate.

Scrivere una classe `Test` che nel `main()` legga da **standard input** istruzioni nel formato:
* `inserisci <nome> <prezzo> <codice> <qty>` per inserire un `ProdottoBase`
* `inserisci <nome> <prezzo> <codicebase> <peso> <qty>` per inserire un `ProdottoPeso`
* `rimuovi <nome>` per rimuovere un prodotto
La lettura termina quando viene inserito, con la combinazione `Ctrl+D` il comando `End-Of-File`.
Infine, stampare su **standard output** il riepilogo della spesa ed il suo costo totale, come da **esempi d'esecuzione**.

#### Esempio d'esecuzione 1:

```text
$ java Test
Inserisci o rimuovi prodotti (Ctrl+D termina)
	inserisci <nome> <prezzo> <codice> <qty>
	inserisci <nome> <prezzo> <codicebase> <peso> <qty>
	rimuovi <nome>
inserisci griglia 73 8192439021 1
inserisci carbonella 7 4929249249 2
inserisci costine 11.9 2012 3570 1
inserisci salsicce 9.9 2011 2564 1
inserisci salsicce 9.9 2011 1834 1
inserisci insalata 3.4 1033 717 1
rimuovi 1033000717
rimuovi 1033000717
E:c does not exist
  
Spesa:
	2011001834 (salsicce): 18.1566 (1834g) qty: 1
	2011002564 (salsicce): 25.3836 (2564g) qty: 1
	2012003570 (costine): 42.483 (3570g) qty: 1
	4929249249 (carbonella): 7.0 qty: 2
	8192439021 (griglia): 73.0 qty: 1
Tot: 173.0232
```

#### Esempio d'esecuzione 2:
```text
$ java Test
Inserisci o rimuovi prodotti (Ctrl+D termina)
	inserisci <nome> <prezzo> <codice> <qty>
	inserisci <nome> <prezzo> <codicebase> <peso> <qty>
	rimuovi <nome>
inserisci terrazzo 2000 1234567890 1
inserisci sgabello 9 1234567890 1
E:product with same code exists
inserisci formaggio 9.99 1234 567890 1
E:product with same code exists
inserisci borracciablu 6.5 123456d789 1      
E:codice contains non-digits
inserisci razzodigomma 3.25 2345678 1
E:wrong length codice
inserisci cannuccia 0.1 0000 1000000 1     
E:peso < 1 || > 999999

Spesa:
	1234567890 (terrazzo): 2000.0 qty: 1
Tot: 2000.0
```
