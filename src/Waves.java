
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
        wavelength= wavelength/100.0;
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


    public void drawTrajectory(Graphics g,int initialX,int initialY,double velocity,double angle)
    {
        double functionX;
        double functionY;
        double xVelo = velocity*Math.cos(Math.toRadians(angle));
        double yVelo = velocity*Math.sin(Math.toRadians(angle));
        double range = (Math.pow(velocity,2) * Math.sin(2*Math.toRadians(angle)))/(9.81);
        //the denominator of the step function is the number of points on the trajectory
		double step = range/30;
		//scale is used as a multiplier. so if you have a scale of X, that means X pixels = 1 meter
		int scale = 10;
        int currentX;
        int currentY;

        for (double i=0;i<=range;i=i+step)
        {
            functionX = i;
            /*(i/xVelo)^2 is the time squared, there for when you sub that into the 2nd
            *kinematic you end ump with yPosition as a function of xPosition
            * therefore you can loop through all the xPositions and calculate there yPositions
            * */

            functionY = (-4.9*Math.pow((i/xVelo),2))+(Math.tan(Math.toRadians(angle))*i);
            currentX =(int)(functionX*10);
            currentY = (int)(functionY*10);


            g.fillOval(currentX+initialX,initialY-currentY,4,4);
        }



    }

	public void paint(Graphics g) 
    {

        g.setColor(Color.WHITE);

        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(Color.BLACK);
		//g.setColor(Color.RED);
        

        g.drawString( "Closed Columns : " + " Length is " + length + " m when Wavelength is " + wavelength + " m/s", getWidth()/2, getHeight()/2);

        //g.drawString("Wavelength is " + wavelength + "when Frequency is:" + String.valueOf(wavelength) + "m/s", getWidth()/2, getHeight()/2);
        drawWave(g,0,getHeight()/2,50,1,wavelength);
        //drawTrajectory(g,0,getHeight()/2,20,85);
        /*
		g.setColor(Color.BLACK);
		drawTrajectory(g,0,getHeight()/2,20,40);
		g.setColor(Color.RED);
		drawTrajectory(g,0,getHeight()/2,20,35);
		g.setColor(Color.BLACK);
		drawTrajectory(g,0,getHeight()/2,20,30);
		g.setColor(Color.RED);
		drawTrajectory(g,0,getHeight()/2,20,25);
		g.setColor(Color.BLACK);
		drawTrajectory(g,0,getHeight()/2,20,20);
		g.setColor(Color.RED);
		drawTrajectory(g,0,getHeight()/2,20,15);
		*/
		//g.setColor(Color.BLACK);
		//g.drawLine(0,getHeight()/2,getWidth(),getHeight()/2);



    }
}
          

          
          
          
