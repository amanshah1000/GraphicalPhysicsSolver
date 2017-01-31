
import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JComponent;

public class SpeedofSound2 extends UpdatableComponent 
{ 
private double temperature;
private double speed;
    public SpeedofSound2(double temperature){
    
    	super();
        this.temperature=temperature;
        
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

        g.setColor(Color.WHITE);

        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(Color.BLACK);
        

        g.drawString("Speed of Sound at " + temperature + "degrees Celsius:" + String.valueOf(speed) + "m/s", getWidth()/2, getHeight()/2);
        

    }
}
