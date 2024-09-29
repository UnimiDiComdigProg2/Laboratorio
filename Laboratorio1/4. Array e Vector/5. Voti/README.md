# Filtra voti

Scrivere un programma che:
 * legga da **standard input** una sequenza di valori compresi tra 0 e 100, terminando la lettura quando si preme `ctrl+D`. I valori numerici interi superiori a 60 corrispondono a voti sufficienti; 
 * stampi a video le due sottosequenze di valori che corrisponodo rispettivamente a voti insufficienti e sufficienti.
 
Oltre al metodo `main()`, devono essere definiti ed utilizzati almeno i seguenti metodi:
* `public static List<Integer> leggiNumeri()` che restituisce una `List` in cui sono memorizzati i valori specificati su **standard input**;
* `public static void filtraVoti(List<Integer> l)` che stampi su **standard output** le sottosequenze dei voti sufficienti e insufficienti. 
 
##### Esempio d'esecuzione:

```text
$ java voti
Inserisci i voti:
80
75
60
55 
Voti sufficienti: [80 75 60]
Voti insufficienti: [55]

$ java voti
Inserisci i voti:
100
98
59
40
Voti sufficienti: [100 98]
Voti insufficienti: [59 40]
```
