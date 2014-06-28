/*
 * File: findSmallAndLarge.java
 * ----------------------------
 * This program prompts the user for a list of integers until a sentinel value is entered.
 * Once the values have been entered, the program returns the largest and smallest
 * values of the list of integers
 * 
 */

import acm.program.*;

public class findSmallAndLarge extends ConsoleProgram{

	/*define the sentinel value to be used to stop user input*/
	private static final int SENTINEL = 0;
	
	public void run(){

		println("This program finds the largest and smallet numbers.");
		int value = readInt("? ");
		
		/*check first entry against SENTINEL*/
		if (value==SENTINEL){
			println("FAIL! You entered the sentinel on the first try! No small or large integers for you!");
		}
		else{

			/*first valid entry sets smallest = largest int*/
			int small = value;
			int large = value;
			
			while(value!= SENTINEL){
									
				value = readInt("? ");
	
				/*since the value just changed, need to guard for the SENTINEL entry*/
				if(value == SENTINEL){
					break;
				}
				else if(value<=small){
					small = value;
				}
				else if (value>=large){
					large = value;
				}
				
			}
			
			/*return smallest and largest integers to the console*/
			println("smallest: " + small);
			println("largest: " + large);
		}
	}
}
