package org.usfirst.frc.team5587.robot.subsystems;

import org.usfirst.frc.team5587.robot.RobotPorts;
import org.usfirst.frc.team5587.robot.commands.liftstuff.MoveLiftWithStickSecond;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;

public class Lift extends Subsystem 
{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private VictorSP LiftVictorSP1, LiftVictorSP2;
	private Encoder LiftEncoder;
	
	public static final double LiftMotorSpeed = .1;
	public static final int countsPerTote = 500;//FIND ME
	public static final double distancePerPulse = 500;
	
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        setDefaultCommand( new MoveLiftWithStickSecond() );
    	//setDefaultCommand(new MoveLiftWithThrottle());
    }
    
    public Lift()
    {
    	LiftVictorSP1 = new  VictorSP( RobotPorts.LIFT_MOTOR1 );
    	LiftVictorSP2 = new VictorSP( RobotPorts.LIFT_MOTOR2 );
    	
    	LiftEncoder = new Encoder( RobotPorts.LIFT_ENCODER_A, RobotPorts.LIFT_ENCODER_B );
    	LiftEncoder.setDistancePerPulse( distancePerPulse );
    }
    
    public void setLiftSpeed(double speed)
    {
    	LiftVictorSP1.set( speed * LiftMotorSpeed );
    	LiftVictorSP2.set( speed * LiftMotorSpeed );
    }
    
    /**
    public boolean liftNotAtBottom()
    {
    	if (LiftEncoder.getDistance() > 0)
    	{
    		return true;
    	}
    	else
    		return false;
    }
    */
    
    public boolean liftAtBottom()
    {
    	if (LiftEncoder.getDistance() == 0)
    	{
    		return true;
    	}
    	else
    		return false;
    }
    
    public double getDistance()
    {
    	return LiftEncoder.getDistance();
    }
    
    public void moveLiftWithJoystickSecond(Joystick Blah)
    {
    	double yValueSpeed = Blah.getY();
    	setLiftSpeed( yValueSpeed );
    }
    
    public void lift1Tote()
    {
    	setLiftSpeed( 1 );
    }
    
    public void lower1Tote()
    {
    	setLiftSpeed( -1 );
    }
}