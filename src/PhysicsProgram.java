/*
 * 2017
 * PhysicsProgram 
 * Written By Mark McConachie and AJ Valenty
 * 
 * this class is used as the main runner for a graphical physics solver	
 */
import java.awt.*;
import javax.swing.*;


public class PhysicsProgram extends JFrame
{
    //declares instance variables
    private JPanel mainPanel;
    private PendulumPanel pendulumPanel;
    private SpeedOfSoundPanel speedOfSoundPanel;
    private WavesPanel wavesPanel;
    private SpringPanel springPanel;
    private SonofCousinPanel socPanel;
    private int screenWidth;
    private int screenHeight;
    private PhysicsEquations Eq;

//frame.getContentPane()

	public void addTabs(Container pane)
	{
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Pendulum", pendulumPanel);
        tabbedPane.addTab("Spring",springPanel);
		tabbedPane.addTab("SpeedOfSound", speedOfSoundPanel);
		tabbedPane.addTab("Waves",wavesPanel);
		tabbedPane.addTab("Projectile",socPanel);

		pane.add(tabbedPane, BorderLayout.CENTER);
	}

	public PhysicsProgram()
	{
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //defines screen variables
        //currently defined as 70% of the users screen
        //screenHeight =(int)(screenSize.getHeight()*(0.7));
        //screenWidth =(int)(screenSize.getWidth()*(0.7));
		screenWidth=800;
		screenHeight=600;


        Eq = new PhysicsEquations();
        pendulumPanel = new PendulumPanel(90,100);
        speedOfSoundPanel = new SpeedOfSoundPanel(100);
        wavesPanel = new WavesPanel(100,100);
        springPanel = new SpringPanel(1,100,50);
        socPanel = new SonofCousinPanel(45,20);
		
	  	
		setSize(screenWidth,screenHeight);
		
		//starts the Jframe window, and sets title
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//sets the panels as visible and defines mainPanel as contentPane
		mainPanel=new JPanel();

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
        try {
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException e) {
            // handle exception
        }
        catch (ClassNotFoundException e) {
            // handle exception
        }
        catch (InstantiationException e) {
            // handle exception
        }
        catch (IllegalAccessException e) {
            // handle exception
        }
		
	}


}









	
	


