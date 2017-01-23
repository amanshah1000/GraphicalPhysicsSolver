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
public class PendulumPanel extends PhysicsPanel
{

    private JButton start;
    private JButton stop;
    private JFormattedTextField thetaField;
    private JFormattedTextField lengthField;
    private NumberFormat thetaFormat;
    private NumberFormat lengthFormat;
    private RunnablePanel pendulumPanel;
    private SimplePendulum pendulum;
    private ActionPanel lowerPanel;
    private PhysicsEquations Eq;

    public PendulumPanel(double theta, double length)
    {
        super();
        Eq= new PhysicsEquations();
        init(Eq.degreesToRadian(theta),length);


    }

    public void init(double theta, double length)
    {


        //defines panels
        //mainPanel = new JPanel();
        //adds the pendulum to he array list
        pendulum = new SimplePendulum(length, theta);
        pendulumPanel = new RunnablePanel(pendulum);
        lowerPanel= new ActionPanel();
        //simulationPanel= new RunablePanel();
        pendulumPanel.setLayout(new BorderLayout());
        pendulumPanel.add(lowerPanel, BorderLayout.SOUTH);
        //pendulumPanel.add(simulationPanel,BorderLayout.CENTER);


        //defines buttons
        stop = new JButton("Stop");
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
        lengthField.addPropertyChangeListener("Length", lowerPanel);
        thetaField.addPropertyChangeListener("Theta", lowerPanel);
        stop.addActionListener(lowerPanel);
        start.addActionListener(lowerPanel);


        //intitalizes the equation conversions/solver


        //simulationPanel.add(pendulum);
        pendulumPanel.add(pendulum);
        pendulum.repaint();
        //simulationPanel.repaint();
        pendulumPanel.repaint();
        this.setLayout(new BorderLayout());
        this.add(pendulumPanel,BorderLayout.CENTER);
        //starts the tread in the main panel
        Thread simulationThread = new Thread(pendulumPanel);
        simulationThread.start();

    }


    public class ActionPanel extends JPanel implements ActionListener, PropertyChangeListener
    {


        @Override
        public void actionPerformed(ActionEvent event)
        {

            Object source = event.getSource();

            if (source == stop)
            {

                pendulumPanel.setRunning(false);
                System.out.println("Stop clicked");
                //mainPanel.run();
            } else if (source == start)
            {
                System.out.println("Start clicked");

                pendulumPanel.setRunning(true);
                //mainPanel.run();
            }
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt)
        {

        }

    }
}