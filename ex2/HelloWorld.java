import lejos.nxt.*;

/**
* Alex Layton & Matthew Dutton
* Robot Programming -> ex2 -> Part 1
*
* Hello World NXT Implementation
**/

public class HelloWorld
{
	
	public static void main(String [] args)
	{
		
		LCD.drawString("Hello, World.", 0, 0); //Prints the string on the NXT
		Button.waitForPress();
		
	} //main
	
}