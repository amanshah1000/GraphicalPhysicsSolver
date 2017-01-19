/*
 * 2017
 * PhysicsProgram 
 * Written By Mark McConachie
 * 
 * This class handles the logic for a simple pendulum
 */

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SimplePendulum extends JComponent 
{
	
	private double alpha;
	private double womega;
	private double theta;
	private	double x;
	private double y;
	private double length;
	private double deltaTime;
	
	public SimplePendulum(double length,double theta)
	{
		this.theta=theta;
		this.length=length;
		alpha=(-9.81 / length * Math.sin(theta));
		deltaTime=0.1;
	}
	
	public void setTheta(double theta)
	{
		this.theta=theta;
	}
	public void setLength(double length)
	{
		this.length=length;
	}
	
	public void paint(Graphics g) 
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		int anchorX = getWidth() / 2, anchorY = getHeight() / 4;
		int ballX = anchorX + (int) (Math.sin(theta) * length);
		int ballY = anchorY + (int) (Math.cos(theta) * length);
		g.drawLine(anchorX, anchorY, ballX, ballY);
		g.fillOval(anchorX - 3, anchorY - 4, 7, 7);
		g.fillOval(ballX - 7, ballY - 7, 14, 14);
	}
	
	public void update()
	{
		alpha=(-9.81 / length * Math.sin(theta));
		womega+= alpha * deltaTime;
		theta+=womega*deltaTime;
		repaint();
	}
	
	
	
}
