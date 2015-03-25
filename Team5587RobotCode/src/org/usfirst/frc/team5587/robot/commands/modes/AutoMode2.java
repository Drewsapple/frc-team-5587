package org.usfirst.frc.team5587.robot.commands.modes;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5587.robot.commands.drive.AutoDrive;

/**
 *	Turns Robot left 90 degrees, runs straight
 */
public class AutoMode2 extends CommandGroup
{		
    public  AutoMode2() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	addSequential( new AutoDrive( 5000, 1 ) );
    	addSequential( new AutoDrive( 5000, 0 ) );
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
