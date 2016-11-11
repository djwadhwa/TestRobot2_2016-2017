package org.usfirst.frc.team948.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team948.robot.DS2016;

/**
 *
 */
public class rawDriveStraight extends Command {
	private int initHeading; 
	private int finalHeading; 
	private int leftPower;
	private int rightPower;

    public rawDriveStraight(int leftPower, int rightPower, int initHeading, int finalHeading) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drive);
    	this.leftPower = leftPower;
    	this.rightPower = rightPower;
    	this.initHeading = 90;
    	this.finalHeading = 0;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drive.turnTo(initHeading);// need this method for command to work
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drive.rawTankDrive(leftPower, rightPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
