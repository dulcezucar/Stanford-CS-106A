/*
 * File: calculatePythagoreanTheorem.java
 * ---------------------------------
 * This program prompts the user for two sides of a triangle (a and b) and then 
 * calculates the remaining third side using the Pythagorean theorem:
 * c = square root ( a^2 + b^2)
 */

import acm.program.*;


public class calculatePythagoreanTheorem extends ConsoleProgram {
	
	public void run(){
			
		println("Enter values to compute Pythagorean theorem:");

		double a = readDouble("a: ");
		double b = readDouble("b: ");	
		double c = Math.sqrt((a*a)+(b*b));
	
		println("c = "+c);
		
		
	}

}
