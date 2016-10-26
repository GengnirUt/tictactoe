package com.is.ru.tictac;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import java.io.ByteArrayInputStream;

public class InputTest {
	
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("com.is.ru.tictac.InputTest");
    }

	@Test
	public void testGetPlayerMode() {
		String inputData = "0";
		System.setIn(new ByteArrayInputStream(inputData.getBytes()));
		
		assertEquals(0, Input.getPlayerMode());
	}
	
	@Test
    public void testGetPlayerMove() {
		String inputData = "1 2";
		System.setIn(new ByteArrayInputStream(inputData.getBytes()));
		
		assertArrayEquals(new int[]{1,2}, Input.getPlayerMove());
    }

}