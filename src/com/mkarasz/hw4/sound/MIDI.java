package com.mkarasz.hw4.sound;

public class MIDI {
	public enum Length { 
		WHOLE, HALF, QUARTER, EIGHTH, SIXTEENTH, THIRTYSECONDTH, SIXTYFOURTH
	}
	
	private enum Note {
		C, CSHARP, D, DSHARP, E, F, FSHARP, G, GSHARP, A, ASHARP, B
	}
	
	Length length;
	int midiNumber = 0;
	
	public MIDI(){
		setNoteDefault();
	}
	
	public MIDI(String note, Length length){
		int i = 0;
		this.length = length;
		
		if(note.matches("^[A-G]{1}[#]?[-]?[0-9]{1}$")) {
			if(note.matches("[A-G]{1}[#]?-[2-9]{1}")){ //checking for octaves less than -1
				setNoteDefault();
				System.out.println("Your note " + note + " was out of range. Setting to C4 Quarter note.");
				System.exit(0);
			}
			else if (note.matches("[A,B]{1}[#]?[9]{1}")) { //checking for A9, A#9, and B9
				setNoteDefault();
				System.out.println("Your note " + note + " was out of range. Setting to C4 Quarter note.");
				System.exit(0);
			}
			else if (note.equals("G#9")){ //couldn't do above cause G9 is valid, but G#9 isn't 
				setNoteDefault();
				System.out.println("Your note " + note + " was out of range. Setting to C4 Quarter note.");
				System.exit(0);
			}
			else{
				
			}
		}
		else {
			System.out.println("Your note " + note + " was out of range. Setting to C4 Quarter note.");
			setNoteDefault();
			System.exit(0);
		}
	}
	
	public MIDI(int midiNumber, Length length){
		
	}
	
	public MIDI (double frequency, Length length){
		
	}
	
	private void setNoteDefault(){
		this.midiNumber = 60;
		this.length = Length.QUARTER;
	}
	
	public void setFrequency(double frequency){
		
	}
	
	public double getFrequency(){ //Hz
		
	}
	
	public void setLength(Length length){
		
	}
	
	public Length getLength(){
		
	}
	
	public void setMidiNumber(int midi){
		
	}
	
	public int getMidiNumber(){
		
	}
	
	public void setOctave(int octave){
		
	}
	
	public int getOctave(){
		
	}
	
	public void setSharp(){
		
	}
	
	public boolean isSharp(){
		return false;
	}
	
	public String getNote(){
		
	}
	
	public String toString(){
		
	}










}
