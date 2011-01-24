import java.util.*;
import lejos.nxt.*;
import lejos.robotics.proposal.*;

/**
* Alex Layton & Matthew Dutton
* Robot Programming -> ex2 -> Part 2
*
* This class changes the direction of 
* the NXT robot, when the bumper hits 
* a wall.
**/

public class Bumper
{	
	public static void main(String [] args)
	{
		TouchSensor bumper = new TouchSensor(SensorPort.S4); //declares a touch sensor at Port 4
		final DifferentialPilot pilot = new DifferentialPilot(2.4f,5.6f,Motor.A, Motor.C,true); //going in reverse
		Random direction = new Random(); 
		
		Button.ESCAPE.addButtonListener(new ButtonListener() {
		      public void buttonPressed(Button b) 
			  {
				LCD.drawString("Stopping...", 0, 0);
				pilot.stop();
		      }

		      public void buttonReleased(Button b) 
			  {
				LCD.clear();
				System.exit(0);
			  }
		});
		
		LCD.drawString("Ready...", 0, 0);
		Button.ENTER.waitForPress(); 
		pilot.setSpeed(500); //Sets the speed of the motors in degrees per second
		pilot.forward(); //Makes the NXT move forward
		while(true)
		{
			if(bumper.isPressed())
			{
				pilot.stop(); //Stops the NXT
				pilot.travel(-5); //Travels in reverse for 5 inches
				if(direction.nextBoolean()) //generates a ranom boolean
				{
					pilot.rotate(90); //rotate right
				}	else	{
					pilot.rotate(-90); //rotate left
				}
				pilot.forward();
			}
		}	
	} //main
	
}