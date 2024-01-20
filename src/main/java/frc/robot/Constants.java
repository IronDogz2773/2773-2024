package frc.robot;

//import com.revrobotics.CANSparkLowLevel;

public class Constants {
    public static final boolean isTestRobot = true;

    public static final double balanceSpeed = 0.3;
    public static final double dpadSpeed = 0.3;

    public static final double speedIncrease = 0.9;
    // constants for the CANIDs
    public static final int leftFrontWheelCANID = 15;
    public static final int rightFrontWheelCANID = 13;
    public static final int leftBackWheelCANID = 14;
    public static final int rightBackWheelCANID = 20;

    public static final double speedFactor = 0.4;
    public static final double speedFactorLow = 0.3;
    public static final double speedFactorHigh = 0.5;
    
    public static final double rotationFactor = 0.4;
    public static final double rotationFactorLow = 0.3;
    public static final double rotationFactorHigh = 0.5;
    
    public static final int firstMotorTestingCANID = 11;
    public static final int secondMotorTestingCANID = 19;
    public static final double motorTestingSpeed = 0.4;
    public static final double slowMotorTestingSpeed = 0.2;

    public static final int PnuematicsPort1 = 7;
    public static final int PnuematicsPort2 = 6;
}
