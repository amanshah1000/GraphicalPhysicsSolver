package Circuits;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by markmcconachie on 3/22/17.
 */
public class CircuitProgram extends JFrame implements ActionListener
{
	private int screenWidth;
	private int screenHeight;
	private JPanel mainPanel;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private Board board;
	private JMenuItem fmSaveAs;
	private JMenuItem fmSave;
	private JMenuItem fmOpen;
	private JMenuItem fmNew;


	public CircuitProgram()
	{
		screenWidth = 800;
		screenHeight = 600;
		setSize(screenWidth, screenHeight);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(screenSize.width / 2 - this.getSize().width / 2, screenSize.height / 2 - this.getSize().height / 2);

		//starts the Jframe window, and sets title
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//sets the panels as visible and defines mainPanel as contentPane
		mainPanel = new JPanel();

		mainPanel.setLayout(new BorderLayout());
		board = new Board(12,8);
		mainPanel.add(board);
		board.repaint();
		setContentPane(mainPanel);
		setVisible(true);

		setTitle("CircuitSolver");


		//set up the menubar and submenus
		menuBar = new JMenuBar();
		//Build the first menu.
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_A);
		fileMenu.getAccessibleContext().setAccessibleDescription(
				"allows for loading and saving of circuits");
		menuBar.add(fileMenu);

		//add the menu items to the menu bar

		//NewMenuItem
		fmNew = new JMenuItem("New", KeyEvent.VK_T); //creates the new menu item
		fmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.META_MASK));
		fmNew.getAccessibleContext().setAccessibleDescription("opens a project from a specified location");
		fmNew.addActionListener(this);
		fileMenu.add(fmNew); //adds the new menu item
		//NewMenuItem

		//OpenMenuItem
		fmOpen = new JMenuItem("Open...", KeyEvent.VK_T); //creates the open menu item
		fmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.META_MASK));
		fmOpen.getAccessibleContext().setAccessibleDescription("opens a project from a specified location");
		fmOpen.addActionListener(this);
		fileMenu.add(fmOpen); //adds the open menu item
		//OpenMenuItem

		//Separator
		fileMenu.addSeparator();
		//Separator

		//SaveAsMenuItem
		fmSaveAs = new JMenuItem("SaveAs", KeyEvent.VK_T); //creates the save as menu item
		fmSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.META_MASK));
		fmSaveAs.getAccessibleContext().setAccessibleDescription(
				"Saves the project to specified location");
		fmSaveAs.addActionListener(this);
		fileMenu.add(fmSaveAs); //adds the save as menu item
		//SaveAsMenuItem

		//SaveMenuItem
		fmSave = new JMenuItem("Save", KeyEvent.VK_T); //creates the save as menu item
		fmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.META_MASK ));
		fmSave.getAccessibleContext().setAccessibleDescription("Saves the project to where it exists");
		fmSave.addActionListener(this);
		fileMenu.add(fmSave); //adds the save as menu item
		//SaveMenuItem


		//adds the menu bar to this frame
		this.setJMenuBar(menuBar);


		//prints message to inform user it is running
		System.out.println("starting circuits");

		setResizable(false);


	}


	public void actionPerformed(ActionEvent event)
	{
		Object source = event.getSource();

		//TODO add respective functions to the menu items in actionpreformed

		if (source == fmSaveAs)
		{
			System.out.println("Saving Project to /location");
			//call file saveAs
			//open a JFileChooser

		}
		else if (source == fmOpen)
		{
			System.out.println("Opening Project from /location");
			//call file Open
			//open a JFileChooser

		}
		else if (source == fmNew)
		{
			System.out.println("Creating New Project");
			//Call file New
			//create a new circuit board

		}
		else if (source == fmSave)
		{
			System.out.println("Saving Project");
			//if the file has not been previously saved open JfileChooser
			//else save the fie to its existing location

		}



	}
}


