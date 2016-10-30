#Development Manual
### [1. Introduction](#Introduction)
### [2. Source Control](#SourceControl)
### [3. Build Environment](#BuildEnvironment)
### [4. Additional Dependencies](#AdditionalDependencies)

------

#### Introduction<a id="Introduction"></a>

The purpose of this document is to provide a simple reference for any future developers so that they may begin adding to the project as soon as posible. Below you will find all the information that should be necessary for a developer, as well as any particular practices that are required.

#### Source Control<a id="SourceControl"></a>
This project is open source and uses GitHub as the source control. Link to the repository is: 
[GitHub Repository](https://github.com/GengnirUt/tictactoe)
Clone this to your computer in order to start programming

#### Build Environment<a id="BuildEnvironment"></a>
The programming language used is Java. Make sure that your computer has Java SDK version 1.8+
To install the Java SDK on your machine, use #sudo apt-get install oracle-java8-installer#

Our staging machine is hosted at 82.221.49.74.  You should have received login details from the IT department.  All programming is done there.  You can clone the code from Github onto your machine if you want to use an IDE suit. There are many different Integrated Development Environments that can be used to program in Java, but if you want any assistance from your fellow programmers, please use **Eclipse** as this is used be all others. You can connect to the developing computer via **Git Bash** 

[Eclipse Download Link](https://eclipse.org/downloads)

The project was build using Git (Git Bash, specifically) as the way to connect to the GitHub repository.

[Git Download Link](https://git-scm.com/downloads)

In the case of the original project an online Ubuntu server was used to connect to the GitHub repository, but a user can also clone the repository to his own home machine if the additional development requirements are fulfilled.

**Gradle**
- The build automation system in use for this particular project.
- Support Continuous Delivery, which is a requirement for this project.
- [Gradle Download](https://gradle.org/gradle-download/) and Installation Information.
- For this project, Gradle version 3.1 was used.

#### Additional Dependencies <a id="AdditionalDependencies"></a>

In addition to the required dependencies explained above for the development of the project, these following dependencies were also used:

**Travis**
- A distributed continuous distribution service used to test the project.
- [Travis - Getting Started](https://docs.travis-ci.com/)
- Can be used to deploy to additional dependencies.
