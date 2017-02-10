import javax.swing.*;
import java.awt.*;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Graphics;
import javax.imageio.ImageIO;






public class SpeedofSound2 extends UpdatableComponent 
{ 
private double temperature;
private double speed;
//private Image speedImage;
//private Image tempImage;
    private Image mainImage;
private JPanel SpeedOfSoundPanel;
    public SpeedofSound2(double temperature, JPanel SpeedOfSoundPanel){
    
    	super();
    	this.SpeedOfSoundPanel=SpeedOfSoundPanel;
        this.temperature=temperature;
        try
        {

            mainImage = ImageIO.read(new File("SpeedOfSound.png"));
            //speedImage = ImageIO.read(new File("speedGauge.png"));

        } catch (IOException ex)
        {
            Logger.getLogger(SpeedOfSoundPanel.class.getName()).log(Level.WARNING,null,ex);
        }
        /*
        try
        {
            tempImage = ImageIO.read(new File("thermometer.png"));

        } catch (IOException ex)
        {
            Logger.getLogger(SpeedOfSoundPanel.class.getName()).log(Level.WARNING,null,ex);
        }
        */

        
    }
  
    public void setTemperature(double temperature){
      this.temperature=temperature;
    }
    public void update(){
    	repaint();
    }
    public void setSpeed(double speed){
        this.speed= speed;
    }
    public void calculate(double temperature){
    speed=330.64+(.6*temperature);

    }
	public void paint(Graphics g) 
    {
    	 Graphics2D g2d = (Graphics2D)g;
        g.setColor(Color.WHITE);

        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(Color.BLACK);
        //g2d.drawImage(speedImage, (getWidth()/2)-150,(getHeight()/2)-150, 300,300, this);
        //g2d.drawImage(tempImage, 0,(getHeight()/2)-159, 159,318, this);
        g2d.drawImage(mainImage, 0,0, getWidth(),getHeight(), this);
        /// /g.drawString("First, you must know the Speed Of Sound Equation: velocity = 330.64 + .6(x degrees celsius)", (getWidth()/2)-100, (getHeight()/2)-50);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(temperature), 170,243);
        g.drawString(String.valueOf(speed), 700, 500);
       // g.drawString("Next, plug in your temperature, in this case: "+ temperature + " , to the equation: velocity = 330.64 + .6(" + temperature, getWidth()/2, (getHeight()/2)-25);
        
       

        //g.drawString("Speed of Sound at " + temperature + " degrees Celsius: " + String.valueOf(speed) + "m/s", getWidth()/2, getHeight()/2);
        

    }
}
