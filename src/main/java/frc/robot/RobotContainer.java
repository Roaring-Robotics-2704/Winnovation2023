// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.Utils.RoaringUtils;
import frc.Utils.RoaringUtils.DeadzoneUtils;
import frc.robot.commands.CMDControlArm;
import frc.robot.commands.CMDDriveRobot;
import frc.robot.subsystems.SUBArm;
import frc.robot.subsystems.SUBDrivetrain;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    public final SUBArm kArm = new SUBArm();
    public final SUBDrivetrain kSUBDrivetrain = new SUBDrivetrain();

// Joysticks
private final CommandXboxController kDriver1Controller = new CommandXboxController(0);
private final CommandXboxController kDriver2Controller = new CommandXboxController(1);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  
  // A chooser for autonomous commands

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
    kSUBDrivetrain.setDefaultCommand(
      new CMDDriveRobot(
        ()->DeadzoneUtils.LinearDeadband(kDriver1Controller.getLeftY(), 0.1),
        ()->DeadzoneUtils.LinearDeadband(kDriver1Controller.getRightX(), 0.1),
        kSUBDrivetrain
      ));

        kArm.setDefaultCommand(
      new CMDControlArm(
        ()->RoaringUtils.DeadzoneUtils.LinearDeadband(kDriver2Controller.getLeftY(),0.1),
        kArm));
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems


    // SmartDashboard Buttons

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

  }

  public static RobotContainer getInstance() {
    return robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    kDriver2Controller.povLeft().onTrue(new RunCommand(()->kArm.setPosition(-180, kArm.getEncoderPos()),kArm).until(kArm::atSetpoint));
    kDriver2Controller.povRight().onTrue(new RunCommand(()->kArm.setPosition(180, kArm.getEncoderPos()),kArm).until(kArm::atSetpoint));
    kDriver2Controller.povUp().onTrue(new RunCommand(()->kArm.setPosition(0, kArm.getEncoderPos()),kArm).until(kArm::atSetpoint));

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
// Create some buttons


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
    
  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public CommandXboxController getkDriver1Controller() {
      return kDriver1Controller;
    }
public CommandXboxController getkDriver2Controller() {
      return kDriver2Controller;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return null;
  }
  

}

