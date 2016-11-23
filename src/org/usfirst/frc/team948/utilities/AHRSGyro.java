package org.usfirst.frc.team948.utilities;

import org.usfirst.frc.team948.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.GyroBase;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.PIDSource;

public class AHRSGyro extends GyroBase implements Gyro, PIDSource{
	
	private static AHRS ahrs = null;
	private double previousAngle;
	private double currentAngle;
	
	public AHRSGyro(){
		previousAngle = ahrs.getYaw() < 0 ? (180 - ahrs.getYaw())%360 : ahrs.getYaw();
	}
	
	@Override
	public void calibrate() {
		
	}
	
	@Override
	public void free() {
		ahrs.free();
	}
	
	@Override
	public double getAngle(){
		currentAngle = ahrs.getYaw() < 0 ? (180 - ahrs.getYaw())%360 : ahrs.getYaw();
		double out = currentAngle - previousAngle;
		previousAngle = currentAngle;
		return out;
	}
	
	@Override
	public double getRate() {
		return ahrs.getRawGyroX();
	}
	
	@Override
	public void reset() {
		ahrs.zeroYaw();
		currentAngle = ahrs.getAngle();
		previousAngle = currentAngle;
	}
	
	@Override
	public double pidGet() {
		return getAngle();
	}
}
