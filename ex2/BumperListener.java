import java.util.*;
import lejos.nxt.*;
import lejos.robotics.proposal.*;

/**
* Alex Layton & Matthew Dutton
* Robot Programming -> ex2 -> Part 2
* 
* This class changes the direction of 
* the NXT robot, when the bumper hits 
* a wall, using a Sensor Listener 
**/

public class BumperListener
{
	
	public static void main(String[] args) 
	{

		final DifferentialPilot pilot = new DifferentialPilot(2.4f,5.6f,Motor.A, Motor.C,true); //travelling in reverse
		final TouchSensor bumper = new TouchSensor(SensorPort.S4); //Touch sensor at Port 4
		final Random direction = new Random(); 
		
		SensorPort.S4.addSensorPortListener(new SensorPortListener() //Sensor Port Listener for Port 4
		{
			public void stateChanged(SensorPort port, int oldValue, int newValue)
			{
				if(bumper.isPressed()) //tests to see if the bumper has been touched
				{
					pilot.stop(); //stops the NXT motors
					pilot.travel(-5); //travels in reverse for 5 inches
					if(direction.nextBoolean()) //generates a random Boolean
					{
						pilot.rotate(90); //rotates the NXT 90 degrees
					}	else {
						pilot.rotate(-90); //rotates the NXT 90 degrees anticlockwise
					}
						pilot.forward();
					}
					
				}
			}

		});
		
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
		Button.waitForPress();
		LCD.drawString("Going...", 0, 0);
		pilot.setSpeed(500); //sets the motor speed to 500 degrees per second
		pilot.forward(); //move the NXT forwards

	} //main

}