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
	
	/**
	 * 
	 */
	public MIDI(){
		setNoteDefault();
	}
	
	/**
	 * @param note
	 * @param length
	 */
	public MIDI(String note, Length length){
		this.length = length;
		Note noteEnum = Note.A;
		String letter;
		int octave = 0;
		
		if(note.matches("^[A-G]{1}[#]?[-]?[0-9]{1}$")) {
			if(note.matches("[A-G]{1}[#]?[-]+[2-9]{1}")){ //checking for octaves less than -1
				setNoteDefault();
				System.out.println("Your note " + note + " was out of range. Setting to C4 Quarter note.");
				return;
			}
			else if (note.matches("[A,B]{1}[#]?[9]{1}")) { //checking for A9, A#9, and B9
				setNoteDefault();
				System.out.println("Your note " + note + " was out of range. Setting to C4 Quarter note.");
				return;
			}
			else if (note.equals("G#9")){ //couldn't do above cause G9 is valid, but G#9 isn't 
				setNoteDefault();
				System.out.println("Your note " + note + " was out of range. Setting to C4 Quarter note.");
				return;
			}
			else{
				if(note.matches("[A-G]{1}[#]{1}.*")) {
					letter = note.substring(0, 1);
					if (letter.equals("A")){
						noteEnum = Note.ASHARP;
					}
					else if (letter.equals("C")){
						noteEnum = Note.CSHARP;
					}
					else if (letter.equals("D")){
						noteEnum = Note.DSHARP;
					}
					else if (letter.equals("F")){
						noteEnum = Note.FSHARP;
					}
					else
						noteEnum = Note.GSHARP;
					
					letter = note.substring(2);
					//System.out.println("" + letter + " what you entered.");
					octave = Integer.parseInt(letter);
				}
				else {
					letter = note.substring(0, 1);
					if (letter.equals("A")){
						noteEnum = Note.A;
					}
					else if (letter.equals("B")){
						noteEnum = Note.B;
					}
					else if (letter.equals("C")){
						noteEnum = Note.C;
					}
					else if (letter.equals("D")){
						noteEnum = Note.D;
					}
					else if (letter.equals("E")){
						noteEnum = Note.E;
					}
					else if (letter.equals("F")){
						noteEnum = Note.F;
					}
					else
						noteEnum = Note.G;
					
					letter = note.substring(1);
					octave = Integer.parseInt(letter);
				}
			}
		}
		else {
			System.out.println("Your note " + note + " was out of range. Setting to C4 Quarter note.");
			setNoteDefault();
			return;
		}
		
		switch (noteEnum){//performs calulation with offset
		case A:
			this.midiNumber = (69 + 0) + (octave - 4) * 12;
			break;
		case ASHARP:
			this.midiNumber = (69 + 1) + (octave - 4) * 12;
			break;
		case B:
			this.midiNumber = (69 + 2) + (octave - 4) * 12;
			break;
		case C:
			this.midiNumber = (69 - 9) + (octave - 4) * 12;
			break;
		case CSHARP:
			this.midiNumber = (69 - 8) + (octave - 4) * 12;
			break;
		case D:
			this.midiNumber = (69 - 7) + (octave - 4) * 12;
			break;
		case DSHARP:
			this.midiNumber = (69 - 6) + (octave - 4) * 12;
			break;
		case E:
			this.midiNumber = (69 - 5) + (octave - 4) * 12;
			break;
		case F:
			this.midiNumber = (69 - 4) + (octave - 4) * 12;
			break;
		case FSHARP:
			this.midiNumber = (69 - 3) + (octave - 4) * 12;
			break;
		case G:
			this.midiNumber = (69 - 2) + (octave - 4) * 12;
			break;
		case GSHARP:
			this.midiNumber = (69 - 1) + (octave - 4) * 12;
			break;
		}
	}
	
	/**
	 * @param midiNumber
	 * @param length
	 */
	public MIDI(int midiNumber, Length length){
		this.midiNumber = midiNumber;
		this.length = length;
	}
	
	/**
	 * @param frequency
	 * @param length
	 */
	public MIDI (double frequency, Length length){
		setFrequency(frequency);
		this.length = length;
	}
	
	/**
	 * 
	 */
	private void setNoteDefault(){
		this.midiNumber = 60;
		this.length = Length.QUARTER;
	}
	
	/**
	 * @param frequency
	 */
	public void setFrequency(double frequency){
		this.midiNumber = (int) (12 * (Math.log(frequency/440)/Math.log(2)) + 69);
	}
	
	/**
	 * @return
	 */
	public double getFrequency(){ //Hz
		return Math.pow(2, (this.midiNumber - 69)/12) * 440;
	}
	
	/**
	 * @param length
	 */
	public void setLength(Length length){
		this.length = length;
	}
	
	/**
	 * @return
	 */
	public Length getLength(){
		return this.length; 
	}
	
	/**
	 * @param midi
	 */
	public void setMidiNumber(int midi){
		this.midiNumber = midi;
	}
	
	/**
	 * @return
	 */
	public int getMidiNumber(){
		return this.midiNumber;
	}
	
	/**
	 * @param octave
	 */
	public void setOctave(int octave){
		int last = this.midiNumber % 12;
		this.midiNumber = octave * 12 + 12 + last;
	}
	
	/**
	 * @return
	 */
	public int getOctave(){
		return (int) ((this.midiNumber / 12) - 1);
	}
	
	/**
	 * 
	 */
	public void setSharp(){
		int check = this.midiNumber % 12;
		switch(check){
		case 0:
		case 2:
		case 5:
		case 7:
		case 9:
			this.midiNumber++;
			break;
		default:
			System.out.println("The current midi number cannot be made sharper.");
		}
	}
	
	/**
	 * @return
	 */
	public boolean isSharp(){
		int check = this.midiNumber % 12;
		switch(check){
		case 1:
		case 3:
		case 6:
		case 8:
		case 10:
			return true;
		default:
			return false;
		}
	}
	
	/**
	 * @return
	 */
	public String getNote(){
		int check = this.midiNumber % 12;
		switch(check){
		case 0:
			return "C";
		case 1:
			return "C#";
		case 2:
			return "D";
		case 3:
			return "D#";
		case 4:
			return "E";
		case 5:
			return "F";
		case 6:
			return "F#";
		case 7:
			return "G";
		case 8:
			return "G#";
		case 9:
			return "A";
		case 10:
			return "A#";
		default:
			return "B";
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "SPN: " + getNote() + getOctave() + ", Frequency: " + getFrequency() + ", MIDI Number: " + getMidiNumber(); 
	}










}
