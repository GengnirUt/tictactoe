package com.is.ru.tictac;

public class Printer {
	
	public void greet() {
	    System.out.println("Welcome to Tic-tac-toe!");
	}
	
	public void printIntro()
	{
		System.out.println("Hello I want to play a game");
		System.out.println("TIC TAC TOE");
		
	}
	
	public void getPlayers(int i)
	{
		System.out.println("Player " + i + "!"); 
		System.out.print("Enter zero (0) if you are human and one (1) if you are computer: "); 
	}
	
}