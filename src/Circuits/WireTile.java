package Circuits;

import java.awt.*;

/**
 * Created by markmcconachie on 4/5/17.
 */
public class WireTile extends CircuitTile
{
	private int x1;
	private int x2;
	private int y1;
	private int y2;

	public void drawTile(Graphics g, int row, int col, int tileSize, int initialX, int initialY )
	{
		setTileSize(tileSize);
		g.drawRect(initialX + row*tileSize,initialY + col*tileSize,tileSize,tileSize);
		g.setColor(Color.RED);
		g.drawLine(initialX+row*tileSize,initialY + col*tileSize+tileSize/2,initialX+row*tileSize+tileSize,initialY + col*tileSize+tileSize/2);
		g.setColor(Color.BLACK);
	}
}
