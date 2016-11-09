package org.usfirst.frc.team948.robot.subsystems;

import org.usfirst.frc.team948.robot.RobotMap;
import org.usfirst.frc.team948.robot.commands.ManualDrive;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem{
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new ManualDrive());
	}

	

	public void rawTankDrive(double leftPower, double rightPower) {

		RobotMap.backLeftMotor.set(leftPower);
		RobotMap.backRightMotor.set(-rightPower);
		RobotMap.frontLeftMotor.set(leftPower);
		RobotMap.frontRightMotor.set(-rightPower);
	}

	public void rawStop() {
		RobotMap.backLeftMotor.disable();
		RobotMap.backRightMotor.disable();
		RobotMap.frontLeftMotor.disable();
		RobotMap.frontRightMotor.disable();
	}


}
