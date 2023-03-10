package com.example.mars;

import java.util.ArrayList;
import java.util.List;

public class Plateau {

	private int x;
	private int y;

	private List<Rover> rovers = new ArrayList<Rover>();

	public Plateau(String x, String y) {

		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
	}

	/**
	 * add the rover
	 * @param rover
	 */
	public void addRover(Rover rover) {
		rovers.add(rover);
	}

	/**
	 * checks if position is already occupied by another Rover
	 * @param position
	 * @return
	 */
	public boolean isOccupied(Position position) {
		for (Rover r : rovers) {
			if (r.checkIfPositionOccupied(position)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * returns x coordinate of the Rover
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * returns y coordinate of the Rover
	 * @return
	 */
	public int getY() {
		return y;
	}
}
