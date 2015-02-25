package com.mkarasz.hw4.WindChill;

import static org.junit.Assert.*;

import org.junit.Test;

public class FahrenheitTest {

	@Test
	public void testGetCelsius() {
		Temperature t = new Fahrenheit();
		assertEquals(0, t.getCelsius(), 0);
		t = new Fahrenheit(33.8);
		assertEquals(1, t.getCelsius(), .1);
	}

	@Test
	public void testGetFahrenheit() {
		Temperature t = new Fahrenheit();
		assertEquals(32, t.getFahrenheit(), 0);
		t = new Fahrenheit(48);
		assertEquals(48, t.getFahrenheit(), 0);
	}

	@Test
	public void testFahrenheit() {
		Temperature t = new Fahrenheit();
		assertNotNull(t);
	}

	@Test
	public void testFahrenheitDouble() {
		Temperature t = new Fahrenheit(48);
		assertNotNull(t);
	}


	@Test
	public void testGetTemperature() {
		Temperature t = new Fahrenheit();
		assertEquals(32, t.getTemperature(), 0);
		t = new Fahrenheit(16);
		assertEquals(16, t.getTemperature(), 0);
	}

	@Test
	public void testSetTemperature() {
		Temperature t = new Fahrenheit();
		assertEquals(32, t.getTemperature(), 0);
		t.setTemperature(48);
		assertEquals(48, t.getFahrenheit(), 0);
	}

}
