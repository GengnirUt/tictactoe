package com.is.ru.tictac;

public class GamePlay {
    
    Board board;
    
    public GamePlay()
    {
	board = new Board(); 
    }
    
    public void playerMove(int player, int humanOrComputer) 
    {  
	if(humanOrComputer == 0) // if player is human == 0
	{
	    humanMove(player); 
	}
	else	// if player is computer == 1
	{
	    computerMove(player);
	}
    }

    private void humanMove(int player)
    {
	// get human input
	int x = 0;
	int y = 0;
	while(true)
	{
	    if(isMoveLegal(x, y) && board.isCellEmpty(x, y))
	    {
		playedMove(player, x, y);
		break;
	    }
	    else
	    {
		// tell player that inputIsTakenOrIllegal
		// ask the player to give input again
		x = 1;
	        y = 1;
	    }	
	}
    }
    
    
    public void computerMove(int player)
    {
	// computer move
    }
    
    private void playedMove(int player, int row, int col) 
    {
	board.markCellPlayed(player, row, col);
    }
    
    public boolean checkForWin(int player)
    {
	return checkForWinner(player);
    }
    
    private boolean checkForWinner(int player)
    {
	if(player == board.getPlayerAtRowCol(0, 0) && player == board.getPlayerAtRowCol(0, 1) && player == board.getPlayerAtRowCol(0, 2))
	{
	    return true;
	}
	return false;
	//else if(player = board.getPlayerAtRowCol(0, 0) && (player = board.getPlayerAtRowCol(0, 1) && (player = board.getPlayerAtRowCol(0, 2))
    }
    public boolean isThisMoveLegalTestFunction(int row, int col)
    {
	return isMoveLegal(row, col);
    }
    private boolean isMoveLegal(int row, int col)
    {
	if(row >= 0 && row <= 2 && col >= 0 && col <= 2)
	{
   	    return true;
	}
	else
	{
	    return false;
	}
    }
    
    public void testFunctionForCheckForWin(int player, int row, int col)
    {
	playedMove(player, row, col);
    }

    
}
