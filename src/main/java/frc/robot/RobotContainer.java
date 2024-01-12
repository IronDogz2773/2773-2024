// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Commands.TestDriveCommand;
import frc.robot.Subsystems.MainSubsystems.TestDriveSubsystem;

public class RobotContainer {
    private final XboxController main_stick = new XboxController(0);
    private final XboxController second_stick = new XboxController(1);
    private final TestDriveSubsystem driveSubsystem = new TestDriveSubsystem();
    private final TestDriveCommand driveCommand = new TestDriveCommand(driveSubsystem, main_stick, second_stick);






  public RobotContainer() {
    configureBindings();

    driveSubsystem.setDefaultCommand(driveCommand);
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
