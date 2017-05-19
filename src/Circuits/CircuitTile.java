package Circuits;

import java.awt.*;

/**
 * Created by markmcconachie on 4/5/17.
 */
public abstract class CircuitTile
{
	private int tileSize;


	public CircuitTile()
	{
		//tileWidth = 50;
		//tileHieght = 50;
		//default tile is a square
		//of 50px by 50px
	}
	/*




	 */
	public int getTileSize()
	{
		return tileSize;
	}
	public void setTileSize(int tileSize){this.tileSize=tileSize;}

	public abstract void drawTile(Graphics g,int row,int col,int tileSize, int initialX,int initialY );




}
