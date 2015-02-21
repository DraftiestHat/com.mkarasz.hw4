package com.mkarasz.hw4.WindChill;

import java.util.Scanner;

/**
 * Tests the rest of the windChill classes.
 * @author Matt.
 */
public class Weather {

	public static void main(String[] args) {
		double tempIn = 0;
		String userIn;
		boolean userInputCheck = false;
		Scanner in = new Scanner(System.in);
		Temperature t = null;
		WindSpeed w = null;
		
		System.out.print("Enter a temperature in Celsius or Fahrenheit: ");
		if(in.hasNextDouble() == false){
			System.out.print("Restart this program and enter a DOUBLE.");
			System.exit(0);
		}
		tempIn = in.nextDouble();
		
		System.out.print("Enter the temperature units [F/c]: ");
		
		while (userInputCheck == false){
			if (in.hasNext() == false){
				System.out.println("You have chosen fahrenheight.");
				t = new Fahrenheit(tempIn);
				userInputCheck = true;
			}
			else {
				userIn = in.next();
				userIn = userIn.substring(0, 1).toLowerCase();
				if(userIn.equals("f")){
					t = new Fahrenheit(tempIn);
					System.out.println("You have chosen fahrenheight.");
					userInputCheck = true;
				}
				else if (userIn.equals("c")){
					System.out.println("You have chosen celsius.");
					t = new Celsius(tempIn);
					userInputCheck = true;
				}
				else {
					System.out.print("Please enter a valid temperature [F/c]: ");
				}
			}
		}
		
		 
		
		System.out.print("Please enter the current wind speed in mph: ");
		while(in.hasNextDouble() == false){
			System.out.print("Please enter a valid wind speed in mph: ");
		}
		w = new WindSpeed(in.nextDouble());
		
		tempIn = WindChill.getWindChill(t, w);
		if (tempIn == 0){
			System.out.println("Cannot compute wind chill.");
			System.out.println("Your temperature is either above 50F(10C)");
			System.out.println("Or your wind speed is below 3mph.");
		}
		else{
			System.out.printf("The current wind chill is %.1f ", WindChill.getWindChill(t, w));
			System.out.printf("or, in Watts/m^2, the wind chill is %.1f", WindChill.getWindChillWatts(t, w));
		}
		in.close();
		t = null;
		w = null;
		

	}

}
