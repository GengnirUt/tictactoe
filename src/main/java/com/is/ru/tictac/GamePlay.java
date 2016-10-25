package com.is.ru.tictac;

public class GamePlay {

    public GamePlay()
    {

    }
    
    
    public boolean isMoveLegal(int x, int y) // remember to change to private after tests
    {
	if(x >= 0 && x <= 2 && y >= 0 && y <= 2)
	{
   	    return true;
	}
	else
	{
	    return false;
	}
    }
}
