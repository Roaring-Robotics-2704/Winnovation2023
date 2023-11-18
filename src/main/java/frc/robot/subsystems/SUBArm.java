// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.Constants;
import frc.robot.commands.*;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import javax.swing.text.StyleContext.SmallAttributeSet;

import com.ctre.phoenix.motorcontrol.ControlMode;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
 import com.ctre.phoenix.motorcontrol.FeedbackDevice;
 import com.ctre.phoenix.motorcontrol.NeutralMode;
 import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class SUBArm extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private WPI_TalonSRX talonSRXEnhanced1;
private Encoder encoder = new Encoder(0, 1,true,EncodingType.k4X);
PIDController pid = new PIDController(Constants.kP, Constants.kI, Constants.kD);
private double pos = 0;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public SUBArm() {

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
talonSRXEnhanced1 = new WPI_TalonSRX(3);

    /* Factory default hardware to prevent unexpected behavior */
talonSRXEnhanced1.configFactoryDefault();

        /* Invert Motor? and set Break Mode */
talonSRXEnhanced1.setInverted(false);
talonSRXEnhanced1.setNeutralMode(NeutralMode.Brake);

        /* Set the peak and nominal outputs */
talonSRXEnhanced1.configNominalOutputForward(0, 30);
talonSRXEnhanced1.configNominalOutputReverse(0, 30);
talonSRXEnhanced1.configPeakOutputForward(1, 30);
talonSRXEnhanced1.configPeakOutputReverse(-1, 30);


        
/* Configure Sensor */
        // Phase sensor to have positive increment when driving Talon Forward (Green LED)


        











        


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {

        // This method will be called once per scheduler run
        SmartDashboard.putNumber("armpid", -pid.calculate(-encoder.getRaw(), pos));
        SmartDashboard.putNumber("ArmSensorPos", encoder.getDistance());
        SmartDashboard.putNumber("arm distance per pulse",encoder.getDistancePerPulse());
        SmartDashboard.putNumber("arm encoding scale",encoder.getEncodingScale());

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void setPosition(double pos, double measurement) {
        talonSRXEnhanced1.set(-pid.calculate(measurement, pos));
        this.pos = pos;
        };

    public void setPower(double pos) {
        talonSRXEnhanced1.set(pos);
        };

    public double getEncoderPos() {
        return encoder.getDistance();
    }

}
