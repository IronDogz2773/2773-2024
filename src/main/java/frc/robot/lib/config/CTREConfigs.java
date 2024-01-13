package frc.robot.lib.config;

import com.ctre.phoenix6.sensors.AbsoluteSensorRange;
import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.sensors.SensorInitializationStrategy;
import com.ctre.phoenix6.sensors.SensorTimeBase;
import frc.robot.Constants.Constants;

public final class CTREConfigs {
  public CANcoderConfiguration swerveCanCoderConfig;

  public CTREConfigs() {
    swerveCanCoderConfig = new CANcoderConfiguration();

    /* Swerve CANCoder Configuration */
    swerveCanCoderConfig.absoluteSensorRange = AbsoluteSensorRange.Unsigned_0_to_360;
    swerveCanCoderConfig.sensorDirection = Constants.Swerve.canCoderInvert;
    swerveCanCoderConfig.initializationStrategy =
        SensorInitializationStrategy.BootToAbsolutePosition;
    swerveCanCoderConfig.sensorTimeBase = SensorTimeBase.PerSecond;
  }
}