package com.is.ru.tictac;

public class GamePlay {
    
    
 
    public GamePlay(){}  // not to be instantiated
 
    private int indexRow(int index){
    	if(index < 10)
    		return 0;
    	else if(index < 20)
    		return 1;
    	else
    		return 2;	
    }
    
    private int indexCol(int index){
    	if(index == 0 || index % 10 == 0)
    		return 0;
    	else if(index == 1 || index % 10 == 1)
    		return 1;
    	else
    		return 2;
    }
        
    public int[] computerMove(int player, Board board){
    	//If computer has two in a row, play the third to win.
    	int[] retvalue = new int[2];
    	int index;
    	
    	index = checkForTwoInARowHorizontal(player, board);
    	if(index >= 0){
    		retvalue[0] = indexRow(index);
    		retvalue[1] = indexCol(index);
    		return retvalue;
    	}
    	index = checkForTwoInARowVertical(player, board);
    	if(index >= 0){
    		retvalue[0] = indexRow(index);
    		retvalue[1] = indexCol(index);
    		return retvalue;
    	}
    	index = checkForTwoInARowDiagonal(player, board);
    	if(index >= 0){
    		retvalue[0] = indexRow(index);
    		retvalue[1] = indexCol(index);
    		return retvalue;
    	}
    	
    	//If opponent has two in a row, play the third to block.
    	int opponent;
    	if(player == 1)
    		opponent = 2;
    	else
    		opponent = 1;
    	index = checkForTwoInARowHorizontal(opponent, board);
    	if(index >= 0){
    		retvalue[0] = indexRow(index);
    		retvalue[1] = indexCol(index);
    		return retvalue;
    	}
    	index = checkForTwoInARowVertical(opponent, board);
    	if(index >= 0){
    		retvalue[0] = indexRow(index);
    		retvalue[1] = indexCol(index);
    		return retvalue;
    	}
    	index = checkForTwoInARowDiagonal(opponent, board);
    	if(index >= 0){
    		retvalue[0] = indexRow(index);
    		retvalue[1] = indexCol(index);
    		return retvalue;
    	}
    	
    	//Check for possible ways to create a fork play.
    	index = checkForForks(player, board);
    	if(index >= 0){
    		retvalue[0] = indexRow(index);
    		retvalue[1] = indexCol(index);
    		return retvalue;
    	}
    	
    	//Check for possible forsk for opponent and play block.
    	index = checkForForks(opponent, board);
    	if(index >= 0){
    		retvalue[0] = indexRow(index);
    		retvalue[1] = indexCol(index);
    		return retvalue;
    	}
    	
    	//Check if center is free and if it is free then play it.
    	index = checkIfCenterIsEmpty(player, board);
    	if(index >= 0){
    		retvalue[0] = indexRow(index);
    		retvalue[1] = indexCol(index);
    		return retvalue;
    	}
    	
    	//Check if opponent is in a corner then play the opposite corner.
    	index = checkForOpponentInCorner(player, board);
    	if(index >= 0){
    		retvalue[0] = indexRow(index);
    		retvalue[1] = indexCol(index);
    		return retvalue;
    	}
    	
    	//Check if there is an empty corner, then play it.
    	index = checkForEmptyCorner(player, board);
    	if(index >= 0){
    		retvalue[0] = indexRow(index);
    		retvalue[1] = indexCol(index);
    		return retvalue;
    	}
    	
    	//Check if there is an empty side, then play it.
    	index = checkForEmptySide(player, board);
    	if(index >= 0){
    		retvalue[0] = indexRow(index);
    		retvalue[1] = indexCol(index);
    		return retvalue;
    	}
    	else{
    		retvalue[0] = 3;
			retvalue[1] = 3;
			return retvalue;
    	}
    }
    	
    	
    	//Checks if a player has two cells in a single row horizontal.
    	private int checkForTwoInARowHorizontal(int player, Board board)
        {
    		/* Need to change the index add 10 to all - save until later 
    		for(int x = 0; x < 2; x++){
    			for(int y = 0; y < 2; y++){
    				if(player == board.getPlayerAtRowCol(x, y) 
    		                && player == board.getPlayerAtRowCol(x+1, y))
						return ...
					else if x+2
						return...
						
    			}
    			return -1
    		}
    		*/
	    	if(player == board.getPlayerAtRowCol(0, 0) 
	    			&& player == board.getPlayerAtRowCol(0, 1)){
	    		return 2; // first row - Left + Middle
	    	}
	    	else if(player == board.getPlayerAtRowCol(0, 1) 
	    			&& player == board.getPlayerAtRowCol(0, 2)){
	    		return 0; // first row - Right + Middle
	    	}
	    	else if(player == board.getPlayerAtRowCol(0, 0) 
	    			&& player == board.getPlayerAtRowCol(0, 2)){
	    		return 1; // first row - Right + Left
	    	}
	    	else if(player == board.getPlayerAtRowCol(1, 0) 
	    			&& player == board.getPlayerAtRowCol(1, 1)){
	    		return 12; // second row - Left + Middle
	    	}
	    	else if(player == board.getPlayerAtRowCol(1, 1) 
	    			&& player == board.getPlayerAtRowCol(1, 2)){
	    		return 10; // second row - Middle + Right
	    	}
	    	else if(player == board.getPlayerAtRowCol(1, 0) 
	    			&& player == board.getPlayerAtRowCol(1, 2)){
	    		return 11; // second row - Left + Right
	    	 }
	    	else if(player == board.getPlayerAtRowCol(2, 0) 
	    			&& player == board.getPlayerAtRowCol(2, 1)){
	    		return 22; // third row - Left + Middle
	    	}
	    	else if(player == board.getPlayerAtRowCol(2, 1) 
	    			&& player == board.getPlayerAtRowCol(2, 2)){
	    		return 20; // third row - Middle + Right
	    	}
	    	else if(player == board.getPlayerAtRowCol(2, 0) 
	    			&& player == board.getPlayerAtRowCol(2, 2)){
	    		return 21; // third row - Left + Right
	    	}
	    	else{
	    		return -1;
	    	}
        }
    	
