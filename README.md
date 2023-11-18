# FilmQueryProject
### Overview

   This program is an introductory program into SQL/ORM.  It's a simple program that accesses the databases of a movie rental company in SQL using Java programming.  The main two databases used are Films(Fake) and Actors(Fake).  The program looks up films based on a user entered ID numbers or keywords.  Then the program displayes said films and their details such as name and description along with the actors in them.  Using the keyword prompt the user looks up films that contain their keyword in either the title or description.  The user can continue looking up films either way or exit the program.  


### Technologies / Techniques Used

 - Java
 - Object-Oriented Programming - OO
 - Object-Relaional Mapping - ORM
 - Structuerd Query Language - SQL


### How To Run

   The program starts with a menu and a prompt for the user to select from. They are given the prompts for looking up a film by ID, keyword, or to exit the program. If the user selects ID they are given another prompt to enter their desired ID number.  After the number is entered the corresponding film along with its details and actors are desplayed.  The initial menu is displayed again for the user to select and look up another film and its details.  If the user selects to use a keyword they are prompted to enter the keyword of their choice. After their keyword is entered all films containing their keyword in either the title or the description are displayed along with their details and actors.  The user is once again returned to the initial menu to continue to look up films or they can select to exit the program and the program will close.


### Lessons Learned

   Pros -

  - More detailed understanding of ORM.

  - A better grasp on SQL queries.


   Cons - The obstacles I had during coding -

  - While trying to call the keyword method it kept printing every movie before or after I input anything in the prompt.  I ran a test without the user portion, just passing a String instead and it worked just fine.  So I examined the code and remembered that I needed to flush the Scanner because I switched from an int to a String and it worked. 

  - When I wanted to replace the language ID in Film with the corresponding language in the table Language.  I initially created a method to return a String and inserted it into the Film classes ToString but got a compiler error due to a thrown Exception.  After some fumbling I then realized all I had to do was add to the Prepared Statement the query for the name in Language and add a Variable for it and pass its value through the constuctor.  Then I simply changed the Film classes ToString to return the Language name instead of the Films language ID. 