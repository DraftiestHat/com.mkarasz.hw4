package com.mkarasz.hw4.WindChill;

import static org.junit.Assert.*;

import org.junit.Test;

public class CelsiusTest {

	@Test
	public void testGetCelsius() {
		Temperature t = new Celsius();
		assertEquals(0, t.getCelsius(), 0);
		t = new Celsius(16);
		assertEquals(16, t.getCelsius(), 0);
	}

	@Test
	public void testGetFahrenheit() {
		Temperature t = new Celsius();
		assertEquals(32, t.getFahrenheit(), 0);
		t = new Celsius(1);
		assertEquals(33.8, t.getFahrenheit(), .3);
	}

	@Test
	public void testCelsius() {
		Temperature t = new Celsius();
		assertNotNull(t);
	}

	@Test
	public void testCelsiusDouble() {
		Temperature t = new Celsius(16);
		assertNotNull(t);
		assertEquals(16, t.getCelsius(), 0);
	}

	@Test
	public void testGetTemperature() {
		Temperature t = new Celsius();
		assertEquals(0, t.getTemperature(), 0);
		t = new Celsius(16);
		assertEquals(16, t.getTemperature(), 0);
	}

	@Test
	public void testSetTemperature() {
		Temperature t = new Celsius();
		assertEquals(0, t.getCelsius(), 0);
		t.setTemperature(16);
		assertEquals(16, t.getCelsius(), 0);
	}

}
