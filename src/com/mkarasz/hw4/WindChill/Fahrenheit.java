package com.mkarasz.hw4.WindChill;

public class Fahrenheit extends Temperature {
	public Fahrenheit(){
		this.temperature = 0;
	}
	
	public Fahrenheit(double temperature){
		this.temperature = temperature;
	}
	
	@Override
	public double getCelsius(){
		return fahrToCels(this.temperature);
	}
	
	@Override
	public double getFahrenheit() {
		return this.temperature;
	}
	
	/**
	 * Converts fahrenheit to celsius
	 * @param value
	 * @return double
	 */
	private double fahrToCels(double value){
		return (5 * (value - 32)) / 9;
	}
}
