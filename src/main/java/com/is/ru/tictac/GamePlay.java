package com.is.ru.tictac;

public class GamePlay {
    
    Board board;
    Input input;
    Printer print;
    public GamePlay()
    {
	board = new Board();
        input = new Input();
	print = new Printer(); 
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
	System.out.println("player " + player + " moved ");
	//print.printPlayer(player);
	//print.printBoard(board);
    }
    
    private void humanMove(int player)
    {
	// get human input
	int[] move = input.getPlayerMove();	
	int row = move[0];
	int col = move[1];
	while(true)
	{
	    if(isMoveLegal(row, col) && board.isCellEmpty(row, col))
	    {
		playedMove(player, row, col);
		break;
	    }
	    else
	    {
		print.spotTakenOrIllegal();
		print.playerMove(player);
		move = input.getPlayerMove();
		row = move[0];
	        col = move[1];
	    }	
	}
    }
        
    public void computerMove(int player)
    {
	boolean exit = false;
	for(int row = 0; row < 3; row++)
	{
	    if(exit)
	    {
		break;
	    }
	    for(int col = 0; col < 3; col++)
	    {
		if(board.isCellEmpty(row, col))
		{
		    playedMove(player, row, col);
		    exit = true;
		    break;
		}
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
