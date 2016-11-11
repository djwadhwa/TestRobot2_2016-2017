package org.usfirst.frc.team948.utilities;

import org.usfirst.frc.team948.robot.RobotMap;

import edu.wpi.first.wpilibj.interfaces.Accelerometer;

public class AHRSAccelerometer implements Accelerometer {
	
	private AHRS ahrs = RobotMap.robotAHRS;
	
	public AHRSAccelerometer(){};
	
	@Override
	public double getX() {
		return ahrs.getWorldLinearAccelX();
	}
	
	@Override
	public double getY() {
		return ahrs.getWorldLinearAccelY();
	}
	
	@Override
	public double getZ() {	
		return ahrs.getWorldLinearAccelZ();
	}
}