# Filtra voti

Scrivere un programma che:
 * legga da **standard input** una sequenza di valori compresi tra 0 e 100, terminando la lettura quando si preme `ctrl+D`. I valori numerici interi superiori a 60 corrispondono a voti sufficienti; 
 * stampi a video le due sottosequenze di valori che corrisponodo rispettivamente a voti insufficienti e sufficienti.
 
Oltre al metodo `main()`, devono essere definiti ed utilizzati almeno i seguenti metodi:
* `public static ArrayList<Integer> leggiNumeri()` che restituisce una `ArrayList` in cui sono memorizzati i valori specificati su **standard input**;
* `public static ArrayList<Integer> filtraVotiSufficienti(ArrayList<Integer> l)` che restituisca la sottosequenza dei voti sufficienti di `l`. 
* `public static ArrayList<Integer> filtraVotiInsufficienti(ArrayList<Integer> l)` che restituisca la sottosequenza dei voti insufficienti di `l`.

Sarebbe possibile fare un'unico metodo `filtraVoti()` per sostituire i due precedenti? Come lo fareste e che parametri avrebbe? E se volessimo fare un metodo per svolgere un qualunque filtraggio arbitrario (es: restituisi i voti pari, o quelli divisibili per 5)? Cosa servirebbe per poter fare questo tipo di operazioni?

##### Esempio d'esecuzione:

```text
$ java Voti
Inserisci i voti:
80
75
60
55 
Voti sufficienti: [80 75 60]
Voti insufficienti: [55]

$ java Voti
Inserisci i voti:
100
98
59
40
Voti sufficienti: [100 98]
Voti insufficienti: [59 40]
```
