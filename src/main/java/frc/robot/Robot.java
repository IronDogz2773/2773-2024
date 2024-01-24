// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.CANcoderConfigurator;
import com.ctre.phoenix6.configs.MagnetSensorConfigs;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.signals.AbsoluteSensorRangeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  private CANcoder     absoluteEncoder;

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
    absoluteEncoder = new CANcoder(/* Change this to the CAN ID of the CANcoder */ 0);
    CANcoderConfigurator cfg = absoluteEncoder.getConfigurator();
    cfg.apply(new CANcoderConfiguration());
    MagnetSensorConfigs  magnetSensorConfiguration = new MagnetSensorConfigs();
    cfg.refresh(magnetSensorConfiguration);
    cfg.apply(magnetSensorConfiguration.withAbsoluteSensorRange(AbsoluteSensorRangeValue.Unsigned_0To1).withSensorDirection(SensorDirectionValue.CounterClockwise_Positive));
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    StatusSignal<Double> angle = absoluteEncoder.getAbsolutePosition().waitForUpdate(0.1);

    System.out.println("Absolute Encoder Angle (degrees): " + Units.rotationsToDegrees(angle.getValue()));
  
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

 @Override
  public void teleopPeriodic() {}
 
  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}
}
