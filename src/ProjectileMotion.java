import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class ProjectileMotion extends UpdatableComponent{
        
    /**
     * Creates a new instance of <code>ProjectileMotion</code>
     */
     
    private JPanel ProjectilePanel;
    private double angle;
	private double initVelocity;
	private final double g = -9.8;
	private Image mainImage;
	


    public ProjectileMotion(double angle, double initVelocity, JPanel ProjectilePanel ) {
    	
    	super();
    	this.ProjectilePanel=ProjectilePanel;
        this.angle=angle;
        this.initVelocity = initVelocity;
         try
        {

            mainImage = ImageIO.read(new File("qurans d.png"));
            //speedImage = ImageIO.read(new File("speedGauge.png"));

        } catch (IOException ex)
        {
            Logger.getLogger(SonofCousinPanel.class.getName()).log(Level.WARNING,null,ex);
        }
    	
    }
    
    public void setAngle(double angle){
        this.angle = angle;
    }
    
    public void setVelocity(double initVelocity)
	{
        this.initVelocity= initVelocity;
        
    }
    /**
     * @param //args the command line arguments
     */

	public void drawTrajectory(Graphics g,int initialX,int initialY)
	{
		g.setColor(Color.RED);
		double functionX;
		double functionY;
		double xVelo = initVelocity*Math.cos(Math.toRadians(angle));
		double yVelo = initVelocity*Math.sin(Math.toRadians(angle));
		double range = (Math.pow(initVelocity,2) * Math.sin(2*Math.toRadians(angle)))/(9.81);
		//the denominator of the step function is the number of points on the trajectory
		double step = range/((30*(angle/90))*(initVelocity/20));
		//scale is used as a multiplier. so if you have a scale of X, that means X pixels = 1 meter
		int scale = 10;
		int currentX;
		int currentY;

		for (double i=0;i<=range+(270/angle);i=i+step)
		{
			functionX = i;
            /*(i/xVelo)^2 is the time squared, there for when you sub that into the 2nd
            *kinematic you end ump with yPosition as a function of xPosition
            * therefore you can loop through all the xPositions and calculate there yPositions
            * */

			functionY = (-4.9*Math.pow((i/xVelo),2))+(Math.tan(Math.toRadians(angle))*i);
			currentX =(int)(functionX*scale);
			currentY = (int)(functionY*scale);


			g.fillOval(currentX+initialX,initialY-currentY,4,4);
		}
		g.setColor(Color.BLACK);



	}

	public void drawTrajectoryDeprecated(Graphics g)
    {

    	double xVelo = initVelocity * Math.sin(Math.toRadians(angle));
    	double yVelo = initVelocity * Math.cos(Math.toRadians(angle));
    	double range = (Math.pow(xVelo, 2) * Math.sin(Math.toRadians(angle))) / 9.81;
    	//double time = 
    	int initX= getWidth()/16;
    	int initY= getHeight() - (getHeight()/3);
    	double yPos;
    	double xPos;
    	
    	for(double i= 0; i <=range; i = i + 1)
    	{
    		//xpos is 'i'
    		xPos=i;
    		yPos= -4.9*Math.pow((xPos/yVelo),2)+Math.tan(angle)*xPos;
    		g.drawOval(initX+(int)xPos,initY + (int)yPos,4,4);
    		//System.out.println(xVelo +", " +  yVelo);  		
    	}
    	
    	
    }
    
    
	
	public void paint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0,0,getWidth(), getHeight());
	
		Graphics2D g2d = (Graphics2D)g;


		drawTrajectory(g,75+(int)(60*Math.cos(Math.toRadians(angle))),350-(int)(60*Math.sin(Math.toRadians(angle))));
		g.setColor(new Color(113,59,28));
		g.fillRect(0,getHeight() - (getHeight()/4)+40,800,350);
		//g2d.rotate(Math.toRadians(90),20, 560 ); (Deprecated)
		AffineTransform old = g2d.getTransform();
		g2d.rotate(Math.toRadians(-angle), 75, 350);
		g2d.drawImage(mainImage,getWidth()/16, getHeight() - (getHeight()/3), 100, 100, this);
		g2d.setTransform(old);
		g.setColor(Color.gray);
		g.fillOval(getWidth()/15 +5, getHeight() - (getHeight()/4), 40, 40);

		/*
		g.setColor(Color.BLUE);

		for( int i = 0; i <= 800; i = i+10)
		{
			g2d.drawLine(i, 0, i, 600);
			String k = String.valueOf(i);
			g2d.drawString(k,i,  0);
		}
		
		for( int j = 0; j <= 600; j = j+10)
		{
			g2d.drawLine(0,j, 800, j);
			String k = String.valueOf(j);
			g2d.drawString(k, 0, j);
		}

		*/

	//	AffineTransform old = g2d.getTransform();
	//	g2d.rotate(angle);
		
	}   
		
	public void update()
	{
		repaint();
	}
}
