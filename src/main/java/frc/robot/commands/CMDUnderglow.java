// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.SUBUnderglow;
import edu.wpi.first.math.MathUtil;
public class CMDUnderglow extends CommandBase {
  Timer lightTimer = new Timer();

  SUBUnderglow subGlow;

  /** Creates a new CMDUnderglow. */
  public CMDUnderglow(SUBUnderglow subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    subGlow = subsystem;
    addRequirements(subGlow);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    lightTimer.reset();
    lightTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    int[] breatheRGB = getBreatheColor(Constants.yellowRGB, Constants.blueRGB, lightTimer.get());
    subGlow.set_full_strand(breatheRGB[0], breatheRGB[1], breatheRGB[2]); //pass the color to the strand
  }

  int[] getBreatheColor(int[] yellow, int[] blue, double time){
    double controlValue = Math.IEEEremainder(time, 2); //https://stackoverflow.com/questions/26671975/why-do-we-need-ieee-754-remainder
    double yellowness = MathUtil.clamp(controlValue,0,1);
    double blueness = MathUtil.clamp(-controlValue,0,1);

    int[] ret = {0,0,0};
    
    for(int i = 0; i<3; i++){
      ret[i] =(int) dualLerp(yellow[i],blue[i],yellowness,blueness); //cast the component value to an int so we can use it
    }

    return ret;
  }

  double dualLerp(double value1,double value2,double pos1,double pos2){//lerp for one component 
    return lerp(0,value1,pos1) + lerp(0,value2,pos2);//at least one lerp should always be zero
  }

  public static double lerp(double a, double b, double f) {//convenience function from http://www.java2s.com/example/java-utility-method/lerp/lerp-double-a-double-b-double-f-4ce8e.html
    return a + f * (b - a);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
