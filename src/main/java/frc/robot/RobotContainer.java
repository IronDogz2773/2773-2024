// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Commands.TestDriveCommand;
import frc.robot.Constants.Constants;
import frc.robot.Subsystems.MainSubsystems.MainDriveSubsystem;
import frc.robot.Subsystems.TestSubsystems.TestDriveSubsystem;

public class RobotContainer {
    private final XboxController main_stick = new XboxController(0);
    private final XboxController second_stick = new XboxController(1);
    private final TestDriveSubsystem testDriveSubsystem = new TestDriveSubsystem();
    private final TestDriveCommand testDriveCommand = new TestDriveCommand(testDriveSubsystem, main_stick, second_stick);
    private final MainDriveSubsystem mainDriveSubsystem = new MainDriveSubsystem();

  public RobotContainer() {
    configureBindings();
    if(Constants.IsTestRobot) {
    testDriveSubsystem.setDefaultCommand(testDriveCommand);}
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
