# Vetreria

Un `Contenitore` può contenere una certa quantità di liquido, fino ad un massimo pari al proprio volume. Se si cerca di creare un `Contenitore` con più liquido della sua capienza, viene lanciata una `ExceededCapacityException` (checked) Il liquido contenuto (se presente) è memorizzato con il suo nome (vuoto se non vi è del liquido). È possibile versare il liquido di un contenitore dentro un altro, ma solamente se questo contiene lo stesso liquido oppure non contiene già del liquido. Se i liquidi non sono compatibili viene lanciata una `IncompatibleLiquidsException` (unchecked) e i due contenitori non vengono modificati. Se il contenitore di destinazione ha sufficiente capienza rimanente, tutto il liquido sarà versato, lasciando il contenitore di origine vuoto, mentre il contenitore di destinazione conterrà la somma dei volumi che prima erano contenuti nei due contenitori. Altrimenti, il contenitore sarà riempito fino alla sua massima capienza ed il resto del liquido rimarrà nel contenitore di origine. I contenitori devono poter essere naturalmente ordinati in base alla loro capienza (in ordine DECRESCENTE).

Sono possibili svariati tipi di contenitori, tra cui:
* `Cilindro`, che è definito dal suo raggio `r` e altezza `h`, e che calcola il proprio volume massimo come `h * PI * r^2`
* `Sfera`, che è definita dal suo raggio e che calcola il proprio volume massimo come `PI * r^3 * 4/3`
* `Cuboide` (o parallelepipedo rettangolo) che è un solido con 6 facce rettangolari, ed è definito dai suoi tre lati `a`, `b` e `c`. Il suo volume massimo è calcolato come `a * b * c`

Una `Vetreria` è un insieme di contenitori di un laboratorio. Deve poter restituire un iteratore ai contenitori presenti. Deve anche essere in grado di ordinare i propri contenitori in base alla loro capienza (in ordine DECRESCENTE). Inoltre, deve essere possibile estrarre dalla vetreria tutti i contenitori con il liquido di un certo tipo, restituendo una nuova `Vetreria` e rimuovendoli dalla `Vetreria` d'origine. Infine, deve essere previsto un metodo per ottimizzare la distribuzione dei liquidi, riempiendo fino al massimo quelli più capienti (con lo stesso liquido) e svuotando, se possibile, alcuni tra quelli meno capienti.

Progettare, specificare ed implementare le classi descritte sopra ed i loro metodi.

Scrivere un metodo main nella classe `Vetreria` per testare le strutture dati create. A tal fine, leggere da **standard input** una serie di righe nel formato `<nomeLiquido> <quantitàLiquido> <tipoContenitore> <parametriContenitore>`, fino a quando non viene premuta la combinazione dei tasti `CTRL+D`. Costruire una `Vetreria` con i contenitori letti e stamparla su **standard output**. Infine, estrarre una `Vetreria` per ciascun liquido diverso, ordinarla per volume del contenitore, ottimizzarla e stamparla a **standard output**, come da esempio d'esecuzione.

#### Esempio d'esecuzione:

```text
$ java Vetreria
acqua 1000 Cuboide 10 10 9
Il cuboide ha capienza: 900.0 ma il liquido ha un volume di: 1000.0

$ java Vetreria 
alcool 300 Sfera 5
acqua 1000 Cuboide 10 10 10
alcool 200 Cilindro 5 4

Vetreria con:
  Sfera - raggio: 5.0
    (capienza: 523.5987755982989, contenuto: 300.0, liquido: alcool)
  Cuboide - lati: 10.0, 10.0, 10.0
    (capienza: 1000.0, contenuto: 1000.0, liquido: acqua)
  Cilindro - altezza: 5.0, raggio: 4.0
    (capienza: 251.32741228718345, contenuto: 200.0, liquido: alcool)

Vetreria con:
  Sfera - raggio: 5.0
    (capienza: 523.5987755982989, contenuto: 500.0, liquido: alcool)
  Cilindro - altezza: 5.0, raggio: 4.0
    (capienza: 251.32741228718345, contenuto: 0.0)

Vetreria con:
  Cuboide - lati: 10.0, 10.0, 10.0
    (capienza: 1000.0, contenuto: 1000.0, liquido: acqua)

```
