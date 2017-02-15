import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by markmcconachie on 2/10/17.
 */
public class SimpleSpring extends UpdatableComponent
{
    private double period;
    private double mass;
    private double k; // k is the spring constant
    private double displacement;
    private double acceleration;
    private double velocity;
    private double deltaTime;
    private Image springImage;


    public SimpleSpring(double mass,double k, double displacement)
    {
        //sets mass
        this.mass=mass*100;
        this.displacement=displacement;
        this.k=k;
        deltaTime=0.0166;
        acceleration = (-k*displacement)/mass;
        try
        {
            //both of these image methods work
            springImage = ImageIO.read(new File("Spring.png"));
            //diceImage = Toolkit.getDefaultToolkit().getImage("dice.png");
        } catch (IOException ex)
        {
            Logger.getLogger(PendulumPanel.class.getName()).log(Level.WARNING,null,ex);
        }


    }
    public void setK(double k)
    {
        this.k=k;
    }
    public void setDisplacement(double displacement)
    {
        this.displacement=displacement;
    }



    public void setMass(double mass)
    {
        this.mass = mass*100;
    }

    public void reset()
    {
		acceleration = (-k*displacement)/mass;
    	velocity=0;
        repaint();
    }

    public void paint(Graphics g)
    {
        //+ is right - is left
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        int anchorX = getWidth()/32, anchorY = getHeight() / 2;
        g.fillOval(anchorX +(22), anchorY - (50), 7, 7);
        g2d.drawImage(springImage, anchorX, anchorY-100,(int)(500+displacement),100,this);
        g.setColor(Color.cyan);
        g.fillRect((int)((anchorX+475)+displacement),getHeight()/2-75,(int)mass/2,(int)50);
		g.setColor(Color.BLACK);
		g.drawRect((int)((anchorX+475)+displacement),getHeight()/2-75,(int)mass/2,(int)50);
		//g.setColor(Color.RED);
        //g.drawOval((int)((anchorX+475+7)),getHeight()/2+150,7,7);

    }

    public void update()
    {
        acceleration = (-k*displacement)/mass;
        velocity += acceleration*deltaTime;
        displacement += velocity*deltaTime;


        repaint();
    }



}
