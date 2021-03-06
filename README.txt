These are my solutions to the free online course. I'll update these as I complete the course. Hopefully they can help you!

Git user NatashaTheRobot helped immensely as well. Check out NatashaTheRobot's page for taking CS106A: https://github.com/NatashaTheRobot/Stanford-CS-106A/wiki/Stanford-Introduction-To-Computer-Science-Programming-Methodology-CS106A-Class-Guide

---------------------------------
Assignment 1:
For all the Karel exercises, I only included the solution java files here.

The links I found extremely useful in setting up the Karel environment (needs to use JVM 1.6) is this guy:
http://arnaudbertrand.com/playing-with-stanfords-karel-the-robot-on-a-standard-eclipse/ (Thank you Arnaud!)

-----------------------------------
Problem set 1:
The solutions include the world created based on the problem.
At first, I couldn't figure out how to put the little walls for each ballot rectangle. So, I made the algorithm to depend on the rectangle being 1x3, so only 3 spaces long. Afterwards, I figured out how to add the walls. Shrug. Still works ;) Could edit it to look for walls instead.

- my answer isn't as elegant as the solution, but it's another way of doing the same thing (probably too complicated for this simple issue..)

--------------------------------
Assignment 2: Simple Java Program

#1) drawPyramids.java

The key to understanding this one is what getHeight() and getWidth() return. 
- getHeight() returns the bottom leftmost pixels on the screen. This is the max of y pixels; the program needs to compute brick height's worth of rows from this bottom point.
-getWidth just returns the full x range of pixels on the screen. Also, where the midpoint is per row (or layer) of bricks.

Also, in Eclipse, remember to edit the (x)=Parameters in the Run Configurations for this Java applet. The default in Eclipse was set to 50 x 50, which was far too small to let the screen fill up with the pyramid. I changed it to 600x600.

Finally, I played around with different values in BRICKS_IN_BASE to make sure it worked. I started with it equal to 1 to test my code and then increased it up. 0 works as well just in case. There is no upper boundary; for an upper boundary, I'd have to determine the window size and set it accordingly, which is probably beyond the point of this exercise.

#2) drawTarget.java

Drawing concentric circles using some constants, including the number of concentric circles. I simplified the calling of 3 ovals using a switch statement. 

Used the same principles of drawPyramids to find the central point

#3) drawAcmHierarchy.java

Used the same concepts of finding the central point of the window. Created the program box with label. Then, added a for loop and switch statement to iterate through creating the subclass boxes.

The trickiest part was figuring out the middle of the class box to place the lable correctly in the x orientation.

#4) calculatePythagoreanTheorem.java

Takes two sides of a triangle (a and b) and uses the Pythagorean theorem to solve for c. There is no need for sentinel since readDouble has error checking built in. That is, if the user enters a non-numerical value, the console will prompt them to re-enter the appropriate value.

#5) findSmallAndLarge.java

The trickiest is the guard against the SENTINEL. It needs to occur at the first entry and then consequently immediately after the next readInt is called.

#6) hailstoneSequence.java

This was fairly straight forward; implemented using the read-until-sentinel-pattern with a changeable sentinel

----------------------------------------------
Problem Set # 2

1. FibonacciSequencer.java

I had a harder time than I'd care to admit with this one at first. I suddenly realized my issue: I needed a temp variable to hold the "previous" value to get the value of the next term. 

2. DrawRobotFace.java

This was fairly straight forward. I computed the locations of each element (head, eyes, mouth) based on a center point x and y value. I broke it out into methods of drawHead, drawEyes, and drawMouth.

I did an "l" and "r" to represent "left" and "right" eyes when it came to draw the eyes.