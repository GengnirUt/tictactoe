package com.is.ru.tictac;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


import org.junit.Test;

public class GamePlayTest {
    @Test
    public void isMoveLegalTestReturnsTrue() 
    {
	GamePlay game = new GamePlay();
	assertTrue("this is legal move", game.isMoveLegal(1, 1));
    }
    
    @Test
    public void isMoveLegalTestReturnsFalse_1()
    {
	GamePlay game = new GamePlay();
	assertFalse("this is not legal move", game.isMoveLegal(3, -1));
    }
    
    @Test
    public void isMoveLegalTestReturnsFalse_2()
    {
	GamePlay game = new GamePlay();
	assertFalse("this is not legal move", game.isMoveLegal(2, 3));
    }
}
