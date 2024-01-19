package frc.robot.TestBot;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import frc.robot.RobotContainer;

public class TestRotateMotorsCommand {
    private  CANSparkMax motorToTurn1 = new CANSparkMax(RobotContainer.getInstance().getConstants().getFirstMotorTestingCANID(), MotorType.kBrushless);
    private CANSparkMax motorToTurn2 = new CANSparkMax(RobotContainer.getInstance().getConstants().getSecondMotorTestingCANID(), MotorType.kBrushless);

    
}
