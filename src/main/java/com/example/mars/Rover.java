package com.example.mars;

import java.util.ArrayList;

public class Rover {

	private Plateau plateau;
	private Position position;
	private Direction direction;
	private boolean landed = false;

	/**
	 * set the Rover on the plateau
	 * 
	 * @param plateau
	 * @param roverPostion
	 */
	public Rover(Plateau plateau, String roverPostion) {
		String[] parts = roverPostion.split(" ");
		if (parts.length != 3) {
			throw new RuntimeException("Invalid Input for Rover!");
		}
		int x = Integer.parseInt(parts[0]);
		int y = Integer.parseInt(parts[1]);
		Direction direction = mapDirection(parts[2].toCharArray()[0]);

		this.plateau = plateau;
		this.position = new Position(x, y);
		this.direction = direction;
		if (!position.IsOnPlateau(plateau)) {
			throw new RuntimeException("out of Plateau!");
		}

		if (plateau.isOccupied(position)) {
			throw new RuntimeException("Already occupied by a rover!");
		}
		this.landed = true;
		plateau.addRover(this);
	}

	/**
	 * gets the rover position
	 * 
	 * @return
	 */
	public String getRoverPosition() {
		return position.toString() + " " + displayDirection(direction);
	}

	/**
	 * check if the position is already occupied
	 * 
	 * @param pos
	 * @return
	 */
	public boolean checkIfPositionOccupied(Position pos) {
		return position.isEqual(pos);
	}

	/**
	 * process the instructions to the rover
	 * 
	 * @param instructions
	 */
	public void processInstructions(String instructions) {

		for (Instruction i : getInstructions(instructions)) {
			if (position == null || direction == null) {
				throw new RuntimeException("Rover not found");
			}
			switch (i) {
			case LEFT:
				turnLeft();
				break;
			case MOVE:
				moveForward();
				break;
			case RIGHT:
				turnRight();
				break;
			default:
				throw new RuntimeException("Invalid move");
			}
		}
	}

	/**
	 * checks if rover is landed
	 * 
	 * @return
	 */
	public boolean isLanded() {
		return landed;
	}

	/**
	 * converts the Instructions to Array
	 * 
	 * @param instructions
	 * @return
	 */
	private Instruction[] getInstructions(String instructions) {
		ArrayList<Instruction> instrArr = new ArrayList<Instruction>();

		for (char c : instructions.toCharArray()) {
			switch (c) {
			case 'L':
				instrArr.add(Instruction.LEFT);
				break;
			case 'M':
				instrArr.add(Instruction.MOVE);
				break;
			case 'R':
				instrArr.add(Instruction.RIGHT);
				break;
			default:
				throw new RuntimeException("Invalid instruction!");
			}
		}

		return instrArr.toArray(new Instruction[instrArr.size()]);
	}

	/**
	 * turns the Rover left
	 */
	private void turnLeft() {
		switch (direction) {
		case EAST:
			direction = Direction.NORTH;
			break;
		case NORTH:
			direction = Direction.WEST;
			break;
		case SOUTH:
			direction = Direction.EAST;
			break;
		case WEST:
			direction = Direction.SOUTH;
			break;
		default:
			throw new RuntimeException("Invalid direction!");
		}
	}

	/**
	 * turns the Rover right
	 */
	private void turnRight() {
		switch (direction) {
		case EAST:
			direction = Direction.SOUTH;
			break;
		case NORTH:
			direction = Direction.EAST;
			break;
		case SOUTH:
			direction = Direction.WEST;
			break;
		case WEST:
			direction = Direction.NORTH;
			break;
		default:
			throw new RuntimeException("Invalid direction!");
		}
	}

	/**
	 * moves Rover forward
	 */
	private void moveForward() {
		Position newPosition = position.moveForward(direction);
		if (!newPosition.IsOnPlateau(plateau)) {
			throw new RuntimeException("Rover is out of Plateau");
		}
		position = newPosition;
	}

	private Direction mapDirection(char direction) {
		switch (direction) {
		case 'N':
			return Direction.NORTH;
		case 'W':
			return Direction.WEST;
		case 'S':
			return Direction.SOUTH;
		case 'E':
			return Direction.EAST;
		default:
			throw new RuntimeException("Unsupported character '" + direction + "'!");
		}
	}

	private char displayDirection(Direction direction) {
		switch (direction) {
		case NORTH:
			return 'N';
		case WEST:
			return 'W';
		case SOUTH:
			return 'S';
		case EAST:
			return 'E';
		default:
			throw new RuntimeException("Unsupported direction '" + direction + "'!");
		}
	}

}
