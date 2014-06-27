/*
 * File: drawAcmHierarchy.java
 * ---------------------
 * This program draws the acm.program class hierarchy as presented in lecture 6
 * 
 */

import acm.graphics.*;
import acm.program.*;

public class drawAcmHierarchy extends GraphicsProgram {

	/*Defines class box width */
	private static final int BOX_WIDTH = 150;
	
	/*Defines class box height*/
	private static final int BOX_HEIGHT = 30;
	
	/*Defines the number of subclasses as 3*/
	private static final int NUM_SUBCLASSES = 3;
	
	/*Defines the buffer space in between the boxes*/
	private static final int BOX_BUFFER = 10;
	
	public void run(){
		
		/*
		 * Algorithm
		 * --------
		 * 1. Find the midpoint of the window (x and y coordinates)
		 * 2. Draw Program SuperClass box
		 * 		-At 1.5 times the box distance north of the midpoint, start the Program class box
		 * 3. Draw Program SuperClass label
		 * 		-Center it within the box
		 * 4. Draw subclasses 
		 * 		-At 1.5 times the box distance south of the midpoint, level the GraphicsProgram, ConsoleProgram, and DialogProgram boxes
		 * 5. Draw subclasses labels
		 * 		- Center them within their respective boxes
		 * 6. Draw lines starting from the middle of the Program class box to the middle of each of the 3 sub boxes
		 */
		
		double midpointX = getWidth()/2;
		
		/*remember getHeight() returns the leftmost y position 
		 *so subtracting half the getHeight() returns it to the central point
		 *in the y direction
		 * */
		double midpointY = getHeight() - (getHeight()/2.0);
		
		
		/*variables used for the boxes and labels*/
		double xEdge = 0.0;
		double yEdge = 0.0;
		
		double lableYedge = 0.0;
		double midLableX = 0.0;
		double midLableY = 0.0;
		

		/* draw the Program superclass box
 		 * -------------------------------
		 * Y Direction: start at the center point, a box and a half north of the middle
		 * X Direction: start at the center point, half a box west of the middle
		 */
		
		xEdge = midpointX - (double) BOX_WIDTH/2.0;
		yEdge = midpointY - (double)(BOX_HEIGHT + (double) BOX_HEIGHT/2.0);
			
		GRect classBox = new GRect(xEdge, yEdge, BOX_WIDTH, BOX_HEIGHT);
		
		/* add the Program superclass label
 		 * ---------------------------------
		 * X Direction: 
		 * 		Start from center point and subtract half the width of the label to arrive in the center
		 * Y Direction:
		 * 		Start from center point and subtract a whole box to arrive in the box
		 * 		Add the height of the label to arrive in the center
		 * 
		 */

		/*Put the label in the middle of the box*/
		lableYedge = midpointY - (double) BOX_HEIGHT;
	
		/*creates label*/
		GLabel boxLabel = new GLabel("Program");

		/*defines the x and y coordinates to draw the lable*/
		midLableX = midpointX - (boxLabel.getWidth())/2.0;
		midLableY = lableYedge + (boxLabel.getAscent())/2.0;		
		boxLabel.setLocation(midLableX, midLableY);
		
		add(classBox);
		add(boxLabel);
		
	
		/* draw the subclasses boxes
 		 * -------------------------------
 		 * For each subclass box defined by NUM_SUBCLASSES and a switch statement
 		 * If greater than 3, add additional switch statements.
 		 * 
		 * X Direction: 
		 * 		Define leftmost edge: start at the center point, 1.5 boxes to the west + BOX_BUFFER
		 * 		1st box: leftmost edge; each subsequent box is a box width + buffer from the leftmost edge
		 * 		
		 * Y Direction: (doesn't change)
		 * 		Start at the center point, a half a box south of the middle
		 * 
         *
		 * add the subclasses label
 		 * ---------------------------------
		 * For each subclass box:
		 * X Direction: 
		 * 		Start at the left edge of the box and go half a box width to find the middle
		 * 		then center the label by subtracting half the label width from the middle of the subclass box 		
		 * Y Direction: 
		 * 		Start at the center point, then go a box width south to be in the middle of the box
		 * 
		 * 
		 * add the lines between the superclass and subclasses
		 * ---------------------------------------------------
		 * X1 Y1: middle of the bottom of the program box  (center point for X and half a box height in the Y)
		 * X2 Y2: middle of the top of the subclass boxes
		 * 
		 */

		/*defines the leftmost x edge including the buffer between the boxes*/
		double leftMostXedge = midpointX - (double)(1.5*BOX_WIDTH) - BOX_BUFFER;
		
		/*defines the y edge*/
		yEdge = midpointY + (double)BOX_HEIGHT/2.0;
		
		/*Put the label in the middle of the box*/
		lableYedge = midpointY + (double) BOX_HEIGHT;
		
		/* defines center point of the Program box to draw the lines from*/
		double programBottomX = midpointX;
		double programBottomY = midpointY - (double) BOX_HEIGHT/2;

		/* defines the center point of the subclass boxes to draw the lines to */
		double subclassTopX = 0.0;
		double subclassTopY = midpointY + (double)BOX_HEIGHT/2.0;

		
		/*NUM_CLASSES currently at 3; need additional switch statements if greater than 3 */
		for(int i=0; i<NUM_SUBCLASSES; i++){
			
			xEdge = leftMostXedge + i*(BOX_WIDTH + BOX_BUFFER);				
			classBox = new GRect(xEdge, yEdge, BOX_WIDTH, BOX_HEIGHT);
		
			switch(i){
				case 0:
					boxLabel = new GLabel("GraphicsProgram");
					break;
				case 1:
					boxLabel = new GLabel("ConsoleProgram");
					break;
				case 2:
					boxLabel = new GLabel("DialogProgram");
					break;
				default:
					break;
			}
						

			subclassTopX = xEdge + (float)0.5*BOX_WIDTH ;

			/*finds the location to place the labels in the box centrally*/
			midLableX = subclassTopX - (boxLabel.getWidth())/2.0;
			midLableY = lableYedge + (boxLabel.getAscent())/2.0;
			
			boxLabel.setLocation(midLableX, midLableY);

			/*ready to add the line*/
			GLine classLine = new GLine(programBottomX, programBottomY, subclassTopX, subclassTopY);

			add(classBox);
			add(boxLabel);
			add(classLine);
			
	
		}
		
	}
}
