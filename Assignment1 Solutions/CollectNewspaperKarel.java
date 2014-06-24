/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {


/**
 * specifies program entry point 
 */
	
	public void run(){
		moveToNewspaper();
		pickupNewspaper();
		returnHome();
	}
	
/**
 * Moves Karel to the newspaper
 * Move forward until he reaches the door
 * Turn right move forward one space 
 * Turn left to face doorway
 * 
 */
	private void moveToNewspaper(){
		while (frontIsClear()){
			move();
		}
		turnRight();
		move();
		turnLeft();
	}
	
	/**
	 * Moves Karel forward to pickup the beeper
	 */
	private void pickupNewspaper(){
		move();
		pickBeeper();
	}
	
	/**
	 * Turns Karel back around 
	 * Moves Karel into the doorway
	 * Turns Karel to the right to face the wall
	 * Moves Karel until he hits the wall
	 * Turns left 
	 * Moves Karel until he reaches his starting point
	 * Turns Karel around to face his starting location
	 */
	private void returnHome(){
		turnAround();
		move();
		turnRight();
		while(frontIsClear()){
			move();
		}
		turnLeft();
		while(frontIsClear()){
			move();
		}
		turnAround();
	}

}
