package frc.robot.Swerve;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.SPI;

import com.kauailabs.navx.frc.AHRS;

public class Gyroscope {
    AHRS gyro = new AHRS(SPI.Port.kMXP);

}
