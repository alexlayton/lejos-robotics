package ex3;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.OpticalDistanceSensor;
import lejos.nxt.comm.RConsole;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

/**
 * @author Alex Layton
 */
public class PartOne
{

    public static void main(String [] args)
    {

        RConsole.openBluetooth(30000); //open bluetooth console

        Button.ESCAPE.addButtonListener(new ExitListener(Motor.A, Motor.C));
        OpticalDistanceSensor ranger = new OpticalDistanceSensor(SensorPort.S2); //some sensor port
        MoveForward moveForward = new MoveForward(Motor.A, Motor.C, ranger, 100); //10cm
        MoveForward moveBackward = new MoveForward(Motor.A, Motor.C, ranger, 100); //10cm
        Arbitrator arbi = new Arbitrator(new Behavior[]{ moveForward, moveBackward });

        LCD.drawString("Ready...", 0, 0);
        System.out.println("Waiting for Button Press.");
        Button.ENTER.waitForPress();
        System.out.println("Running...");
        arbi.start();
    } //main

} //PartOne
