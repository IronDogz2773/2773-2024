package frc.robot.Subsystems.MainSubsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class TestDriveSubsystem extends SubsystemBase {
  // private final DifferentialDrive m_robotDrive = new
  // DifferentialDrive(m_leftMotor, m_rightMotor);
  // Above is our old DifferentialDrive, now we are using MotorControllerGroups
  // specific drive motors
  private  CANSparkMax leftForMotor = new CANSparkMax(Constants.leftForWheelsCANID, MotorType.kBrushless);
  private  CANSparkMax rightForMotor = new CANSparkMax(Constants.rightForWheelsCANID, MotorType.kBrushless);
  private final CANSparkMax leftBackMotor = new CANSparkMax(Constants.leftBackWheelsCANID, MotorType.kBrushless);
  private final CANSparkMax rightBackMotor = new CANSparkMax(Constants.rightBackWheelsCANID, MotorType.kBrushless);
  private final DifferentialDrive mainDrive = new DifferentialDrive(leftForMotor, rightForMotor);

  //private final MotorControllerGroup leftGroup = new MotorControllerGroup(leftBackMotor, leftForMotor);
 // private final MotorControllerGroup rightGroup = new MotorControllerGroup(rightBackMotor, rightForMotor);
  //private final DifferentialDrive mainDrive = new DifferentialDrive(leftGroup, rightGroup);

  /** Creates a new DriveSubsystem. */
  public TestDriveSubsystem() {
      leftBackMotor.follow(leftForMotor);
      rightBackMotor.follow(rightForMotor);

    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
      rightForMotor.setInverted(true);
      rightBackMotor.setInverted(true);

  }

  @Override
  public void periodic() {
  }

  public boolean lowSpeed;
  public boolean isMoving;

  public void changeSpeedMode() {
    if (lowSpeed = false) {
      lowSpeed = true;
    }
    if (lowSpeed = true) {
      lowSpeed = false;
    }
  }

  public void arcadeDrive(double speed, double rotation) {
    mainDrive.arcadeDrive(speed, rotation);
  }

  public void rotation(double speed) {
    mainDrive.tankDrive(speed, -speed);
  }

  // Drive with tank drive
  public void driveLine(double speed) {
    mainDrive.tankDrive(speed, speed);
  }

  public void driveSlow()
  { mainDrive.tankDrive(0.2,0.2);
}

  public void stopAllDrive() {
    mainDrive.tankDrive(0, 0);
  }

  public void driveBack() {
    mainDrive.tankDrive(-0.3, -0.3);
  }
}
// end