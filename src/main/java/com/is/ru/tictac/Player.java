package com.is.ru.tictac;

public class Player {
	
	private boolean human;
	private int playerNumber;
	
	public Player(int playerNr, boolean humanTrue ) {
		playerNumber = playerNr;
		human = humanTrue;		
	}
	/*
	public Player(Player p ) {
		playerNumber = p.playerNumber;
		human = p.human;		
	}
	*/
	public boolean isHuman(){
		return human;
	}
	
	public int getPlayerNr(){
		return playerNumber;
	}

}
