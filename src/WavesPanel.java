import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

/**
 * Created by Aman Shah
 */
public class WavesPanel extends PhysicsPanel
{

    private RunnablePanel WavesPanel;

    private ActionPanel lowerPanel;//clickable panel is defined in the bottom of this class
    //private RunnablePanel simulationPanel;//runnable panel is defined in the bottom of this class

    private PhysicsEquations Eq;
    //private SpeedofSoundEq Speed;
    private JButton calc;
    private JButton openClose;
    //private JButton clear;
    private JFormattedTextField wavelenghtField;
    private NumberFormat thetaFormat;
	private SpeedofSound2 speedOfSound2;
	private Waves wavesComponent;
	private boolean isOpen;
//	private double temperature;
	

    public WavesPanel(double harmonic, double length)
    {
        super();
          Eq= new PhysicsEquations();
        init(harmonic,length);
    }


    public void init(double harmonic, double length)

    {
		isOpen=false;
        wavesComponent = new Waves(harmonic);
        //defines panels
		WavesPanel = new RunnablePanel(wavesComponent);
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
        

        lowerPanel= new ActionPanel(); 
   
        //speedOfSoundPanel.add(speedOfSound2);

        //simulationPanel= new RunablePanel();

        WavesPanel.setLayout(new BorderLayout());

        WavesPanel.add(lowerPanel,BorderLayout.NORTH);

      //  speedOfSoundPanel.add(speedOfSoundPanel,BorderLayout.CENTER);
        //defines buttons

        calc  = new JButton("Calculate");
        openClose = new JButton("Open / Closed");

        //clear = new JButton("Clear");



        //defines text fields

        wavelenghtField = new JFormattedTextField(thetaFormat);

        wavelenghtField.setValue(harmonic);

        wavelenghtField.setColumns(4);

        //adds buttons to the panel
        
        lowerPanel.add(new JLabel("Enter Harmonic Number"));
        lowerPanel.add(wavelenghtField);

        lowerPanel.add(calc);
        lowerPanel.add(openClose);

        //lowerPanel.add(clear);







        //add actionliseners to buttons on a clickable panel

        wavelenghtField.addPropertyChangeListener("WaveLength",lowerPanel);



        calc.addActionListener(lowerPanel);

        openClose.addActionListener(lowerPanel);

        //starts the tread in the main panel
        WavesPanel.add(wavesComponent);
        WavesPanel.repaint();

        Thread wavesThread = new Thread(WavesPanel);

        wavesThread.start();
		WavesPanel.setRunning(false);

        this.setLayout(new BorderLayout());
        this.add(WavesPanel,BorderLayout.CENTER);


    }
    
    public class ActionPanel extends JPanel implements ActionListener, PropertyChangeListener
    {


        @Override
        public void actionPerformed(ActionEvent event)
        {

            Object source = event.getSource();

            if (source == calc)
            {
				String text = wavelenghtField.getText();
				
				double harmonic = Double.parseDouble(text);
				//WavesPanel.setRunning(true);
				wavesComponent.setHarmonic(harmonic);
				//wavesComponent.calculate();
				wavesComponent.repaint();
				
				System.out.print(harmonic);
				
				
				System.out.println("Calc clicked");
                //mainPanel.run();
            }
            else if (source==openClose)
			{
				isOpen=!isOpen;
				wavesComponent.setOpen(isOpen);
				//TODO set is open in waves
				System.out.println("Open is: "+isOpen);
				wavesComponent.repaint();
			}
		}

        @Override
        public void propertyChange(PropertyChangeEvent evt)
        {

        }

    }


}


