package com.example.mars;
public class Position {

	public int x;
	public int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Position(Position position) {
		this.x = position.x;
		this.y = position.y;
	}
	
	public boolean isEqual(Position position) {
		return x == position.x && y == position.y;
	}
	
	@Override
	public String toString() {
		return x + " " + y;
	}
	
	/**
	 * Checks if the rover is on the plateau
	 * @param p
	 * @return
	 */
	public boolean IsOnPlateau(Plateau p) {
		if (x < 0 || x > p.getX()) {
			return false;
		}
		
		if (y < 0 || y > p.getY()) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * moves the Rover forward
	 * @param direction
	 * @return
	 */
	public Position moveForward(Direction direction) {
		switch (direction) {
			case EAST: return new Position(x + 1, y);
			case NORTH: return new Position(x, y + 1);
			case SOUTH: return new Position(x, y - 1);
			case WEST: return new Position(x - 1, y);
			default: throw new RuntimeException("Invalid direction!");
		}
	}
}
