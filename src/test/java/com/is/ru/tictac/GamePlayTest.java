package com.is.ru.tictac;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


import org.junit.Test;

public class GamePlayTest {
    
  /*  Set as comments for now - cant find the replacing function
    @Test
    public void isMoveLegalTestReturnsTrue() 
    {
	GamePlay game = new GamePlay();
	assertTrue("this is legal move", game.isThisMoveLegalTestFunction(1, 1));
    }
    
    @Test
    public void isMoveLegalTestReturnsFalse_1()
    {
	GamePlay game = new GamePlay();
	assertFalse("this is not legal move", game.isThisMoveLegalTestFunction(3, -1));
    }
    
    @Test
    public void isMoveLegalTestReturnsFalse_2()
    {
	GamePlay game = new GamePlay();
	assertFalse("this is not legal move", game.isThisMoveLegalTestFunction(2, 3));
    }
    */
    /*    
    @Test  // cannot run this test because now the user enters the input
    public void humanPlayerMoveTestReturnsFalse_1()
    {
	GamePlay game = new GamePlay();
	game.playerMove(1, 0); // player 1 and 0 for human player
	assertFalse(game.board.isCellEmpty(0, 0));
    }
    
    @Test  // cannot run this test because now the user enters the input
    public void playerMoveTestReturnsFalse_2()
    {
        GamePlay game = new GamePlay();
        game.playerMove(1, 0); // player 1 and 0 for human player
        game.playerMove(1, 0); 
        assertFalse(game.board.isCellEmpty(1, 1));
    }
    
    */

      
    /*
    @Test
    public void checkForWinFirstRow()
    {
        GamePlay game = new GamePlay();
	game.testFunctionForCheckForWin(1,0,0); // player 1
	game.testFunctionForCheckForWin(1,0,1); // player 1
	game.testFunctionForCheckForWin(1,0,2); // player 1 first row win!
        assertTrue("returns true", game.checkForWin(1));
    }
    @Test
    public void checkForWinSecondRow()
    {
        GamePlay game = new GamePlay();
        game.testFunctionForCheckForWin(1,1,0); // player 1
        game.testFunctionForCheckForWin(1,1,1); // player 1
        game.testFunctionForCheckForWin(1,1,2); // player 1 first row win!
        assertTrue("returns true", game.checkForWin(1));
    }

    @Test
    public void checkForWinThirdRow()
    {
        GamePlay game = new GamePlay();
        game.testFunctionForCheckForWin(2,2,0); // player 2
        game.testFunctionForCheckForWin(2,2,1); // player 2
        game.testFunctionForCheckForWin(2,2,2); // player 2 third row win!
        assertTrue("returns true", game.checkForWin(2));
    }
    
    @Test
    public void checkForWinThirdRowReturnsFalse()
    {
        GamePlay game = new GamePlay();
        game.testFunctionForCheckForWin(1,2,0); // player 1
        game.testFunctionForCheckForWin(1,2,1); // player 1
        game.testFunctionForCheckForWin(1,1,2); // player 1 third row should fail!
        assertFalse("returns false", game.checkForWin(1));
    }

    @Test
    public void checkForWinFirstColReturnsTrue()
    {
        GamePlay game = new GamePlay();
        game.testFunctionForCheckForWin(1,0,0); // player 1
        game.testFunctionForCheckForWin(1,0,1); // player 1
        game.testFunctionForCheckForWin(1,0,2); // player 1 
        assertTrue("returns true", game.checkForWin(1));
    }

    @Test
    public void checkForWinSecondColReturnsTrue()
    {
        GamePlay game = new GamePlay();
        game.testFunctionForCheckForWin(1,1,0); // player 1
        game.testFunctionForCheckForWin(1,1,1); // player 1
        game.testFunctionForCheckForWin(1,1,2); // player 1
        assertTrue("returns true", game.checkForWin(1));
    }
    
    @Test
    public void checkForWinSecondColReturnsFalse()
    {
        GamePlay game = new GamePlay();
        game.testFunctionForCheckForWin(1,1,0); // player 2
        game.testFunctionForCheckForWin(1,1,1); // player 2
        game.testFunctionForCheckForWin(1,1,2); // player 2
        assertFalse("returns false", game.checkForWin(2)); // wrong player, player 1 has won
    }
    
    @Test
    public void checkForWinThirdColReturnsTrue()
    {
        GamePlay game = new GamePlay();
        game.testFunctionForCheckForWin(2,1,0); // player 2
        game.testFunctionForCheckForWin(2,1,1); // player 2
        game.testFunctionForCheckForWin(2,1,2); // player 2
        assertTrue("returns true", game.checkForWin(2));
    }

    @Test
    public void checkForWinThirdColMixOfPlayersReturnsFalse()
    {
        GamePlay game = new GamePlay();
        game.testFunctionForCheckForWin(2,1,0); // player 2
        game.testFunctionForCheckForWin(1,1,1); // player 1
        game.testFunctionForCheckForWin(2,1,2); // player 2
        assertFalse("returns false", game.checkForWin(2)); // returns false
    }

    @Test
    public void checkForWinDiagonalReturnsTrue_1()
    {
        GamePlay game = new GamePlay();
        game.testFunctionForCheckForWin(1,0,0);
        game.testFunctionForCheckForWin(1,1,1); 
        game.testFunctionForCheckForWin(1,2,2); 
        assertTrue("returns true", game.checkForWin(1)); 
    }

    @Test
    public void checkForWinDiagonalReturnsTrue_2()
    {
        GamePlay game = new GamePlay();
        game.testFunctionForCheckForWin(1,0,0);
        game.testFunctionForCheckForWin(1,1,1);
        game.testFunctionForCheckForWin(1,2,2);
        assertTrue("returns true", game.checkForWin(1));
    }
    
    @Test
    public void checkForWinDiagonalReturnsFalse_1()
    {
        GamePlay game = new GamePlay();
        game.testFunctionForCheckForWin(1,0,0);
        game.testFunctionForCheckForWin(2,1,1);
        game.testFunctionForCheckForWin(1,2,2);
        assertFalse("returns false", game.checkForWin(1));
    }
    */
    
    
    @Test
    public void TestCheckForForks()
    {
		Board board = new Board();
    	GamePlay game = new GamePlay();
    	board.markCellPlayed(1, 0, 0);
    	board.markCellPlayed(1, 2, 2);
    	assertEquals(2, game.checkForForks(1));
    	board.markCellPlayed(0, 0, 0);
    	board.markCellPlayed(0, 2, 2);
    	assertEquals(-1, game.checkForForks(1));
    }
    /* Unnessary test - iscellempty is enough
    @Test
    public void TestCheckIfCenterIsEmpty()
    {
    	GamePlay game = new GamePlay();
    	assertEquals(11, gameplay.checkIfCenterIsEmpty(1));
    	game.playedMove(1, 1, 1);
    	assertEquals(-1, gameplay.checkIfCenterIsEmpty(1));
    }
    */
    @Test
    public void TestCheckForOpponentInCorner()
    {
		Board board = new Board();
    	GamePlay game = new GamePlay();
    	board.markCellPlayed(2, 0, 0);
    	assertEquals(22, game.checkForOpponentinCorner(1, board));
    	board.markCellPlayed(0, 0, 0);
    	
    	board.markCellPlayed(2, 0, 2);
    	assertEquals(20, game.checkForOpponentinCorner(1, board));
    	board.markCellPlayed(0, 0, 2);
    	
    	board.markCellPlayed(2, 2, 2);
    	assertEquals(0, game.checkForOpponentinCorner(1, board));
    	board.markCellPlayed(0, 2, 2);
    	
    	board.markCellPlayed(2, 2, 0);
    	assertEquals(2, game.checkForOpponentinCorner(1, board));
    }
    
