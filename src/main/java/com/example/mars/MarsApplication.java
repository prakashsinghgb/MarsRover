package com.example.mars;

import java.util.Scanner;

public class MarsApplication {
	/**
	 * This method is the point of execution and takes the input regarding the
	 * numbers of rovers, rovers position , instructions to the Rover and displays
	 * the output
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in);) {

			System.out.print("Enter upper-right coordinates of the plateau (in the form x y):");
			String dimensions = scanner.nextLine();
			String[] dims = dimensions.split(" ");
			if (dims != null && (dims.length > 2 || dims.length < 2))
				throw new Exception("Invalid input");
			Plateau plateau = new Plateau(dims[0], dims[1]);

			System.out.print("Enter number of rovers:");

			if (!scanner.hasNextInt())
				throw new Exception("Invalid input");

			int roversCount = Integer.parseInt(scanner.nextLine());

			int i = 0;
			while (i < roversCount) {
				i++;
				String name = "Rover" + i;
				System.out.print("Enter position for " + name + " (x y N/S/E/W):");
				String roverPostion = scanner.nextLine();

				Rover rover = new Rover(plateau, roverPostion);

				System.out.print("Enter instructions for " + name + " (in the form LMRMMMLMM):");
				String instructions = scanner.nextLine();
				rover.processInstructions(instructions);
				System.out.println(name + " moved to: " + rover.getRoverPosition());

			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
