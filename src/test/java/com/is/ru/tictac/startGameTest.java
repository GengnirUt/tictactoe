package com.is.ru.tictac;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class startGameTest {
	
    /* // The 3 functions below are not testable because the
       // game.checkIfOnBoard(move) is now private in GamePlay.java
    @Test
    public void isMoveLegalTrue()
    {
        startGame game = new startGame(true, true);
        int[] move = new int[2];
        move[0] = 0;
        move[1] = 1;
        assertTrue("this is legal move", game.checkIfOnBoard(move));
    }

    @Test
    public void isMoveLegalFalse()
    {
        startGame game = new startGame(true, true);
        int[] move = new int[2];
        move[0] = 3;
        move[1] = 4;
        assertFalse("this is legal move", game.checkIfOnBoard(move));
    }

    @Test
    public void isMoveLegalTestReturnsTrue()
    {
        startGame game = new startGame(true, true);
        int[] move = new int[2];
        move[0] = 0;
        move[1] = 1;
        assertTrue("this is legal move", game.checkIfOnBoard(move));
    }
    */

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
    public void checkForWinSecondRow()
    {
        startGame game = new startGame(true, true);
        game.board.markCellPlayed(1,1,0); // player 1
        game.board.markCellPlayed(1,1,1);
        game.board.markCellPlayed(1,1,2);
        assertTrue("returns true", game.checkForWin(1));
    }
    
    public void checkForWinThirdRowReturnsTrue()
    {
        startGame game = new startGame(true, true);
        game.board.markCellPlayed(1,2,0); // player 1
        game.board.markCellPlayed(1,2,1);
        game.board.markCellPlayed(1,2,2);
        assertTrue("returns true", game.checkForWin(1));
    }

    @Test
    public void checkForWinThirdRowReturnsFalse()
    {
        startGame game = new startGame(true, true);
        game.board.markCellPlayed(1,2,0); // player 1
        game.board.markCellPlayed(2,2,1); // player 2
        game.board.markCellPlayed(1,2,2); // player 1
        assertFalse("returns false", game.checkForWin(1));
    }

    @Test
    public void checkForWinFirstColReturnsTrue()
    {

        startGame game = new startGame(true, true);
        game.board.markCellPlayed(1,0,0); // player 1
        game.board.markCellPlayed(1,1,0); // player 1
        game.board.markCellPlayed(1,2,0); // player 1
        assertTrue("returns true", game.checkForWin(1));
    }
    
    @Test
    public void checkForWinSecondColReturnsTrue()
    {

        startGame game = new startGame(true, true);
        game.board.markCellPlayed(1,0,1); // player 1
        game.board.markCellPlayed(1,1,1); // player 1
        game.board.markCellPlayed(1,2,1); // player 1
        assertTrue("returns true", game.checkForWin(1));
    }

    @Test
    public void checkForWinThirdColReturnsTrue()
    {

        startGame game = new startGame(true, true);
        game.board.markCellPlayed(1,0,2); // player 1
        game.board.markCellPlayed(1,1,2); // player 2
        game.board.markCellPlayed(1,2,2); // player 1
        assertTrue("returns true", game.checkForWin(1));
    }

        
    @Test
    public void checkForWinDiagonalReturnsTrue_1()
    {

        startGame game = new startGame(true, true);
        game.board.markCellPlayed(1,0,0); // player 1
        game.board.markCellPlayed(1,1,1); // player 1
        game.board.markCellPlayed(1,2,2); // player 1
        assertTrue("returns true", game.checkForWin(1));
    }
    
    @Test
    public void checkForWinDiagonalReturnsTrue_2()
    {

        startGame game = new startGame(true, true);
        game.board.markCellPlayed(1,0,2); // player 1
        game.board.markCellPlayed(1,1,1); // player 1
        game.board.markCellPlayed(1,2,0); // player 1
        assertTrue("returns true", game.checkForWin(1));
    }
    
    @Test
    public void checkForWinDiagonalReturnsFalse_1()
    {

        startGame game = new startGame(true, true);
        game.board.markCellPlayed(1,0,2); // player 1
        game.board.markCellPlayed(2,1,1); // player 2
        game.board.markCellPlayed(1,2,0); // player 1
        assertFalse("returns false", game.checkForWin(1));
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
