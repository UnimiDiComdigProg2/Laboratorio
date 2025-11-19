# Pets

Un `Pet`, definito dal nome dell'animale domestico che rappresenta, può essere  `Cane`, `Gatto` e `Cavia` e espone come funzionalità quella di stampare su **standard output** il verso dell'animale. Il verso specifico dipende dal tipo di `Pet`, come da esempio di esecuzione. Inoltre due `Pet` sono considerati uguali se hanno lo stesso nome e lo stesso tipo.

Una `Persona`, identificata da nome, presenta le seguenti funzionalità:
* aggiungere alla `Persona` un `Pet`. Se il pet è già presente lancia una `PetException` (Checked).
* rimuovere un `Pet` della `Persona`, dato il nome del `Pet`. Se il pet non è già presente lancia una `PetException`.
* iterare i `Pet` della `Persona`.

Progettare, specificare ed implementare le classi descritte ed i loro metodi. Quando opportuno, le classi dovranno avere costruttori, Abstraction Function e Representation Invariant, ed eventuali altri metodi o ridefinizioni dei metodi. Dovranno esserci i controlli opportuni ed eventuali lanci di eccezioni appropriate.

Creare una classe `Pets` con un metodo `main()` per testare le classi implementate. Dovrà leggere da **standard input** una serie di righe di testo nel formato `nomePersona nomeAnimale tipoAnimale`, creare una lista di persone, inizializzate con il loro nome e con aggiunti i loro animali domestici e stampare per ciascuna persona il coro dei loro animali domestici, come da esempio d'esecuzione.

**NOTA**: Normalmente gli oggetti non dovrebbero stampare direttamente su **standard output**, invece questo dovrebbe essere fatto attraverso delle specifiche classi che fungono da interfaccia con l'utente: ad esempio, la classe `Pets` in questo caso.

#### Esempio d'esecuzione:

```text
$ java Pets
Inserisci righe nel formato `nomePersona nomeAnimale tipoAnimale` (CTRL+D per terminare)
Clelia Axel Cane
Francesca Lupin Gatto
Francesca Ryo Gatto
Clelia Frida Gatto
Clelia Kaboto Gatto
Maribel Lillo Cane
Danilo Saetta Cavia

Il coro degli animali di Clelia:
	Axel dice bau
	Frida dice miao
	Kaboto dice miao

Il coro degli animali di Francesca:
	Lupin dice miao
	Ryo dice miao

Il coro degli animali di Maribel:
	Lillo dice bau

Il coro degli animali di Danilo:
	Saetta dice squit
```
