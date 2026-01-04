### **Surprise Calendar**

Design, specify, and implement the classes described below and their methods. When appropriate, the classes must have constructors, an Abstraction Function and a Representation Invariant, as well as any other methods or redefinitions of methods from extended classes or implemented interfaces. Proper checks and any necessary exception throwing must be included.

A `Surprise` is defined by its name, and two surprises are considered equal if they have the same name. Furthermore, a `Surprise` can return its cost, and surprises are naturally ordered based on their cost. The cost is calculated depending on the type of `Surprise`:
* For surprises of type `Chocolate`, additionally defined by their cocoa percentage, the cost is one tenth of the cocoa percentage.
* For surprises of type `Toy`, additionally defined by a description, the cost is the number of words in the description.

Write in the `Surprise` class a `main()` method to:
1. Create a `Chocolate` named `Lindt` with 25% cocoa and write its information to **standard output**.
2. Create a `Toy` named `Yorick` with description `of infinite jest` and write its information to **standard output**.
3. Create a `Chocolate` named `Yorick` with 1% cocoa and write its information to **standard output**.
4. Write to **standard output** the result of checking equality between the first two objects and between the last two objects.
5. Write to **standard output** whether the first object is greater than the second object.

#### Sample execution:

```text
$ java Surprise
Chocolate: Lindt (2.5) cocoa: 25%
Toy: Yorick (3.0) description: of infinite jest
Chocolate: Yorick (0.1) cocoa: 1%
Are the first two equal? false
Are the last two equal? true
Is the first greater than the second? false
```

A `Calendar` of surprises consists of a series of boxes, one per day (from day 1 to day 31), inside which there may be a `Surprise`. A `Calendar` provides the following features:
* Insert a `Surprise` into the `Calendar` for a given day. If that day already contains a surprise, a `DayException` (checked) is thrown. If the specified `Surprise` is already present in the `Calendar`, a `SurpriseException` (unchecked) is thrown.
* Open the box for a given day, obtaining the `Surprise` it contains and removing it from the `Calendar`. If no `Surprise` is present for that day, a `DayException` is thrown.
* Return the cost of the `Calendar`, calculated as the sum of the costs of all surprises it contains.
* Iterate over the surprises contained in the `Calendar`, ordered based on their natural order (i.e., their cost, see above).

Write a class `Test` whose `main()` method reads from **standard input** instructions in the format:
* `insert <day> Chocolate <name> <% cocoa>` to insert a new `Chocolate` into the specified day with the given name and cocoa percentage
* `insert <day> Toy <name> <description>` to insert a new `Toy` on the specified day with the given name and description
* `open <day>` to open the box for the specified day, removing the `Surprise` (if any) from the `Calendar` and printing it to **standard output**
Reading ends when the command `End-Of-File` is entered with `Ctrl+D`. After reading ends, print to **standard output** the `Calendar`, showing its cost and the surprises it contains, as in the sample execution.

#### Sample execution:

```text
$ java Test
Insert surprise or open day (Ctrl+D ends)
	insert <day> Chocolate <name> <% cocoa>
	insert <day> Toy <name> <description>
	open <day>

insert 4 Chocolate Venchi 35
insert 13 Toy Trippy Joy and Mistery
insert 4 Toy Yorick of infinite jest
	Exception: A surprise is already present for this day
insert 19 Chocolate Trippy 3
	Exception: This surprise is already present in the calendar
insert 22 Chocolate Lindt 99
open 4
	found: Chocolate: Venchi (3.5) cocoa: 35%
apri 5
	Eccezione: Nessuna sorpresa per il giorno

Surprise Calendar (12.9)
	Toy: Trippy (3.0) description: Joy and Mistery
	Chocolate: Lindt (9.9) cocoa: 99%
```
