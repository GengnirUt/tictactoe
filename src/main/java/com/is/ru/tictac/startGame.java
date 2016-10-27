package com.is.ru.tictac;

public class startGame {
    public static void main(String[] args) {
	GamePlay game = new GamePlay();
	//Printer print = new Printer();
	int maxTurns = 9; // only 9 moves possible
	int player_1 = 1;
	int player_2 = 2;
	int playerOneHumanOrComputer = 0;
	int playerTwoHumanOrComputer = 0;
	
	//System.out.println("player 1 enter 0 or 1");
	game.print.getPlayers(player_1);
	playerOneHumanOrComputer = game.input.getPlayerMode();
	
	game.print.getPlayers(player_2);
	playerTwoHumanOrComputer = game.input.getPlayerMode();
	
	for(int i = 0; i < maxTurns; i++)
	{
	    if(playerOneHumanOrComputer == 0)
	    {
		System.out.println("Player 1: ");
		game.print.playerMove(player_1);
		game.playerMove(player_1, playerOneHumanOrComputer); 
	    }
	    else
	    {

		System.out.println("Player 1: ");
		System.out.println("computer make a move");
		game.playerMove(player_2, playerOneHumanOrComputer);
	    }
	    if(game.checkForWin(player_1))
	    {   
		System.out.println("player 1 has won"); 
		break;
	    }
	    if(playerOneHumanOrComputer == 0)
            {
                System.out.println("Player 2: ");
                game.print.playerMove(player_2);
                game.playerMove(player_1, playerOneHumanOrComputer);
            }
            else
            {
                System.out.println("Player 2: ");
                System.out.println("computer make a move");
                game.playerMove(player_2, playerOneHumanOrComputer);
            }
	    if(game.checkForWin(player_2))
	    {
		System.out.println("player 2 has won");
		break;
	    }
	}
    }
}
