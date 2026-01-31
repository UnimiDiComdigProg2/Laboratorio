### Winter Olympics

Design, specify, and implement the classes described below and their methods. When appropriate, the classes must have constructors, an Abstraction Function and a Representation Invariant, as well as any other methods or overrides of methods from extended classes or implemented interfaces. Appropriate checks must be present and suitable exceptions must be thrown when necessary.

An `Event` of the Winter Olympics is defined by its name, and two events are considered equal if they have the same name. An `Event` can return its duration in minutes, which depends on the type of `Event`, and events are naturally ordered based on their duration.
* For events of type `Ceremony`, which can be opening or closing ceremonies, the duration is a fixed 60 minutes.
* For events of type `Competition`, also defined by the number of athletes participating, the duration is 5 minutes per athlete.

Write in the `Event` class a `main()` method to:
1. Create an opening `Ceremony` named `Opening2026` and write its information to **standard output**.
2. Create a `Competition` named `Luge1` with 15 athletes and write its information to **standard output**.
3. Create a closing `Ceremony` named `Luge1` and write its information to **standard output**.
4. Write to **standard output** the result of checking equality between the first two objects and between the last two objects.
5. Write to **standard output** whether the first object is greater than the second object.

#### Sample execution:

```text
$ java Event
Opening ceremony name: Opening2026 duration: 60
Competition name: Luge1 duration: 75 with 15 athletes
Closing ceremony name: Luge1 duration: 60
Are the first two equal? false
Are the last two equal? true
Is the first greater than the second? false
```

A winter `Olympics` is defined by the year in which it takes place and by the events scheduled during its 19 days, one per day (from day 1 to day 19). An `Olympics` provides the following functionalities:
* Add an `Event` for a given day. If that day already contains an `Event`, a `DayException` (checked) is thrown. If the specific `Event` to be added is already present, an `EventException` (unchecked) is thrown. If the `Event` to be added is an opening `Ceremony` and the day is not the first one, a `DayException` is thrown; similarly, if the `Ceremony` is a closing one and the day is not the last one.
* Remove the `Event` from a given day. If no `Event` is present for the specified day, a `DayException` is thrown.
* Iterate over the events of the `Olympics`, ordered according to their natural order (that is, their duration).
In addition, the abstraction function of `Olympics` must return a representation of it, specifying its year and then, in day order, the scheduled events (as shown in the sample execution).

Write a class `Test` whose `main()` method reads from the **command line** the year of the `Olympics` and then, from **standard input**, instructions in the format:
* `add <day> Ceremony <name> <opening / closing>` to add a new opening or closing `Ceremony` on the specified day with the specified name
* `add <day> Competition <name> <number of athletes>` to add a new `Competition` on the specified day with the given name and number of athletes
* `remove <day>` to remove the `Event` from the specified day
Reading ends when the **End-Of-File** command is entered using `Ctrl+D`. At the end of the reading, print to **standard output** the `Olympics`, indicating its year and the scheduled events, ordered by day of the `Olympics`. Then, print to **standard output** the events ordered by their natural order, as shown in the sample execution.

#### Sample execution:

```text
$ java Test 2026
Available commands (Ctrl+D ends)
	add <day> Ceremony <name> <opening / closing>
	add <day> Competition <name> <number of athletes>
	remove <day>

add 1 Ceremony Opening2026 opening
add 1 Competition Ski1 10
	EXCEPTION: an event already present for the day
add 3 Competition Ski1 10
add 5 Competition Ski1 10
	EXCEPTION: event already exists
add 7 Competition Curling1 15
remove 5
	EXCEPTION: day does not exist
remove 3
add 14 Competition Luge1 20
add 18 Ceremony Closing2026 closing
	EXCEPTION: ceremony on wrong day
add 19 Ceremony Closing2026 closing

Winter Olympics 2026:
	1: Opening ceremony name: Opening2026 duration: 60
	7: Competition name: Curling1 duration: 75 with 15 athletes
	14: Competition name: Luge1 duration: 100 with 20 athletes
	19: Closing ceremony name: Closing2026 duration: 60

Events ordered by duration:
	Opening ceremony name: Opening2026 duration: 60
	Closing ceremony name: Closing2026 duration: 60
	Competition name: Curling1 duration: 75 with 15 athletes
	Competition name: Luge1 duration: 100 with 20 athletes
```
