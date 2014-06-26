/*
 * File: drawTarget.java
 * ---------------------
 * This program draws a bullseye much like the Target logo in red
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class drawTarget extends GraphicsProgram {
	
	/* defines 3 concentric circles to display*/
	private static final int NUM_CIRCLES = 3;
	
	/*outermost circle radius; 1" = 72 pixels*/
	private static final int THIRD_CIRCLE_RADIUS = 72;
	
	/*inner (middle) circle radius; 0.65" = 46.8 pixels ~ 47 pixels*/
	private static final int SECOND_CIRCLE_RADIUS = 47;
	
	/*innermost (center) circle radius; 0.3" = 21.6 pixels ~ 22 pixels*/
	private static final int FIRST_CIRCLE_RADIUS = 22;

	
	public void run(){
		
		/*
		 * Algorithm:
		 * ---------
		 * 1. Find the center point of the screen (x and y location)
		 * Because the objects layer on top of each other, need to start with the outermost first:
		 * 2. Draw the 3rd (outermost) circle; fill it in red
		 * 3. Draw the 2nd (inner/middle) circle; fill it in white
		 * 4. Draw the 1st (center/innermost) circle; fill it in red.
		 * 
		 */
	
		double midpointX = getWidth()/2;
		
		/*remember getHeight() returns the leftmost y position */
		double midpointY = getHeight() - (getHeight()/2);

		/* 
		 * currently setup for NUM_CIRCLES to be 3; the switch case will not handle more than 3 cases
		 * the default sets the radius to 0 so no circle is drawn.
		 * 
		 * if adding additional concentric circles, these radii need added to the constants and an additional switch
		 * case will be needed
		 * 
		 * */
		
		for(int i=NUM_CIRCLES; i>0; i--){
 
			double circleXedge = midpointX;
			double circleYedge = midpointY;
			double circleRadius = 0.0;

			GOval circle = new GOval(circleRadius, circleRadius);
			
			switch(i){
				case 3:
					circleXedge -= (THIRD_CIRCLE_RADIUS)/2.0;
					circleYedge -= (THIRD_CIRCLE_RADIUS)/2.0;
					circleRadius = THIRD_CIRCLE_RADIUS;
					break;
				case 2:
					circleXedge -= (SECOND_CIRCLE_RADIUS)/2.0;
					circleYedge -= (SECOND_CIRCLE_RADIUS)/2.0;
					circleRadius = SECOND_CIRCLE_RADIUS;
					break;
				case 1:
					circleXedge -= (FIRST_CIRCLE_RADIUS)/2.0;
					circleYedge -= (FIRST_CIRCLE_RADIUS)/2.0;
					circleRadius = FIRST_CIRCLE_RADIUS;
					break;
				default:
					break;
			}
			
			circle = new GOval(circleXedge, circleYedge, circleRadius, circleRadius);

			/*if it's an odd circle, it is red*/
			if(i%2==1){
				circle.setColor(Color.red);
				circle.setFilled(true);
				circle.setFillColor(Color.red);
			}
			/*if it's an even circle, it is white*/
			else{
				circle.setColor(Color.white);
				circle.setFilled(true);
				circle.setFillColor(Color.white);
				
			}
			add(circle);

		}
		
		/*
		 * I commented out this section because it seemed too brute force;
		 * I created cleaner code using a switch case above
		 */
		
		/*
		double circleXedge = midpointX - (THIRD_CIRCLE_RADIUS/2.0); 
		double circleYedge = midpointY - (THIRD_CIRCLE_RADIUS/2);
		double circleRadius = THIRD_CIRCLE_RADIUS;		
		GOval circle = new GOval(circleXedge, circleYedge, circleRadius, circleRadius);
		circle.setColor(Color.red);
		circle.setFilled(true);
		circle.setFillColor(Color.red);
		
		add(circle);

		circleXedge = midpointX - (SECOND_CIRCLE_RADIUS/2.0);
		circleYedge = midpointY - (SECOND_CIRCLE_RADIUS/2.0);
		circleRadius = SECOND_CIRCLE_RADIUS;		
		circle = new GOval(circleXedge, circleYedge, circleRadius, circleRadius);
		circle.setColor(Color.white);
		circle.setFilled(true);
		circle.setFillColor(Color.white);

		add(circle);

		circleXedge = midpointX - (FIRST_CIRCLE_RADIUS/2.0);
		circleYedge = midpointY - (FIRST_CIRCLE_RADIUS/2);
		circleRadius = FIRST_CIRCLE_RADIUS;		
		circle = new GOval(circleXedge, circleYedge, circleRadius, circleRadius);
		circle.setColor(Color.red);
		circle.setFilled(true);
		circle.setFillColor(Color.red);

		add(circle);
		*/

	
	}
}
