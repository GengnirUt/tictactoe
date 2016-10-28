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
    

    public boolean isCellEmpty(int row, int col){
        if( board[row][col] == 0 )
            return true;
        else
            return false;
    }
    
    public int getBoardSize(){
    	return size;
    }

    public void markCellPlayed(int player, int row, int col){
    	if(!isCellEmpty(row, col))
    		throw new IllegalArgumentException("Cell (" + row + "," + col + ") has been marked already!!!");
           board[row][col] = player;
    }
    
    public int getPlayerAtRowCol(int row, int col)
    {
    	return board[row][col];
    }
}

