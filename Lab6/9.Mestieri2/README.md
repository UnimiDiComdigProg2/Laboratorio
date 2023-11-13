# Mestieri 2

Progettare, specificare ed implementare una classe `Dottore` che estende `Persona` e i cui oggetti rappresentano i medici di una clinica. Oltre alle caratteristiche di `Persona`, un `Dottore` ha una Specializzazione (String) e una parcella per le visite (double). Progettare, specificare ed implementare anche una classe `Paziente` che estende `Persona` e i cui oggetti rappresentano i pazienti della clinica. Oltre alle caratteristiche di `Persona`, un `Paziente` ha un codice identificativo (String).
Infine, progettare, specificare ed implementare una classe `Visita` che definisca una visita a un `Paziente` da un `Dottore`.
Scrivere un metodo `main()` per verificare la definizione della classe che legga da **standard input**, prima una serie di righe nel formato `<nome> <specializzazione> <parcella>` e inizializzi una lista di dottori con questi dati, poi una serie di righe nel formato `<nome> <codice>` e inizializzi una lista di pazienti con questi dati, e infine una serie di righe nel formato `<nomeDottore> <codicePaziente>` e inizializzi una lista di visite con questi dati. Stampare per ciascun medico, il guadagno dato dalle visite effettuate.

#### Esempio d'esecuzione:

```text
$ java Dipendente 2374
Inserisci medici nel formato `nome specializzazione parcella` (termina con CTRL+D)
Dr.Strange Chirurgia 300
Dr.Who Geriatria 150
Dr.No AnatomoPatologia 280
Dr.Strangelove Psichiatria 200
Dr.Acula Ematologia 170

Inserisci i pazienti nel formato `nome codice` (termina con CTRL+D)
Dormamu 123456
Bond 007
Davros 1963
Turkleton 182

Inserisci visite nel formato `nomeDottore codicePaziente` (termina con CTRL+D)
Dr.Strange 123456
Dr.Who 1963
Dr.Acula 182
Dr.Who 007

I guadagni del mese sono:
Dr.Strange 300
Dr.Who 300
Dr.Acula 170
```
