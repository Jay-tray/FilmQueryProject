# FilmQueryProject
Homework week 7

# Description
Film Query Project introduced how to utilizes databases to run queries within Java. The app gives the user options to search for a Film based on its ID or Keywords. If the user inputs a film or keyword that does not match a known film then the app will notify the user and re-prompt the menu.

Using an interface and multiple classes, the main app FilmQueryApp runs the program allowing user input.

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
- Becoming more familiar with what benefits JUNIT testing offer. Initially the tests written did not catch the issues with my written code. The code would compile and complete the specific tests but there were still multiple run time errors.
- Learned the power of a space. Originally in my search by keyword I had "% " and " %" which resulted in only being able to search descriptions and not by title. Eventually I looked back at tips given during class and saw the space was not included. Removing it immediately fixed my problem.
- Overall I would say attention to detail is the biggest lesson for me in this project. The new concepts were not overly tricky but it was my lack of detail that resulted in the majority of my problems and learning! 
