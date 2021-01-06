# Calculator App (Java)
Built with Java + JavaFX.

A calculator simple program which parses infix expressions (by evaluating it as a postfix expression, a.k.a. Reverse Polish Notation). Includes a graphical user interface, but can also be run in text-based mode on the command line.

Operators supported: Add, Subtract, Multiply and Divide (also supports decimal points and previous answer as input).

This program was developed using Test-Driven-Development in Eclipse, with the JUnit4 testing framework. All Java source code adheres to the Google coding standards. Uses the MVC Architectural design pattern.

## Running the program
The program is run using the CalculatorApp.jar file, which will launch the GUI version. Alternatively, the jar file can be run through the command line using *java -jar CalculatorApp.jar*, which will run the program with a text-based interface on the command line. 

All test files for this program can be run by importing the project folder into Eclipse, and running the files as JUnit Tests.

NOTE: The expression inputs to the calculator must contain spaces between each token, e.g. 3 + 5, not 3+5.

![screenshot](https://i.imgur.com/K84LD8E.png)