    @Test
    public void TestCheckForEmptyCorner()
    {
		Board board = new Board();
    	GamePlay game = new GamePlay();
    	assertEquals(0, game.checkForEmptyCorner(1));
    	board.markCellPlayed(1, 0, 0);
    	assertEquals(2, game.checkForEmptyCorner(1));
    	board.markCellPlayed(1, 0, 2);
    	assertEquals(22, game.checkForEmptyCorner(1));
    	board.markCellPlayed(1, 2, 2);
    	assertEquals(20, game.checkForEmptyCorner(1));
    	board.markCellPlayed(1, 2, 0);
    	assertEquals(-1, game.checkForEmptyCorner(1));
    }
    
    @Test
    public void TestCheckForEmptySide()
    {
		Board board = new Board();
    	GamePlay game = new GamePlay();
    	assertEquals(1, game.checkForEmptySide(1));
    	board.markCellPlayed(1, 0, 1);
    	assertEquals(12, game.checkForEmptySide(1));
    	board.markCellPlayed(1, 1, 2);
    	assertEquals(21, game.checkForEmptySide(1));
    	board.markCellPlayed(1, 2, 1);
    	assertEquals(10, game.checkForEmptySide(1));
    	board.markCellPlayed(1, 1, 0);
    	assertEquals(-1, game.checkForEmptySide(1));
    }
	
	@Test
    public void testIndexRow(){
    	int index = 5;
    	assertEquals(0, gameplay.indexRow(index));
    	index = 15;
    	assertEquals(1, gameplay.indexRow(index));
    	index = 25;
    	assertEquals(2, gameplay.indexRow(index));
    }
    
    @Test
    public void testIndexCol(){
    	int index = 0;
    	assertEquals(0, gameplay.indexRow(index));
    	index = 10;
    	assertEquals(0, gameplay.indexRow(index));
    	index = 20;
    	assertEquals(0, gameplay.indexRow(index));
    	index = 1;
    	assertEquals(1, gameplay.indexRow(index));
    	index = 11;
    	assertEquals(1, gameplay.indexRow(index));
    	index = 21;
    	assertEquals(1, gameplay.indexRow(index));
    	index = 22;
    	assertEquals(2, gameplay.indexRow(index));
    }
}
