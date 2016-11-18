package org.usfirst.frc.team948.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team948.subsytems.Drive;

import org.usfirst.frc.team948.robot.Robot;

public class AutoDriveStrait extends Command {
	
	static final double powerToSpeed = 1;
	
	static final double defualtPower = 1;
	
	static final double defualtTime = 1;
	
	Timer timer = new Timer();
	
	final int constructorValue;
	
	final double power;
	
	final double time;
	
	final double distance;
	
	public AutoDriveStrait(double power,double time){
		requires(drive);
		this.power = power;
		this.time = time;
		constructorValue = 0;
		distance = powerToSpeed*power*time;
		
	}
	
	public AutoDriveStrait(double distance,double time){
		requires(Robot.drive);
		this.time = time;
		this.distance = distance;
		constructorValue = 1;
		power = distance/(time*powerToSpeed);
	}
	
	public AutoDriveStrait(double distance,double power){
		requires(drive);
		this.power = power;
		this.distance = distance;
		constructorValue = 2
		time = distance/(power*powerToSpeed);
	}
	
	public AutoDriveStrait(double distance){
		requires(Robot.drive);
		this.distance = distance;
		power = defualtPower;
		constructorValue = 3;
		time = distance/(power*powerToSpeed);
	}
	
	public AutoDriveStrait(double time){
		requires(Robot.drive);
		this.time = time;
		power = defualtPower;
		constructorValue = 4;
		distance = powerToSpeed*power*time;
	}
	
	public AutoDriveStait(double power){
		requires(Robot.drive);
		time = defualtTime;
		this.power = power;
		constructorValue = 5;
		distance = Double.MAX_VALUE;	
	}
	
	public AutoDriveStrait(){
		requires(Robot.drive);
		time = defualtTime;
		power = defualtPower;
		distance = powerToSpeed*power*time;
	}
	
    protected void initialize() {
    	Robot.drive.rawStop();
    	timer.reset();
    	timer.start();
    }
    
    protected void execute() {
    	double remainingTime = time - timer.get();
    	double newPower = power;
    	 if(remainingTime <= 1){
    		 newPower = newPower * remainingTime;
    	 }
    	 Robot.drive.rawTankDrive(newPower, newPower);
    }
    
    protected boolean isFinished() {
    	boolean output = constructorValue == 5 ? false : timer.get() > time;
        return output;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    	end();
    }
}
