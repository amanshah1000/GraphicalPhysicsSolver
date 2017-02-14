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
    private Image springImage;


    public SimpleSpring(double mass,double k, double displacement)
    {
        //sets mass
        this.mass=mass*100;
        this.displacement=displacement;
        this.k=k;
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

    public void setMass(double mass)
    {
        this.mass = mass*100;
    }

    public void reset()
    {
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
        g2d.drawImage(springImage, anchorX, anchorY-100,500,100,this);
        g.drawRect(anchorX+475,getHeight()/2-75,(int)mass/2,(int)50);

    }

    public void update()
    {
        repaint();
    }



}
