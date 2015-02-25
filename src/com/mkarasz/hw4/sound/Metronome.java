package com.mkarasz.hw4.sound;

/** Implements a basic class for a metronome using MIDI notes
 * @author Matt
 *
 */
public class Metronome {
	
	MIDI note;
	double bpm;
	
	/**
	 * Default constructor. Sets bpm to 60 and the note to default midi note.
	 */
	public Metronome() {
		this.note = new MIDI(); 
		this.bpm = 60;
	}
	
	/**
	 * Lets you set all parameters of the metronome.
	 * @param bpm the beats per minute of the metronome
	 * @param note the MIDI note to store
	 */
	public Metronome(double bpm, MIDI note){
		this.note = note;
		this.bpm = bpm;
	}	
	
	
	/**
	 * Gets the note in the metronome
	 * @return the note
	 */
	public MIDI getNote() {
		return note;
	}

	/**
	 * Lets you set the note in the metronome
	 * @param note the note to set
	 */
	public void setNote(MIDI note) {
		this.note = note;
	}

	/**
	 * returns the beats per minute of the metronome
	 * @return the bpm
	 */
	public double getBpm() {
		return bpm;
	}

	/**
	 * Lets you set the beats per minute of the metronome
	 * @param bpm the bpm to set
	 */
	public void setBpm(double bpm) {
		this.bpm = bpm;
	}

	/**
	 * Calculates how many seconds each note of a metronome lasts.
	 * @return the seconds the note lasts
	 */
	public double calcSeconds(){
		double bps = bpm/60;
		
		switch (note.getLength()){
		case WHOLE:
			return 4 / bps;
		case HALF:
			return 2 / bps;
		case QUARTER:
			return 1 / bps;
		case EIGHTH:
			return (1/2) / bps;
		case SIXTEENTH:
			return (1/4) / bps;
		case THIRTYSECONDTH:
			return (1/8) / bps;
		case SIXTYFOURTH:
			return (1/16) / bps;
		default:
			return 0;
		}
	}
	
}
