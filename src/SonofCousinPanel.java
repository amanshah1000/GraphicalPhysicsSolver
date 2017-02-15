import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;


public class SonofCousinPanel extends PhysicsPanel {
        
    /**
     * Creates a new instance of <code>SonofCousinPanel</code>.
     */
     
     private ActionPanel buttonPanel;
     private RunnablePanel runPanel;
     private JPanel fieldPanel;
     private ProjectileMotion projectile;
     private JButton calc;
     private JButton clear;
     private JButton run;
     private JFormattedTextField angleField;
     private JFormattedTextField veloField;
	 private NumberFormat thetaFormat;
     //Put any buttons or panels instantiated in this area.
     
    public SonofCousinPanel(double angle, double initVelocity) 
    {
    	super();
    	init(angle, initVelocity);
    }
    
    public void init(double angle, double initVelocity)
    {
    	projectile = new ProjectileMotion(angle, initVelocity, runPanel);
    	
    	runPanel = new RunnablePanel(projectile);
    	buttonPanel = new ActionPanel();
        buttonPanel.setBackground(Color.WHITE);
        fieldPanel = new JPanel();
    	
    	runPanel.setLayout(new BorderLayout());
        runPanel.add(fieldPanel,BorderLayout.NORTH);
        runPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        calc  = new JButton("Calculate");
        clear = new JButton("Clear");
        run = new JButton("Run");
        
        angleField = new JFormattedTextField(thetaFormat);
        angleField.setValue(0);
        angleField.setColumns(4);
		veloField = new JFormattedTextField(thetaFormat);
		veloField.setValue(0);
		veloField.setColumns(4);



		fieldPanel.add(new JLabel("Enter Angle(X�)"));
        fieldPanel.add(angleField);
        fieldPanel.add(new JLabel("Enter Initial Velocity(X m/s)"));
        fieldPanel.add(veloField);
        
        buttonPanel.add(calc);
        buttonPanel.add(clear);
        //angleField.addPropertyChangeListener("Angle",lowerPanel);
		//tempField.addPropertyChangeListener("Initial Velocity",lowerPanel);

        calc.addActionListener(buttonPanel);
        clear.addActionListener(buttonPanel);
        
        runPanel.add(projectile);
        projectile.repaint();

        Thread projectileThread = new Thread(runPanel);

        projectileThread.start();

        this.setLayout(new BorderLayout());
        this.add(runPanel,BorderLayout.CENTER);

    	
    }
    
    public class ActionPanel extends JPanel implements ActionListener, PropertyChangeListener
    {


        @Override
        public void actionPerformed(ActionEvent event)
        {

            Object source = event.getSource();

            if (source == calc)
            {
				String text1 = angleField.getText();
				String text2 = veloField.getText();
				
				double angle = Double.parseDouble(text1);
				double velo = Double.parseDouble(text2);
				runPanel.setRunning(true);
				projectile.setAngle(angle);
				projectile.calculate(angle, velo);
				projectile.repaint();
				
				System.out.print(angle);
				System.out.print(velo);
				
				System.out.println("Calc clicked");
                //mainPanel.run();
            } else if (source == clear)
            {
                System.out.println("clear clicked");
				runPanel.setRunning(true);
				
               
                //mainPanel.run();
            }
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt)
        {

        }

    }
    

}
