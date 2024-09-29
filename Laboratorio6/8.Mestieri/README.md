# Mestieri

Scrivere una classe `Persona` che contenga un solo attributo `nome`, un costruttore che inizializzi una nuova persona col suo nome e un getter per lo stesso attributo. Progettare, specificare ed implementare una classe `Dipendente` che estende `Persona` e i cui oggetti rappresentano le schede dei dipendenti di un’azienda. Oltre alle caratteristiche di `Persona`, un `Dipendente` possiede una retribuzione annuale (double), un anno di assunzione (int) e un codice identificativo (String). Implementare gli appropriati costruttori e metodi. Scrivere un metodo `main()` per verificare la definizione della classe che legga da **standard input** una serie di righe nel formato `<nome> <codice> <anno> <salario>` e stampi a schermo i dipenti con l'anno di assunzione antecedente all'anno passato come parametro da **riga di comando** 

#### Esempio d'esecuzione:

```text
$ java Dipendente 2374
Inserisci dipendenti nel formato `nome codice anno salario` (termina con CTRL+D)
Jean-luc NCC-1701 2371 3000
William NCC-80102 2377 2500
Kathryn NCC-74656 2373 2650
Benjamin NCC-75633 2375 2550
Carol  NCC-75567 2376 2400
Dipendenti assunti prima del 2374:
Jean-luc
Kathryn
```
