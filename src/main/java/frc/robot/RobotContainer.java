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
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.TestBot.TestDriveSubsystem;
import frc.robot.TestBot.TestRotateMotorsCommand;
import frc.robot.TestBot.TestDriveCommand;
import frc.robot.Constants;

public class RobotContainer {
  private final XboxController mainStick = new XboxController(0);
  private final XboxController secondStick = new XboxController(1);
  private final TestDriveSubsystem testDriveSubsystem = new TestDriveSubsystem();
  private final TestDriveCommand testDriveCommand = new TestDriveCommand(testDriveSubsystem, mainStick, secondStick);
  private final TestRotateMotorsCommand testRotateMotorsCommand = new TestRotateMotorsCommand();
    InstantCommand driveSlow = new InstantCommand(testDriveSubsystem::driveSlow, testDriveSubsystem);
    InstantCommand turnSlow = new InstantCommand(testDriveSubsystem::turnSlow, testDriveSubsystem);
    InstantCommand stopAllDrive = new InstantCommand(testDriveSubsystem::stopAllDrive, testDriveSubsystem);
    InstantCommand turnSwerveModuleCommand = new InstantCommand(testRotateMotorsCommand::runSwerveTurn);
    InstantCommand driveSwerveModuleCommand = new InstantCommand(testRotateMotorsCommand::runSwerveDrive);
    InstantCommand stopDriveSwerveModuleCommand = new InstantCommand(testRotateMotorsCommand::stopSwerveDrive);
    InstantCommand stopTurnSwerveModuleCommand = new InstantCommand(testRotateMotorsCommand::stopSwerveTurn);
    InstantCommand getTestEncoderPosition = new InstantCommand(testRotateMotorsCommand::getTestEncoder);
    
  private Command driveAndTurnAutoCommand() {
    final ParallelRaceGroup driveForTwoSlow = new ParallelRaceGroup(driveSlow, new WaitCommand(2));
    final ParallelRaceGroup turnFor10Slow = new ParallelRaceGroup(turnSlow, new WaitCommand(10));
    return driveForTwoSlow.andThen(stopAllDrive).andThen(turnFor10Slow).andThen(stopAllDrive);//.andThen(driveForTwoSlow);
  }

    JoystickButton turnSwerveModule = new JoystickButton(mainStick, 1);
    JoystickButton driveSwerveModule = new JoystickButton(mainStick, 2);
    JoystickButton stopTurnSwerveModule = new JoystickButton(mainStick, 3);
    JoystickButton stopDriveSwerveModule = new JoystickButton(mainStick, 4);
    JoystickButton getTestEncoderButton = new JoystickButton(secondStick, 1);

  public RobotContainer() {
    configureBindings();
    if(Constants.isTestRobot) {
      testDriveSubsystem.setDefaultCommand(testDriveCommand);
    }
  }

  private void configureBindings() {
    
    getTestEncoderButton.onTrue(getTestEncoderPosition);
    turnSwerveModule.onTrue(turnSwerveModuleCommand);
    driveSwerveModule.onTrue(driveSwerveModuleCommand);
    stopDriveSwerveModule.onTrue(stopDriveSwerveModuleCommand);
    stopTurnSwerveModule.onTrue(stopTurnSwerveModuleCommand);


  }

  public Command getAutonomousCommand() {
    return driveAndTurnAutoCommand(); //Commands.print("No autonomous command configured");
  }
}
