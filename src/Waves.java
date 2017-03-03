
import java.awt.Color;



import java.awt.Graphics;

import javax.swing.JComponent;

public class Waves extends UpdatableComponent 
{ 
    private double frequency;
    private double wavelength;
    private double velocity;
    private double speed;

    public Waves(double velocity)
    {
    
    	super();
        this.velocity=velocity;
        frequency=1;
        wavelength=1;
        
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
    public void drawWave(Graphics g,int x,int y,int scale,double periods,double wavelength)
    {
        //resolution is how close each step is to the other the higher the resolution the higher the step.
        //resolution is not dependent on period
        // as you go too high in resolution you get weird artifacts. 64 doesnt give much artifacting
        wavelength= wavelength/100;
        double resolution =(wavelength/2)*64;
        double step = (2*Math.PI)/resolution;
        double maxSteps=(2*Math.PI)*periods;
        double functionX;
        double functionY;
        double nxtFunctionX;
        double nxtFunctionY;
        int currentX;
        int currentY;
        int nxtX;
        int nxtY;
        int initialX=x;
        int initialY=y;



       for (double i=0;i<=maxSteps;i=i+step)
       {
           functionX=i;
           functionY=Math.sin(wavelength*(i));
           nxtFunctionX=i+step;
           nxtFunctionY=Math.sin(wavelength*(i+step));
           currentX= initialX+(int)(functionX *scale);
           currentY= initialY+(int)(functionY *scale);
           nxtX= initialX+(int)(nxtFunctionX *scale);
           nxtY= initialY+(int)(nxtFunctionY *scale);


           g.drawLine(currentX,currentY,nxtX,nxtY);
       }



    }

	public void paint(Graphics g) 
    {

        g.setColor(Color.WHITE);

        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(Color.BLACK);
        

        g.drawString("Wavelength is " + wavelength + "when Frequency is:" + String.valueOf(wavelength) + "m/s", getWidth()/2, getHeight()/2);
        drawWave(g,0,getHeight()/2,50,1,wavelength);

        

    }
}
          

          
          
          
