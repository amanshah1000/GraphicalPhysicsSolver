
/*

 * 2017

 * PhysicsProgram 

 * Written By AJ Valenty and Karan Lingineni and Mark McCconachie

 * 

 * this class is used as the main runner for a graphical physics solver    

 */


import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.beans.PropertyChangeEvent;

import java.beans.PropertyChangeListener;

import java.text.NumberFormat;


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

private RunablePanel SpeedOfSoundPanel;

private JFormattedTextField tempField;

//panels for the pendulum simulation

RunablePanel pendulumPanel;

ClickablePanel lowerPanel;//clickable panel is defined in the bottom of this class

RunablePanel simulationPanel;//runnable panel is defined in the bottom of this class

private int screenWidth;

private int screenHeight;

private boolean isRunning;

private SimplePendulum pendulum;

private PysicsEquations Eq;

private SpeedofSoundEq Speed;

private JButton calc;

private JButton clear;


    


//frame.getContentPane()


    public void addTabs(Container pane)

    {

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Pendulum", pendulumPanel);

        tabbedPane.addTab("SpeedOfSound", SpeedOfSoundPanel);

       

        pane.add(tabbedPane, BorderLayout.CENTER);

    }


    public void initPendulumPanel(double theta, double length)

    {

        //defines screen variables

         screenWidth = 800;

          screenHeight = 600;

          

        

        //defines panels

        //mainPanel = new JPanel();

          pendulumPanel=new RunablePanel();

        lowerPanel= new ClickablePanel();

        simulationPanel= new RunablePanel();

        pendulumPanel.setLayout(new BorderLayout());

        pendulumPanel.add(lowerPanel,BorderLayout.SOUTH);

        pendulumPanel.add(simulationPanel,BorderLayout.CENTER);

        

        

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

        Eq=new PysicsEquations();

        

        

        //set other variables

        isRunning=false;

        pendulum=new SimplePendulum(100,Eq.degreesToRadian(160));

        //simulationPanel.add(pendulum);

        pendulumPanel.add(pendulum);

        pendulum.repaint();

        //simulationPanel.repaint();

        pendulumPanel.repaint();

        

        //starts the tread in the main panel

        Thread simulationThread = new Thread(pendulumPanel);

        simulationThread.start();

        

    }

    
 public void initSpeedofSoundPanel(double temperature, double velocity)

    {

        //defines screen variables

        	screenWidth = 800;

          	screenHeight = 600;

          

        

        //defines panels

        //mainPanel = new JPanel();

        SpeedOfSoundPanel=new RunablePanel();

        lowerPanel= new ClickablePanel();

        simulationPanel= new RunablePanel();

        SpeedOfSoundPanel.setLayout(new BorderLayout());

        SpeedOfSoundPanel.add(lowerPanel,BorderLayout.SOUTH);

        SpeedOfSoundPanel.add(simulationPanel,BorderLayout.CENTER);

        

        

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

        

        

        

        //intitalizes the equation conversions/solver

        Eq=new PysicsEquations();

        

        

        //set other variables

        //simulationPanel.add(pendulum);

       // SpeedOfSoundPanel.add(pendulum);

        

        //simulationPanel.repaint();

        

        

        //starts the tread in the main panel

        Thread simulationThread = new Thread(SpeedOfSoundPanel);

        simulationThread.start();

        

    }

    

    public PhysicsProgram()

    {

        //initpendulum adds the buttons to the panels

        initPendulumPanel(90,100);

        

        setSize(screenWidth,screenHeight);

        

        //starts the Jframe window, and sets title

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //sets the panels as visible and defines mainPanel as contentPane

        mainPanel=new JPanel();

        SpeedOfSoundPanel=new RunablePanel();

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

        // TODO Auto-generated method stub

        Object source = event.getSource();

        

        if(source==stop)

        {

            isRunning=false;

            System.out.println("Stop clicked");

            //mainPanel.run();

        }

        

        else if(source==start)

        {

            System.out.println("Start clicked");

            isRunning=true;

            //mainPanel.run();

        }
         else if(source==calc)

        {

            System.out.println("calc clicked");

            

            //mainPanel.run();

        }
         else if(source==clear)

        {

            System.out.println("clear clicked");

         //   isRunning=true;

            //mainPanel.run();

        }

    }


    @Override

    public void propertyChange(PropertyChangeEvent evt) 

    {

        // TODO Auto-generated method stub

        

    }


}


/*

 * definition and instantiation of RunnablePanel

 */


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



}





    

    


