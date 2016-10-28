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
    public void computerPlayerMoveTestReturnsFalse_1()
    {
        Board board = new Board();
        board.markCellPlayed(1, 1, 1); // player 1 and 1 for computer
        assertFalse(board.isCellEmpty(1, 1));
    }
    
    @Test
    public void computerPlayerMoveTestReturnsTrue_1()
    {
        Board board = new Board();
        board.markCellPlayed(1, 0, 0); // player 1 and 1 for computer
        assertTrue(game.board.isCellEmpty(1, 1));
    }
	
	 @Test
    public void computerPlayerMoveTestReturnsFalse_2()
    {
        Board board = new Board();
        board.markCellPlayed(0, 0, 1); // player 1 and 1 for computer
		board.markCellPlayed(1, 0, 0); // player 1 and 1 for computer
        assertFalse(game.board.isCellEmpty(0, 1));
    }
    
    
}

