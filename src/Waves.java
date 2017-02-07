
import java.awt.Color;



import java.awt.Graphics;

import javax.swing.JComponent;

public class Waves extends UpdatableComponent 
{ 
    private double frequency;
    private double wavelength;
    private double velocity;
    private double speed;
    public Waves(double velocity){
    
    	super();
        this.velocity=velocity;
        frequency=1;
        
    }
    public void setVelocity(double velocity){
      this.velocity=velocity;
    }
    public void update(){
    	repaint();
    }
    public void setWavelength(double wavelength){
        this.wavelength= wavelength;
    }
    public void calculate(double velocity){
    wavelength = velocity/frequency;

    }
	public void paint(Graphics g) 
    {

        g.setColor(Color.WHITE);

        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(Color.BLACK);
        

        g.drawString("Speed of Sound at " + wavelength + "degrees Celsius:" + String.valueOf(wavelength) + "m/s", getWidth()/2, getHeight()/2);
        

    }
}
          

          
          
          
