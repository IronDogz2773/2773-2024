// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.TestBot.TestDriveSubsystem;
import frc.robot.TestBot.TestDriveCommand;
import frc.robot.Constants.IConstants;
import frc.robot.Constants.TestConstants;
import frc.robot.Constants.MainConstants;


public class RobotContainer {

  private static RobotContainer instance;

  private final IConstants constants = new TestConstants();
  //private final IConstants constants = new MainConstants();

  private final XboxController mainStick = new XboxController(0);
  private final XboxController secondStick = new XboxController(1);
  private final TestDriveSubsystem testDriveSubsystem = new TestDriveSubsystem();
  private final TestDriveCommand testDriveCommand = new TestDriveCommand(testDriveSubsystem, mainStick, secondStick);
    
  public RobotContainer() {
    instance=this;
    configureBindings();
    if(constants.isTestRobot()) {
      testDriveSubsystem.setDefaultCommand(testDriveCommand);
    }
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

  // GET INSTANCE
  public static RobotContainer getInstance() {
    return instance;
  }

  public IConstants getConstants() {
    return constants;
  }

}
