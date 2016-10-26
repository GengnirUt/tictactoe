package com.is.ru.tictac;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


import org.junit.Test;

public class GamePlayTest {
    
  
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
    
    
    @Test
    public void humanPlayerMoveTestReturnsFalse_1()
    {
	GamePlay game = new GamePlay();
	game.playerMove(1, 0); // player 1 and 0 for human player
	assertFalse(game.board.isCellEmpty(0, 0));
    }
    
    @Test
    public void playerMoveTestReturnsFalse_2()
    {
        GamePlay game = new GamePlay();
        game.playerMove(1, 0); // player 1 and 0 for human player
        game.playerMove(1, 0); 
        assertFalse(game.board.isCellEmpty(1, 1));
    }
    
    /*    
    @Test
    public void computerPlayerMoveTestReturnsFalse_1()
    {
        GamePlay game = new GamePlay();
        game.playerMove(1, 0); // player 1 and 0 for human player
        assertFalse(game.board.isCellEmpty(0, 0));
    }
    */
    
    
    @Test
    public void checkForWinTestReturnsFalse()
    {
	GamePlay game = new GamePlay();
        assertFalse("returns false", game.checkForWin(1));
	
    }    
    
    
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
        game.testFunctionForCheckForWin(1,2,0); // player 2
        game.testFunctionForCheckForWin(1,2,1); // player 2
        game.testFunctionForCheckForWin(1,1,2); // player 2 third row should fail!
        assertFalse("returns false", game.checkForWin(1));

    }



}
