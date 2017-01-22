import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

/**
 * Created by markmcconachie on 1/21/17.
 */
public class SpeedOfSoundPanel extends JPanel
{

    private RunnablePanel speedOfSoundPanel;
    private RunnablePanel pendulumPanel;
    private ActionPanel lowerPanel;//clickable panel is defined in the bottom of this class
    //private RunnablePanel simulationPanel;//runnable panel is defined in the bottom of this class
    private UpdatableComponent soundComponent;
    private PhysicsEquations Eq;
    //private SpeedofSoundEq Speed;
    private JButton calc;
    private JButton clear;
    private JFormattedTextField tempField;
    private NumberFormat thetaFormat;

    public SpeedOfSoundPanel(double temperature, double velocity)
    {
        super();
        init(temperature,velocity);

    }


    public void init(double temperature, double velocity)

    {

        //defines panels

        //mainPanel = new JPanel();
        soundComponent=new UpdatableComponent();
        speedOfSoundPanel=new RunnablePanel(soundComponent);

        lowerPanel= new ActionPanel();

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

        this.setLayout(new BorderLayout());
        this.add(speedOfSoundPanel,BorderLayout.CENTER);



    }


    private class ActionPanel extends JPanel implements ActionListener, PropertyChangeListener
    {


        @Override
        public void actionPerformed(ActionEvent event)
        {

            Object source = event.getSource();


        }

        @Override
        public void propertyChange(PropertyChangeEvent evt)
        {

        }

    }


}
