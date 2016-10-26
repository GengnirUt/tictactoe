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
	
	@Test
    public void testPrintIntro() {
        Printer printer = new Printer();
		
		ByteArrayOutputStream outData = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outData));
		
		printer.printIntro();
		String expectedOutput = "Hello I want to play a game\nTIC TAC TOE\n";
		assertEquals(expectedOutput, outData.toString());
    }
	
	@Test
    public void testGetPlayers() {
        Printer printer = new Printer();
		
		ByteArrayOutputStream outData = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outData));
		
		printer.getPlayers(1);
		String expectedOutput = "Player 1!\n";
		expectedOutput += "Enter zero (0) if you are human and one (1) if you are computer: ";
		assertEquals(expectedOutput, outData.toString());
    }
	
	@Test
    public void testPrintEmptyBoard() {
        Printer printer = new Printer();
		
		ByteArrayOutputStream outData = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outData));
		
		printer.printEmptyBoard();
		String expectedOutput = "     |     |     \n";
		for(int i = 0; i < 2; i++){
			expectedOutput += "-----+-----+-----\n";
			expectedOutput += "     |     |     \n";
		}
		assertEquals(expectedOutput, outData.toString());
    }
	
	@Test
    public void testPlayerMove() {
        Printer printer = new Printer();
		
		ByteArrayOutputStream outData = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outData));
		
		printer.playerMove();
		assertEquals("Your move: \n", outData.toString());
    }
}