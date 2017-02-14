/**
 * @(#)SonofCousinPanel.java
 *
 *
 * @author 
 * @version 1.00 2017/1/31
 */

public class SonofCousinPanel extends PhysicsPanel {
        
    /**
     * Creates a new instance of <code>SonofCousinPanel</code>.
     */
     
     private ActionPanel lowerPanel;
     private RunnablePanel runPanel;
     private ProjectileMotion projectile;
     private JButton calc;
     private JButton clear;
     private JFormattedTextField angleField;
     private JFormattedTextField veloField;
	 private NumberFormat thetaFormat;
     //Put any buttons or panels instantiated in this area.
     
    public SonofCousinPanel(double angle, double initVelocity) 
    {
    	super();
    	init(angle, initVelocity);
    }
    
    public void init(double temperature, double velocity)
    {
    	projectile = new ProjectileMotion(angle, initVelocity, runPanel);
    	
    	runPanel = new RunnablePanel(projectile);
    	lowerPanel = new ActionPanel();
        lowerPanel.setBackground(Color.WHITE);
    	
    	runPanel.setLayout(new BorderLayout());
        runPanel.add(fieldPanel,BorderLayout.NORTH);
        
        calc  = new JButton("Calculate");
        clear = new JButton("Clear");
        
        tempField = new JFormattedTextField(thetaFormat);
        tempField.setValue(0);
        tempField.setColumns(4);
        
        lowerPanel.add(new JLabel("Enter Angle(X°)"));
        lowerPanel.add(angleField);
        lowerPanel.add(new JLabel("Enter Initial Velocity(X m/s)"));
        lowerPanel.add(veloField);
        
        lowerPanel.add(calc);
        lowerPanel.add(clear);
        tempField.addPropertyChangeListener("Angle",lowerPanel);
		tempField.addPropertyChangeListener("Initial Velocity",lowerPanel);

        calc.addActionListener(lowerPanel);
        clear.addActionListener(lowerPanel);
        
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
