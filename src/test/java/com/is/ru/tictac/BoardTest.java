package com.is.ru.tictac;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class BoardTest{

    @Test
    public void testBoardConstructor(){
        assertNotNull("Should not be null!", new Board());
    }

    @Test
    public void testEmptyCell(){
        Board board = new Board();
        assertEquals(true, board.isCellEmpty(0,0));
        assertEquals(true, board.isCellEmpty(1,2));
    }

    @Test
    public void testMarkCellPlayed(){
        Board board = new Board();
        board.markCellPlayed(1, 0, 0);
        assertEquals(false, board.isCellEmpty(0,0));
    }
    
    @Test
    public void testGetPlayerAtRowCol(){
        Board board = new Board();
        int x = board.getPlayerAtRowCol(0, 0);
        assertEquals(0, x);
    }
    
    @Test
    public void testIndexRow(){
    	int index = 5;
    	assertEquals(0, board.indexRow(index));
    	index = 15;
    	assertEquals(1, board.indexRow(index));
    	index = 25;
    	assertEquals(2, board.indexRow(index));
    }
    
    @Test
    public void testIndexCol(){
    	int index = 0;
    	assertEquals(0, board.indexRow(index));
    	index = 10;
    	assertEquals(0, board.indexRow(index));
    	index = 20;
    	assertEquals(0, board.indexRow(index));
    	index = 1;
    	assertEquals(1, board.indexRow(index));
    	index = 11;
    	assertEquals(1, board.indexRow(index));
    	index = 21;
    	assertEquals(1, board.indexRow(index));
    	index = 22;
    	assertEquals(2, board.indexRow(index));
    }
}

