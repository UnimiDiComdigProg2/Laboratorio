# Ricevimento Studenti

Scrivere un programma che permetta agli studenti di prenotare il ricevimento con un docente, segnalando gli appuntamenti possibili. Gli appuntamenti possono essere prenotati per le ore 13, 14, 15, 16, 17 o 18. Il programma deve leggere da **standard input** il nome dello studente che desidera prenotarsi ed in seguito l'ora in cui si vuole prenotare. Se ci sono ancora delle disponibilità di orario, il programma tornerà a chiedere l'inserimento di un nuovo appuntamento, altrimenti terminerà stampando gli orari e i rispettivi nomi degli studenti prenotati.

In una classe statica `Ricevimento` evono essere specificate, implementate ed utilizzate almeno le seguenti **procedure totali**:

* `public static void prenota(String[] agenda, int ora, String nome) throws NullPointerException, AlreadyBookedException, TimeBusyException, IllegalArgumentException` che **modifica** l'array `agenda` assegnando all'ora indicata dall'indice dell'array (`0` = `13`, `1` = `14` ...) il nome dello studente. Questa procedura può lanciare le seguenti eccezioni (con opportuni messaggi diversi):
    * Se l'agenda è `null` la procedura lancia una `NullPointerException` ed il programma termina;
    * Se l'agenda non ha esattamente 6 elementi la procedura lancia una `IllegalArgumentException` ed il programma termina;
    * Se il nome dello studente è nullo o vuoto la procedura lancia una `IllegalArgumentException` ed il programma torna a chiedere un'appuntamento;
    * Se l'orario specificato non è valido la procedura lancia una `IllegalArgumentException` ed il programma torna a chiedere un'appuntamento;
    * Se l'orario è già prenotato (la stringa non è vuota) la procedura lancia una `TimeBusyException` (unchecked) ed il programma torna a chiedere un'appuntamento;
    * Se lo studente ha già prenotato un orario diverso la procedura lancia una `AlreadyBookedException` (checked) ed il programma torna a chiedere un'appuntamento;
* `public static []int orariDisponibili(String[] agenda) throws NullPointerException, IllegalArgumentException` che restituisce gli orari ancora disponibili (lanciando eccezioni nei casi corrispondenti ai primi due punti del primo metodo).

Oltre a queste procedure, definire un metodo `main()` in una classe `Test` per verificare il funzionamento della classe `Ricevimento`, come da esempio d'esecuzione.
Inoltre, gestire anche le altre possibili eccezioni che possono avvenire durante la lettura.

##### Esempio d'esecuzione:

```text
$ java Test
Puoi prenotare un appuntamento alle [13, 14, 15, 16, 17, 18]
Qual e' il tuo nome? 
Anna
A che ora vorresti l'appuntamento?
14
Puoi prenotare un appuntamento alle [13, 15, 16, 17, 18]
Qual e' il tuo nome? 
Paolo
A che ora vorresti l'appuntamento?
13
Puoi prenotare un appuntamento alle [15, 16, 17, 18]
Qual e' il tuo nome? 
Marco
A che ora vorresti l'appuntamento?
16
Puoi prenotare un appuntamento alle [15, 17, 18]
Qual e' il tuo nome? 
Stefano
A che ora vorresti l'appuntamento?
18
Puoi prenotare un appuntamento alle [15, 17]
Qual e' il tuo nome? 
Maria
A che ora vorresti l'appuntamento?
13
L'orario specificato e' gia' allocato per un altro appuntamento
A che ora vorresti l'appuntamento?
Qual e' il tuo nome? 
Maria
A che ora vorresti l'appuntamento?
12
Non e' un'ora corretta
Qual e' il tuo nome? 
Maria
A che ora vorresti l'appuntamento?
17
Puoi prenotare un appuntamento alle [15].
Qual e' il tuo nome? 
Paola
A che ora vorresti l'appuntamento?
15
Fissati tutti gli appuntamenti
Alle 13 e' fissato l'appuntamento di Paolo
Alle 14 e' fissato l'appuntamento di Anna
Alle 15 e' fissato l'appuntamento di Paola
Alle 16 e' fissato l'appuntamento di Marco
Alle 17 e' fissato l'appuntamento di Maria
Alle 18 e' fissato l'appuntamento di Stefano
```
