package Circuits;

import java.awt.*;

/**
 * Created by markmcconachie on 4/5/17.
 */
public class EmptyTile extends CircuitTile
{
	public void drawTile(Graphics g, int row, int col, int tileSize, int initialX, int initialY )
	{
		setTileSize(tileSize);
		g.drawRect(initialX + row*tileSize,initialY + col*tileSize,tileSize,tileSize);
	}

}
