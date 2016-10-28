package com.is.ru.tictac;

import java.util.Scanner;

import edu.princeton.cs.algs4.StdIn;

public class Input {
	
        public static boolean getPlayerMode()
	{
        int mode = StdIn.readInt();
        while(mode != 0 || mode != 1)
        	mode = StdIn.readInt();
        if(mode == 0)
        	return false; // player is human
        return true;
	}
	
	public static int[] getPlayerMove()
	{    
	    int[] move = new int[2];
	    move[0] = StdIn.readInt(); // row move
	    move[1] = StdIn.readInt(); // col move
	    return move;
	}

}
