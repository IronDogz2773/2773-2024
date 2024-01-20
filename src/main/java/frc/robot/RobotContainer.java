// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.TestBot.TestDriveSubsystem;
import frc.robot.TestBot.TestDriveCommand;
import frc.robot.Constants;

public class RobotContainer {
  private final XboxController mainStick = new XboxController(0);
  private final XboxController secondStick = new XboxController(1);
  private final TestDriveSubsystem testDriveSubsystem = new TestDriveSubsystem();
  private final TestDriveCommand testDriveCommand = new TestDriveCommand(testDriveSubsystem, mainStick, secondStick);
    InstantCommand driveSlow = new InstantCommand(testDriveSubsystem::driveSlow, testDriveSubsystem);
    InstantCommand turnSlow = new InstantCommand(testDriveSubsystem::turnSlow, testDriveSubsystem);
    
  private Command driveAndTurnAutoCommand() {
    final ParallelRaceGroup driveForTwoSlow = new ParallelRaceGroup(driveSlow, new WaitCommand(2));
    final ParallelRaceGroup turnFor10Slow = new ParallelRaceGroup(turnSlow, new WaitCommand(10));
    return driveForTwoSlow.andThen(turnFor10Slow).andThen(driveForTwoSlow);
  }


  public RobotContainer() {
    configureBindings();
    if(Constants.isTestRobot) {
      testDriveSubsystem.setDefaultCommand(testDriveCommand);
    }
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return driveAndTurnAutoCommand(); //Commands.print("No autonomous command configured");
  }
}
