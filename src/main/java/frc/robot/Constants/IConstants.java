package frc.robot.Constants;

public interface IConstants {
    boolean isTestRobot();

    double getBalanceSpeed();
    double getDpadSpeed();
    double getSpeedIncrease();

    int getLFWheelsCANID();
    int getRFWheelsCANID();
    int getLBWheelsCANID();
    int getRBWheelsCANID();

    double getSpeedFactor();
    double getSpeedFactorLow();
    double getSpeedFactorHigh();
    double getRotationFactor();
    double getRotationFactorLow();
    double getRotationFactorHigh();

    int getFirstMotorTestingCANID();
    int getSecondMotorTestingCANID();

    double getMotorTestingSpeed();
    double getSlowMotorTestingSpeed();

    int getPnuematicsPort1();
    int getPnuematicsPort2();

}