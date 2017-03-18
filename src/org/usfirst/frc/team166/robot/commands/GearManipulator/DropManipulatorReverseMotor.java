package org.usfirst.frc.team166.robot.commands.GearManipulator;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team166.robot.RobotMap;
import org.usfirst.frc.team166.robot.commands.DriveDistance;

/**
 *
 */
public class DropManipulatorReverseMotor extends CommandGroup {

	public DropManipulatorReverseMotor() {
		addSequential(new ReverseManipulatorMotors());
		addSequential(new DownManipulator());

		double reverseFromPegDistance = Preferences.getInstance().getDouble(RobotMap.reverseFromPegDistance, 0.0);
		double reverseFromPegSpeed = Preferences.getInstance().getDouble(RobotMap.reverseFromPegSpeed, 0.0);

		addSequential(new DriveDistance(-Math.abs(reverseFromPegDistance), -Math.abs(reverseFromPegSpeed)));
		addSequential(new ManipulatorMotorOff());
		addSequential(new UpManipulator());

	}
}
