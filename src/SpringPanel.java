import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

/**
 * Created by markmcconachie on 2/10/17.
 */
public class SpringPanel extends PhysicsPanel
{
    private JButton startButton;
    private JButton stopButton;
    private JButton setButton;
    private JFormattedTextField massField;
    private NumberFormat massFormat;
    private JPanel fieldPanel;
    private ActionPanel lowerPanel;
    private JPanel upperButtonPanel;
    private JPanel upperPanel;
    private RunnablePanel springPanel;
    private SimpleSpring spring;

    public SpringPanel(double mass)
    {
        super();
        init(mass);

    }

    public void init(double mass)
    {

        //defines panels
        lowerPanel = new ActionPanel();
        lowerPanel.setBackground(Color.WHITE);

        upperPanel = new JPanel(new BorderLayout());
        upperPanel.setBackground(Color.WHITE);
        upperButtonPanel = new JPanel();
        upperButtonPanel.setBackground(Color.WHITE);

        spring = new SimpleSpring(1,100,0);
        springPanel = new RunnablePanel(spring);

        fieldPanel = new JPanel();
        fieldPanel.setBackground(Color.WHITE);

        //define layouts and add defined panels to the main one
        springPanel.setLayout(new BorderLayout());
        springPanel.add(lowerPanel, BorderLayout.SOUTH);
        springPanel.add(upperPanel, BorderLayout.NORTH);

        //defines the buttons
        stopButton = new JButton("Stop");
        startButton = new JButton("Start");
        setButton = new JButton("Set");

        //defines the fields
        massField = new JFormattedTextField(massFormat);
        massField.setValue(mass);
        massField.setColumns(4);

        //adds componets to their respective panels
        //adds buttons to the panel
        lowerPanel.add(startButton);
        lowerPanel.add(stopButton);

        fieldPanel.add(new JLabel("Mass (Kg)"));
        fieldPanel.add(massField);

        upperButtonPanel.add(setButton);

        upperPanel.add(fieldPanel, BorderLayout.NORTH);
        upperPanel.add(upperButtonPanel, BorderLayout.SOUTH);
        stopButton.addActionListener(lowerPanel);
        startButton.addActionListener(lowerPanel);
        setButton.addActionListener(lowerPanel);

        springPanel.add(spring);
        spring.repaint();
        springPanel.repaint();

        //adds the spring panel to the current class
        this.setLayout(new BorderLayout());
        this.add(springPanel, BorderLayout.CENTER);
        //starts the tread in the main panel
        Thread simulationThread = new Thread(springPanel);
        simulationThread.start();


    }


    public class ActionPanel extends JPanel implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent event)
        {

            Object source = event.getSource();

            if (source == stopButton)
            {
                springPanel.setRunning(false);
                System.out.println("Stop clicked");

            } else if (source == startButton)
            {

                System.out.println("Start clicked");
                springPanel.setRunning(true);
            } else if (source == setButton)
            {
                spring.setMass((double) massField.getValue());
                System.out.println((double) massField.getValue());
                spring.reset();
            }


        }

    }
}
