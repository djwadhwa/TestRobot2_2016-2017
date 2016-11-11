package org.usfirst.frc.team948.utilities;

public class Mathutil {
	public static int clamp(double input, double min, double max){
		if(input < min){
			return min;
		}
		else if(input > max){
			return max;
		}
		return input;
}
