// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SUBServo extends SubsystemBase {
  /** Creates a new SUBServo. */
  Servo markerServo = new Servo(2);
  Servo clawServo = new Servo(3);

  public SUBServo() {
    //not needed
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("MarkerServoPos", markerServo.getAngle());
    SmartDashboard.putNumber("ClawServoPos", clawServo.getPosition());

    // This method will be called once per scheduler run
  }
  public void setMarkerPos(double pos) {
    markerServo.setAngle(pos);
  }
  public void setClawPos(double pos) {
    clawServo.set(pos);
  }
  public void setClawDisabled() {
    clawServo.setDisabled();
  }
}
