// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SUBUnderglow extends SubsystemBase {

  AddressableLED lightStrand;
  AddressableLEDBuffer lightBuffer;

  /** Creates a new SUBunderglow. */
  public SUBUnderglow() {
    lightStrand = new AddressableLED(Constants.strandPort);
    lightBuffer = new AddressableLEDBuffer(Constants.strandLength);

    lightStrand.setLength(Constants.strandLength);

    lightStrand.start();
  }

  public void set_full_strand(int R,int G,int B){
    SmartDashboard.putNumber("R", R);
    SmartDashboard.putNumber("G", G);
    SmartDashboard.putNumber("B", B);
    for(int i = 0; i<Constants.strandLength; i++){
        lightBuffer.setRGB(i,R,G,B);
    }
    lightStrand.setData(lightBuffer);
  }


  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
