package com.mkarasz.hw4.WindChill;

public abstract class Temperature {
	double temperature; 
	
	public abstract double getCelsius();
	public abstract double getFahrenheit();
	
	/**
	 * @return the temperature
	 */
	public double getTemperature() {
		return temperature;
	}
	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	
}

