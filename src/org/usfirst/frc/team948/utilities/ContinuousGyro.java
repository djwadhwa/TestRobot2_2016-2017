package org.usfirst.frc.team948.utilities;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI.Port;

public class ContinuousGyro extends AHRS {

	public ContinuousGyro(Port spi_port_id) {
		super(spi_port_id);
		// TODO Auto-generated constructor stub
	}

	public double pidGet(){
		return getAngle();
	}
}
