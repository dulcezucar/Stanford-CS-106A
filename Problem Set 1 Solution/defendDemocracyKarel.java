/* 
 * File: defendDemocracyKarel.java
 * -------------------------------
 * Once completed, this program will allow Karel to go through all the
 * ballots before it is counted to ensure no unwanted chad remains. 
 * 
 *  Facts about the world:
 *  1. Single row of ballot rectangles appear on every even intersection. 
 *     Size of ballot can differ (there can be multiple ballot rectangles); however, 
 *     the card will begin one square to the left of the first rectangle and 
 *     end one square to the right of the last rectangle
 *  2. Every ballot rectangle is exactly one space wide and three spaces high
 *  3. Karel always begins immediately to the left of the first ballot rectangle, facing
 *     the hole that gives Karel access to the voting area along the center line of rectangles
 *  4.  Karel must finish execution facing east at the rightmost edge of the ballot    
 * 
 */

/**
 * 
 * This is meant to recreate the Karel Assignment 1
 * provided in the Stanford CS 106A class. Unfortunately, it was not 
 * available for public use; however, I'm going to try to make it
 * 
 * @author Viviana
 *
 */

import stanford.karel.*;

public class defendDemocracyKarel extends SuperKarel{
	
	/**
	 * Algorithm:
	 * 1. Walk to rectangle
	 * 2. Check for missing chad; if exists, clear the rectangle of all chad
	 * 3. Repeat for each rectangle until end of ballot
	 *  
	 */
	
	public void run(){
		
		move();
		while(frontIsClear()){
			checkIfEmpty();
			moveToNextRectangle();
		}	
		
	}

	/*
	 * method: checkIfEmpty()
	 * -----------------------------
	 * pre-condition: 	Karel is inside a rectangle
	 * execution: 		Karel checks if there's a beeper present in the middle
	 * post-condition:	If there's no beeper present, remove all beepers;
	 * 					If there's a beeper present, ensure singular beepers in rectangle
	 * 
	 */
	public void checkIfEmpty(){
		
			if(beepersPresent()){
				fillRectangle();
			}
			else{
				emptyRectangle();
			}
		
	}
	
	/*
	 * method: emptyRectangle()
	 * -----------------------------
	 * pre-condition: 	Karel is at the center of the ballot rectangle
	 * 					where beeper is missing
	 * execution: 		Remove all beepers from the 1x3 rectangle
	 * post-condition:	all beepers were removed and Karel is ready to move 
	 * 					onto the next ballot rectangle
	 * 
	 */
	public void emptyRectangle(){
		
		startFromTop();
		
		while(beepersPresent()){
			pickBeeper();
		}
		for(int i=0; i<2; i++){
			move();
			while(beepersPresent()){
				pickBeeper();
			}
		}
		returnToMiddle();
	}
	
	public void startFromTop(){
		turnLeft();
		move();
		turnAround();
	}
	
	public void returnToMiddle(){
		turnAround();
		move();
		turnRight();
		
	}
	
	/*
	 * method: fillRectangle()
	 * -----------------------------
	 * pre-condition: 	Karel is at the center of the ballot rectangle
	 * 					where beeper is present
	 * execution: 		Remove all beepers from the 1x3 rectangle (could be more than 1)
	 * 					Fill all beepers in the rectangle (to ensure only 1)
	 * post-condition:	1 beeper is added in each space and Karel is ready to move 
	 * 					onto the next ballot rectangle
	 * 
	 */
	public void fillRectangle(){
	
		emptyRectangle();
		
		startFromTop();
	
		putBeeper();
		for(int i=0; i<2; i++){
			move();
			putBeeper();
		}
		returnToMiddle();
		
	}	
	
	/*
	 * method: moveToNextRectangle()
	 * -----------------------------
	 * pre-condition: 	Karel is at a ballot rectangle he just finished checking
	 * execution: 		So long as there's no wall, Karel moves forward 2 spaces to next ballot rectangle
	 * post-condition:	Karel is standing in the middle of the next ballot rectangle
	 * 
	 */
	public void moveToNextRectangle(){
		for(int i=0; i<2; i++) {
			if(frontIsClear()){
				move();
			}
		}
		
		
	}

}
