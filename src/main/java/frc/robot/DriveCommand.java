// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class DriveCommand extends Command {
  TestSubsystem s;
  XboxController joy;
  /** Creates a new DriveCommand. */
  public DriveCommand(TestSubsystem s, XboxController joy) {
    this.s = s;
    this.joy = joy;
    addRequirements(s);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //s.drive(joy.getLeftY() * 0.4, joy.getRightX() * 0.3);
    double x = joy.getLeftX(), y = joy.getLeftY();
    double speed = Math.sqrt(x * x + y * y) * 0.4;
    double angle = Math.atan2(y, x);
    if (Math.abs(x) < 0.1 && Math.abs(y) < 0.1) {
      s.stop();
    } else {
      s.directionalDrive(speed, angle);
    } 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
