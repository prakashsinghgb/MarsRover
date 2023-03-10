package com.example.mars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MarsApplicationTest {

	private Plateau plateau = new Plateau("5", "5");
	
	@Test
	public void moveRoverSuccess() {
		Rover rover = new Rover(plateau, "1 2 N");

		rover.processInstructions("LMLMLMLMM");
		
		String report = rover.getRoverPosition();		
		assertEquals("1 3 N", report);
	}
	
	
	@Test
	public void moverRoverSuccess2() {
		Rover rover = new Rover(plateau, "3 3 E");
		rover.processInstructions("MMRMMRMRRM");

		String report = rover.getRoverPosition();
		assertEquals("5 1 E", report);
	}
	
	@Test
	public void moveRoverOutofPlateau() {
		Rover rover = new Rover(plateau, "2 2 N");
		
		try {
			rover.processInstructions(("MMMMMMMM"));
			assertTrue(false,"Moving should have thrown before!");			
		}
		catch (Exception ex) {
			assertEquals("Rover is out of Plateau", ex.getMessage());
		}
	}
	
	@Test
	public void landingRoverOutofPlateau() {
		try {
			new Rover(plateau, "6 6 N");
		}
		catch (Exception ex) {
			assertEquals("out of Plateau!", ex.getMessage());
		}
	}
	
	@Test
	public void landingRoverInvalid() {
		try {
			new Rover(plateau,"");
		}
		catch (Exception ex) {
			assertEquals("Invalid Input for Rover!", ex.getMessage());
		}
	}

	
	@Test
	public void unknownInstructionstoRover() {
		Rover rover = new Rover(plateau,"1 2 N");
		try {
			rover.processInstructions(("XXXX"));
			assertTrue(false,"Should have thrown before!");
		}
		catch (Exception ex) {
			assertEquals("Invalid instruction!", ex.getMessage());
		}
	}
	
	@Test
	public void dropRoverSameCordinates() {		
		try {
			new Rover(plateau, "3 5 E");
			new Rover(plateau, "3 5 N");
		}
		catch (RuntimeException ex) {
			assertEquals("Already occupied by a rover!", ex.getMessage());
		}
	}
	
	@Test
	public void landRoversNextto() {
		Rover one = new Rover(plateau, "3 5 E");
		Rover two = new Rover(plateau, "4 5 N");
		assertTrue(one.isLanded());
		assertTrue(two.isLanded());
		
	}
}
