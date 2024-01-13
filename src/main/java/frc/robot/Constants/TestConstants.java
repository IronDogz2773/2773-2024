package frc.robot.Constants;

//import com.revrobotics.CANSparkLowLevel;

public class TestConstants {
    public static boolean IsTestRobot = true;

    //more drive command stuff
    public static final double BalanceSpeed = 0.3;
    public static final double DpadSpeed = 0.3;
    public static final double SpeedIncrease = 0.9;
    
    // constants for the CANIDs
    public static final int leftForWheelsCANID = 15;
    public static final int rightForWheelsCANID = 13;
    public static final int leftBackWheelsCANID = 14;
    public static final int rightBackWheelsCANID = 20;

    // constants for MainDriveSubsystem, speed + rotation factor (was for the PWMs
    // not the Neos...)
    public static final double SpeedFactor = 0.4;
    public static final double SpeedFactorLow = 0.3;
    public static final double SpeedFactorHigh = 0.5;
    public static final double RotationFactor = 0.4;
    public static final double RotationFactorLow = 0.3;
    public static final double RotationFactorHigh = 0.5;

    // create a private class for the motorType, brushless motors, DOES NOT WORK ATM
    //public static final CANSparkLowLevel.MotorType kBrushless;

    public static final int firstMotorTestingCANID = 11;
    public static final int secondMotorTestingCANID = 19;

    public static final double motorTestingSpeed = 0.4;
    public static final double slowMotorTestingSpeed = 0.2;

    public static final int PnuematicsPort1 = 7;
    public static final int PnuematicsPort2 = 6;
}
