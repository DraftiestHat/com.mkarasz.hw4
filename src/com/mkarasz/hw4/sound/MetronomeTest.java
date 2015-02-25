package com.mkarasz.hw4.sound;

import static org.junit.Assert.*;

import org.junit.Test;

public class MetronomeTest {

	@Test
	public void testMetronome() {
		Metronome m = new Metronome();
		assertNotNull(m);
	}

	@Test
	public void testMetronomeDoubleMIDI() {
		MIDI m = new MIDI();
		assertNotNull(m);
		Metronome n = new Metronome(75.0, m);
		assertNotNull(n);
	}

	@Test
	public void testGetNote() {
		MIDI m = new MIDI();
		assertNotNull(m);
		Metronome n = new Metronome(75.0, m);
		assertNotNull(n);
		assertEquals(m, n.getNote());
	}

	@Test
	public void testSetNote() {
		Metronome m = new Metronome();
		assertNotNull(m);
		MIDI n = new MIDI();
		m.setNote(n);
		assertEquals(n, m.getNote());
	}

	@Test
	public void testGetBpm() {
		MIDI m = new MIDI();
		assertNotNull(m);
		Metronome n = new Metronome(75.0, m);
		assertNotNull(n);
		assertEquals(75, n.getBpm(), 0);
	}

	@Test
	public void testSetBpm() {
		Metronome m = new Metronome();
		assertNotNull(m);
		m.setBpm(80);
		assertEquals(80, m.getBpm(), 0);
	}

	@Test
	public void testCalcSeconds() {
		Metronome m = new Metronome();
		assertNotNull(m);
		assertEquals(1, m.calcSeconds(), 0);
	}

}
