# Imminent Nativity

A `Figure` of a `Nativity` scene is defined by its name. It can be `Base`, `Person`, or `Animal` and provides the following functionalities:
* Return its name.
* Return its value, calculated for each type of `Figure` in its own way.
* Expose a natural ordering based on its value.
* Is considered equal to another `Figure` with the same type and name.

A `Person` `Figure` must have a name that ends with `r` (e.g., `Hunter`, `Melchior`); otherwise, it throws a `NameException` (unchecked). Its value is equal to the number of characters in its name.

An `Animal` `Figure` must have both a name and an adjective (e.g., `Heating Ox`), and its value is equal to the number of characters in its adjective.

A `Base` `Figure` is one of the three main figures in the `Nativity` scene and can only have one of the following names: `Jesus`, `Joseph`, or `Mary` (otherwise, it throws a `NameException`). It is defined not only by its name but also by a series (1 or more) of adjectives (e.g., `Joseph wise old`) and its value is calculated as the sum of the lengths of all its adjectives.

A `Nativity` scene contains various figures and provides the following functionalities:
* Add a `Figure`. If the figure is already present, it throws a `FigureException` (checked).
* Remove a `Figure` by its name. If no `Figure` with that name is present, it throws a `FigureException`.
* Return the sum of the values of all the figures in the `Nativity` scene.
* Return an iterator for the figures in the `Nativity` scene, ordered by their natural order.

Design, specify, and implement the described classes and their methods. Where appropriate, the classes should include constructors, an **Abstraction Function**, a **Representation Invariant**, and any additional methods or redefinitions of methods from extended classes or implemented interfaces. Proper checks and appropriate exception throwing must be implemented.

Write a `Test` class where the `main()` method reads from **standard input** instructions in the following format:
* `add <name> Person` to add a `Figure` of type `Person`.
* `add <name> Animal <adjective>` to add a `Figure` of type `Animal`.
* `add <name> Base [adjective1 adjective2 ...]` to add a `Figure` of type `Base`.
* `remove <name>` to remove a `Figure`.

The input reading ends when the `End-Of-File` command is entered using the `Ctrl+D` combination.
Finally, print to **standard output** the total value of the `Nativity` scene and its figures, ordered by their natural order, specifying their name, value, and adjectives (if any), as shown in the execution example.

#### Execution example 1:
```text
$ java Test 
Add or remove Figure (Ctrl+D terminates)
	add <name> Person
	add <name> Animal <adjective>
	add <name> Base [adjective1 adjective2 ...]
	remove <name>

add Herder Person
add Donkey Animal sad
add Jesus Base handsome intelligent fascinating nice
add Ox Animal heating
add Professor Person
add Melchior Person
add Mary Base virgin kind
add Joseph Base old wise
remove Professor 
add Caspar Person
add Balthazar Person
add Mummy Person
	Error: Mummy is not a Person Figure of the Nativity scene

Imminent Nativity (90)
	Animal: Donkey (3) <sad>
	Person: Herder (6)
	Person: Caspar (6)
	Base: Joseph (7) [old, wise]
	Animal: Ox (7) <heating>
	Person: Melchior (8)
	Person: Balthazar (9)
	Base: Mary (10) [virgin, kind]
	Base: Jesus (34) [handsome, intelligent, fascinating, nice]
```

#### Execution example 2:
```text
$ java Test 
Add or remove Figure (Ctrl+D terminates)
	add <name> Person
	add <name> Animal <adjective>
	add <name> Base [adjective1 adjective2 ...]
	remove <name>

add Anakin Base jedi powerful
	Error: Anakin is not a Base Figure of the Nativity scene
add Emperor Person
remove ObiWan
	Error: Figure ObiWan absent
add Emperor Person
	Error:Person Figure: Emperor (7) already added

Imminent Nativity (7)
	Person: Emperor (7)
```