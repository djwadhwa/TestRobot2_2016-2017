package org.usfirst.frc.team948.utilities;

import org.usfirst.frc.team948.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.interfaces.Accelerometer;

public class AHRSAccelerometer implements Accelerometer {
	
	private AHRS ahrs = null;
	
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

	@Override
	public void setRange(Range range) {
		// TODO Auto-generated method stub
		
	}
}