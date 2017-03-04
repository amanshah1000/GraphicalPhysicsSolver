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
        //inputs image
        try
        {
            mainImage = ImageIO.read(new File("SpeedOfSound.png"));

        } catch (IOException ex)
        {
            Logger.getLogger(SpeedOfSoundPanel.class.getName()).log(Level.WARNING,null,ex);
        }
    }
  
    public void setTemperature(double temperature){
      this.temperature=temperature;
    }

    public void update(){
    	repaint();
    }

    public void setSpeed(double speed) {
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
        //300 m/s = -215
        //400 m/s = 30


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

        double yCalculated;
        //equation created to convert temperature to coordinates
        if(temperature<100 &&temperature>-30) {
            yCalculated = (-2*temperature)+300;
        }
        //limits so temperature doesn't go off thermometer
        else if(temperature>=100){
            yCalculated = 95;
        }
        else {
            yCalculated=360;
        }
        //finds the changing height in relation to yCalculated and the bottom of the thermometer
        double heightCalculated = Math.abs(yCalculated-380);

        g2d.setColor(Color.RED);


        g2d.fillRect(57,(int)yCalculated,20,(int)heightCalculated);


        //center coordinates
        //300 m/s = -215
        //400 m/s = 30
        //350 m/s= -90

        int x1= 645;
        int y1 = 260;
        double theta;
        //created quadratic equation converting speed to a theta value
        if(speed<400 && speed>300) {
            theta = (-0.001000 * speed * speed) + (3.150 * speed) - 1070;
        }
        //limits so line doesn't go off gauge
        else if(speed>400){
            theta=30;
        }
        else {
            theta=-215;
        }

        g2d.setColor(Color.black);
        g2d.rotate(Math.toRadians(theta),x1,y1);

        g2d.drawLine(x1,y1, x1+70,y1);

    }
}
