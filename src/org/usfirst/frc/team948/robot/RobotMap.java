package org.usfirst.frc.team948.robot;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Encoder;

import com.kauailabs.navx.frc.AHRS;

import org.usfirst.frc.team948.utilities.AHRSGyro;
import org.usfirst.frc.team948.utilities.AHRSAccelerometer;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static Victor backLeftMotor = new Victor(3);
	public static Victor frontLeftMotor = new Victor(2);
	public static Victor backRightMotor = new Victor(1);
	public static Victor frontRightMotor = new Victor(0);
	
	public static AHRS robotAHRS = new AHRS(SPI.Port.kMXP);
	public static AHRSGyro robotGyro = new AHRSGyro();
	public static AHRSAccelerometer robotAccelerometer = new AHRSAccelerometer();
	
	//To check values
	public static Encoder rightEncoder = new Encoder(2,3);
	//To check values
	public static Encoder leftEncoder = new Encoder(0,1);
}
