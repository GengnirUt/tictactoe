package com.is.ru.tictac;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

public class PrinterTest {
    
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
    public void testPlayerMove() {
        Printer printer = new Printer();
	
	ByteArrayOutputStream outData = new ByteArrayOutputStream();
	System.setOut(new PrintStream(outData));
	
	printer.playerMove(1);
	assertEquals("Player 1 move: \n", outData.toString());
    }
	
    @Test
    public void testSpotTakenOrIllegal() {
        Printer printer = new Printer();
	
	ByteArrayOutputStream outData = new ByteArrayOutputStream();
	System.setOut(new PrintStream(outData));
	
	printer.spotTakenOrIllegal();
	assertEquals("The spot is taken or not legal\n", outData.toString());
    }
    
    @Test
    public void testPrintBoard() {
        Printer printer = new Printer();
	
	ByteArrayOutputStream outData = new ByteArrayOutputStream();
	System.setOut(new PrintStream(outData));
	
	printer.printBoard(new Board());
	String expectedOutput = "\n     |     |     \n";
	for(int i = 0; i < 2; i++){
	    expectedOutput += "-----+-----+-----\n";
	    expectedOutput += "     |     |     \n";
	}
	expectedOutput += "\n";
	assertEquals(expectedOutput, outData.toString());
    }
    
    @Test
    public void testWinner() {
        Printer printer = new Printer();
	
	ByteArrayOutputStream outData = new ByteArrayOutputStream();
	System.setOut(new PrintStream(outData));
	
	printer.winner(2);
	assertEquals("Player 2 won!\n", outData.toString());
    }
}
