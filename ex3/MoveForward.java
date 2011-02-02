package ex3;

import lejos.nxt.Motor;
import lejos.nxt.addon.OpticalDistanceSensor;

/**
 * @author Alex Layton
 */
public class MoveForward extends AbstractBehaviour
{
    
    public MoveForward(Motor left, Motor right, OpticalDistanceSensor ranger, int threshold)
    {
        super(left, right, ranger, threshold);
    } //constructor
    
    public boolean takeControl()
    {
        if(ranger.getDistance() > threshold)
        {
            return true;
        }   else    {
            return false;
        }
    } //takeControl

    public void action()
    {
        System.out.println("Going Forwards.");
        left.forward();
        right.forward();
    } //action

} //MoveForward
