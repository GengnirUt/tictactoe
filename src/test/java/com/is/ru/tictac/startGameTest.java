package com.is.ru.tictac;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class startGameTest {
	
    
    @Test
    public void checkForWinTestReturnsFalse()
    {
	startGame game = new startGame(true, true);
        assertFalse(game.checkForWin(1));
    }  

    @Test
    public void checkForWinFirstRow()
    {
        startGame game = new startGame(true, true);
        game.board.markCellPlayed(1,0,0); // player 1
        game.board.markCellPlayed(1,0,1);
        game.board.markCellPlayed(1,0,2);
        assertTrue("returns false", game.checkForWin(1));
    }
    
    @Test
    public void TestCheckForTwoInARowHorizontal()
    {
    	startGame game = new startGame(true, true);
    	game.board.markCellPlayed(1, 0, 0);
    	game.board.markCellPlayed(1, 0, 1);
    	assertEquals(2, GamePlay.checkForTwoInARowHorizontal(1, game.board));
    	game.board.markCellPlayed(2, 2, 2);
    	game.board.markCellPlayed(2, 1, 2);
    	assertEquals(-1, GamePlay.checkForTwoInARowHorizontal(2, game.board));
    }
    
    @Test
    public void TestCheckForTwoInARowVertical()
    {
    	startGame game = new startGame(true, true);
       
    	game.board.markCellPlayed(1, 0, 0);
    	game.board.markCellPlayed(1, 1, 0);
    	assertEquals(20, GamePlay.checkForTwoInARowVertical(1, game.board));
    	game.board.markCellPlayed(2, 2, 0);
    	game.board.markCellPlayed(2, 0, 1);
    	assertEquals(-1, GamePlay.checkForTwoInARowVertical(2, game.board));
    }
    
    @Test
    public void TestCheckForTwoInARowDiagonal()
    {
    	startGame game = new startGame(true, true);

    	game.board.markCellPlayed(1, 0, 0);
    	game.board.markCellPlayed(1, 1, 1);
    	assertEquals(22, GamePlay.checkForTwoInARowDiagonal(1, game.board));
    	game.board.markCellPlayed(2, 1, 0);
    	game.board.markCellPlayed(2, 2, 1);
    	assertEquals(-1, GamePlay.checkForTwoInARowDiagonal(2, game.board));
    }
	
	
}
