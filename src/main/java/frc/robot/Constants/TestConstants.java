package frc.robot.Constants;

import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import com.revrobotics.CANSparkLowLevel.MotorType;


public class TestConstants {
    public static boolean IsTestRobot = true;

    // constants for the CANIDs
    public static final int leftForWheelsCANID = 15;
    public static final int rightForWheelsCANID = 13;
    public static final int leftBackWheelsCANID = 14;
    public static final int rightBackWheelsCANID = 20;

    // constants for MainDriveSubsystem, speed + rotation factor (was for the PWMs
    // not the Neos...)
    public static final double SpeedFactor = 0.6;
    public static final double SpeedFactorLow = 0.3;
    public static final double SpeedFactorHigh = 0.7;
    public static final double RotationFactor = 0.4;
    public static final double RotationFactorLow = 0.3;
    public static final double RotationFactorHigh = 0.5;

    // create a private class for the motorType, brushless motors
    public static final CANSparkLowLevel.MotorType kBrushless;

}
