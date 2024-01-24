// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix6.hardware.TalonFX;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs
 * the motors with
 * arcade steering.
 */
public class Robot extends TimedRobot {
	private final TalonFX m_top = new TalonFX(3);
	private final TalonFX m_bottom = new TalonFX(6);
	private final Joystick m_stick = new Joystick(0);
	private double speed = 0;

	@Override
	public void disabledInit() {
		m_top.set(0);
		m_bottom.set(0);
		System.out.println("Disabled");
	}

	@Override
	public void robotInit() {
		System.out.println(m_top.getDeviceID());
		System.out.println(m_bottom.getDeviceID());
		m_top.setInverted(true);
		System.out.println("Robot init");
	}

	@Override
	public void teleopInit() {
		System.out.println("Teleop init");
	}

	@Override
	public void teleopPeriodic() {
		if (m_stick.getRawButton(1)) {
			double speed = -0.5;
			System.out.println(speed);
			m_top.set(speed);
			m_bottom.set(speed);
		} else {
			m_top.set(0);
			m_bottom.set(0);
		}
		// changeSpeed();
		// double speed = 0.6;
		// double speed_top = 0.95;
		// double speed_bottom = 1;
		// m_top.set(speed_top); // right
		// m_bottom.set(-speed_bottom); // left
	}

	private void setSpeeds() {
		if (speed > 1) {
			speed = 1;
		} else if (speed < 0) {
			speed = 0;
		}
		System.out.println(speed);
		speed = Math.round(speed * 100) / 100.0;
		if (m_stick.getRawButton(1)) {
			m_top.set(speed);
			m_bottom.set(-speed);
			System.out.println("active");
		} else {
			m_top.set(0);
			m_bottom.set(0);
		}
	}

	private void changeSpeed() {
		if (m_stick.getRawButtonPressed(5)) {
			speed += 0.1;
		}

		if (m_stick.getRawButtonPressed(3)) {
			speed -= 0.1;
		}

		if (m_stick.getRawButtonPressed(6)) {
			speed += 0.05;
		}

		if (m_stick.getRawButtonPressed(4)) {
			speed -= 0.05;
		}

		setSpeeds();
	}
}