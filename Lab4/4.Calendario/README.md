# Calendario

Progettare, specificare e implementare una classe `Calendario` per gestire un calendario eventi. La classe deve essere in grado di gestire l'inserimento di un numero arbitrario di oggetti di tipo `Evento` (dell'esercizio precedente). Sono possibili più eventi in una determinata data e sono possibili eventi in date diverse con lo stesso nome (es ricorrenze). Se però l'evento da inserire è uguale a uno già inserito (per data e nome) non deve essere inseribile. Un evento deve essere cancellabile, specificandone la data e il nome (se esiste). Inoltre, il `Calendario` deve poter restituire tutti gli eventi di una certa data. Infine, la classe dovrà avere un metodo per copiare un `Evento` esistente a `n` giorni di distanza.

Nella classe `Calendario` implementare un metodo `main()` per il testing della classe. Il metodo deve leggere da **standard input** una serie di righe (finchè non viene premuto CTRL+D) in questo formato: `<+/-> <NomeEvento> <gg/mm/aaaa>` e creare (`+`) o cancellare (`-`) l'evento in data specificata e con il nome specificato, stampando messaggi appropriati se l'oggetto è già presente o non esiste nel calendario. Se il carattere iniziale passato è `*`, l'evento specificato dovrà essere copiato in una nuova data definita da un ulteriore parametro che specifica il numero di giorni fra quanti dovrà essere inserito l'evento copiato. In tal caso il formato sarà `<*> <NomeEvento> <gg/mm/aaaa> <offset>`.

Ragionare sulle **Astrazioni** da utilizzare per i tipi di dati implementati e sulla loro **Rappresentazione**. Implementare gli appositi metodi **Funzione di Astrazione** ed **Invariante di Rappresentazione**

##### Esempio d'esecuzione:

```text
$ java Calendario 
Inserisci +/-/* NomeEvento gg/mm/aaaa [offset] (termina con CTRL+D)
+ compleannoNipote 13/5/2022
+ dataInutile 1/11/2022
+ compleannoCugino 14/1/2022
- dataInutile 1/11/2022
* compleannoNipote 13/5/2022 365

Calendario: (
        Evento: compleannoNipote in data: 13/5/2023
        Evento: compleannoCugino in data: 14/1/2022
        Evento: compleannoNipote in data: 13/5/2022
)
```
