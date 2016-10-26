package com.is.ru.tictac;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PrinterTest {
	
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("com.is.ru.tictac.PrinterTest");
    }
    
    @Test
    public void printerTestResultsInHello() {
        Printer print = new Printer();
		assertEquals("Welcome to Tic-tac-toe!", print.greet());
    }
}