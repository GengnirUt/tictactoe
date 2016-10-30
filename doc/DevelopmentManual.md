#Development Manual
###[1. Introduction](#Introduction)
###[2. Source Control](#SourceControl)
###[3. Build Environment](#BuildEnvironment)
###[4. Additional Dependencies](#AdditionalDependencies)

------

#### Introduction <a id="Introduction"></a>

The purpose of this document is to provide a simple reference for any future developers so that they may begin adding to the project. Below you will find all the information that should be necessary for a developer, as well as any particular practices that are required.

#### Source Control <a id="SourceControl"></a>
This project is open source and uses GitHub as the source control. Link to the repository is:
[GitHub Repository](https://github.com/GengnirUt/tictactoe)
Use **git clone https://github.com/GengnirUt/tictactoe** to clone the project onto your computer.

#### Build Environment <a id="BuildEnvironment"></a>
The development server has IP address 82.221.49.74.  You should have received your login info from the IT department, when you started.
All programming should be done there.  You can also clone the project to your local drive if you would like to work within a IDE environment. There are many different Integrated Development Environments that can be used to program in Java, but in case you are not familiar with one, you should use **Eclipse** as most of your coworkers use that.

The programming language used is Java 1.8. Make sure that you have **Java SDK version 1.8+** on your machine.

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
