import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

/**
 * Created by Valenty on 3/22/17.
 */

public class PlanetsPanel extends PhysicsPanel{
    private PhysicsEquations Eq;
    private RunnablePanel PlanetsPanel;

    private ActionPanel fieldPanel;
    private Planets planets;

    private JButton calc;
    private JFormattedTextField inputMass1;
    private JFormattedTextField inputMass2;
    private JFormattedTextField inputDist;

    private NumberFormat thetaFormat;
    public PlanetsPanel(double massBig, double massSmall, double distance){
        super();
        Eq= new PhysicsEquations();
        init(massBig,massSmall, distance);
    }
    public void init(double massBig, double massSmall, double distance){
        planets = new Planets(PlanetsPanel);

        PlanetsPanel=new RunnablePanel(planets);

        fieldPanel = new PlanetsPanel.ActionPanel();
        fieldPanel.setBackground(Color.WHITE);


        PlanetsPanel.setLayout(new BorderLayout());
        PlanetsPanel.add(fieldPanel,BorderLayout.NORTH);

        calc  = new JButton("Calculate");





        //defines text fields

        inputMass1 = new JFormattedTextField(thetaFormat);
        inputMass1.setValue(0);
        inputMass1.setColumns(4);

        inputMass2 = new JFormattedTextField(thetaFormat);
        inputMass2.setValue(0);
        inputMass2.setColumns(4);

        inputDist = new JFormattedTextField(thetaFormat);
        inputDist.setValue(0);
        inputDist.setColumns(4);



        //adds buttons to the panel


        fieldPanel.add(new JLabel("Enter mass of Planet 1"));
        fieldPanel.add(inputMass1);
        fieldPanel.add(new JLabel("Enter mass of Planet 2"));
        fieldPanel.add(inputMass2);
        fieldPanel.add(new JLabel("Enter distance between the Planets"));
        fieldPanel.add(inputDist);

        fieldPanel.add(calc);


        //add actionlisteners to buttons on a clickable panel

        addPropertyChangeListener("mass",fieldPanel);
        addPropertyChangeListener("mass",fieldPanel);


        calc.addActionListener(fieldPanel);


        //starts the tread in the main panel
        fieldPanel.add(planets);
        planets.repaint();

        Thread planetsThread = new Thread(PlanetsPanel);

        planetsThread.start();

        this.setLayout(new BorderLayout());
        this.add(PlanetsPanel,BorderLayout.CENTER);




    }
}
