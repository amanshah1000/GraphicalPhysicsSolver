import javax.swing.*;
import java.awt.*;

/**
 * Created by Valenty on 3/22/17.
 */
public class Planets extends UpdatableComponent  {

    private double massBig;
    private double massSmall;
    private double distance;
    private RunnablePanel PlanetsPanel;
public Planets(RunnablePanel PlanetsPanel){

    super();
    this.PlanetsPanel=PlanetsPanel;


}
    public void setVariables(double massBig, double massSmall, double distance) {
        this.massBig=massBig;
        this.massSmall=massSmall;
        this.distance=distance;
    }

    public void update(){
        repaint();
    }
    public void paint(Graphics g){
        g.setColor(Color.WHITE);

        g.fillRect(0, 0, getWidth(), getHeight());
        


    }


}
