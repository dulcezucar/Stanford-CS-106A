/*
 * File: DrawRobotFace.java
 * --------------------------
 * This class draws a robot face according to the specifications defined in Problem Set 2 
 * question 2
 * 
 */

import acm.graphics.*;
import acm.program.*;

import java.awt.*;

public class DrawRobotFace extends GraphicsProgram{
	
	/*define pixel constants for the rectangular head*/
	private static final int HEAD_WIDTH = 100;
	private static final int HEAD_HEIGHT = 140;
	
	/*define pixel constants for the eye radius*/
	private static final int EYE_RADIUS = 10;
	
	/*define pixel constants for the rectangular mouth*/
	private static final int MOUTH_WIDTH = 60;
	private static final int MOUTH_HEIGHT = 30;
	
	public void run(){
		
		/*the x coordinate of the center point in the canvas */
		double x = getWidth()/2;;
		
		/*the y coordinate of the center point in the canvas */
		double y = getHeight()/2;
		
		add(drawHead(x, y));
		add(drawEyes(x, y, "l"));
		add(drawEyes(x, y, "r"));
		add(drawMouth(x, y));
		
	}
	
	
	/*
	 * method: drawHead
	 * -----------------
	 * definition: draws the rectangular robot head
	 * 
	 * inputs: 
	 * 	the x and y coordinate of the canvas' center point
	 * 
	 * output: the drawHead GRect object
	 */
	private GRect drawHead(double x, double y){
		
		x = x - (HEAD_WIDTH/2);
		y = y - (HEAD_HEIGHT/2);
		
		GRect head = new GRect(x, y, HEAD_WIDTH, HEAD_HEIGHT);
		head.setColor(Color.BLACK);
		head.setFilled(true);
		head.setFillColor(Color.GRAY);
		
		return head;
	}
	
	/*
	 * method: drawEyes
	 * -----------------
	 * definition: 
	 * 	draws the robot's circular eyes whose centers are set
	 * 	horizontally to a quarter of the width of the head from either edge and
	 * 	a quarter of the distance down from the top of the head
	 * 
	 * inputs: 
	 * 	the x and y coordinate of the canvas' center point
	 * 	string indicating if this is the left or the right eye, since the x locations are different
	 * 
	 * output: the drawEyes GOval object
	 */	
	private GOval drawEyes(double x, double y, String c){
		
		/*left eye x coordinate*/
		if(c.equals("l")){
			x = x - (HEAD_WIDTH/4) - EYE_RADIUS;
		}
		/*right eye x coordinate*/
		else if (c.equals("r")){
			x =  x + (HEAD_WIDTH/4) - EYE_RADIUS;
		}
		
		y = y - (HEAD_HEIGHT/4) - EYE_RADIUS/2;
				
		GOval eye = new GOval(x, y, 2*EYE_RADIUS, 2*EYE_RADIUS);
		eye.setColor(Color.YELLOW);
		eye.setFilled(true);
		eye.setFillColor(Color.YELLOW);
		
		return eye;
		
	}

	/*
	 * method: drawMouth
	 * -----------------
	 * definition: 
	 * 	draws the robot's rectangular mouth which is centered with respect to the head
	 *  in the x direction and  a quarter of the distance up from the bottom of the head 
	 *  in the y direction
	 *  
	 * inputs: 
	 * 	the x and y coordinate of the canvas' center point
	 * 
	 * output: the drawMouth GRect object
	 */		
	private GRect drawMouth(double x, double y){
	
		x = x - MOUTH_WIDTH/2;
		y = y + HEAD_HEIGHT/4 - MOUTH_HEIGHT/2;
		
		GRect mouth = new GRect (x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
		mouth.setColor(Color.WHITE);
		mouth.setFilled(true);
		mouth.setFillColor(Color.WHITE);
		
		return mouth;
		
	}
	

}
