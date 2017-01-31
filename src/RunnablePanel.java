import javax.swing.*;
import java.util.ArrayList;

public class RunnablePanel extends JPanel implements Runnable
{
    private boolean isRunning;
    private UpdatableComponent component;
    private ArrayList<UpdatableComponent> components;

    public RunnablePanel(UpdatableComponent component)
    {
        super();
        isRunning = false;
        this.component = component;
        //System.out.println(this);
        System.out.println(component);
    }

    public void setRunning(boolean isRunning)
    {
        this.isRunning = isRunning;
    }


    @Override
    public void run()
    {

        while (true)
        {
            //System.out.print("simulation active");
            if(isRunning==true)
            {
                //System.out.println(component);
                component.update();
            }
            try
            {
                Thread.sleep(15);
            } catch (InterruptedException ex)
            {
            }
        }

    }

}



