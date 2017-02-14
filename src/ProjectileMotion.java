/**
 * @(#)ProjectileMotion.java
 *
 *
 * @author 
 * @version 1.00 2017/2/6
 */

public class ProjectileMotion extends UpdatableComponent{
        
    /**
     * Creates a new instance of <code>ProjectileMotion</code>
     */
     
    private JPanel ProjectilePanel;
    private double angle;
	private double initVelocity;


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
    public void calculate(double angle, double initVelocity){
    
    speed=330.64+(.6*temperature);

    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
