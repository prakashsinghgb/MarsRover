##MARS ROVERS

A squad of robotic rovers are to be landed by NASA on a plateau on Mars.

This plateau, which is curiously rectangular, must be navigated by the rovers so that their onboard cameras can get a complete view of the surrounding terrain to send back to Earth.

A rover's position is represented by a combination of an x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.

To control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right, respectively, without moving from its current spot.

'M' means move forward one grid point and maintain the same heading.

Assume that the square directly North from (x, y) is (x, y+1).

Input:

The first line of input is the upper-right coordinates of the plateau. The lower-left coordinates are assumed to be 0,0.

The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover's position, and the second line is a series of instructions telling the rover how to explore the plateau.

The position is made up of two integers and a letter separated by spaces, corresponding to the x and y coordinates and the rover's orientation.

Each rover will be finished sequentially, which means that the second rover won't start to move until the first one has finished moving.

Output:

The output for each rover should be its final coordinates and heading.

**Input:**  
5 5  
1 2 N  
LMLMLMLMM  
3 3 E  
MMRMMRMRRM

**Output:**  
1 3 N  
5 1 E

## Implementation as Below

The Application is developed using Maven as build tool, please follow the below mentioned steps to execute it

Run the test cases:

```
mvn test
```

Package the app using:

```
mvn clean install
```

And then execute the app from the target folder `\target`:

 ```
java -jar mars-0.0.1-SNAPSHOT.jar
 ```
 Enter the input on the screen as prompted an it gives the position of the Rover:
 
  ```
Enter upper-right coordinates of the plateau (in the form x y):5 5
Enter number of rovers:2
Enter position for Rover1 (x y N/S/E/W):1 2 N
Enter instructions for Rover1 (in the form LMRMMMLMM):LMLMLMLMM
Rover1 moved to: 1 3 N
Enter position for Rover2 (x y N/S/E/W):3 3 E 
Enter instructions for Rover2 (in the form LMRMMMLMM):MMRMMRMRRM
Rover2 moved to: 5 1 E

 ```
 
 
 
