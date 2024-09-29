# Sottostringhe palindrome

Scrivere un programma che legga da **riga di comando** una stringa senza spazi e stampi a schermo tutte le sottostringhe palindrome della stringa.

Oltre al metodo `main()`, devono essere definiti ed utilizzati almeno i seguenti metodi:
* `private static boolean isPalindroma(String s)` che restituisce `true` se `s` è palindroma e `false` altrimenti;

##### Esempio d'esecuzione
```text
$ java Palindrome sottotono
[ otto tt tot oto ono ]

$ java Palindrome banana
[ ana anana nan ana ]

$ java Palindrome ereggere
[ ere ereggere regger egge gg ere ]

$ java Palindrome Vaðlaheiðarvegavinnuverkfærageymsluskúrslyklakippuhringurinn
[ nn pp nn]

$ java Palindrome donaudampfschifffahrtselektrizitätenhauptbetriebswerkbauunterbeamtengesellschaft
[ ff fff ff ele izi tät uu ese ll ]
```
