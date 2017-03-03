import javax.swing.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.*;
import java.util.Scanner;
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

        g2d.drawImage(mainImage, 0,0, getWidth(),getHeight(), this);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(temperature + "°C"), getWidth()-(13*getWidth()/16),getHeight()-(41*getHeight()/88));
        //formatter that limits the decimal place to hundredths
        Formatter change = new Formatter();
        change.format("%.2f", speed);

        g.drawString(String.valueOf(speed), getWidth()-(37*getWidth()/200), getHeight()-(5*getHeight()/16));

        //center coordinates
        int x1= 645;
        int y1 = 260;

        //for loops create grid with printed coordinates to determine points
        /*
        for(int x=0; x<=800;x+=20){

                g.drawLine(x,0,x,600);
            String xString = String.valueOf(x);

            g.drawString(xString, x,20);

        }
        for(int y=0; y<=600;y+=20){

            g.drawLine(0,y,800,y);
            String yString = String.valueOf(y);
            //String
            g.drawString(yString, 0,y);

        }
        */
        g.drawLine(x1,y1,0,0);
        /*
        int x2=0;
        int y2=0;
        if(speed<300) {
             x2 = getWidth() - (3 * getWidth() / 12);
             y2 = getHeight() - (23 * getHeight() / 50);
        }
        else if(speed<500 || speed>=300){
            x2 = getWidth() - (8 * getWidth() / 36);
            y2 = getHeight() - (28 * getHeight() / 50);
        }
        if(speed>=500){
            x2 = getWidth() - (3 * getWidth() / 36);
            y2 = getHeight() - (23 * getHeight() / 50);

        }
        */
        double yCalculated;
        //quadratic equation created to convert temperature to coordinates
        if(temperature<140) {
            yCalculated = (-.0009 * temperature * temperature) - (1.85 * temperature) + (375);
        }
        else {
            yCalculated = 95;
        }
        //finds the changing height in relation to yCalulated and the bottom of the thermometer
        double heightCalculated = Math.abs(yCalculated-380);

        g2d.setColor(Color.RED);


        g2d.fillRect(57,(int)yCalculated,20,(int)heightCalculated);

//bottom left is 55,375
        /*
        int x=getWidth()-(445*getWidth()/480);
        int y=getHeight()-(17*getHeight()/48);

        g.fillRect(x,y,23,1);
        */



       // g.drawString("Next, plug in your temperature, in this case: "+ temperature + " , to the equation: velocity = 330.64 + .6(" + temperature, getWidth()/2, (getHeight()/2)-25);
        
       

        //g.drawString("Speed of Sound at " + temperature + " degrees Celsius: " + String.valueOf(speed) + "m/s", getWidth()/2, getHeight()/2);
        

    }
}
