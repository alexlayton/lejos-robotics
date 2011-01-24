import lejos.nxt.*;
import lejos.robotics.proposal.*;

/**
* Alex Layton & Matthew Dutton
* Robot Programming -> ex2 -> Part 3
**/

public class MazeBot
{

	static DifferentialPilot pilot = new DifferentialPilot((float)2.4,(float)5.6f,Motor.A, Motor.C,true); //going in reverse

	public static void main(String [] args)
	{		
		
		TouchSensor bumper = new TouchSensor(SensorPort.S4);
		pilot.setSpeed(100); //10 inches per second
		Button.ESCAPE.addButtonListener(new ButtonListener() {
		      public void buttonPressed(Button b) 
			  {
		        LCD.drawString("Stopping", 0, 0);
				pilot.stop();
		      }

		      public void buttonReleased(Button b) 
			  {
		        LCD.clear();
				System.exit(0);
		      }
		});
		LCD.drawString("Ready...",0,0);
		Button.ENTER.waitForPress();
		moveRight();
		while(true)
		{
			if(bumper.isPressed())
			{
				moveLeft();
				moveRight();
			}
		}
	} //main

	public static void moveLeft()
	{
		pilot.steer(100);
		try { Thread.sleep(250); } catch (InterruptedException e) {}
		pilot.stop();
	} //moveLeft
	
	public static void moveRight()
	{
		pilot.steer(-100);
	} //moveRight
}