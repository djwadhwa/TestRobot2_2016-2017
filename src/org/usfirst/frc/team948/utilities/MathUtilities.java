package org.usfirst.frc.team948.utilities;

public class MathUtilities {
	public static double clamp(double input, double min, double max){
		if(input < min){
			return min;
		}
		else if(input > max){
			return max;
		}
		return input;
	}
	
	public static double deadband(double value, double deadbandMin){
		return (Math.abs(value) < Math.abs(deadbandMin)) ? 0 : value;
	}
}
