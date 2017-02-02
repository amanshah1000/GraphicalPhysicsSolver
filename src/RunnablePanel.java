import javax.swing.*;
import java.util.ArrayList;

public class RunnablePanel extends JPanel implements Runnable
{
    private boolean isRunning;
    private UpdatableComponent component;
    private ArrayList<UpdatableComponent> components;
    private long frameTime;


    //takes just a component everything else is default
    public RunnablePanel(UpdatableComponent component)
    {
        super();
        isRunning = false;
        this.component = component;
        components=new ArrayList<UpdatableComponent>();
        components.add(this.component);
        frameTime=10;
        //System.out.println(this);
        //System.out.println(component);
    }

    //takes a component and a frame time, to have an adjustable frame time
    public RunnablePanel(UpdatableComponent component,long frameTime)
    {
        super();
        isRunning = false;
        this.component = component;
        components=new ArrayList<UpdatableComponent>();
        components.add(this.component);
        this.frameTime=frameTime;
        //System.out.println(this);
        //System.out.println(component);
    }

    //takes an array of updatable components so you can update multiple objects
    public RunnablePanel(ArrayList <UpdatableComponent> components)
    {
        super();
        isRunning = false;
        this.components=components;
        frameTime=10;


    }

    //takes an array of updatable components so you can update multiple objects
    //takes in a frame time so it is adjustable
    public RunnablePanel(ArrayList <UpdatableComponent> components,long frameTime)
    {
        super();
        isRunning = false;
        this.components=components;
        this.frameTime=frameTime;


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
                for(int i =0;i<components.size();i++)
                {
                    components.get(i).update();
                }

            }
            try
            {
                Thread.sleep(frameTime);
            } catch (InterruptedException ex)
            {
            }
        }

    }

}



