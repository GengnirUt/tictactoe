#Development Manual
###1. Introduction
###2. Source Control
###3. Build Environment
###4. Additional Dependencies

------

#### Introduction

The purpose of this document is to provide a simple reference for any future developers so that they may begin adding to the project. Below you will find all the information that should be necessary for a developer, as well as any particular practices that are required.

#### Source Control
This project is open source and uses GitHub as the source control. Link to the repository is below:
[GitHub Repository](https://github.com/GengnirUt/tictactoe)

#### Build Environment
The programming language used is Java. There are many different Integrated Development Environments that can be used to program in Java, but in the case of the original version of this program, **Eclipse** was used:

[Eclipse Download Link](https://eclipse.org/downloads)

The project was build using Git (Git Bash, specifically) as the way to connect to the GitHub repository.

[Git Download Link](https://git-scm.com/downloads)

In the case of the original project an online Ubuntu server was used to connect to the GitHub repository, but a user can also clone the repository to his own home machine if the additional development requirements are fulfilled.

**Gradle**
- The build automation system in use for this particular project.
- Support Continuous Delivery, which is a requirement for this project.
- [Gradle Download](https://gradle.org/gradle-download/) and Installation Information.
- For this project, Gradle version 3.1 was used.

#### Additional Dependencies

In addition to the required dependencies explained above for the development of the project, these following dependencies were also used:

**Travis**
- A distributed continuous distribution service used to test the project.
- [Travis - Getting Started](https://docs.travis-ci.com/)
- Can be used to deploy to additional dependencies.