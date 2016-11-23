package org.usfirst.frc.team948.robot.subsystems;

import org.usfirst.frc.team948.robot.RobotMap;
import org.usfirst.frc.team948.robot.commands.ManualDrive;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends Subsystem implements PIDOutput{
	private PIDController drivePID;
	private double pidOutput;
	private double pidError;
	
	private final double DRIVE_STRAIGHT_ON_HEADING_P = 0.025;
	private final double DRIVE_STRAIGHT_ON_HEADING_I = 0.01;
	private final double DRIVE_STRAIGHT_ON_HEADING_D = 0.02;
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new ManualDrive());
	}

	public void driveOnHeadingInit(double heading)
	{
		drivePID = new PIDController(DRIVE_STRAIGHT_ON_HEADING_P, DRIVE_STRAIGHT_ON_HEADING_I, DRIVE_STRAIGHT_ON_HEADING_D, RobotMap.continuousGyro, this);
		drivePID.setSetpoint(heading);
		drivePID.setOutputRange(-1, 1);
		drivePID.enable();
	}
	
	public void driveOnHeading(double power)
	{
		double leftPower, rightPower;
		leftPower = power + pidOutput;
		rightPower = power - pidOutput;
		rawTankDrive(leftPower, rightPower);		
		SmartDashboard.putNumber("PID error", pidError);
		SmartDashboard.putNumber("PID Output", pidOutput);
	}
	
	public void driveOnHeadingEnd()
	{
		drivePID.reset();
		drivePID.free();
		pidOutput = 0;
		rawStop();
	}
	
	public void rawTankDrive(double leftPower, double rightPower) {

		RobotMap.backLeftMotor.set(-leftPower);
		RobotMap.backRightMotor.set(rightPower);
		RobotMap.frontLeftMotor.set(-leftPower);
		RobotMap.frontRightMotor.set(rightPower);
		
		SmartDashboard.putNumber("left Power", leftPower);
		SmartDashboard.putNumber("right Power", rightPower);
		
	}

	public void rawStop() {
		RobotMap.backLeftMotor.disable();
		RobotMap.backRightMotor.disable();
		RobotMap.frontLeftMotor.disable();
		RobotMap.frontRightMotor.disable();
	}

	@Override
	public void pidWrite(double output) {
		pidOutput = output;
		pidError = drivePID.getError();
	}
}
