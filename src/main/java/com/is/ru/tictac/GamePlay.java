package com.is.ru.tictac;

public class GamePlay {
    
    Board board;
    //Input input;
    //Printer print;
    public GamePlay(){
    	board = new Board();
    	//input = new Input();
    	//print = new Printer(); 
    }
    /*
    public void playerMove(int player, int humanOrComputer){  
		if(humanOrComputer == 0) // if player is human == 0
		{
		    humanMove(player); 
		}
		else	// if player is computer == 1
		{
		    computerMove(player);
		}

		print.printBoard(board);
    }
  */  
    public void humanMove(int player){
	// get human input
    	int[] move = Input.getPlayerMove();	
    	int row = move[0];
    	int col = move[1];
    	while(true)
		{
		    if(isMoveLegal(row, col) && board.isCellEmpty(row, col)){
		    	playedMove(player, row, col);
		    	break;
		    }
		    else{
		    	Printer.spotTakenOrIllegal();
		    	Printer.playerMove(player);
		    	move = Input.getPlayerMove();
		    	row = move[0];
		        col = move[1];
		    }	
		}
    }
        
    public void computerMove(int player){
    	//If computer has two in a row, play the third to win.
    	int index;
    	index = checkForTwoInARowHorizontal(player);
    	if(index >= 0){
    		playedMove(player, board.indexRow(index), board.(indexCol(index)));
    		return;
    	}
    	index = checkForTwoInARowVertical(player);
    	if(index >= 0){
    		playedMove(player, board.indexRow(index), board.(indexCol(index)));
    		return;
    	}
    	index = checkForTwoInARowDiagonal(player);
    	if(index >= 0){
    		playedMove(player, board.indexRow(index), board.(indexCol(index)));
    		return;
    	}
    	
    	//If opponent has two in a row, play the third to block.
    	int opponent;
    	if(player == 1)
    		opponent = 2;
    	else
    		opponent = 1;
    	index = checkForTwoInARowHorizontal(opponent);
    	if(index >= 0){
    		playedMove(player, board.indexRow(index), board.(indexCol(index)));
    		return;
    	}
    	index = checkForTwoInARowVertical(opponent);
    	if(index >= 0){
    		playedMove(player, board.indexRow(index), board.(indexCol(index)));
    		return;
    	}
    	index = checkForTwoInARowDiagonal(opponent);
    	if(index >= 0){
    		playedMove(player, board.indexRow(index), board.(indexCol(index)));
    		return;
    	}
    	
    	//Check for possible ways to create a fork play.
    	index = checkForForks(player);
    	if(index >= 0){
    		playedMove(player, board.indexRow(index), board.(indexCol(index)));
    		return;
    	}
    	
    	//Check for possible forsk for opponent and play block.
    	index = checkForForks(opponent);
    	if(index >= 0){
    		playedMove(player, board.indexRow(index), board.(indexCol(index)));
    		return;
    	}
    	
    	//Check if center is free and if it is free then play it.
    	index = checkIfCenterIsEmpty(player);
    	if(index >= 0){
    		playedMove(player, board.indexRow(index), board.(indexCol(index)));
    		return;
    	}
    	
    	//Check if opponent is in a corner then play the opposite corner.
    	index = checkForOpponentInCorner(player);
    	if(index >= 0){
    		playedMove(player, board.indexRow(index), board.(indexCol(index)));
    		return;
    	}
    	
    	//Check if there is an empty corner, then play it.
    	index = checkForEmptyCorner(player);
    	if(index >= 0){
    		playedMove(player, board.indexRow(index), board.(indexCol(index)));
    		return;
    	}
    	
    	//Check if there is an empty side, then play it.
    	index = checkForEmptySide(player);
    	if(index >= 0){
    		playedMove(player, board.indexRow(index), board.(indexCol(index)));
    		return;
    	}
    	
    	
    	//Checks if a player has two cells in a single row horizontal.
    	private int checkForTwoInARowHorizontal(int player)
        {
	    	if(player == board.getPlayerAtRowCol(0, 0) 
	                && player == board.getPlayerAtRowCol(0, 1))
	    	{
	    	    return 2; // first row - Left + Middle
	    	}
	    	else if(player == board.getPlayerAtRowCol(0, 1) 
	                     && player == board.getPlayerAtRowCol(0, 2))
	    	{
	    	    return 0; // first row - Right + Middle
	    	}
	    	else if(player == board.getPlayerAtRowCol(0, 0) 
	                && player == board.getPlayerAtRowCol(0, 2))
	    	{
		    return 1; // first row - Right + Left
	    	}
	    	else if(player == board.getPlayerAtRowCol(1, 0) 
	                && player == board.getPlayerAtRowCol(1, 1))
	    	{
		    return 12; // second row - Left + Middle
	    	}
	    	else if(player == board.getPlayerAtRowCol(1, 1) 
	           && player == board.getPlayerAtRowCol(1, 2))
	    	{
	    		return 10; // second row - Middle + Right
	    	}
	    	else if(player == board.getPlayerAtRowCol(1, 0) 
	    	           && player == board.getPlayerAtRowCol(1, 2))
	    	 {
	    	    return 11; // second row - Left + Right
	    	 }
	    	else if(player == board.getPlayerAtRowCol(2, 0) 
	                && player == board.getPlayerAtRowCol(2, 1))
	    	{
		    return 22; // third row - Left + Middle
	    	}
	    	else if(player == board.getPlayerAtRowCol(2, 1) 
	           && player == board.getPlayerAtRowCol(2, 2))
	    	{
	    		return 20; // third row - Middle + Right
	    	}
	    	else if(player == board.getPlayerAtRowCol(2, 0) 
	    	           && player == board.getPlayerAtRowCol(2, 2))
	    	{
	    	    return 21; // third row - Left + Right
	    	}
	    	else
	    	{
	    	    return -1;
	    	}
        }
    	
    	//Checks if a player has two cells in a single row vertical
    	private int checkForTwoInARowVertical(int player)
        {
	    	if(player == board.getPlayerAtRowCol(0, 0) 
	                && player == board.getPlayerAtRowCol(1, 0))
	    	{
	    	    return 20; // first row - Top + Middle
	    	}
	    	else if(player == board.getPlayerAtRowCol(1, 0) 
	                     && player == board.getPlayerAtRowCol(2, 0))
	    	{
	    	    return 0; // first row - Bottom + Middle
	    	}
	    	else if(player == board.getPlayerAtRowCol(0, 0) 
	                && player == board.getPlayerAtRowCol(2, 0))
	    	{
		    return 10; // first row - Top + Bottom
	    	}
	    	else if(player == board.getPlayerAtRowCol(0, 1) 
	                && player == board.getPlayerAtRowCol(1, 1))
	    	{
		    return 21; // second row - Top + Middle
	    	}
	    	else if(player == board.getPlayerAtRowCol(1, 1) 
	           && player == board.getPlayerAtRowCol(2, 1))
	    	{
	    		return 1; // second row - Middle + Bottom
	    	}
	    	else if(player == board.getPlayerAtRowCol(0, 1) 
	    	           && player == board.getPlayerAtRowCol(2, 1))
	    	 {
	    	    return 11; // second row - Top + Bottom
	    	 }
	    	else if(player == board.getPlayerAtRowCol(0, 2) 
	                && player == board.getPlayerAtRowCol(1, 2))
	    	{
		    return 22; // third row - Top + Middle
	    	}
	    	else if(player == board.getPlayerAtRowCol(1, 2) 
	           && player == board.getPlayerAtRowCol(2, 2))
	    	{
	    		return 2; // third row - Middle + Bottom
	    	}
	    	else if(player == board.getPlayerAtRowCol(0, 2) 
	    	           && player == board.getPlayerAtRowCol(2, 2))
	    	{
	    	    return 12; // third row - Top + Bottom
	    	}
	    	else
	    	{
	    	    return -1;
	    	}
        }
    	
    	//Checks if a player has two cells in a single row diagonal
    	private int checkForTwoInARowDiagonal(int player)
        {
	    	if(player == board.getPlayerAtRowCol(0, 0) 
	                && player == board.getPlayerAtRowCol(1, 1))
	    	{
	    	    return 22; // Top Left + Middle Middle
	    	}
	    	else if(player == board.getPlayerAtRowCol(1, 1) 
	                     && player == board.getPlayerAtRowCol(2, 2))
	    	{
	    	    return 0; // Middle Middle + Bottom Right
	    	}
	    	else if(player == board.getPlayerAtRowCol(0, 0) 
	                && player == board.getPlayerAtRowCol(2, 2))
	    	{
		    return 11; // Top Left + Bottom Right
	    	}
	    	else if(player == board.getPlayerAtRowCol(0, 2) 
	                && player == board.getPlayerAtRowCol(1, 1))
	    	{
		    return 20; // Top Right + Middle Middle
	    	}
	    	else if(player == board.getPlayerAtRowCol(1, 1) 
	           && player == board.getPlayerAtRowCol(2, 0))
	    	{
	    		return 2; // Middle Middle + Bottom Left
	    	}
	    	else if(player == board.getPlayerAtRowCol(2, 0) 
	    	           && player == board.getPlayerAtRowCol(0, 2))
	    	 {
	    	    return 11; // Bottom Left + Top Right
	    	 }
	    	else
	    	{
	    	    return -1;
	    	}
        }
    	
    	//Checks if there are any fork plays available in the corners
    	private int checkForForks(int player)
    	{
    		if(player == board.getPlayerAtRowCol(0, 0) 
	                && player == board.getPlayerAtRowCol(2, 2)
	                && isCellEmpty(0, 1)
	                && isCellEmpty(0, 2)
	                && isCellEmpty(1, 2))		
	    	{
	    	    return 2; // Top Left + Middle Middle
	    	}
    		else if(player == board.getPlayerAtRowCol(0, 2) 
	                && player == board.getPlayerAtRowCol(2, 0)
	                && isCellEmpty(1, 2)
	                && isCellEmpty(2, 2)
	                && isCellEmpty(2, 1))		
	    	{
	    	    return 22; // Top Left + Middle Middle
	    	}
    		else if(player == board.getPlayerAtRowCol(2, 2) 
	                && player == board.getPlayerAtRowCol(0, 0)
	                && isCellEmpty(2, 1)
	                && isCellEmpty(2, 0)
	                && isCellEmpty(1, 0))		
	    	{
	    	    return 20; // Top Left + Middle Middle
	    	}
    		else if(player == board.getPlayerAtRowCol(2, 0) 
	                && player == board.getPlayerAtRowCol(0, 2)
	                && isCellEmpty(1, 0)
	                && isCellEmpty(0, 0)
	                && isCellEmpty(0, 1))		
	    	{
	    	    return 0; // Top Left + Middle Middle
	    	}
    		else
	    	{
	    	    return -1;
	    	}	
    	}
    	
    	//Checks if the center cell is empty
    	private int checkIfCenterIsEmpty(int player)
    	{
    		if(isCellEmpty(1,1))
    			return 11;
    		else
    			return -1;
    	}
    	
    	//Checks if the opponent has played any of the corners and the opposite corner is empty
    	private int checkForOpponentInCorner(int player)
    	{
    		if(player != board.getPlayerAtRowCol(0, 0) 
	                && !isCellEmpty(0, 0))
    		{
    			return 22;
    		}
    		else if(player != board.getPlayerAtRowCol(0, 2) 
	                && !isCellEmpty(0, 2))
    		{
    			return 20;
    		}
    		else if(player != board.getPlayerAtRowCol(2, 2) 
	                && !isCellEmpty(2, 2))
    		{
    			return 0;
    		}
    		else if(player != board.getPlayerAtRowCol(2, 0) 
	                && !isCellEmpty(2, 0))
    		{
    			return 2;
    		}
    		else
	    	{
	    	    return -1;
	    	}
    	}
    	
    	//Checks if there is an empty corner to play
    	private int checkForEmptyCorner(int player)
    	{
    		if(isCellEmpty(0, 0))
    		{
    			return 0;
    		}
    		else if(isCellEmpty(0, 2))
    		{
    			return 2;
    		}
    		else if(isCellEmpty(2, 2))
    		{
    			return 22;
    		}
    		else if(isCellEmpty(2, 0))
    		{
    			return 20;
    		}
    		else
	    	{
	    	    return -1;
	    	}
    	}
    	
    	//Checks if there is an empty cell in the sides
    	private int checkForEmptySide(int player)
    	{
    		if(isCellEmpty(0, 1))
    		{
    			return 1;
    		}
    		else if(isCellEmpty(1, 2))
    		{
    			return 12;
    		}
    		else if(isCellEmpty(2, 1))
    		{
    			return 21;
    		}
    		else if(isCellEmpty(1, 0))
    		{
    			return 10;
    		}
    		else
	    	{
	    	    return -1;
	    	}
    	}	
    }
    
