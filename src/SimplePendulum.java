/*
 * 2017
 * PhysicsProgram 
 * Written By Mark McConachie
 * 
 * This class handles the logic for a simple pendulum
 */

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class SimplePendulum extends UpdatableComponent
{
	
	private double alpha;
	private double womega;
	private double theta;
	private double thetaOld;
	private	double x;
	private double y;
	private double length;
	private double deltaTime;
	private double totalTime=0;
	private double meterLength;
	private double period;
    private Image diceImage;
    private boolean doesRotate;
    private boolean singlePeriod;

	
	public SimplePendulum(double length,double theta)
	{
		this.theta=theta;
		this.thetaOld=theta;
		this.length=length;
		meterLength=length/100;
		alpha=(-9.80665 / meterLength * Math.sin(theta));
		//alpha =-9.81*Math.sin(theta);
        doesRotate=false;
        singlePeriod=false;
		deltaTime=0.01;
		period=(2*Math.PI)*Math.pow((meterLength*theta/(9.80665*Math.sin(theta))),0.5);
        //simple harmonic motion using small angle aprox
        //period=(2*Math.PI)*Math.pow((meterLength/(9.81)),0.5);

        try
        {
            diceImage = ImageIO.read(new File("dice.png"));
        } catch (IOException ex)
        {
            Logger.getLogger(PendulumPanel.class.getName()).log(Level.WARNING,null,ex);
        }

		//deltaTime=0.1;
	}
	
	public void setTheta(double theta)
	{
		this.theta=theta;
		this.thetaOld=theta;
	}
	public void setLength(double length)
	{
		this.length=length;
		meterLength=this.length/100;
	}

	public double getTheta()
    {
        return theta;
    }
    public double getLength()
    {
        return length;
    }

    public double getWomega()
    {
        return womega;
    }
    public double getAlpha()
    {
        return alpha;
    }
    public void doesRotate(boolean doesRotate)
    {
        this.doesRotate=doesRotate;

    }
    public void useSinglePeriod(boolean singlePeriod)
    {
        this.singlePeriod=singlePeriod;

    }




    public void reset()
    {
	   womega=0;
	   totalTime=0;
	   alpha=(-9.80665 / meterLength * Math.sin(theta));
	   //my derivation for period not using small angle aprox
	   period=(2*Math.PI)*Math.pow((meterLength*theta/(9.80665*Math.sin(theta))),0.5);
	   //simple harmonic motion using small angle aprox
	   //period=(2*Math.PI)*Math.pow((meterLength/(9.81)),0.5);
	   repaint();
    }
	
	public void paint(Graphics g) 
	{
        Graphics2D g2d = (Graphics2D)g;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		int anchorX = (getWidth()*3)/5, anchorY = getHeight() / 4;
		int ballX = anchorX + (int) (Math.sin(theta) * length);
		int ballY = anchorY + (int) (Math.cos(theta) * length);
		g.drawLine(anchorX, anchorY, ballX, ballY);
		g.fillOval(anchorX - 3, anchorY - 4, 7, 7);
		g.fillOval(ballX - 7, ballY - 7, 14, 14);

		//sets the old transform so that you can unrotate the screen
        AffineTransform old = g2d.getTransform();
		if(doesRotate==true)
        {
            g2d.rotate((theta*.25)+Math.toRadians(womega), ballX , ballY);
        }

        //diceTransform.rotate( Math.toRadians(theta));
        //diceTransform.translate(ballX-25,ballY-25);
        g2d.drawImage(diceImage, ballX-25, ballY-25,50,50,this);
       // g.finalize();
        g2d.setTransform(old);
        g2d.drawString("Alpha (rad/s/s) = "+Math.round(alpha*100.0)/100.0,getWidth()/8,getHeight()/4-getHeight()/16);
        g2d.drawString("Omega (rad/s) = "+Math.round(womega*100.0)/100.0,getWidth()/8,getHeight()/4-getHeight()/16-getHeight()/16);
        g2d.drawString("Time Elapsed(s) = "+Math.round(totalTime*100000)/100000.0,getWidth()/8,getHeight()/4-getHeight()/16+getHeight()/16);
        g2d.drawString("Period (s) = "+Math.round(period*100000)/100000.0,getWidth()/8,getHeight()/4-getHeight()/16+getHeight()/8);
        g2d.drawString("Theta (deg) = "+Math.round(Math.toDegrees(theta)*100)/100.0,getWidth()/8,getHeight()/4-getHeight()/16-getHeight()/8);
    }
	
	public void update()
	{
	    double meterLength = length/100;
		alpha=(-9.80665 / meterLength * Math.sin(theta));
		//alpha = -9.81 * Math.sin(theta);
		womega+= alpha * deltaTime;
		theta+= womega*deltaTime;
        totalTime+= deltaTime;
		//period=(2*Math.PI)*Math.pow((meterLength/(9.81*Math.sin(theta))),0.5);
		repaint();
	}
	
	
	
}
