package frc.robot.TestBot;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import frc.robot.Constants;

public class TestRotateMotorsCommand {
    private  CANSparkMax motorToTurn1 = new CANSparkMax(Constants.firstMotorTestingCANID, MotorType.kBrushless);
    private CANSparkMax motorToTurn2 = new CANSparkMax(Constants.secondMotorTestingCANID, MotorType.kBrushless);

    
}
