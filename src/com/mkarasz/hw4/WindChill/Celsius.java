package com.mkarasz.hw4.WindChill;

public class Celsius extends Temperature{
	public Celsius(){
		this.temperature = 0;
	}
	
	public Celsius(double temperature){
		this.temperature = temperature;
	}
	
	@Override
	public double getCelsius(){
		return this.temperature;
	}
	
	@Override
	public double getFahrenheit() {
		return celsToFahr(this.temperature);
	}
	
	/**
	 * Converts celsius to fahrenheit
	 * @param value
	 * @return
	 */
	private double celsToFahr(double value){
		return ((9 * value) / 5) + 32;
	}
}
