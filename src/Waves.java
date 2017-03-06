import java.awt.Color;



import java.awt.Graphics;
import java.awt.*;
import javax.swing.JComponent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Waves extends UpdatableComponent 
{ 
    private double length;
    private double wavelength;
    private double frequency;
    private Image wavesImage;
    
    public Waves(double frequency){
    
    	super();
        this.frequency = frequency;
        
        try 
        {
        	wavesImage = ImageIO.read(new File("FirstHarmonic.jpg"));
        }	
        catch(IOException ex)
        {
       	     Logger.getLogger(WavesPanel.class.getName()).log(Level.WARNING,null,ex);
        }	 
        
    }
    public void setFrequency(double frequency){
      this.frequency = frequency;
    }
    
    public void setLength(double length)
    {
    	this.length = length;
    }
    public void update(){
    	repaint();
    }
    public void setWavelength(double wavelength){
        this.wavelength= wavelength;
    }
    public void calculate(){
    length  = .25 * wavelength;

    }
    
    public void drawWave(Graphics g)
    {
    	double step = (2 * Math.PI)/64;
    	for(double i = 0; i < 2 * Math.PI; i = i + step)
    	{
    		g.drawLine(i, Math.sin(i),i + step, Math.sin(i + step));
    	}
    }
    
    
	public void paint(Graphics g) 
    {

        g.setColor(Color.WHITE);

        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(Color.BLACK);
        

        g.drawString( "Closed Columns : " + " Length is " + length + " m when Wavelength is " + wavelength + " m/s", getWidth()/2, getHeight()/2);
        
        

    }
}
          

          
          
          



          
          
          

