import lejos.nxt.*;
import lejos.robotics.proposal.*;

/**
* Alex Layton & Matthew Dutton
* Robot Programming -> ex2 -> Part 3
**/

public class MazeMover
{

	static DifferentialPilot pilot = new DifferentialPilot((float)2.4,(float)5.6f,Motor.A, Motor.C,true); //going in reverse

	public static void main(String [] args)
	{		
		
		TouchSensor bumper = new TouchSensor(SensorPort.S4); //Touch Sensor ar Port 4
		pilot.setSpeed(100); //10 inches per second
		
		Button.ESCAPE.addButtonListener(new ButtonListener() { //Escape button listener
		      public void buttonPressed(Button b) 
			  {
		        LCD.drawString("Stopping", 0, 0);
				pilot.stop(); //Stops NXT motors
		      }

		      public void buttonReleased(Button b) 
			  {
		        LCD.clear();
				System.exit(0); //exits the program
		      }
		});
		
		LCD.drawString("Ready...",0,0);
		Button.ENTER.waitForPress();
		moveRight();
		while(true)
		{
			if(bumper.isPressed()) //tests to see if the bumper has been touched
			{
				moveLeft(); 
				moveRight(); 
			}
		}
	} //main

	public static void moveLeft()
	{
		pilot.steer(100); //moves the robot in a circle to the left
		try { Thread.sleep(400); } catch (InterruptedException e) {} //Pauses the program for 250 milliseconds
		pilot.stop();
	} //moveLeft
	
	public static void moveRight()
	{
		pilot.steer(-100); //moves the robot in a circle to the right
	} //moveRight
}