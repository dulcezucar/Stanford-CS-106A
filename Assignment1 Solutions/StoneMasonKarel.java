/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	/**
	 * Program starting point
	 */
	public void run(){		
		fixColumn();
		returnTo1stSt();
		
		while(frontIsClear()){
			moveToNextColumn();
			fixColumn();
			returnTo1stSt();
		}
	}

	/**
	 * Karel finds a column and determines if a stone is needed at 
	 * the start.
	 * Karel walks up the column and places a stone only when 
	 * one isn't already in existence.
	 * Karel walks up the column until he hits the wall which
	 * indicates the top (and end) of the column
	 * At the top, he needs to check the fence condition at which
	 * if no stone is present, he places a stone
	 */
	private void fixColumn(){
		if(noBeepersPresent()){
			putBeeper();
		}
		turnLeft();
		

		while(frontIsClear()){
			
			move();
			
			if(noBeepersPresent()){
				putBeeper();
			}
		}
		
		if(noBeepersPresent()){
			putBeeper();
		}
	}

	/**
	 * Once Karel has finished repairing the column, 
	 * he needs to turn around and return to 1st street
	 * before he can continue onto the next column or stop
	 */
	private void returnTo1stSt(){
		
		turnAround();
		while(frontIsClear()){
			move();
		}
		turnLeft();
		
	}
	
	/**
	 * So long as there's no wall in front of Karel,
	 * move him 4 steps to the next column.
	 * This abides by the constraint there are bounds of 3 spaces 
	 * in between each column
	 */
	
	private void moveToNextColumn(){
			move();
			move();
			move();
			move();
	}
}
