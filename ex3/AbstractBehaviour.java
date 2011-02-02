package ex3;

import lejos.nxt.Motor;
import lejos.nxt.addon.OpticalDistanceSensor;
import lejos.robotics.subsumption.Behavior;

/**
 *
 * @author Alex Layton
 */
public abstract class AbstractBehaviour implements Behavior
{
    protected final Motor left;
    protected final Motor right;
    protected final OpticalDistanceSensor ranger;
    protected final int threshold;

    public AbstractBehaviour(Motor left, Motor right, OpticalDistanceSensor ranger, int threshold)
    {
        this.left = left;
        this.right = right;
        this.ranger = ranger;
        this.threshold = threshold;
    } //constructor

    public void suppress() {
        left.stop();
        right.stop();
    } //suppress

} //AbstractBehaviour
