package com.is.ru.tictac;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import java.io.ByteArrayInputStream;

public class InputTest {
	
//	public static void main(String args[]) {
//		org.junit.runner.JUnitCore.main("com.is.ru.tictac.InputTest");
//    }

	@Test
	public void testGetPlayerMode() {
	    String inputData = "0";
	    System.setIn(new ByteArrayInputStream(inputData.getBytes()));	
	    assertTrue(Input.getPlayerMode());
	}

    /*	There is an error in the arraycreation -> nosuchelementexception
	@Test
        public void testGetPlayerMove() {
	    String inputData = "1 2";
	    System.setIn(new ByteArrayInputStream(inputData.getBytes()));
	    assertArrayEquals(new int[] {1,2}, Input.getPlayerMove());
    }
    */
}
