import javax.swing.*;
import java.awt.*;

/**
 * Created by Valenty on 3/22/17.
 */
public class ElasticCollision extends UpdatableComponent  {

    private double mass1;
    private double mass2;
    private double velocity1;
    private double velocity2;
    private RunnablePanel ElasticPanel;
    private double deltaTime;
    public ElasticCollision(RunnablePanel ElasticPanel){

        super();
        this.ElasticPanel=ElasticPanel;
        deltaTime=0.0166;


    }
    public void setVariables(double mass1, double mass2, double velocity1, double velocity2) {
        this.mass1=mass1;
        this.mass2=mass2;
        this.velocity1=velocity1;
        this.velocity2=velocity2;
    }

    public void update(){
        repaint();
    }
    public void paint(Graphics g){

        Graphics2D g2d = (Graphics2D)g;
        g.setColor(Color.WHITE);

        for(int i =0;i<200;i++) {
            g2d.setColor(Color.RED);
            g2d.fillOval(200+i, 300, (int) mass1, (int) mass1);


            g2d.setColor(Color.BLUE);
            g2d.fillOval(400-i, 300, (int) mass2, (int) mass2);

            repaint();
        }


    }


}
