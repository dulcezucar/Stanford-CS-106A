/*
 * File: drawPyramids.java
 * ----------------------
 * This file draws a centered pyramid of bricks of BRICK_WIDTH by BRICK_HEIGHT, 
 * starting from the BASE_IN_BRICKS number and decrementing per row ("layer") 
 * until 1 is reached.
 * 
 */


import acm.graphics.*;
import acm.program.*;


public class drawPyramids extends GraphicsProgram {

	/*Width of brick*/
	private static final int BRICK_WIDTH = 30;

	/*Height of brick*/
	private static final int BRICK_HEIGHT = 12;
	
	/*Number of bricks in the base*/
	private static final int BRICKS_IN_BASE = 14;

	
	/*Runs the program */
	public void run(){
		
		
		/*
		 * Algorithm:
		 * For each brick layer (which is iterated by currentRow):
		 * 1. Find the middle of the window to start the brick layer (midPoint)
		 * 2. Find the left edge brick row (leftXedge and leftYedge)
		 * 3. Layer the bricks from start to stop by BRICK_WIDTH and BRICK_HEIGHT
		 */

		double currentRow = 1.0;
		
		for(int i=BRICKS_IN_BASE; i>0; i--){

			/* determine middle of the row to the center the pyramid
			 * -----------------------------------------------------
			 * If there's an odd number of bricks at the base, the midpoint
			 * is the center of the window + BRICK_WIDTH/2;
			 * If there's an even number of bricks at the base, the midpoint 
			 * is the center of the window.
			 */

			double midPoint= ((i % 2) == 0) ? (getWidth()/2) : (getWidth()/2 -  ((double) BRICK_WIDTH/2));
			
		
			/*leftmost X edge is half the distance of the # of bricks * the BRICK_WIDTH*/
			double leftXedge = midPoint - (double)( (i/2)* BRICK_WIDTH);

			
			/*
			 * The height (y) remains unchanged per row; it is iterated by the currentRow
			 * Note that getHeight() returns the bottom leftmost part of the window, so to get
			 * the correct height per row, subtract the window height from the # of stacked bricks ' height
			 * 
			 */
			
			double y = getHeight() - (double)(BRICK_HEIGHT *currentRow);
			
			/*layer the brick row; the number of bricks is decremented by i in the outer loop*/
			for(int j=0; j<i; j++){

				/*the x position of the brick is the # of BRICK_WIDTH added onto the leftmost x edge */
				double x = leftXedge + (double) (j*BRICK_WIDTH);
				
				/* 
				 * note: the height (y) remains unchanged per row; 
				 * it iterates once the row of bricks is completely built 
				 * 
				 */
				GRect brick = new GRect (x, y, BRICK_WIDTH, BRICK_HEIGHT);
				
				add(brick);

			}
			
			/* increase to the next row*/
			currentRow++;
		}
	}
}