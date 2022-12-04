# FilmQueryProject
Homework week 8

# Description
Film Query assignment introduced how to use databases to run queries in Java. The app gives the user options to search for a Film based on its ID. Search for a film using keywords and to quit. If the user inputs a film that does not exist then the app will notify the user and re-prompt the menu.

Using in interface and multiple classes, the main app FilmQueryApp runs the program allowing user input.

Using prepared statements, the DatabaseAccessorObject class takes the user input to run the query returning results back to the user.

The Film and Actor class provide appropriate fields, constructors, getters and setters, and toString.

# Technologies Used
- Java
- Maven
- MySQL
- Terminal
- MAMP
- Git
- Eclipse
- ATOM

# Lessons Learned
- Became much more familiar with reading Stack Trace errors and learning to find mistakes. On my initial creation of the Film class I did not spend enough time considering which primitives were appropriate for each field of the database and that resulted in several errors relaying "column not found." Initially I attempted to trouble shoot those errors without utilizing the stack trace but that resulted in no solutions and wasted time.
- SQL Exceptions and method organization. Originally I used throw SQL exceptions with my methods but after using the try/catch I found that to be the better path for me rather than ensuring across multiple classes that "throw SQL exception" was displayed. 
