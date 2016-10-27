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

}

