package org.usfirst.frc.team948.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command {
	private double p, i , d;
	private PIDController distancePID = new PIDController(p, i, d, null, null); 
	
	
	protected void initialize() {
		
	}	
	
	
	protected void execute() {
		
		
	}
	
	
	protected boolean isFinished() {
		
		return false;
	}
	
	
	protected void end() {

		
	}

	protected void interrupted() {
		
	}







}
