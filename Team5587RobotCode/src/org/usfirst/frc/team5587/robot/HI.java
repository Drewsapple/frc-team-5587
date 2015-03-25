package org.usfirst.frc.team5587.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team5587.robot.commands.drive.SlowSpeed;
import org.usfirst.frc.team5587.robot.commands.liftstuff.LiftTote;

public class HI 
{
	private Joystick stick;
	private Joystick stickSecond;
	
	private JoystickButton slowButton;
	private JoystickButton unSlowButton;
	
	private JoystickButton liftButton;
	private JoystickButton lowerButton;

	public HI() 
	{
		stick = new Joystick( RobotPorts.JOYSTICK_MAIN );
		stickSecond = new Joystick( RobotPorts.JOYSTICK_SECOND );
		
		SlowSpeed slow = new SlowSpeed();
		
		slowButton = new JoystickButton( stick, RobotPorts.SLOW_BUTTON );
		slowButton.toggleWhenActive( slow );
		
		unSlowButton = new JoystickButton( stick, RobotPorts.UNSLOW_BUTTON );
		unSlowButton.cancelWhenPressed( slow );
		
		LiftTote lift = new LiftTote();
		
		liftButton = new JoystickButton( stick, RobotPorts.LIFT_BUTTON );
		liftButton.toggleWhenPressed( lift );
		
		lowerButton = new JoystickButton( stick, RobotPorts.LOWER_BUTTON );
		lowerButton.cancelWhenPressed( lift );
	}
	
	public Joystick getstick() //this is currently used for driving 
	{
		return stick;
	}
	
	public Joystick getstick2() // currently used for lift
	{
		return stickSecond;
	}
	
	public boolean isSlow()
	{
		return slowButton.get();
	}
}