# Evento

Progettare, specificare e implementare una classe `Evento`, che modelli un evento di un calendario, definito da una data specificata e dal suo nome (`Evento(Date data, String nome)`). La classe dovrà essere in grado di restituire il nome (`String getNome()`) e la data dell'evento (`Date getData()`), dovrà poter verificare se due istanze di `Evento` sono uguali, e dovrà poter creare un nuovo evento con lo stesso nome ma a `n` giorni di distanza (`Evento copiaEvento(int n)`). Definire in maniera indipendente le eventuali eccezioni da lanciare e documentarle in maniera appropriata.
Per implementare la data è possibile usare il tipo `java.util.Date`.

Implementare un metodo `main()` per il testing della classe. Il metodo deve leggere da **standard input** la data di un evento (nel formato `gg/mm/aaaa`) ed il suo nome e poi la data di un secondo evento ed il suo nome, stampando se i due eventi sono uguali. Verificare in maniera indipendente la funzione `copiaEvento`.

Ragionare sulle **Astrazioni** da utilizzare per i tipi di dati implementati e sulla loro **Rappresentazione**. Implementare gli appositi metodi **Funzione di Astrazione** ed **Invariante di Rappresentazione**

##### Esempio d'esecuzione:

```text
$ java Evento
Inserisci data del primo evento
13/5/2022
Inserisci nome del primo evento
nomeEvento
Inserisci data del secondo evento
13/5/2022
Inserisci nome del secondo evento
nomeEvento
I due eventi sono uguali
```
