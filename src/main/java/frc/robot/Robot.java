// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;


import com.ctre.phoenix6.hardware.TalonFX;


/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */
public class Robot extends TimedRobot {
  private final TalonFX m_leftMotor = new TalonFX(0);
  private final TalonFX m_rightMotor = new TalonFX(21);
 
  private final Joystick m_stick = new Joystick(0);
  private int count; 

  public Robot() {
    
  }

  @Override
  public void robotInit() {
    m_rightMotor.setInverted(true);
  }

  @Override
  public void teleopPeriodic() {
    
    // if(m_stick.getPOV() == 0){
    //   count++;
    //   System.out.println(count);
    // }
    // else if(m_stick.getPOV() == 180){
    //   count--;
    //   System.out.println(count);
    // }

    if(m_stick.getRawButton(1)){
      m_leftMotor.set(1);
      m_rightMotor.set(1);
    }
    else{
      m_leftMotor.set(0);
      m_rightMotor.set(0);
    }
  }
}
