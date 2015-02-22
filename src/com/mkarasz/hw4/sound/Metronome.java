package com.mkarasz.hw4.sound;

import java.util.Scanner;

import com.mkarasz.hw4.sound.MIDI.Length;


public class Metronome {
	
	MIDI midiNote;
	double bps;
	
	public void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String userChoice;
		String note = null;
		double frequency = 0.0;
		double length = 0.0;
		Length lenEntered = Length.QUARTER; 
		int mNum = -1;
		double duration = 0.0;
		
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
			if (length != 1 || length != 0.5 || length != .25 || length != 1/8 || length != 1/16 || length != 1/32 || length != 1/64){
				System.out.println("You entered something wrong. Try again!");
				System.exit(1);
			}
			else {
				if(length == 1){
					lenEntered = Length.WHOLE;
				}
				else if (length == 0.5){
					lenEntered = Length.HALF;
				}
				else if (length == 0.25){
					lenEntered = Length.QUARTER;
				}
				else if (length == 1/8){
					lenEntered = Length.EIGHTH;
				}
				else if (length == 1/16){
					lenEntered = Length.SIXTEENTH;
				}
				else if (length == 1/32){
					lenEntered = Length.THIRTYSECONDTH;
				}
				else if (length == 1/64){
					lenEntered = Length.SIXTYFOURTH;
				}
				else{
					System.out.println("You entered something wrong. Try again!");
					System.exit(1);
				}
			}
		}
		
		if(userChoice.equalsIgnoreCase("F")){
			setMidiNote(new MIDI(frequency, lenEntered));
		}
		else if (userChoice.equalsIgnoreCase("S")){
			setMidiNote(new MIDI(note, lenEntered));
		}
		else {
			setMidiNote(new MIDI(mNum,lenEntered));
		}
			
		System.out.println("What are the beats per minute?");
		
		if(in.hasNextDouble()){
			this.bps = in.nextDouble()/60;
		}
		else {
			System.out.println("You enetered something wrong. Please try again!");
			System.exit(0);
		}
		
		duration = calcSeconds();
		
		System.out.println("The duration is " + duration + ".");
		
	
	
	
		in.close();
	
	}

	public MIDI getMidiNote() {
		return midiNote;
	}

	public void setMidiNote(MIDI midiNote) {
		this.midiNote = midiNote;
	}
	
	private double calcSeconds(){
		switch (midiNote.getLength()){
		case WHOLE:
			return 4 / this.bps;
		case HALF:
			return 2 / this.bps;
		case QUARTER:
			return 1 / this.bps;
		case EIGHTH:
			return (1/2) / this.bps;
		case SIXTEENTH:
			return (1/4) / this.bps;
		case THIRTYSECONDTH:
			return (1/8) / this.bps;
		case SIXTYFOURTH:
			return (1/16) / this.bps;
		default:
			return 0;
		}
	}
	
}
