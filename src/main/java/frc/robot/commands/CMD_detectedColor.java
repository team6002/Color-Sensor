package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SUB_colorSensor;

public class CMD_detectedColor extends CommandBase {
    private SUB_colorSensor m_colorSensor;

    public CMD_detectedColor(SUB_colorSensor p_colorSensor )
    {
        m_colorSensor = p_colorSensor;
    }

    @Override
    public void initialize()
    {
        m_colorSensor.detectedColor();
    }

    @Override
    public boolean isFinished()
    {
        return true;
    }
}
