package com.is.ru.tictac;

import java.util.Scanner;

public class Input {
	
    public static int getPlayerMode()
	{
		Scanner in = new Scanner(System.in);
		
	    int mode = in.nextInt();
	    return mode;
	}

}