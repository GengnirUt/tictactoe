package com.is.ru.tictac;

import java.util.Scanner;

public class Input {
	
	public static boolean getPlayerMode()
	{
		Scanner in = new Scanner(System.in).useDelimiter("\\D*");
        	int mode = in.nextInt();
        	while(mode != 0 && mode != 1)
        		mode = in.nextInt();
        	if(mode == 0)
        		return true; // player is human
        	return false;
	}
	
	public static int[] getPlayerMove()
	{    
	    Scanner in = new Scanner(System.in);
	    int[] move = new int[2];
	    move[0] = in.nextInt(); // X move
	    move[1] = in.nextInt(); // Y move
	    return move;
	}
}
