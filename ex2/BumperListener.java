import lejos.nxt.*;
import lejos.robotics.proposal.*;

public class BumperListener
{
	
	public static void main(String[] args) 
	{

		final DifferentialPilot pilot = new DifferentialPilot(2.4f,5.6f,Motor.A, Motor.C,true); //travelling in reverse
		final TouchSensor bumper = new TouchSensor(SensorPort.S4);
		
		SensorPort.S4.addSensorPortListener(new SensorPortListener() 
		{
			public void stateChanged(SensorPort port, int oldValue, int newValue)
			{
				if(bumper.isPressed())
				{
					pilot.stop();
					pilot.travel(-5);
					pilot.rotate(90);
					pilot.forward();
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
		pilot.setSpeed(500);
		pilot.forward();

	}

}