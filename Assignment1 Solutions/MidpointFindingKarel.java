/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	/*
	 *Algorithm:
	 *
	 *1. Start Karel by marking the first and last spots in the street (row) 
	 *	 with a beeper.
	 *2. Starting from the last edge beeper, find the first beeper again
	 *3. Start: 
	 *   While Karel is on a spot with a beeper:
	 *	 a.) pick up the beeper
	 *	 b.) turn around
	 *   c.) if the front is clear, move forward
	 *   	 i.) if there's a beeper in the next spot, you've found the midpoint!
	 *           STOP Karel here by picking up the beeper and removing it from the spot
	 *   	 ii.) otherwise (if there's NO beeper in the next spot), 
	 *   		  put the beeper down (moves the beeper ahead one space) and find
	 *   		  the next edge beeper
	 * 4. Karel found the midpoint! Put the beeper down and let Karel dance.
	 */
	
		public void run(){

			setEdges();
			findFirstBeeper();
			findMidPoint();			
			putBeeper();
			letKarelDance();
		}
		
		private void setEdges(){
			putBeeper();
			markEnd();
					
		}
		
		private void findFirstBeeper(){
			turnAround();
			findBeeper();

		}
		
		private void findMidPoint(){
			while(beepersPresent()){
				pickBeeper();
				turnAround();
				
				if(frontIsClear()){
					move();
					if(beepersPresent()){
						pickBeeper();
					}
					else{
						putBeeper();
						findBeeper();
					}
				}
			}

		}
		
		private void letKarelDance(){
			for(int i=0; i<5; i++){
				turnRight();
			}
		}
		
		private void markEnd(){
			while(frontIsClear()){
				move();
			}
			putBeeper();
			
		}
		
		private void findBeeper(){
			if(frontIsClear()){
				move();
			}
			while(noBeepersPresent()){
				move();
			}

		}
	
}
