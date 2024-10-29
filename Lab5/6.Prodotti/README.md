# Prodotti

Progettare, specificare ed implementare una classe prodotto che modelli prodotti di un negozio, registrandoli con il loro nome e costo. Le operazioni supportate dalla classe devono includere la creazione di un nuovo prodotto, la modifica del costo del prodotto e un metodo `sconto` che restituisce il valore del prodotto scontato del 5%. Estendere la classe in un nuovo tipo `ProdottoAlimentare` che modelli prodotti alimentari deperibili, contenendo anche la data di scadenza (tipo `LocalDate`) e, se la data di scadenza è inferiore a 10 giorni (per queste operazioni usare il tipo `LocalDate` e i suoi metodi), il metodo `sconto` deve restituire il valore del prodotto scontato del 30%. Estendere la classe in un nuovo tipo `ProdottoNonDeperibile` che modelli invece i prodotti non deperibili, contenendo un flag per segnalare se il prodotto è in materiale riciclabile. In tal caso il prodotto sarà scontato del 10% nel metodo `sconto`. Creare una classe di servizio `Main` con il solo metodo `main` per testare il codice creato. Nel `main()` leggere da standard input una serie di prodotti e, per ciascuno, stampare il suo costo scontato. Terminare la lettura con CTRL+D. 

##### Esempio d'esecuzione:

```text
$ java Main
Inserisci un prodotto nel formato: `<nome> <costo> alimentare <datascadenza>` oppure `<nome> <costo> nondeperibile riciclabile\nonriciclabile`
Scarponi 65 nondeperibile nonriciclabile
Prezzo con sconto del 5%: 61.75
Panettone 9 alimentare 20-11-2022
Prezzo con sconto del 30%: 6.3
Quaderno 4 nondeperibile riciclabile
Prezzo con sconto del 10%: 3.6
Tonno 3 alimentare 31-12-2050
Prezzo con sconto del 5%: 2.85
```
