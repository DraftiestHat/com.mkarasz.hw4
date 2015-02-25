package com.mkarasz.hw4.sound;

import java.util.Scanner;

import com.mkarasz.hw4.sound.MIDI.Length;

/**Simple parsing and getting user input for MIDI and metronome.
 * @author Matt
 *
 */
public class Sound {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Scanner inTwo = new Scanner(System.in);
		String userChoice;
		String note = null;
		double frequency = 0.0;
		double length = 0.0;
		Length lenEntered = Length.QUARTER; 
		int mNum = -1;
		MIDI noteMIDI = null;
		double bpm = 0.0;
		Metronome met = null;
		
		System.out.println("Would you like to enter a frequency, a note in SPN form, or a MIDI number?");
		System.out.println("F - frequency, S - SPN form, M - MIDI");
	
		userChoice = in.nextLine();
		
		if(userChoice.equalsIgnoreCase("F")){
			System.out.println("Please enter the frequency:");
			if(in.hasNextDouble()){
				frequency = in.nextDouble();
			}
			else
				System.out.println("You entered something wrong. Please start over.");
		}
		else if (userChoice.equalsIgnoreCase("S")){
			System.out.println("Please enter the note in SPN form:");
			note = in.nextLine();
		}
		else if (userChoice.equalsIgnoreCase("M")){
			System.out.println("Please enter the MIDI number:");
			if(in.hasNextInt()){
				mNum = in.nextInt();
			}
			else
				System.out.println("You entered something wrong. Please start over.");
		}
		else {
			System.out.println("Please choose a one letter input from the above values.");
			System.exit(1);
		}
		
		System.out.println("Please enter a length for the note.");
		System.out.println("e.g. 1, 1/2, 1/4, 1/8, 1/16, 1/32, 1/64");
		
		if(in.hasNextDouble()){
			length = in.nextDouble();
			System.out.println("" + length + " length");
			
			if(length == 1){
				lenEntered = Length.WHOLE;
			}
			else if (length == (double) 0.5){
				lenEntered = Length.HALF;
			}
			else if (length == (double) 0.25){
				lenEntered = Length.QUARTER;
			}
			else if (length == (double) 1/8){
				lenEntered = Length.EIGHTH;
			}
			else if (length == (double) 1/16){
				lenEntered = Length.SIXTEENTH;
			}
			else if (length == (double) 1/32){
				lenEntered = Length.THIRTYSECONDTH;
			}
			else if (length == (double) 1/64){
				lenEntered = Length.SIXTYFOURTH;
			}
			else{
				System.out.println("You entered something wrong. Try again!");
				System.exit(1);
			}
			
		}
		//System.out.println("" + length + " length2");
		if(userChoice.equalsIgnoreCase("F")){
			noteMIDI = new MIDI(frequency, lenEntered);
		}
		else if (userChoice.equalsIgnoreCase("S")){
			noteMIDI = new MIDI(note, lenEntered);
		}
		else {
			noteMIDI = new MIDI(mNum,lenEntered);
		}
			
		System.out.println("What are the beats per minute?");
		
		if(inTwo.hasNextInt()){
			bpm = (double)inTwo.nextInt();
		}
		else {
			System.out.println("You enetered something wrong. Please try again!");
			System.exit(0);
		}
		
		met = new Metronome(bpm, noteMIDI);
		
		System.out.println("The duration is " + met.calcSeconds() + " seconds.");
		
	
	
	
		in.close();
		inTwo.close();

	}

}
