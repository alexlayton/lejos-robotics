package ex3;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;
import lejos.nxt.Motor;

/**
 *
 * @author Alex Layton
 */
public class ExitListener implements ButtonListener
{

    private final Motor left;
    private final Motor right;

    public ExitListener(Motor left, Motor right)
    {
      this.left = left;
      this.right = right;
    }

    public void buttonPressed(Button button)
    {
        LCD.drawString("Stopping...", 0, 0);
        System.out.println("Stopping...");
        right.stop();
        left.stop();
    }

    public void buttonReleased(Button button)
    {
        System.exit(0);
    }

}
