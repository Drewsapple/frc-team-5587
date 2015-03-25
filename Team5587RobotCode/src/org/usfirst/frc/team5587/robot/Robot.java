package org.usfirst.frc.team5587.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team5587.robot.HI;
import org.usfirst.frc.team5587.robot.subsystems.*;
import org.usfirst.frc.team5587.robot.commands.modes.*;


public class Robot extends IterativeRobot 
{
	public static HI hi;
	public static final Feet feet = new Feet();
	public static final Lift lift = new Lift();
	private CommandGroup auto;
	private CommandGroup teleOp;
	
    public void robotInit() 
    {
    	hi = new HI();
    	auto = new AutoMode1();
    	teleOp = new TeleOpDrive();
    }
	
	public void disabledPeriodic() 
	{
		Scheduler.getInstance().run();
	}

    public void autonomousInit() 
    
    {
        if (auto != null) auto.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit() 
    {
        if (auto != null) auto.cancel();
        if (teleOp != null) teleOp.start();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit()
    {
    }

    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
        DriverStation.reportError( "LiftE " + Robot.lift.getDistance(), true);
        //DriverStation.reportError( "JoyStick2 " + Robot.hi.getstick2(), true);
        //DriverStation.reportError( "RFeetE " + Robot.feet.getEncoderCount(Robot.feet.right), false);
        //DriverStation.reportError( "LFeetE " + Robot.feet.getEncoderCount(Robot.feet.left), false);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() 
    {
        LiveWindow.run();
    }
}
