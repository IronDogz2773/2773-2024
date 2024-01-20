// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Constants.Constants;



public class RobotContainer {
  private final XboxController mainStick = new XboxController(0);
  private final XboxController secondStick = new XboxController(1);
  private final MainDriveSubsystem mainDriveSubsystem = new MainDriveSubsystem();

  public RobotContainer() {
    configureBindings();
    if(!Constants.isTestRobot) {
    }
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

}
