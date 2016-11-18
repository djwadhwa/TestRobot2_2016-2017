package org.usfirst.frc.team948.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team948.subsystems.Drive;

public class AutoDriveStrait extends Command {
	
	static final double powerToSpeed = 1;
	
	static final double runToTime = 1;
	
	static final double defualtPower = 1;
	
	static final double defualtTime = 1;
	
	boolean commandStop = true;
	
	final double power;
	
	final double time;
	
	final double distance;
	
	double runCount;
	
	public AutoDriveStrait(double power,double time){
		this.power = power;
		this.time = time;
		distance = powerToSpeed*power*time;
		
	}
	
	public AutoDriveStrait(double distance,double time){
		this.time = time;
		this.distance = distance;
		power = distance/(time*powerToSpeed);
	}
	
	public AutoDriveStrait(double distance,double power){
		this.power = power;
		this.distance = distance;
		time = distance/(power*powerToSpeed);
	}
	
	public AutoDriveStrait(double distance){
		this.distance = distance;
		power = defualtPower;
		time = distance/(power*powerToSpeed);
	}
	
	public AutoDriveStrait(double time){
		this.time = time;
		power = defualtPower;
		distance = powerToSpeed*power*time;
	}
	
	public AutoDriveStait(double power){
		time = defualtTime;
		this.power = power;
		commandStop = false;
		distance = Double.MAX_VALUE;	
	}
	
	public AutoDriveStrait(){
		time = defualtTime;
		power = defualtPower;
		distance = powerToSpeed*power*time;
	}
	
	
}
