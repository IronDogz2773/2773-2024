package frc.robot.TestBot;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.ctre.phoenix6.hardware.CANcoder;
import com.revrobotics.CANSparkMax;

import frc.robot.Constants;

public class TestRotateMotorsCommand {
    private  CANSparkMax motorToTurn1 = new CANSparkMax(Constants.firstMotorTestingCANID, MotorType.kBrushless);
    private CANSparkMax motorToTurn2 = new CANSparkMax(Constants.secondMotorTestingCANID, MotorType.kBrushless);
    private CANSparkMax testingSwerveModule1Motor = new CANSparkMax(22, MotorType.kBrushless);
    private CANSparkMax testingSwerveModule2Motor = new CANSparkMax(23, MotorType.kBrushless);
    private final CANcoder testEncoder = new CANcoder(53, "rio");

    public void runSwerveDrive() {
        testingSwerveModule1Motor.set(0.1);
    }

    public void runSwerveTurn() {
        testingSwerveModule2Motor.set(0.1);
    }

    public void stopSwerveDrive() {testingSwerveModule1Motor.set(0);}
    public void stopSwerveTurn() {testingSwerveModule2Motor.set(0);}

    public void getTestEncoder() {
        System.out.println(testEncoder.getPosition());
    }
}
