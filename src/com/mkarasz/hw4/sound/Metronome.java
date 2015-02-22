package com.mkarasz.hw4.sound;

public class Metronome {
	
	MIDI note;
	double bps;
	
	public Metronome() {
		this.note = new MIDI(); 
		this.bps = 60;
	}
	
	public Metronome(double bps, MIDI note){
		this.note = note;
		this.bps = bps;
	}	
	
	
	/**
	 * @return the note
	 */
	public MIDI getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(MIDI note) {
		this.note = note;
	}

	/**
	 * @return the bps
	 */
	public double getBps() {
		return bps;
	}

	/**
	 * @param bps the bps to set
	 */
	public void setBps(double bps) {
		this.bps = bps;
	}

	public double calcSeconds(){
		switch (note.getLength()){
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
