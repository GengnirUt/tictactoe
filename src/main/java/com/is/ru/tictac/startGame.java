package com.is.ru.tictac;

public class startGame {
    public static void main(String[] args) {
    	GamePlay game = new GamePlay();
		//Input input = new Input();
		//Printer print = new Printer();
		int maxTurns = 9; // only 9 moves possible
		//int player_1 = 1;
		//int player_2 = 2;
		//int playerOneHumanOrComputer = 0;
		//int playerTwoHumanOrComputer = 0;
		
		//System.out.println("player 1 enter 0 or 1");
		Printer.getPlayers(1);
		Player p1 = new Player(1, Input.getPlayerMode());
		Printer.getPlayers(2);
		Player p2 = new Player(2, Input.getPlayerMode());
		
		for(int i = 0; i < maxTurns; i++)
		{
			Printer.playerMove(p1.getPlayerNr());
		    if(p1.isHuman()){
		    	game.humanMove(p1.getPlayerNr()); 
		    }
		    else{
		    	game.computerMove(p1.getPlayerNr());
		    }
	
		    if(game.checkForWin(p1.getPlayerNr())){   
		    	Printer.winner(p1.getPlayerNr());
		    	break;
		    }
		    
		    Printer.playerMove(p2.getPlayerNr());
		    if(p2.isHuman()){
		    	game.humanMove(p2.getPlayerNr()); 
		    }
		    else{   
		    	game.computerMove(p2.getPlayerNr());
		    }
	
		    if(game.checkForWin(p2.getPlayerNr())){
		    	Printer.winner(p2.getPlayerNr());
		    	break;
		    }
		}
    }
}
