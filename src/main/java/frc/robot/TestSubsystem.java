// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.hardware.CANcoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TestSubsystem extends SubsystemBase {
  SwerveDriveModule n1 = new SwerveDriveModule(17, 21, 52, 0.111083984375);
  SwerveDriveModule n2 = new SwerveDriveModule(10, 11, 54, 0.13037109375);
  SwerveDriveModule n3 = new SwerveDriveModule(22, 23, 55,  -0.43115234375);
  SwerveDriveModule n4 = new SwerveDriveModule(19, 12, 53, 0.244873046875);
  
  /** Creates a new TestSubsystem. */
  public TestSubsystem() {}

  @Override
  public void periodic() {
  }

  public void drive(double speed, double rotate) {
    n1.drive(speed, rotate);
    n2.drive(speed, rotate);
    n3.drive(speed, rotate);
    n4.drive(speed, rotate);
  }

  public void directionalDrive(double speed, double angle) {
    n1.directionalDrive(speed, angle);
    n2.directionalDrive(speed, angle);
    n3.directionalDrive(speed, angle);
    n4.directionalDrive(speed, angle);
  }

  public void reset() {
    n1.reset();
    n2.reset();
    n3.reset();
    n4.reset();
  }

  public void stop() {
    n1.stop();
    n2.stop();
    n3.stop();
    n4.stop();
  }
}
