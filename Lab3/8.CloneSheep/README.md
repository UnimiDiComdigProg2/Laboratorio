# Clone Sheep

Modellare, specificare e implementare una classe `Sheep`, definita da un nome e da un attributo `dna`, contenente una serie di stringhe che definiscono i codici dna dei diversi cromosomi della pecora. Creare un costruttore per inizializzare un nuovo oggetto di tipo `Sheep` con gli attributi appropriati. Ridefinire il metodo `clone()` sulla classe `Sheep`; a tal fine, è anche necessario definire la classe come `clonable` (`public class Sheep implements Cloneable`). Ridefinire il metodo `equals()` per verificare se due `Sheep` sono uguali. Definire anche un metodo per leggere una data stringa del dna in base al suo indice, e un metodo per poter sostituire una stringa del dna a un dato indice con un'altra data come parametro. Identificare e gestire i casi limite dei metodi della classe.

Implementare un metodo `main()` per testare la classe. Il metodo main dovrà leggere da **riga di comando** il nome della pecora, e da **standard input** una serie di stringhe che rappresenteranno il dna della pecora, fino a quando non viene premuto `CTRL+D`.
Clonare la pecora in una nuova variabile e verificare che le due variabili siano uguali. Chiedere all'utente l'indice del cromosoma da cambiare e una nuova stringa per sostituire la precedente. Verificare nuovamente l'uguaglianza tra le due variabili.

##### Esempio d'esecuzione:

```text
$ java CloneSheep Dolly
Inserisci i cromosomi, uno per riga (terminare con CTRL+D):
GATTTAGACAGATTA
TAGAGACATTTATAC
CATAGAGATATAGAG
TACATTACATAGAGA

Ho creato un clone di Dolly.
Le due pecore sono uguali.
Inserisci il cromosoma da modificare ed il nuovo codice:
3 CATAGATAGATAGAG

Le due pecore sono diverse.
```
