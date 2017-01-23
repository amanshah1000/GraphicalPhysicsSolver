
import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JComponent;



public class SpeedofSound2 extends JComponent 
{ 

private double temperature;

private double speed;

private int screenWidth;

private int screenHeight;


    public SpeedofSound2(double temperature,double speed)
    {
    	 screenWidth = 800;
         screenHeight = 600;
        this.temperature=temperature;
        this.speed=speed;
    }

    public void setTemperature(double temperature)
    {
      this.temperature=temperature;
    }

    public void setSpeed(double speed)
    {
        this.speed= speed;
    }
    public void calculate()
    {
    speed=330.64+(.6*temperature);
    }

    public void paint(Graphics g) 
    {

        g.setColor(Color.WHITE);

        g.fillRect(0, 0, getWidth(), getHeight());

        g.drawString(String.valueOf(speed), screenWidth/2, screenHeight/2);

    }
}
