package com.is.ru.tictac;

public class Board{

    private int[][] board;
    private final int size = 3;

    public Board(){
        board = new int[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++)
                board[i][j] = 0;
        }
    }
    
    public int indexRow(int index){
    	if(index < 10)
    		return 0;
    	else if(index < 20)
    		return 1;
    	else
    		return 2;	
    }
    
    public int indexCol(int index){
    	if(index == 0 || index == 10 || index == 20)
    		return 0;
    	else if(index == 1 || index == 11 || index == 21)
    		return 1;
    	else
    		return 2;
    }

    public boolean isCellEmpty(int row, int col){
        if( board[row][col] == 0 )
            return true;
        else
            return false;
    }

    public void markCellPlayed(int player, int row, int col){
        if(isCellEmpty(row, col))
           board[row][col] = player;
    }
    
    public int getPlayerAtRowCol(int row, int col)
    {
    	return board[row][col];
    }
}

