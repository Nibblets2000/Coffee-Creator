Hello there. Welcome to the Coffee Creator program.

This file will detail the information and the functionality of each
file within this program.

1. Starting the program
NOTE: Please be sure that all .java files in the package are in the same directory
as main, else the program will not function.

Running the "Main" file should begin the program. You will be prompted multiple selections
upon start up. Enter the number of the option to select it.


2. File descriptions

- Main.java
Main runs the Coffee Creator program and holds most of the visual display for the program. It prints
the menus, controls many of the options chosen by the users, and also controls the many of the logging
functions.

- Coffee.java
The "Coffee.java" file is an interface that is the basis for coffee creation, that is it provides the methods
for each file in relation to coffee creation.

- BlackCoffee.java, Espresso.java, CoffeeDecorator.java, and all "With___.java" files
All of "With___.java" files in the package extend the CoffeeDecorator file and the rest
implement the "Coffee.java" file. All of these files contain getter methods that return either
a price, String representing the item, or List object representing the ingredient.

- "Inventory - _____.txt" files and OrderLog.txt
The "Inventory - ____.txt" files are log files that keep track of the ingredients in stock
as per each location. When running the program, if the number in stock is 0, the item will
not be added. OrderLog.txt keeps track of each order made with the Coffee Creator program.
