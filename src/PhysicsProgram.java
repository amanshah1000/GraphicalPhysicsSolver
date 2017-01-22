/*
 * 2017
 * PhysicsProgram 
 * Written By Mark McConachie and AJ Valenty
 * 
 * this class is used as the main runner for a graphical physics solver	
 */
//TODO Refactor the Pendulum and SS Panels into Seperate Classes
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.ArrayList;


import javax.swing.*;


public class PhysicsProgram extends JFrame
{
//declares instance variables
private JButton start;
private JButton stop;
private JFormattedTextField thetaField;
private JFormattedTextField lengthField;
private NumberFormat thetaFormat;
private NumberFormat lengthFormat;
private JPanel mainPanel;
private RunnablePanel speedOfSoundPanel;
//panels for the pendulum simulation
private RunnablePanel pendulumPanel;
private ClickablePanel lowerPanel;//clickable panel is defined in the bottom of this class
//private RunnablePanel simulationPanel;//runnable panel is defined in the bottom of this class
private int screenWidth;
private int screenHeight;
private boolean isRunning;
private UpdatableComponent soundComponent;
private SimplePendulum pendulum;
//private ArrayList<UpdatableComponent> pendulumComponents;
private PhysicsEquations Eq;
//private SpeedofSoundEq Speed;
private JButton calc;
private JButton clear;
private JFormattedTextField tempField;


	

//frame.getContentPane()

	public void addTabs(Container pane)
	{
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Pendulum", pendulumPanel);
		tabbedPane.addTab("SpeedOfSound", speedOfSoundPanel);
       
		pane.add(tabbedPane, BorderLayout.CENTER);
	}

    public void initSpeedofSoundPanel(double temperature, double velocity)

    {

        //defines panels

        //mainPanel = new JPanel();
        soundComponent=new UpdatableComponent();
        speedOfSoundPanel=new RunnablePanel(soundComponent);

        lowerPanel= new ClickablePanel();

        //simulationPanel= new RunablePanel();

        speedOfSoundPanel.setLayout(new BorderLayout());

        speedOfSoundPanel.add(lowerPanel,BorderLayout.SOUTH);

        //speedOfSoundPanel.add(simulationPanel,BorderLayout.CENTER);
        //defines buttons

        calc  = new JButton("Calculate");

        clear = new JButton("Clear");



        //defines text fields

        tempField = new JFormattedTextField(thetaFormat);

        tempField.setValue(0);

        tempField.setColumns(4);

        //adds buttons to the panel

        lowerPanel.add(calc);

        lowerPanel.add(clear);

        lowerPanel.add(tempField);





        //add actionliseners to buttons on a clickable panel

        tempField.addPropertyChangeListener("Temperature",lowerPanel);



        calc.addActionListener(lowerPanel);

        clear.addActionListener(lowerPanel);

        //starts the tread in the main panel

        Thread speedOfSoundThread = new Thread(speedOfSoundPanel);

        speedOfSoundThread.start();



    }

	public void initPendulumPanel(double theta, double length)
	{

		
		//defines panels
		//mainPanel = new JPanel();
		//adds the pendulum to he array list
        pendulum = new SimplePendulum(100,Eq.degreesToRadian(90));
	  	pendulumPanel=new RunnablePanel(pendulum);
		lowerPanel= new ClickablePanel();
		//simulationPanel= new RunablePanel();
		pendulumPanel.setLayout(new BorderLayout());
		pendulumPanel.add(lowerPanel,BorderLayout.SOUTH);
		//pendulumPanel.add(simulationPanel,BorderLayout.CENTER);
		
		
		//defines buttons
		stop  = new JButton("Stop");
		start = new JButton("Start");
		
		//defines text fields
		lengthField = new JFormattedTextField(thetaFormat);
		lengthField.setValue(new Double(length));
		lengthField.setColumns(4);
		
		thetaField = new JFormattedTextField(thetaFormat);
		thetaField.setValue(new Double(theta));
		thetaField.setColumns(4);

		//adds buttons to the panel
		lowerPanel.add(start);
		lowerPanel.add(stop);
		lowerPanel.add(lengthField);
		lowerPanel.add(thetaField);
		
		//add actionliseners to buttons on a clickable panel
		lengthField.addPropertyChangeListener("Length",lowerPanel);
		thetaField.addPropertyChangeListener("Theta",lowerPanel);
		stop.addActionListener(lowerPanel);
		start.addActionListener(lowerPanel);
		
		
		
	    //intitalizes the equation conversions/solver

	    
	    
	    //set other variables
	    isRunning=false;
	    //simulationPanel.add(pendulum);
	    pendulumPanel.add(pendulum);
	    pendulum.repaint();
	    //simulationPanel.repaint();
	    pendulumPanel.repaint();
	    
	    //starts the tread in the main panel
	    Thread simulationThread = new Thread(pendulumPanel);
	    simulationThread.start();
	    
	}
	
	public PhysicsProgram()
	{
        //defines screen variables
        screenWidth = 800;
        screenHeight = 600;

        Eq=new PhysicsEquations();
        //initpendulum adds the buttons to the panels
		initPendulumPanel(90,100);
		initSpeedofSoundPanel(60,1000);
		
	  	
		setSize(screenWidth,screenHeight);
		
		//starts the Jframe window, and sets title
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//sets the panels as visible and defines mainPanel as contentPane
		mainPanel=new JPanel();

		mainPanel.setLayout(new BorderLayout());
		setContentPane(mainPanel);
		setVisible(true);
			    
        setTitle("PhysicsSolver");
	    addTabs(mainPanel);
	    //prints message to inform user it is running
	    System.out.println("starting sumulation");
	    
		
	}
	
	
	
	public static void main(String[] arguments)
	{
		//main method calls the constructor to initialize the program
		PhysicsProgram physicsProgram = new PhysicsProgram();
		
	}
	
	
/*
 * definition and instantiation of Clickable Panel
 */
	

public class ClickablePanel extends JPanel implements ActionListener,PropertyChangeListener
{
	

	@Override
	public void actionPerformed(ActionEvent event) 
	{

		Object source = event.getSource();
		
		if(source==stop)
		{
		    isRunning=false;
			pendulumPanel.setRunning(false);
			System.out.println("Stop clicked");
			//mainPanel.run();
		}
		
		else if(source==start)
		{
			System.out.println("Start clicked");
			isRunning=true;
			pendulumPanel.setRunning(true);
			//mainPanel.run();
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) 
	{

	}

}

/*
 * definition and instantiation of RunnablePanel
 */
/*
public class RunablePanel extends JPanel implements Runnable
{


	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		while(true)
		{
			//System.out.print("simulation active");
			if(isRunning==true)
				pendulum.update();

			 try {
			        Thread.sleep(15);
			      } catch (InterruptedException ex) {
			      }
		}

	}

}
*/

}




	
	


