import Circuits.Board;
import Circuits.CircuitProgram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

/**
 * Created by markmcconachie on 3/22/17.
 */
public class CircuitLauncherPanel extends PhysicsPanel
{
	private JButton launchButton;
	private ActionPanel mainPanel;
	private CircuitProgram circuitProgram;


	public CircuitLauncherPanel ()
	{
		mainPanel=new ActionPanel();
		mainPanel.setLayout(new BorderLayout());
		launchButton = new JButton("Launch Circuit Solver");
		launchButton.addActionListener(mainPanel);
		mainPanel.add(launchButton,BorderLayout.CENTER);
		this.add(mainPanel);

	}

	public class ActionPanel extends JPanel implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object source = event.getSource();

			if (source == launchButton)
			{
				//System.out.println("Launching Circuit Solver");
				if(circuitProgram== null)
				{
					circuitProgram = new CircuitProgram();
				}
				else
				{
					circuitProgram.setVisible(true);
				}
				//JFrame frame = new JFrame();

			}
		}
	}
}
