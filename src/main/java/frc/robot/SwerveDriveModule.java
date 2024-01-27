// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.hardware.CANcoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;

import com.revrobotics.CANSparkMax;

/** Add your docs here. */
public class SwerveDriveModule {
  CANSparkMax driveMotor;
  CANSparkMax rotateMotor;
  CANcoder encoder;
  int id;
  double alpha;
  private PIDController pidRotate;

  public SwerveDriveModule(int driveId, int rotateId, int encoderId, double alpha) {
    driveMotor = new CANSparkMax(driveId, MotorType.kBrushless);
    rotateMotor = new CANSparkMax(rotateId, MotorType.kBrushless);
    encoder = new CANcoder(encoderId);
    id = encoderId;
    this.alpha = alpha;
    this.pidRotate = new PIDController(4 / 2 / 3.14, 0, 0);
  }

  public void drive(double speed, double rotate) {
    driveMotor.set(speed);
    rotateMotor.set(rotate);
    // System.out.println(id + " " + encoder.getAbsolutePosition());
  }

  public void directionalDrive(double speed, double angle) {
    pidRotate.setSetpoint(0);
    double pos = -position() - angle;
    while (pos <= -Math.PI)
      pos += 2 * Math.PI;
    while (pos > Math.PI)
      pos -= 2 * Math.PI;
    // -0.5 < pos <= 0.5
    double s = pidRotate.calculate(pos);
    s = MathUtil.clamp(s, -0.7, 0.7);
    rotateMotor.set(s);
    driveMotor.set(speed);
  }

  private double position() {
    // position [-0.5..0.5)
    double value = encoder.getAbsolutePosition().getValueAsDouble() - alpha;
    if (value < -0.5)
      value += 1.0;
    if (value >= 0.5)
      value -= 1.0;
    return value * 2 * Math.PI;
  }

  public void reset() {
    pidRotate.setSetpoint(0);
    double s = pidRotate.calculate(-position());
    s = MathUtil.clamp(s, -0.7, 0.7);
    rotateMotor.set(s);
  }

  public void stop() {
    driveMotor.stopMotor();
    rotateMotor.stopMotor();
  }
}
