# Menu

Modellare, specificare e implementare una classe `Piatto` che rappresenti un piatto di un menu con il suo nome, tipo (primo, secondo), e costo. Inoltre, modellare, specificare e implementare la classe `Menu` che contenga una serie di piatti.
Definire i metodi per aggiungere, togliere e modificare i piatti del menu. In particolare, definire un metodo che restituisca un iteratore per generare uno ad uno i piatti del menu. Se il metodo viene chiamato con un parametro `tipo`, l'iteratore dovrà generare solamente i piatti di quel tipo.

Scrivere un metodo `main()` per testare la classe e gli iteratori creati, come da esempio d'esecuzione.

##### Esempio d'esecuzione:

```text
$ java Menu
aggiungi i piatti nel formato: nome tipo costo (terminare la lettura con CTRL+D):
lasagne primo 11€
scaloppine secondo 14€
filetto secondo 20€
casoncelli primo 10€
tagliata secondo 23€
tagliatelle primo 9€

primi:
lasagne primo 11€
casoncelli primo 10€
tagliatelle primo 9€

secondi:
scaloppine secondo 14€
filetto secondo 20€
tagliata secondo 23€
```
