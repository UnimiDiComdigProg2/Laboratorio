# Vetreria

Un `Contenitore` di laboratorio può contenere una certa quantità di liquido, fino alla sua massima capienza (ovvero il proprio volume). Il liquido contenuto (se presente) è memorizzato con il suo nome. Se si cerca di creare un `Contenitore` con più liquido della sua capienza, viene lanciata una `CapacityException` (unchecked).

Deve essere possibile versare il liquido da un `Contenitore` dentro un altro, ma solamente se questo contiene lo stesso liquido oppure non contiene già del liquido. Se i liquidi non sono compatibili viene lanciata una `LiquidsException` (checked) e i due contenitori non vengono modificati. Se il `Contenitore` di destinazione ha sufficiente capienza rimanente, tutto il liquido sarà versato, lasciando il `Contenitore` di origine vuoto, mentre il `Contenitore` di destinazione conterrà la somma dei volumi che prima erano contenuti nei due contenitori. Altrimenti, il `Contenitore` sarà riempito fino alla sua massima capienza ed il resto del liquido rimarrà nel `Contenitore` di origine.

Inoltre, i contenitori devono poter essere naturalmente ordinati in base alla loro capienza.

Sono possibili svariati tipi di contenitori, tra cui:
* `Cilindro`, che è definito dal suo raggio `r` e altezza `h`, e che calcola il proprio volume massimo come `h * PI * r^2`
* `Sfera`, che è definita dal suo raggio e che calcola il proprio volume massimo come `PI * r^3 * 4/3`
* `Cuboide` (o parallelepipedo rettangolo) che è un solido con 6 facce rettangolari, ed è definito dai suoi tre lati `a`, `b` e `c`. Il suo volume massimo è calcolato come `a * b * c`.

Creare un metodo `main()` nella classe `Contenitore` per testare i contenitori creati. Specificatamente: 
* creare una `Sfera` di raggio 2, con all'interno acqua per un volume di 25
* creare un `Cuboide` con i lati 2, 3 e 4, vuoto
* creare un `Cilindro` di altezza 3 e raggio 2, con all'interno alcool per un volume di 20
* cercare di travasare il liquido dalla Sfera al Cilindro e scrivere a **standard output** eventuale messaggio di Eccezione
* cercare di travasare il liquido dalla Sfera al Cuboide e scrivere a **standard output** eventuale messaggio di Eccezione
* scrivere a **standard output** i contenitori creati, come da esempio d'esecuzione

#### Esempio d'esecuzione:
```text
$ java Contenitore
liquidi incompatibili acqua e alcool
Sfera - r: 2.0
	(capienza: 33.510321638291124 liquido: acqua qty: 1.0)
Cuboide - a: 2.0 b: 3.0 c: 4.0
	(capienza: 24.0 liquido: acqua qty: 24.0)
Cilindro - h: 3.0 r: 2.0
	(capienza: 37.69911184307752 liquido: alcool qty: 20.0)
```

Una `Vetreria` è un insieme di contenitori di un laboratorio ed espone le seguenti funzionalità:
* Deve permettere di aggiungere di un nuovo `Contenitore` alla vetreria.
* Deve essere possibile estrarre dalla vetreria tutti i contenitori con il liquido di un certo tipo, restituendo una nuova `Vetreria` e rimuovendoli dalla `Vetreria` d'origine.
* Deve poter restituire un iteratore ai contenitori presenti, ordinati in base al loro ordine naturale.

Progettare, specificare ed implementare le classi descritte sopra ed i loro metodi.

Scrivere un metodo main in una classe `Main` per testare le strutture dati create. A tal fine, leggere da **standard input** una serie di righe nel formato `<nomeLiquido> <quantitàLiquido> <tipoContenitore> <parametriContenitore>`, fino a quando non viene premuta la combinazione dei tasti `CTRL+D`. Costruire una `Vetreria` con i contenitori letti e stamparla su **standard output**. Infine, estrarre una `Vetreria` per ciascun liquido diverso e stamparla a **standard output**, come da esempio d'esecuzione.

#### Esempio d'esecuzione:

```text
$ java Main
acqua 1000 Cuboide 10 10 9
Il cuboide ha capienza: 900.0 ma il liquido ha un volume di: 1000.0

$ java Main 
alcool 300 Sfera 5
acqua 1000 Cuboide 10 10 10
alcool 200 Cilindro 5 4

Vetreria con:
	Cuboide - a: 10.0 b: 10.0 c: 10.0
		(capienza: 1000.0 liquido: acqua qty: 1000.0)
	Sfera - r: 5.0
		(capienza: 523.5987755982989 liquido: alcool qty: 300.0)
	Cilindro - h: 4.0 r: 5.0
		(capienza: 314.1592653589793 liquido: alcool qty: 200.0)


Vetreria con:
	Sfera - r: 5.0
		(capienza: 523.5987755982989 liquido: alcool qty: 300.0)
	Cilindro - h: 4.0 r: 5.0
		(capienza: 314.1592653589793 liquido: alcool qty: 200.0)


Vetreria con:
	Cuboide - a: 10.0 b: 10.0 c: 10.0
		(capienza: 1000.0 liquido: acqua qty: 1000.0)
```
