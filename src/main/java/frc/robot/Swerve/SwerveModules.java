package frc.robot.Swerve;

import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrain;
import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrainConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants;

public class SwerveModules {
    //Instantiating drivetrain object. If you want to access indivual
    //modules, use getModule​(int index).
    SwerveModuleConstants swerveConstants = new SwerveModuleConstants();
    SwerveDrivetrainConstants swerveDrivetrainConstants = new SwerveDrivetrainConstants();
    SwerveDrivetrain driveTrain = new SwerveDrivetrain(swerveDrivetrainConstants, swerveConstants);
}
