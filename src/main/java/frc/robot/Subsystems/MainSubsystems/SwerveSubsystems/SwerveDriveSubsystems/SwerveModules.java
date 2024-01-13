package frc.robot.Subsystems.MainSubsystems.SwerveSubsystems.SwerveDriveSubsystems;

import com.ctre.phoenix6.mechanisms.swerve.SwerveModule;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants;
import edu.wpi.first.math.kinematics.SwerveModuleState;

public class SwerveModules {
    SwerveModuleConstants frontLeftCons = new SwerveModuleConstants();
    SwerveModuleState frontLeftState = new SwerveModuleState();
    SwerveModule frontLeft = new SwerveModule(frontLeftCons, "14");
    SwerveModuleConstants frontRightCons = new SwerveModuleConstants();
    SwerveModuleState frontRightState = new SwerveModuleState();
    SwerveModule frontRight = new SwerveModule(frontRightCons, "14");
    SwerveModuleConstants backLeftCons = new SwerveModuleConstants();
    SwerveModuleState backLeftState = new SwerveModuleState();
    SwerveModule backLeft = new SwerveModule(backLeftCons, "14");
    SwerveModuleConstants backRightCons = new SwerveModuleConstants();
    SwerveModuleState backRightState = new SwerveModuleState();
    SwerveModule backRight = new SwerveModule(backRightCons, "14");
}
