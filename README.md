# Nested List Sets
We have a special type of set where the syntax is depicted by the following grammar:

```
Set := "{" Elementlist "}"
Elementlist := <empty> | List
List := Element | Element "," List
Element := Atom | Set
Atom := "{" | "}" | ","
```

##Input Specification
The first line of the input contains a number representing the number of lines to follow.
Each line consists of a word, for which the program will decide if it is a syntactically correct representation of a set.

##Sample Input
```
{}
{{}}
{{}},{,}}
{,,}
```

##Sample Output
```
Word #1: Set
Word #2: Set
Word #3: Set
Word #4: No Set
```
