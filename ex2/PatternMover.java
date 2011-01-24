import java.util.*;
import lejos.nxt.*;
import lejos.robotics.proposal.*;

/**
* Alex Layton & Matthew Dutton
* Robot Programming -> ex2 -> Part 1
*
* This class allows the NXT to move in 
* two different patterns using the left
* and right buttons
**/
public class PatternMover
{	

	static DifferentialPilot pilot = new DifferentialPilot(2.3f,5.3f,Motor.A, Motor.C,true); //going in reverse
	static Boolean pattern = true;
	
	public static void main(String [] args)
	{	
		//Declare Button Listeners
		Button.ESCAPE.addButtonListener(new ButtonListener() {
		      public void buttonPressed(Button b) 
			  {
				LCD.drawString("Stopping", 0, 0);
				pilot.stop(); //stops the NXT
		      }

		      public void buttonReleased(Button b) 
			  {
				LCD.clear();
				System.exit(0); //exits the program
			  }
		});
		
		Button.LEFT.addButtonListener(new ButtonListener() {
		      public void buttonPressed(Button b) 
			  {
				if(pattern)
				{
					pattern = false; //changes the pattern that is currently running
				}	else	{
					pattern = true;
				}
		      }

		      public void buttonReleased(Button b) {}
		});
		
		Button.RIGHT.addButtonListener(new ButtonListener() {
		      public void buttonPressed(Button b) 
			  {
				if(pattern)
				{
					pattern = false;
				}	else	{
					pattern = true;
				}
		      }

		      public void buttonReleased(Button b) {}
		});
		
		pilot.setSpeed(500); //sets a constant speed for the robot
		Button.ENTER.waitForPress(); //pauses program until Enter is pressed
		while(true)
		{
			if(pattern)
			{
				pilot.travel(15); //travel forward 15 inches
				pilot.rotate(90); //rotate 90 degrees
			}	else	{
				pilot.travel(15);
				pilot.rotate(180);
			}
		}	
	} //main	
}