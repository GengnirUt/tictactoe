# Design report
### 1. Introduction
### 2. Initial Design Ideas
#### - Basic Requirements
#### - Design Choices
### 3. Class Diagram

___
#### Introduction
Before actual coding could begin a rudimentary idea of what the program should accomplish needs to be formed. In this particular case the software was a simple game of tic-tac-toe with the Java programming langauge as the weapon of choice.

Keeping in mind what a game of tic-tac-toe actually is, what possible ways said game can be played and displayed have to be taken into account; as well as any additional options that would be possible to add to the program.

In our case the basic idea of what the program could be was setup with the help of a class diagram, shown below, and a simple list of things that will be included in the program.

#### Initial Design Ideas
##### Basic Requirements
Tic-tac-toe is in essence a very simple game with only 2 players and a total of 9 options for those players combined. Here is an example of a tic-tac-toe board with all of the spaced filled in:

|  X  |  O  |  X |

|  X  |  O  |  O |

|  O  |  X  |  X |

Looking at this board gives us an idea of what a program to play tic-tac-toe would require.
- A 3X3 board with a total of 9 empty spaces.
- Support for 2 players, each of them taking alternate turns.
- Each player plays either with X symbols or O symbols.
- No player can fill a space that has already been filled, meaning that a game of tic-tac-toe has a maximum of 9 turns.
- A game of tic-tac-toe ends when someone wins by getting 3 of his symbols in a horizonal, vertical or diagonal row:
- If no one has won a game after 9 turns, then a draw is called.

These are the core requirements needed to run the program. Anything in addition to these would be improvements to make the programs work better or look better.
##### Design Choices
The initial design of the project was created for the purpose of planning. It is therefore to be considered as the origin of the final product. A guideline rather than a blueprint to be followed. 

With the requirements described above in mind we chose to implement 5 classes in total for the basic implementation of the program:

**1. Board Class**
 - This class will create the basic structure of the board behind the scenes.
 - This class will keep track of the tiles.

**2. Input Class**
 - This class will handle input from the user or users.

**3. Print Class**
 - This class take care of everything that is displayed to the user or users.
 - Will display introduction, rules explanation and ask for inpur from the user or users.
 - This class will take care of displaying the board, tiles and symbols once they are played.
 - This class will also take care of any messages that must be relayed to the user or users, in the case of errors or illegal moves for example.

**4. Play  Class**
 - Takes care of the moves being taken by players from the Input class
 - Relays those moves through to the Board class to change the state of the board
 - Checks if the game has been won
 - Checks if the move made is legal

**5. Database Class**
 - Creates the database to store information about the game played.
 - Insert information about the game that was played into the database.

Once these five classes have been implemented and gotten to work, then additional features and improvements can be added to the program. These five classes above should be all that is needed for the program to run.

The Database Class is not something that is mentioned as a requirement for the tic-tac-toe program, but it has been added here as it is considered to be a requirement from the stockholder in question. It adds an additional documentational layer to the program, as it records games played. It shall be implemented using an SQL database to store basic information from each game, and if anything specific needs to be recorded and stores in the database, then the Class can be updated to do so.

#### Class Diagram
Below is an image of the UML Class Diagram showing the initial design of the program. 

![alt text][diagram]

[diagram]: https://github.com/GengnirUt/tictactoe/blob/documentation/doc/class_diagram.jpeg
