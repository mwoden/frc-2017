package org.usfirst.frc.team166.robot.commands;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

import org.usfirst.frc.team166.robot.RobotMap;
import org.usfirst.frc.team166.robot.commands.GearManipulator.OpenManipulator;

/**
 *
 */
public class centerGearAutonomous extends CommandGroup {

	public centerGearAutonomous() {

		// double distance = Preferences.getInstance().getDouble(RobotMap.desiredDistance, 0.0);
		// SmartDashboard.putData(new DriveDistance(distance, speed));

		double centerGearAutoSpeed = Preferences.getInstance().getDouble(RobotMap.centerGearAutoSpeed, 0.0);
		double centerGearAutoDistance = Preferences.getInstance().getDouble(RobotMap.centerGearAutoDistance, 0.0);
		double autoWaitTime = Preferences.getInstance().getDouble(RobotMap.autoWaitTime, 0.0);

		addSequential(new DriveDistance(centerGearAutoDistance, centerGearAutoSpeed), 5.0);
		addSequential(new WaitCommand(autoWaitTime));
		addSequential(new OpenManipulator());
	}
}
