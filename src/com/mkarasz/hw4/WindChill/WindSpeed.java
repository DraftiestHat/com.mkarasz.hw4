/**
 * Wind Speed class that holds the speed of the wind
 * @author Matt
 *
 */
package com.mkarasz.hw4.WindChill;


public class WindSpeed {
	double mph;
	
	/**
	 * @param mph constructor for WindSpeed class using American units.
	 */
	public WindSpeed(double mph){
		this.mph = mph;
	}
	
	/**
	 * Converts and then returns the wind speed in meters/second
	 * @return the speed in meters per second
	 */
	public double toMetersPerSecond(){
		return this.mph * 0.44704;
	}
	
	/** 
	 * Returns a string with the mph formated correctly.
	 * @return String the speed in mph
	 */
	public String toString(){
		return new String("" + this.mph);
	}

	/**
	 * Returns the objects wind speed
	 * @return mph the wind speed in miles per hour
	 */
	public double getMph() {
		return mph;
	}

	/**
	 * Sets the wind speed in miles per hour
	 * @param mph the wind speed
	 */
	public void setMph(double mph) {
		this.mph = mph;
	}
	
}
