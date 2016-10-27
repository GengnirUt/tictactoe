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
	
	public void printEmptyBoard()
	{
		firstLine();
		secondLine();
		firstLine();
		secondLine();
		firstLine();
	}
	
	public void printBoard(Board gameBoard)
	{
		for(int x = 0; x < 3; x++)
		{
			for(int y = 0; y < 3; y++)
			{
				if(gameBoard.getPlayerAtRowCol(x,y) == 1) // X for player 1
				{
					System.out.print("  X  ");
				}
				else if(gameBoard.getPlayerAtRowCol(x,y) == 2) // O for player 2
				{
					System.out.print("  O  ");
				}
				else // empty for free spot
				{
					System.out.print("     ");
				}
				if(y != 2)
				{
					System.out.print("|");
				}
				
			}
			System.out.println();
			if(x != 2)
			{
				System.out.println("-----" + "+" + "-----" + "+" + "-----");
			}
		}
	}
	
	private void firstLine()
	{
		System.out.println("     " + "|" + "     " + "|" + "     ");
	}
	
	private void secondLine()
	{
		System.out.println("-----" + "+" + "-----" + "+" + "-----");
	}
	
	public void playerMove(int number)
	{
		System.out.println("Player " + number + " move:");
	}
	
	public void spotTakenOrIllegal()
	{
		System.out.println("The spot is taken or not legal");
	}
	
<<<<<<< HEAD
}
=======
	public void winner(int number)
	{
		System.out.println("Player " + number + " won!");
	}
	
}
>>>>>>> master
