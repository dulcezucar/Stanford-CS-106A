/*
 * File: hailstoneSequence.java
 * ----------------------------
 * This program determines the Hailstone sequence as developed by Douglas Hofstradter:
 * 
 * Pick some positive integer and call it n.
 * If n is even, divide it by two.
 * If n is odd, multiply it by three and add one.
 * Continue this process until n is equal to one.
 * 
 */

import acm.program.*;

public class hailstoneSequence extends ConsoleProgram{
	
	private static final int SENTINEL = 1;
	
	public void run(){
		
		int n = readInt("Enter a number: ");
		
		/*needed to iterate through the steps in the process*/
		int counter=0;
		
		while(true){
			
			/*implements guard to stop loop*/
			if(n==SENTINEL){
				break;
			}
			
			/*if odd*/
			else if(n%2==1){
				println(n + " is odd, so I make 3n + 1: " + (3*n+1));
				n = 3*n + 1;
				counter++;
			}
			
			/*if even*/
			else if (n%2 ==0){
				println(n + " is even, so I talk half " + (n/2));
				n = n/2;
				counter++;
			}
			
		}
		
		println("The process took " + counter +" to reach 1");
	}

}
