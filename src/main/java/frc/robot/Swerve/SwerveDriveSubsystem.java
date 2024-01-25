package frc.robot.Swerve;

import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModule;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModule.DriveRequestType;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import com.kauailabs.navx.frc.AHRS;

public class SwerveDriveSubsystem extends SubsystemBase
{

    // Attributes
    SwerveDriveKinematics kinematics;
    SwerveDriveOdometry   odometry;
    SwerveModule[]        swerveModules; // Psuedo-class representing swerve modules.
    AHRS                  gyro;
    
    // Constructor
    public SwerveDriveSubsystem() 
    {
    
        swerveModules = new SwerveModule[4]; // Psuedo-code; Create swerve modules here.
        
        // Create SwerveDriveKinematics object
        // Translation2d(x,y) == Translation2d(front, left)
        //TODO get distance from modules to gyro, put below
        kinematics = new SwerveDriveKinematics(
            new Translation2d(Units.inchesToMeters(12.5), Units.inchesToMeters(12.5)), // Front Left
            new Translation2d(Units.inchesToMeters(12.5), Units.inchesToMeters(-12.5)), // Front Right
            new Translation2d(Units.inchesToMeters(-12.5), Units.inchesToMeters(12.5)), // Back Left
            new Translation2d(Units.inchesToMeters(-12.5), Units.inchesToMeters(-12.5))  // Back Right
        );
        
        gyro = new AHRS(); // Psuedo-constructor for generating gyroscope.

        // Create the SwerveDriveOdometry given the current angle, the robot is at x=0, r=0, and heading=0
        odometry = new SwerveDriveOdometry(
            kinematics,
            gyro.getRotation2d(), // returns current gyro reading as a Rotation2d
            new SwerveModulePosition[]{new SwerveModulePosition(), new SwerveModulePosition(), new SwerveModulePosition(), new SwerveModulePosition()},
            // Front-Left, Front-Right, Back-Left, Back-Right
            new Pose2d(0,0, new Rotation2d()) // x=0, y=0, heading=0
        );
            
    }
    
    // Simple drive function
    public void drive(double xMetersPerSecond, double yMetersPerSecond, int degreesPerSecond)
    {
        // Create test ChassisSpeeds going X = 14in, Y=4in, and spins at 30deg per second.
        ChassisSpeeds testSpeeds = new ChassisSpeeds(xMetersPerSecond, yMetersPerSecond, Units.degreesToRadians(degreesPerSecond));
        
        // Get the SwerveModuleStates for each module given the desired speeds.
        SwerveModuleState[] swerveModuleStates = kinematics.toSwerveModuleStates(testSpeeds);
        // Output order is Front-Left, Front-Right, Back-Left, Back-Right

        swerveModules[0].apply(swerveModuleStates[0], DriveRequestType.OpenLoopVoltage);
        swerveModules[1].apply(swerveModuleStates[1], DriveRequestType.OpenLoopVoltage);
        swerveModules[2].apply(swerveModuleStates[2], DriveRequestType.OpenLoopVoltage);
        swerveModules[3].apply(swerveModuleStates[3], DriveRequestType.OpenLoopVoltage);
    }
    
    // Fetch the current swerve module positions.
    public SwerveModulePosition[] getCurrentSwerveModulePositions()
    {
        return new SwerveModulePosition[]{
            new SwerveModulePosition(swerveModules[0].getPosition(true).distanceMeters, swerveModules[0].getPosition(true).angle), // Front-Left
            new SwerveModulePosition(swerveModules[1].getPosition(true).distanceMeters, swerveModules[1].getPosition(true).angle), // Front-Right
            new SwerveModulePosition(swerveModules[2].getPosition(true).distanceMeters, swerveModules[2].getPosition(true).angle), // Back-Left
            new SwerveModulePosition(swerveModules[3].getPosition(true).distanceMeters, swerveModules[3].getPosition(true).angle)  // Back-Right
        };
    }
    
    @Override
    public void periodic()
    {
        // Update the odometry every run.
        odometry.update(gyro.getRotation2d(),  getCurrentSwerveModulePositions());
    }
    
}