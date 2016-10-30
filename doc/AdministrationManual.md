# Administration Manual
### [1. Introduction](#Introduction)
### [2. Server Application](#ServerApplication)
### [3. Desktop Application](#DesktopApplication)
### [4. Program Tutorial](#ProgramTutorial)


-----
#### Introduction <a id="Introduction"></a>
The administration manual explains how to install and run the program. First is the case of a simple desktop application on the client machine. Secondly will be instructions on running the programs on a server through the use of Git Bash.

Following that is a short tutorial on how to actually use the application.

#### Server Application <a id="ServerApplication"></a>

In order to run the program through a server then certain requirements must be met.
- A program capable of connecting to a server or GitHub must be used.
	- Example: Git (Git Bash to be precise).

- The server must run the latest version of gradle, available at, [Gradle Download](https://gradle.org/gradle-download/), along with Installation Information.

- Connect to the proper git repository and cloning it: [Available here](https://github.com/GengnirUt/tictactoe).

Once the project itself has been downloaded from GitHub and Gradle is running on the server, the user then enters the *tictactoe* directory containing the project and uses the following code to the run the application:

`gradle run`

#### Desktop Application <a id="DesktopApplication"></a>

Requirements:
- Java Runtime Environment must be installed on the machine.

The program must be deployed from the server, which is done by connecting to the git project as described above in **Server Application** and using the following command:

`./gradlew deploy`

This will create the folder *StartGame* in the same location as the *tictactoe* folder.

Inside of this *StartGame* folder is a file called *tictactoe.jar* which is the program.

To the run the program, a command line or a command line tool such as Git Bash must be used.
If Java is installed on the machine then the code to run the executable file is:

`java -jar tictactoe.jar`

#### Program Guide <a id="ProgramTutorial"></a>

Once the application is running it gives you the choice of selecting either a human player or a computer (AI) player by pressing *0* or *1* for either option.

The game can be played either human player vs. human player, human player vs. computer or you can let the computer AI play against itself.

To play the game itself the human players must choose which of the 9 spaces they wish to occupy. This is done by first choosing *0*, *1* or *2* for the Y-axis and pressing *Enter* and then *0*, *1* or *2* again for the X-axis and pressing *Enter* again.

Example: If it is the first move of the game and *1* is chosen for the Y-axis and then *2* is chosen for the X-axis, the resulting move would be:

|  &nbsp;&nbsp;&nbsp;  |  &nbsp;&nbsp;&nbsp;  |  &nbsp;&nbsp;&nbsp;  |

|  &nbsp;&nbsp;&nbsp;  |  &nbsp;&nbsp;&nbsp;  |  X  |

|  &nbsp;&nbsp;&nbsp;  |  &nbsp;&nbsp;&nbsp;  |  &nbsp;&nbsp;&nbsp;  |

The second player then makes his own move and so on and so on, until someone wins or all the spaces are filled without a winner, resulting in a draw.
