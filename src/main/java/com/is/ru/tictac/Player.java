package com.is.ru.tictac;

public class Player {
	
	private static boolean human;
	private static int playerNumber;
	
	public Player(int playerNr, boolean humanTrue ) {
		playerNumber = playerNr;
		human = humanTrue;		
	}
	
	public static boolean isHuman(){
		return human;
	}
	
	public static int getPlayerNr(){
		return playerNumber;
	}

}
