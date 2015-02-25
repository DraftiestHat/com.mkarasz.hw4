package com.mkarasz.hw4.sound;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mkarasz.hw4.sound.MIDI.Length;

public class MIDITest {

	@Test
	public void testMIDI() {
		MIDI m = new MIDI();
		assertNotNull(m);
	}

	@Test
	public void testMIDIStringLength() {
		MIDI m = new MIDI("A#4", Length.QUARTER);
		assertNotNull(m);
	}

	@Test
	public void testMIDIIntLength() {
		MIDI m = new MIDI(48, Length.QUARTER);
		assertNotNull(m);
	}

	@Test
	public void testMIDIDoubleLength() {
		MIDI m = new MIDI(428.3, Length.QUARTER);
		assertNotNull(m);
	}

	@Test
	public void testSetFrequency() {
		MIDI m = new MIDI();
		assertNotNull(m);
		m.setFrequency(27.5);
		//System.out.println("" + m.getMidiNumber());
		assertEquals(21, m.getMidiNumber(), 1);
	}

	@Test
	public void testGetFrequency() {
		MIDI m = new MIDI();
		assertNotNull(m);
		assertEquals(261.63, m.getFrequency(), .2);
	}

	@Test
	public void testSetOctave() {
		MIDI m = new MIDI();
		assertNotNull(m);
		m.setOctave(6);
		assertEquals(84, m.getMidiNumber(), 0);
	}

	@Test
	public void testGetOctave() {
		MIDI m = new MIDI();
		assertNotNull(m);
		assertEquals(4, m.getOctave(), 0);
	}

	@Test
	public void testSetSharp() {
		MIDI m = new MIDI();
		assertNotNull(m);
		m.setSharp();
		assertEquals(61, m.getMidiNumber(), 0);
	}

	@Test
	public void testIsSharp() {
		MIDI m = new MIDI();
		assertNotNull(m);
		assertFalse("M is sharp. Woops.", m.isSharp());
	}

	@Test
	public void testGetNote() {
		MIDI m = new MIDI();
		assertNotNull(m);
		String s = m.getNote();
		assertTrue(s.equals("C"));
	}
}
