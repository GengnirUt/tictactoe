package com.is.ru.tictac;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

public class PrinterTest {
	
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("com.is.ru.tictac.PrinterTest");
    }
    
    @Test
    public void testGreet() {
        Printer printer = new Printer();
		
		ByteArrayOutputStream outData = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outData));
		
		printer.greet();
		assertEquals("Welcome to Tic-tac-toe!\n", outData.toString());
    }
}