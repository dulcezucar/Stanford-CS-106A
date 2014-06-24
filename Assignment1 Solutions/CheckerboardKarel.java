/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	/**
	 * Start of program
	 * 
	 * Karel needs to:
	 * 1. Check the edge case of a singular column; if exists, turn Karel left and checker Odd
	 * 
	 * If not the column case ...
	 * 2. For his first row, Karel starts checkering odd until he hits a wall
	 * 3. Karel turns left, checks if the last space had a beeper. If so, move up to the avenue street (row) and
	 *    checker even until he hits a wall.	
	 * 4. Karel turns right, checks if the last space had a beeper. If so, move up to the next street (row) and
	 *    checker even until he hits a wall.
	 * 5. Repeat steps 3 and 4 until there are no more rows left.
	 */
	public void run(){
		
		if(frontIsBlocked()){
			turnLeft();
			checkerOdd();
		}
		else{

			checkerOdd();
		
			while (leftIsClear()){				
				checkEvenStreet();
				checkOddStreet();				
			}
		}
	}
	
	/**
	 * Checker the even street as appropriate
	 */
	private void checkEvenStreet(){
		if(beepersPresent()){
			moveUpAve();
			checkerEven();
		}
		else{
			moveUpAve();
			checkerOdd();
		}		
	}
	
	/**
	 * Checker the odd street as appropriate
	 */
	private void checkOddStreet(){
		if(beepersPresent()){
			nextSt();
			checkerEven();
		}
		else{
			nextSt();
			if(frontIsClear()){
				checkerOdd();
			}
		}
		
	}
	
	/**
	 * Karel will turn left and move up the avenue if there is no wall
	 */
	
	private void moveUpAve(){

		turnLeft();

		if(frontIsClear()){
			move();
			turnLeft();
		}
		
	}

	/**
	 * Karel will turn right and move up to the next street if there is no wall
	 */
	private void nextSt(){

		turnRight();
		
		if(frontIsClear()){
			move();
			turnRight();
		}
		
	}
	
	
	/**
	 * Karel fills the checker pattern where he
	 * places the beeper on every odd numbered street or avenue
	 * depending on if he is filling a row or a column.
	 * This is odd because he begins with placing a beeper
	 * 
	 */
	private void checkerOdd(){
		
		putBeeper();
		
		if(frontIsClear()){
			move();
		}
		
		while(frontIsClear()){
			move();			
			putBeeper();
		
			if(frontIsClear()){
				move();
			}
			
		}
			
	}

	/**
	 * Karel fills the checker pattern where he
	 * places the beeper on every even numbered street or avenue
	 * depending on if he is filling a row or a column.
	 * This is even because he begins with skipping the first place
	 * and then filling the second place and every second place
	 * thereafter.
	 * 
	 */
	private void checkerEven(){
				
		if(frontIsClear()){
			move();
			putBeeper();

		}
		
		while(frontIsClear()){
			move();			
		
			if(frontIsClear()){
				move();
				putBeeper();
			}
			
		}
			
	}
	

	
}