    	//Checks if a player has two cells in a single row vertical
    	private int checkForTwoInARowVertical(int player, Board board)
        {
	    	if(player == board.getPlayerAtRowCol(0, 0) 
	    			&& player == board.getPlayerAtRowCol(1, 0)){
	    		return 20; // first row - Top + Middle
	    	}
	    	else if(player == board.getPlayerAtRowCol(1, 0) 
	    			&& player == board.getPlayerAtRowCol(2, 0)){
	    		return 0; // first row - Bottom + Middle
	    	}
	    	else if(player == board.getPlayerAtRowCol(0, 0) 
	    			&& player == board.getPlayerAtRowCol(2, 0)){
	    		return 10; // first row - Top + Bottom
	    	}
	    	else if(player == board.getPlayerAtRowCol(0, 1) 
	    			&& player == board.getPlayerAtRowCol(1, 1)){
	    		return 21; // second row - Top + Middle
	    	}
	    	else if(player == board.getPlayerAtRowCol(1, 1) 
	    			&& player == board.getPlayerAtRowCol(2, 1)){
	    		return 1; // second row - Middle + Bottom
	    	}
	    	else if(player == board.getPlayerAtRowCol(0, 1) 
	    			&& player == board.getPlayerAtRowCol(2, 1)){
	    		return 11; // second row - Top + Bottom
	    	 }
	    	else if(player == board.getPlayerAtRowCol(0, 2) 
	    			&& player == board.getPlayerAtRowCol(1, 2)){
	    		return 22; // third row - Top + Middle
	    	}
	    	else if(player == board.getPlayerAtRowCol(1, 2) 
	    			&& player == board.getPlayerAtRowCol(2, 2)){
	    		return 2; // third row - Middle + Bottom
	    	}
	    	else if(player == board.getPlayerAtRowCol(0, 2) 
	    			&& player == board.getPlayerAtRowCol(2, 2)){
	    		return 12; // third row - Top + Bottom
	    	}
	    	else{
	    		return -1;
	    	}
        }
    	
