
import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JComponent;

public class Waves extends JComponent
{
	private double length;
    private double frequency;
    private double wavelength;
    private double velocity;
    	

          public Waves(double velocity, double frequency)
          {
          	this.velocity = velocity;
          	this.frequency = frequency;
          	wavelength = velocity/frequency;
          }
          
          public void setVelocity(double velocity)
          {
          	this.length = length;
          }
          
          public void setFrequency(double frequency)
          {
          	this.frequency = frequency;
          }
          
 }
          

          
          
          
