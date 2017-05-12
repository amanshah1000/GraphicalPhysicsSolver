import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

/**
 * Created by Valenty on 3/22/17.
 */

public class ElasticPanel extends PhysicsPanel {
    private PhysicsEquations Eq;
    private RunnablePanel ElasticPanel;

    private ActionPanel fieldPanel;
    private ElasticCollision elastic;

    private JButton calc;
    private JFormattedTextField inputRadius1;
    private JFormattedTextField inputRadius2;
    private JFormattedTextField inputVelocity1;
    private JFormattedTextField inputVelocity2;

    private NumberFormat thetaFormat;

    public ElasticPanel(double mass1, double mass2, double velocity1, double velocity2) {
        super();
        Eq = new PhysicsEquations();
        init(mass1, mass2, velocity1, velocity2);
    }

    public void init(double mass1, double mass2, double velocity1, double velocity2) {
        elastic = new ElasticCollision(ElasticPanel,mass1,mass2,velocity1,velocity2);

        ElasticPanel = new RunnablePanel(elastic);

        fieldPanel = new ActionPanel();
        fieldPanel.setBackground(Color.WHITE);


        ElasticPanel.setLayout(new BorderLayout());
        ElasticPanel.add(fieldPanel, BorderLayout.NORTH);

        calc = new JButton("Calculate");


        //defines text fields

        inputRadius1 = new JFormattedTextField(thetaFormat);
        inputRadius1.setValue(mass1);
        inputRadius1.setColumns(4);

        inputRadius2 = new JFormattedTextField(thetaFormat);
        inputRadius2.setValue(mass2);
        inputRadius2.setColumns(4);

        inputVelocity1 = new JFormattedTextField(thetaFormat);
        inputVelocity1.setValue(velocity1);
        inputVelocity1.setColumns(4);

        inputVelocity2 = new JFormattedTextField(thetaFormat);
        inputVelocity2.setValue(velocity2);
        inputVelocity2.setColumns(4);



        //adds buttons to the panel


        fieldPanel.add(new JLabel("Mass of Particle 1:"));
        fieldPanel.add(inputRadius1);
        fieldPanel.add(new JLabel("Mass of Particle 1:"));
        fieldPanel.add(inputRadius2);
        fieldPanel.add(new JLabel("Enter Velocity of Particle 1: "));
        fieldPanel.add(inputVelocity1);
        fieldPanel.add(new JLabel("Enter Velocity of Particle 2: "));
        fieldPanel.add(inputVelocity2);

        fieldPanel.add(calc);


        //add actionlisteners to buttons on a clickable panel

        // addPropertyChangeListener("radius1", fieldPanel);
        //addPropertyChangeListener("radius2", fieldPanel);


        calc.addActionListener(fieldPanel);




        //starts the tread in the main panel
        fieldPanel.add(elastic);
        elastic.repaint();

        Thread elasticThread = new Thread(ElasticPanel);



        ElasticPanel.add(elastic);
        ElasticPanel.setRunning(true);
        elasticThread.start();
        this.setLayout(new BorderLayout());
        this.add(ElasticPanel, BorderLayout.CENTER);
    }
    public class ActionPanel extends JPanel implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent event) {

            Object source = event.getSource();

            if (source == calc) {
                String rad1 = inputRadius1.getText();
                String rad2 = inputRadius2.getText();
                String vel1 = inputVelocity1.getText();
                String vel2 = inputVelocity2.getText();
                double radius1double = Double.parseDouble(rad1);
                double radius2double = Double.parseDouble(rad2);
                double vel1Double = Double.parseDouble(vel1);
                double vel2Double = Double.parseDouble(vel2);

                ElasticPanel.setRunning(true);
                elastic.setVariables(radius1double, radius2double, vel1Double, vel2Double);

                elastic.repaint();

                // System.out.print();

                System.out.println("Calc clicked");
                //mainPanel.run();
            }
        }




    }
}