    	//Checks if a player has two cells in a single row diagonal
    	private int checkForTwoInARowDiagonal(int player, Board board){
	    	if(player == board.getPlayerAtRowCol(0, 0) 
	    			&& player == board.getPlayerAtRowCol(1, 1)){
	    	    return 22; // Top Left + Middle Middle
	    	}
	    	else if(player == board.getPlayerAtRowCol(1, 1) 
	    			&& player == board.getPlayerAtRowCol(2, 2)){
	    	    return 0; // Middle Middle + Bottom Right
	    	}
	    	else if(player == board.getPlayerAtRowCol(0, 0) 
	    			&& player == board.getPlayerAtRowCol(2, 2)){
	    		return 11; // Top Left + Bottom Right
	    	}
	    	else if(player == board.getPlayerAtRowCol(0, 2) 
	    			&& player == board.getPlayerAtRowCol(1, 1)){
	    		return 20; // Top Right + Middle Middle
	    	}
	    	else if(player == board.getPlayerAtRowCol(1, 1) 
	    			&& player == board.getPlayerAtRowCol(2, 0)){
	    		return 2; // Middle Middle + Bottom Left
	    	}
	    	else if(player == board.getPlayerAtRowCol(2, 0) 
	    			&& player == board.getPlayerAtRowCol(0, 2)){
	    	    return 11; // Bottom Left + Top Right
	    	 }
	    	else{
	    	    return -1;
	    	}
        }
    	
    	//Checks if there are any fork plays available in the corners
    	private int checkForForks(int player, Board board){
    		if(player == board.getPlayerAtRowCol(0, 0) 
	                && player == board.getPlayerAtRowCol(2, 2)
	                && board.isCellEmpty(0, 1)
	                && board.isCellEmpty(0, 2)
	                && board.isCellEmpty(1, 2)){
	    	    return 2; // Top Left + Middle Middle
	    	}
    		else if(player == board.getPlayerAtRowCol(0, 2) 
	                && player == board.getPlayerAtRowCol(2, 0)
	                && board.isCellEmpty(1, 2)
	                && board.isCellEmpty(2, 2)
	                && board.isCellEmpty(2, 1)){
	    	    return 22; // Top Left + Middle Middle
	    	}
    		else if(player == board.getPlayerAtRowCol(2, 2) 
	                && player == board.getPlayerAtRowCol(0, 0)
	                && board.isCellEmpty(2, 1)
	                && board.isCellEmpty(2, 0)
	                && board.isCellEmpty(1, 0)){
	    	    return 20; // Top Left + Middle Middle
	    	}
    		else if(player == board.getPlayerAtRowCol(2, 0) 
	                && player == board.getPlayerAtRowCol(0, 2)
	                && board.isCellEmpty(1, 0)
	                && board.isCellEmpty(0, 0)
	                && board.isCellEmpty(0, 1)){
	    	    return 0; // Top Left + Middle Middle
	    	}
    		else
	    	{
	    	    return -1;
	    	}	
    	}
    	
    	
		//Checks if the center cell is empty
    	//WHY????
    	private int checkIfCenterIsEmpty(int player, Board board){
    		if(board.isCellEmpty(1,1))
    			return 11;
    		else
    			return -1;
    	}
    	
    	
    	//Checks if the opponent has played any of the corners and the opposite corner is empty
    	private int checkForOpponentInCorner(int player, Board board){
    		if(player != board.getPlayerAtRowCol(0, 0) 
	                && !board.isCellEmpty(0, 0)){
    			return 22;
    		}
    		else if(player != board.getPlayerAtRowCol(0, 2) 
	                && !board.isCellEmpty(0, 2)){
    			return 20;
    		}
    		else if(player != board.getPlayerAtRowCol(2, 2) 
	                && !board.isCellEmpty(2, 2)){
    			return 0;
    		}
    		else if(player != board.getPlayerAtRowCol(2, 0) 
	                && !board.isCellEmpty(2, 0)){
    			return 2;
    		}
    		else{
	    	    return -1;
	    	}
    	}
    	
    	//Checks if there is an empty corner to play
    	private int checkForEmptyCorner(int player, Board board){
    		if(board.isCellEmpty(0, 0)){
    			return 0;
    		}
    		else if(board.isCellEmpty(0, 2)){
    			return 2;
    		}
    		else if(board.isCellEmpty(2, 2)){
    			return 22;
    		}
    		else if(board.isCellEmpty(2, 0)){
    			return 20;
    		}
    		else{
	    	    return -1;
	    	}
    	}
    	
    	//Checks if there is an empty cell in the sides
    	private int checkForEmptySide(int player, Board board){
    		if(board.isCellEmpty(0, 1)){
    			return 1;
    		}
    		else if(board.isCellEmpty(1, 2)){
    			return 12;
    		}
    		else if(board.isCellEmpty(2, 1)){
    			return 21;
    		}
    		else if(board.isCellEmpty(1, 0)){
    			return 10;
    		}
    		else{
	    	    return -1;
	    	}
    	}	
}
