package com.is.ru.tictac;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class startGameTest {
    @Test
    public void greetResultsInHello() {
	World world = new World();
	assertEquals("Hello", world.greet());
    }
}
