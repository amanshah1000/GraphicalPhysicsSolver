package Circuits;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by markmcconachie on 4/4/17.
 */
public class Board extends JComponent
{
	private CircuitTile[][] board;
	private int cols;
	private int rows;
	private int tileSize;
	private float tileZoom;// is a percentage of screen hieght


	public Board(int rows, int cols)
	{
		this.cols=cols;
		this.rows=rows;
		tileZoom = .75f;
		//System.out.println(getWidth());
		board = new CircuitTile[rows][cols];
		//creates a new board of empty tiles
		//instatiates the instace variables needed to draw the board
		for (int i=0; i < board.length;i++ )
		{
			for(int j=0; j < board[i].length;j++)
			{
				CircuitTile empty = new EmptyTile();
				board [i][j]= empty;
			}
		}

	}

	public Board(String file)
	{
		//TODO figure out what type of save file to use.
		//creates a new board based on the file passed to it
		//instatiates the instace variables needed to draw the board

	}


	public void Loadboard()
	{
	//loads the board given a some saved object

	}

	public void newBoard()
	{
		//creates a new board
		for (int i=0; i <= board.length;i++ )
		{
			for(int j=0; j <= board[i].length;j++)
			{
				CircuitTile empty = new EmptyTile();
				board [i][j]= empty;
			}
		}
	}
	public CircuitTile addTile(CircuitTile tile, int x, int y)
	{
		//adds a tile to the board at the given location

		return tile;
	}
	public CircuitTile addTile(CircuitTile tile)
	{
		//adds a tile to the board at the next available location, starts in upper corner and goes across

		return tile;
	}

	public ArrayList findLoops()
	{
		//loops through the board and finds loops
		//and creates an array
		ArrayList loops = new ArrayList<CircuitTile>();
		//loops read from battery to battery although the battery is not counted twice

		return loops;
	}

	public ArrayList findNodes()
	{
		//loops through the board and finds the node
		//creates an array containing the
		ArrayList nodes = new ArrayList<CircuitTile>();

		return nodes;
	}

	public void solveBoard()
	{
		//finds i1 in the circuit and then uses the loop node equations to calculate the remaninig things


	}
	public void paint (Graphics g)
	{
		System.out.println(getWidth());

		tileSize= (int)((tileZoom * getHeight())/cols);

		for (int i=0; i < board.length;i++ )
		{
			for(int j=0; j < board[i].length;j++)
			{
				//loop through the board
				//check what type of circuit it is
				//
				int initialX= (getWidth()/2)-((rows*tileSize)/2);
				int initialY= (getHeight()/2)-((cols*tileSize)/2)-50;
				board[i][j].drawTile(g,i,j,tileSize,initialX,initialY);
				//System.out.println(tileSize);

			}
		}


	}

}
