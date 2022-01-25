package frc.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SUB_navxColorSensor extends SubsystemBase{
    private final I2C.Port navi2c = I2C.Port.kMXP;
    private final ColorSensorV3 m_ColorSensorV3 = new ColorSensorV3(navi2c);
    private final ColorMatch m_colorMatcher = new ColorMatch();
    // private Color targetColor = m_ColorSensorV3.getColor();
    private String colorString = "";
    private ColorMatchResult match = m_colorMatcher.matchClosestColor(getSensorColor());

    public SUB_navxColorSensor()
    {
        m_colorMatcher.addColorMatch(Color.kBlue);
        m_colorMatcher.addColorMatch(Color.kRed);
    }

    public String getColor()
    {
        return colorString;
    }

    public Color getSensorColor()
    {
        return m_ColorSensorV3.getColor();
    }

    public void detectedColor()
    {
        match = m_colorMatcher.matchClosestColor(getSensorColor());
        if(match.color == Color.kBlue)
        {
            colorString = "Blue";
        } 
        else if(match.color == Color.kRed)
        {
            colorString = "Red";
        }
        else
        {
            colorString = "unknown";
        }
        
    }

    @Override
    public void periodic()
    {
         SmartDashboard.putString("Detected Color for navx", colorString);
         detectedColor();
    }
}
