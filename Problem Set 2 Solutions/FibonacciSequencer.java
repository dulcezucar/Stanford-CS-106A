/*

 * File: FibonacciSequencer.java
 * -------------------------------
 * This program displays the Fibonacci sequence up to a maximum term, 
 * which is assumed less than 10,000
 * 
 * This is for Problem Set 2 question 1
 * 
 */

import acm.program.*;

public class FibonacciSequencer extends ConsoleProgram{
	
	private static final int MAX_TERM_VALUE = 10000;
	
	public void run(){
		
		println("This program lists the Fibonacci sequence");

		/*first term is defined as 0*/
		int term = 0;
		
		/*used for the value of the previous term; initially set to 0*/
		int prevTerm = term;
		
		/*place holder for the nextTerm*/
		int nextTerm;
		
		while(term<=MAX_TERM_VALUE){

			/* for the first and second terms, 0 and 1 print
			 * for the subsequent terms, the value is added to the previous value
			 * which is held by the nextTerm placeholder
			 */
			println(term);
			nextTerm = findFibonacci(prevTerm,term);

			prevTerm = term;
			term = nextTerm;
		}
	
	}
	
	
	
	/*
	 * method: findFibonacci
	 * ---------------------
	 * input: current term as an integer
	 * output: the Fibonacci value as an integer
	 * 
	 * The only check is for the first term; if it's 0, then simply return 1
	 * 
	 */
	
	private int findFibonacci(int previousTerm, int term){
		
		if (term == 0) return 1;
		else{
			return (previousTerm + term);			
		}
	}

	
}
