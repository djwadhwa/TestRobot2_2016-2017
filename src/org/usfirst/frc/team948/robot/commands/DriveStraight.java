package org.usfirst.frc.team948.robot.commands;

import org.usfirst.frc.team948.robot.DS2016;
import org.usfirst.frc.team948.robot.Robot;
import org.usfirst.frc.team948.robot.RobotMap;
import org.usfirst.frc.team948.utilities.MathUtilities;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command{
	
	public DriveStraight() {
		requires(Robot.drive);
	}
	
	@Override
	protected void initialize() {
		double heading = RobotMap.continuousGyro.getAngle();
		Robot.drive.driveOnHeadingInit(heading);
	}

	@Override
	protected void execute() {
		double power = MathUtilities.deadband(DS2016.rightJS.getY(), .2);
		Robot.drive.driveOnHeading(power);
		System.out.println("execute");
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		Robot.drive.driveOnHeadingEnd();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
