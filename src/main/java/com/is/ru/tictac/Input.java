package com.is.ru.tictac;

import java.util.Scanner;

public class Input {
	
    public static int getPlayerMode()
	{
		Scanner in = new Scanner(System.in);
		
	    int mode = in.nextInt();
	    return mode;
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