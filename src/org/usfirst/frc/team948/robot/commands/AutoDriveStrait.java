package org.usfirst.frc.team948.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team948.robot.RobotMap;

public class AutoDriveStrait extends Command {
	
	static final double powerToSpeed = 1;
	
	static final double defualtPower = 1;
	
	static final double defualtTime = 1;
	
	Timer timer = new Timer();
	
	boolean commandStop = true;
	
	final double power;
	
	final double time;
	
	final double distance;
	
	public AutoDriveStrait(double power,double time){
		requires(drive);
		this.power = power;
		this.time = time;
		distance = powerToSpeed*power*time;
		
	}
	
	public AutoDriveStrait(double distance,double time){
		requires(drive);
		this.time = time;
		this.distance = distance;
		power = distance/(time*powerToSpeed);
	}
	
	public AutoDriveStrait(double distance,double power){
		requires(drive);
		this.power = power;
		this.distance = distance;
		time = distance/(power*powerToSpeed);
	}
	
	public AutoDriveStrait(double distance){
		requires(drive);
		this.distance = distance;
		power = defualtPower;
		time = distance/(power*powerToSpeed);
	}
	
	public AutoDriveStrait(double time){
		requires(drive);
		this.time = time;
		power = defualtPower;
		distance = powerToSpeed*power*time;
	}
	
	public AutoDriveStait(double power){
		requires(drive);
		time = defualtTime;
		this.power = power;
		commandStop = false;
		distance = Double.MAX_VALUE;	
	}
	
	public AutoDriveStrait(){
		requires(drive);
		time = defualtTime;
		power = defualtPower;
		distance = powerToSpeed*power*time;
	}
	
    protected void initialize() {
    	drive.rawStop();
    	timer.reset();
    	timer.start();
    }
    
    protected void execute() {
    	double remainingTime = time - timer.get();
    	double newPower = power;
    	 if(remainingTime <= 1){
    		 newPower = newPower * remainingTime;
    	 }
    	 drive.rawTankDrive(newPower, newPower);
    }
    
    protected boolean isFinished() {
        return (timer.get() > time) && commandStop;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    	end();
    }
}
