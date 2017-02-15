import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

public class ProjectileMotion extends UpdatableComponent{
        
    /**
     * Creates a new instance of <code>ProjectileMotion</code>
     */
     
    private JPanel ProjectilePanel;
    private double angle;
	private double initVelocity;
	private final double g = -9.8;


    public ProjectileMotion(double angle, double initVelocity, JPanel ProjectilePanel ) {
    	
    	super();
    	this.ProjectilePanel=ProjectilePanel;
        this.angle=angle;
        this.initVelocity = initVelocity;
    	
    }
    
    public void setAngle(double angle){
        this.angle = angle;
    }
    
    public void setVelocity(double initVelocity){
        this.initVelocity= initVelocity;
    }
    /**
     * @param args the command line arguments
     */
    public void calculate(double angle, double initVelocity)
    {
    	
    }
   
}
