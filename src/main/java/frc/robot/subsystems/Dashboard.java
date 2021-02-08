package frc.robot.subsystems;

import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * This class is for Displaying Data to user
 * @author Nicholas Blackburn
 */

public class Dashboard extends SubsystemBase {
    
    // Encoder Entrys in the nwtwork tables 
    private NetworkTableEntry rightEncoderEntry;
    private NetworkTableEntry leftEncoderEntry;

    // Gyro Network Table entrys
    private NetworkTableEntry  gyroEntry;
    private NetworkTableEntry accelerationEntry;

    // Button I.O network entrys
    private NetworkTableEntry onBoardButtonAEntry;
    private NetworkTableEntry onBoardButtonBEntry;
    private NetworkTableEntry onBoardButtonCEntry;





    private Drivetrain romidrivetrain;
    private OnBoardIO onBoardIO;
    
    
    public Dashboard(Drivetrain drivetrain, OnBoardIO boardio){
        this.romidrivetrain = drivetrain;
        this.onBoardIO = boardio;
        // Quick and easy way of showing teleop dashboard on start up
        // but you could add the dashboard at lets say robot init or auto init if you have an auto dashboard
        showTeleopDashData();
    }

    // The Telop Dashboard that display all the robots data to the user in a gui Based way

    public void showTeleopDashData(){
        // Sends Simple Log to Console for telling user about opend
        DriverStation.reportWarning("[Teleop DashBoard]" + "TeleOPMode for Dashboard is enabled", false);
        
        // Declares new Shuffleboard tab
        final ShuffleboardTab Teleop_Dashboard = Shuffleboard.getTab(Constants.DashboardTeleopName);
        
        final ShuffleboardLayout ButtonStatusList = Shuffleboard.getTab(Constants.DashboardTeleopName)
        .getLayout("Button Status", BuiltInLayouts.kList)
        .withSize(2, 3)
        .withPosition(3, 3)
        .withProperties(Map.of("Label position", "TOP"));  

        // adds Right Encoder Entry  to Teleop Dash
        rightEncoderEntry = Teleop_Dashboard.add("Right Encoder", false).withSize(2, 1).withPosition(0, 0)
                .withWidget(BuiltInWidgets.kEncoder).getEntry();

        // adds Right Encoder Entry  to Teleop Dash
        leftEncoderEntry = Teleop_Dashboard.add("Left Encoder", false).withSize(2, 1).withPosition(0, 2)
                .withWidget(BuiltInWidgets.kEncoder).getEntry();

        

        gyroEntry = Teleop_Dashboard.add("Gyro Data", false).withSize(2, 2).withPosition(4, 0)
            .withWidget(BuiltInWidgets.kEncoder).getEntry();

        accelerationEntry = Teleop_Dashboard.add("Acceleration Graph", false).withSize(3, 3).withPosition(7, 0)
            .withWidget(BuiltInWidgets.kGraph).getEntry();
    
    
        // adds IO Buttons From romi to Dashbioard
        onBoardButtonAEntry = ButtonStatusList.add("Onboard Button A", false).withSize(2, 1)
            .withWidget(BuiltInWidgets.kEncoder).getEntry();

        
        
        onBoardButtonBEntry = ButtonStatusList.add("Onboard Button A", false).withSize(2, 1)
            .withWidget(BuiltInWidgets.kEncoder).getEntry();

        
        onBoardButtonCEntry = ButtonStatusList.add("Onboard Button A", false).withSize(2, 1)
            .withWidget(BuiltInWidgets.kEncoder).getEntry();
    }

    // this keeps all the dashboard data updated so the user has accurate info from robot
    public void dashboardData() {
        // Encoder Data -> pushed to network tables every 10 ms
        rightEncoderEntry.setValue(romidrivetrain.getRightEncoder());
        leftEncoderEntry.setValue(romidrivetrain.getLeftEncoder());

        // Gyro & acceleration entry data -> pushed to network tables every 10 ms
        gyroEntry.setValue(romidrivetrain.getGryoScope());
        accelerationEntry.setValue(romidrivetrain.getAccelerometer());
        
        onBoardButtonAEntry.setBoolean(onBoardIO.getButtonAPressed());
        onBoardButtonBEntry.setBoolean(onBoardIO.getButtonBPressed());
        onBoardButtonCEntry.setBoolean(onBoardIO.getButtonCPressed());

        
    }

}
