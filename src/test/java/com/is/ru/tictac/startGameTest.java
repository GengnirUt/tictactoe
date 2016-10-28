package com.is.ru.tictac;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class startGameTest {
	/*  Can we throw this away now?
    @Test
    public void greetResultsInHello() {
	World world = new World();
	assertEquals("Hello", world.greet());
    }
	*/
	@Test
    public void checkForWinTestReturnsFalse()
    {
	startGame game = new startGame();
        assertFalse(game.checkForWin(1));
    }  

	@Test
    public void TestCheckForTwoInARowHorizontal()
    {
    	startGame game = new startGame();
    	game.playedMove(1, 0, 0);
    	game.playedMove(1, 0, 1);
    	assertEquals(2, gameplay.checkForTwoInARowHorizontal(1));
    	game.playedMove(0, 0, 0);
    	game.playedMove(0, 0, 1);
    	assertEquals(-1, gameplay.checkForTwoInARowHorizontal(1));
    }
    
    @Test
    public void TestCheckForTwoInARowVertical()
    {
    	startGame game = new startGame(true, true);
    	game.board.boardplayedMove(1, 0, 0);
    	game.board.markCellPlayed(1, 1, 0);
    	assertEquals(20, gameplay.checkForTwoInARowVertical(1));
    	game.board.markCellPlayed(2, 0, 0);
    	game.board.markCellPlayed(2, 1, 0);
    	assertEquals(-1, gameplay.checkForTwoInARowVertical(1));
    }
    
    @Test
    public void TestCheckForTwoInARowDiagonal()
    {
    	startGame game = new startGame(true, true);
    	game.board.playedMove(1, 0, 0);
    	game.board.playedMove(1, 1, 1);
    	assertEquals(22, gameplay.checkForTwoInARowDiagonal(1));
    	game.board.playedMove(2, 0, 0);
    	game.board.playedMove(2, 1, 1);
    	assertEquals(-1, gameplay.checkForTwoInARowDiagonal(1));
    }
	
	
}
