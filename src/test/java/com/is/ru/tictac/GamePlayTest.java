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
    public void checkForWinTestTrue()
    {
	GamePlay game = new GamePlay();
        assertTrue("returns true", game.checkForWin(1));
	
    }    
    
    /*
    @Test
    public void checkForWinTestTrue()
    {
        GamePlay game = new GamePlay();
        assert("returns true", game.checkForWin(1));

    }
    */


}