    private void playedMove(int player, int row, int col) 
    {
	board.markCellPlayed(player, row, col);
    }
    
    public boolean checkForWin(int player)
    {
	if(checkForWinnerHorizontal(player))
	{
	     return true;
	}
	else if(checkForWinnerVertical(player))
	{
	    return true;
	}
	else if(checkForWinnerDiagonal(player))
	{
	    return true;
	}
	else
	{
	    return false;
	}
    }
    
    private boolean checkForWinnerHorizontal(int player)
    {
	if(player == board.getPlayerAtRowCol(0, 0) 
            && player == board.getPlayerAtRowCol(0, 1) 
            && player == board.getPlayerAtRowCol(0, 2))
	{
	    return true; // first row
	}
	else if(player == board.getPlayerAtRowCol(1, 0) 
                 && player == board.getPlayerAtRowCol(1, 1) 
                 && player == board.getPlayerAtRowCol(1, 2))
	{
	    return true; // second row
	}
	else if(player == board.getPlayerAtRowCol(2, 0) 
                 && player == board.getPlayerAtRowCol(2, 1) 
                 && player == board.getPlayerAtRowCol(2, 2))
        {
            return true; // third row
        }
	else
	{
	    return false;
	}
    }

    private boolean checkForWinnerVertical(int player)
    {
        if(player == board.getPlayerAtRowCol(0, 0) 
            && player == board.getPlayerAtRowCol(1, 0) 
            && player == board.getPlayerAtRowCol(2, 0))
        {
            return true; // first row
        }
        else if(player == board.getPlayerAtRowCol(0, 1) 
	         && player == board.getPlayerAtRowCol(1, 1) 
                 && player == board.getPlayerAtRowCol(2, 1))
        {
            return true; // second row
        }
        else if(player == board.getPlayerAtRowCol(0, 2) 
                 && player == board.getPlayerAtRowCol(1, 2) 
                 && player == board.getPlayerAtRowCol(2, 2))
        {
            return true; // third row
        }
	else
	{
            return false;
	}
    }
    
    private boolean checkForWinnerDiagonal(int player)
    {
	
        if(player == board.getPlayerAtRowCol(0, 0)
            && player == board.getPlayerAtRowCol(1, 1)
            && player == board.getPlayerAtRowCol(2, 2))

	{
	    return true;
	}
	else if (player == board.getPlayerAtRowCol(0, 2)
            && player == board.getPlayerAtRowCol(1, 1)
            && player == board.getPlayerAtRowCol(2, 0))
	{
	    return true;
	}
    	else
	{
	    return false;
	}
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
