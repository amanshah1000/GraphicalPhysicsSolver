package Circuits;

import java.awt.*;

/**
 * Created by markmcconachie on 4/5/17.
 */
public class ResistorTile extends CircuitTile
{
	private double resistance;
	private double voltage;
	public ResistorTile(double resitance)
	{
		super();
		this.resistance=resistance;

	}
	public ResistorTile(double resitance,double voltage)
	{
		super();
		this.resistance=resistance;
		this.voltage=voltage;

	}

	public double getResistance(){return resistance;}
	public void setResistance(double resistance){this.resistance=resistance;}
	public double getVoltage(){return voltage;}
	public void setVoltage(double voltage){this.voltage=voltage;}
	public double calculateCurrent(double voltage)
	{
		double current;
		current= resistance/voltage;
		this.voltage=voltage;
		return current;
	}

	public void drawTile(Graphics g, int row, int col, int tileSize, int initialX, int initialY )
	{
		setTileSize(tileSize);
		g.drawRect(initialX + row*tileSize,initialY + col*tileSize,tileSize,tileSize);
	}

}
