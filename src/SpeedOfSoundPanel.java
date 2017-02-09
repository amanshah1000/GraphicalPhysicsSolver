import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

/**
 * Created by Aj Valenty
 */
public class SpeedOfSoundPanel extends PhysicsPanel
{

    private RunnablePanel speedOfSoundPanel;

    private ActionPanel lowerPanel;//clickable panel is defined in the bottom of this class
    //private RunnablePanel simulationPanel;//runnable panel is defined in the bottom of this class

    private PhysicsEquations Eq;
    //private SpeedofSoundEq Speed;
    private JButton calc;
    private JButton clear;
    private JFormattedTextField tempField;
    private NumberFormat thetaFormat;
	private SpeedofSound2 speedOfSound2;
//	private double temperature;
	

    public SpeedOfSoundPanel(double temperature, double velocity)
    {
        super();
          Eq= new PhysicsEquations();
        init(temperature,velocity);
    }


    public void init(double temperature, double velocity)

    {

        //defines panels
		speedOfSound2 = new SpeedofSound2(temperature, speedOfSoundPanel);
			
		//	MovableObject tempGauge = new MovableObject(speedOfSoundPanel, "TempGauge.jpg", 100,10, 50,50);	
	
		/*
        pendulum = new SimplePendulum(length, theta);
        pendulumPanel = new RunnablePanel(pendulum);
        lowerPanel= new ActionPanel();
        //simulationPanel= new RunablePanel();
        pendulumPanel.setLayout(new BorderLayout());
        pendulumPanel.add(lowerPanel, BorderLayout.SOUTH);
		*/


        //mainPanel = new JPanel();
       // speedOfSound2 =new UpdatableComponent();
        
        
        speedOfSoundPanel=new RunnablePanel(speedOfSound2);
        

        lowerPanel= new ActionPanel(); 
   
        //speedOfSoundPanel.add(speedOfSound2);

        //simulationPanel= new RunablePanel();

        speedOfSoundPanel.setLayout(new BorderLayout());

        speedOfSoundPanel.add(lowerPanel,BorderLayout.SOUTH);
      //  	MovableObject tempGauge = new MovableObject(speedOfSoundPanel, "TempGauge.png", 100,10, 50,50);	
      //		speedOfSoundPanel.add(tempGauge);
      //  		tempGauge.draw();


      //  speedOfSoundPanel.add(speedOfSoundPanel,BorderLayout.CENTER);
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
        speedOfSoundPanel.add(speedOfSound2);
        speedOfSound2.repaint();

        Thread speedOfSoundThread = new Thread(speedOfSoundPanel);

        speedOfSoundThread.start();

        this.setLayout(new BorderLayout());
        this.add(speedOfSoundPanel,BorderLayout.CENTER);

    }
    
    public class ActionPanel extends JPanel implements ActionListener, PropertyChangeListener
    {


        @Override
        public void actionPerformed(ActionEvent event)
        {

            Object source = event.getSource();

            if (source == calc)
            {
				String text = tempField.getText();
				
				double temper= Double.parseDouble(text);
				speedOfSoundPanel.setRunning(true);
				speedOfSound2.setTemperature(temper);
				speedOfSound2.calculate(temper);
				speedOfSound2.repaint();
				
				System.out.print(temper);
				
				System.out.println("Calc clicked");
                //mainPanel.run();
            } else if (source == clear)
            {
                System.out.println("clear clicked");
				speedOfSoundPanel.setRunning(true);
				
               
                //mainPanel.run();
            }
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt)
        {

        }

    }


}
