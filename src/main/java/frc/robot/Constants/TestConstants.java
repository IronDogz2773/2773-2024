package frc.robot.Constants;

//import com.revrobotics.CANSparkLowLevel;

public class TestConstants implements IConstants {

    public TestConstants() {

    }

    @Override
    public boolean isTestRobot() {
        return true;
    }

    //more drive command stuff
    @Override
    public double getBalanceSpeed() {
        return 0.3D;
    }
    @Override
    public double getDpadSpeed() {
        return 0.3D;
    }
    @Override
    public double getSpeedIncrease() {
        return 0.9D;
    }

    // constants for the CANIDs
    @Override
    public int getLFWheelsCANID() {
        return 15;
    }
    @Override
    public int getRFWheelsCANID() {
        return 13;
    }
    @Override
    public int getLBWheelsCANID() {
        return 14;
    }
    @Override
    public int getRBWheelsCANID() {
        return 20;
    }

    public double getSpeedFactor() {
        return 0.4;
    }
    
    public double getSpeedFactorLow() {
        return 0.3;
    }
    
    public double getSpeedFactorHigh() {
        return 0.5;
    }
    
    public double getRotationFactor() {
        return 0.4;
    }
    
    public double getRotationFactorLow() {
        return 0.3;
    }
    
    public double getRotationFactorHigh() {
        return 0.5;
    }
    
    public int getFirstMotorTestingCANID() {
        return 11;
    }
    
    public int getSecondMotorTestingCANID() {
        return 19;
    }
    
    public double getMotorTestingSpeed() {
        return 0.4;
    }
    
    public double getSlowMotorTestingSpeed() {
        return 0.2;
    }
    
    public int getPnuematicsPort1() {
        return 7;
    }
    
    public int getPnuematicsPort2() {
        return 6;
    }
}
